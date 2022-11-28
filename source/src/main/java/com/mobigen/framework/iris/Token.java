package com.mobigen.framework.iris;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mobigen.framework.result.JsonResult;
import com.mobigen.framework.utility.restful.RestAPI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
@Slf4j
@Component
@AllArgsConstructor
public class Token {
    private final IRISProperties properties;
    private final RestAPI restAPI;

    public static final String BRICK_AUTH_SUCCESS = "LOGIN_SUCCESS";

    /**
     * Brick을 통해 사용자 Token을 받아온다
     *
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public String getXAccessToken(String username, String password) throws Exception {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", username);
        parameter.put("userPass", password);

        JsonResult result = restAPI.post(properties.getUrl().getBrick().getAuth(), parameter);
        if (result.getResult() == 0) {
            throw new Exception("Brick Auth Fail: " + result.getErrorMessage());
        }

        Map<String, String> data = (LinkedHashMap<String, String>) result.getData();
        if (!data.get("status").equals(BRICK_AUTH_SUCCESS)) {
            throw new Exception("Brick Auth Fail: " + data.toString());
        }

        return (String) data.get("token");
    }

    /**
     * Angora를 통해 사용자 Token을 받아온다
     *
     * @param xAccessToken
     * @return
     * @throws Exception
     */
    public String getAngoraToken(String xAccessToken) throws Exception {
        User user = this.getUserByXAccessToken(xAccessToken);
        return getAngoraToken(user.getUsername(), user.getPassword(), user.getGroupId(), true);
    }

    public String getAngoraToken(String username, String password, String groupId, boolean isEncrypted)
            throws Exception {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("id", username);
        parameter.put("password", password);
        parameter.put("group_id", groupId);
        parameter.put("encrypted", isEncrypted);

        JsonResult result = restAPI.post(properties.getUrl().getAngora().getAuth(), parameter);
        if (result.getResult() == 0) {
            throw new Exception("Angora Auth Fail: " + result.getErrorMessage());
        }

        Map<String, String> data = (LinkedHashMap<String, String>) result.getData();
        if (!data.get("status").equals("OK")) {
            throw new Exception("Brick Auth Fail: " + data.toString());
        }

        return (String) data.get("token");
    }

    /**
     * Request에서 X-ACCESS-TOKEN 정보를 추출
     *
     * @param request
     * @return
     * @throws Exception
     */
    public String getXAccessTokenByHttpServletRequest(HttpServletRequest request) throws Exception {
        String xAccessToken = null;
        if (null != request.getCookies()) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals(properties.getToken().getName())) {
                    xAccessToken = c.getValue();
                    break;
                }
            }
        }

        if (null == xAccessToken) {
            xAccessToken = request.getHeader(properties.getToken().getName());
        }

        return xAccessToken;
    }

    /**
     * Request에서 X-ACCESS-TOKEN 정보를 추출 하여 사용자 정보를 생성 한다.
     *
     * @param request
     * @return
     * @throws Exception
     */
    public User getUserByHttpServletRequest(HttpServletRequest request) {
        String xAccessToken = null;
        User user = null;
        try {
            xAccessToken = getXAccessTokenByHttpServletRequest(request);
            user = getUserByXAccessToken(xAccessToken);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return user;
    }

    /**
     * 주어진 Angora Token이 유효한가?
     *
     * @param token
     * @return
     * @throws Exception
     */
    public Boolean isValidAngoraToken(String token) throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization", "Angora " + token);

        JsonResult result = restAPI.get(properties.getUrl().getAngora().getTokenCheck(), null, header);
        if (result.getResult() == 0) {
            throw new Exception("Angora Auth Fail: " + result.getErrorMessage());
        }

        Map<String, String> data = (LinkedHashMap<String, String>) result.getData();
        if (!data.get("status").equals("OK")) {
            return false;
        }

        return true;
    }

    /**
     * 주어진 Brick Token이 유효한가?
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String isValidBrickToken(String token) throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put(properties.getToken().getName(), token);

        JsonResult result = restAPI.get(properties.getUrl().getBrick().getTokenCheck(), null, header, true);
        if (result.getResult() == 0) {
            throw new Exception("Brick Token invalid:" + result.getErrorMessage());
        }

        ResponseEntity<?> data = (ResponseEntity<?>) result.getData();
        Map<String, Object> body = (Map<String, Object>) data.getBody();
        if (null == body) {
            throw new Exception("Brick Token invalid - Body is Null");
        }

        HttpHeaders headers = data.getHeaders();

        String message = (String) body.get("message");
        switch (message) {
            case "token_fine":
                return token;
            case "refresh_success":
                String xAccessToken = headers.get("x-access-token").get(0);
                return xAccessToken;
        }

        return null;
    }

    /**
     * Token Expired 상태 검증
     *
     * @param xAccessToken
     * @return
     */
    public boolean isExpiredToken(String xAccessToken) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(properties.getToken().getSecret());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(xAccessToken);
            jwt.getExpiresAt();
            return false;
        } catch (Exception e) {
        }

        return true;
    }

    /**
     * 주어진 Cookie를 지운다
     *
     * @param response
     * @param cookieName
     */
    public void deleteCookieByHttpServletResponse(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * X-Access-Token 을 이용하여 사용자 모델 정보를 반환
     *
     * @param xAccessToken
     * @return
     * @throws Exception
     */
    public User getUserByXAccessToken(String xAccessToken) throws Exception {
        if (null == xAccessToken) {
            return null;
        }

        Algorithm algorithm = Algorithm.HMAC256(properties.getToken().getSecret());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(xAccessToken);

        return User.builder().userId(jwt.getClaim("userId").asString()).userPass(jwt.getClaim("encryptPass").asString())
                .groupId(jwt.getClaim("groupId").asString()).groupName(jwt.getClaim("groupName").asString())
                .roleCode(jwt.getClaim("roleCode").asString()).roleName(jwt.getClaim("roleName").asString())
                .xAccessToken(xAccessToken).build();
    }
}
