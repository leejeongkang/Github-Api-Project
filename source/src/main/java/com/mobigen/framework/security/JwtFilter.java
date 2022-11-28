package com.mobigen.framework.security;

import com.mobigen.framework.iris.IRISProperties;
import com.mobigen.framework.iris.Token;
import com.mobigen.framework.iris.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private Token token;
    private SessionManager sessionManager;
    private IRISProperties properties;
    private String[] ignores;
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    public JwtFilter(Token token, SessionManager sessionManager, IRISProperties properties) {
        this.token = token;
        this.sessionManager = sessionManager;
        this.properties = properties;
        this.ignores = properties.getSecurity().getIgnores();
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        for (String item : ignores) {
            if (pathMatcher.match(item, path)) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!shouldNotFilter(request)) {
            try {
                // 이미 인증된 사용자가 있는지 보고 없다면
                // token을 사용해서 재인증을 한다.
                User user = sessionManager.getUser();
                if (user == null) {
                    String xAccessToken = token.getXAccessTokenByHttpServletRequest(request);

                    if (token.isExpiredToken(xAccessToken)) {
                        token.deleteCookieByHttpServletResponse(response, properties.getToken().getName());
                    } else {
                        user = token.getUserByHttpServletRequest(request);
                        sessionManager.auth(user);
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}