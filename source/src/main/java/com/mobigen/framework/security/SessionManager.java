package com.mobigen.framework.security;

import com.mobigen.framework.iris.IRISProperties;
import com.mobigen.framework.iris.Token;
import com.mobigen.framework.iris.User;
import com.mobigen.framework.utility.RSA;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class SessionManager {
    private final IRISProperties properties;
    private final Token token;

    private static final String PRIVATE_KEY = "private-key";

    /**
     * 계정 정보를 직접 전달하여 세션 생성
     *
     * @param user
     * @return
     * @throws Exception
     */
    public User auth(User user) throws Exception {
        if (user == null) {
            return null;
        }

        // 사용자 Token 생성
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("Administrator"));

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null,
                grantedAuths);
        authenticationToken.setDetails(user);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return user;
    }

    /**
     * 현재 세션에 대한 사용자 계정을 반환
     *
     * @return
     */
    public User getUser() {
        User user = null;
        try {
            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof User) {
                user = (User) details;
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        return user;
    }

    /**
     * 현재 세션에 대한 사용자 계정을 반환
     *
     * @return
     */
    public String getUsername() {
        String name = "";
        try {
            User user = this.getUser();
            if (user != null) {
                name = user.getUsername();
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return name;
    }

    /**
     * 쿠키로 토큰값을 추가
     *
     * @param response
     * @param token
     * @return
     */
    public HttpServletResponse addTokenToResponse(HttpServletRequest request, HttpServletResponse response, String token) {
        if (null == response) {
            return null;
        }

        Cookie tokenCookie = new Cookie(properties.getToken().getName(), token);
        tokenCookie.setPath(request.getContextPath());
        tokenCookie.setHttpOnly(true);
        tokenCookie.setMaxAge(properties.getToken().getMaxAge());

        response.addCookie(tokenCookie);
        return response;
    }

    /**
     * 개발용으로 로컬 호스트 일때 무조건 세션 생성
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public User localLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String remoteHost = request.getRemoteHost();
        User user = null;
        switch (remoteHost) {
            case "localhost":
            case "0:0:0:0:0:0:0:1":
            case "127.0.0.1":
                String xAccessToken = token.getXAccessToken(properties.getTest().getBrickUsername(), properties.getTest().getBrickPassword());
                this.addTokenToResponse(request, response, xAccessToken);
                user = token.getUserByXAccessToken(xAccessToken);
                break;
            default:
                break;
        }

        return user;
    }

    public String generateRSAPublicKey(HttpServletRequest request) throws Exception {
        String publicKey = null;
        RSA rsa = new RSA();
        publicKey = rsa.getBase64PublicKeyFromKeyPair(rsa.getKeyPair());

        HttpSession session = request.getSession();
        session.setAttribute(PRIVATE_KEY, rsa.getKeyPair().getPrivate());

        log.info("GENERATE public-key: " + publicKey);
        return publicKey;
    }

    public String decryptRSAString(HttpServletRequest request, String encrypted) throws Exception {
        HttpSession session = request.getSession();
        PrivateKey privateKey = (PrivateKey) session.getAttribute(PRIVATE_KEY);

        RSA rsa = new RSA();
        String decrypted = rsa.decryptRSA(encrypted, privateKey);
        return decrypted;
    }
}
