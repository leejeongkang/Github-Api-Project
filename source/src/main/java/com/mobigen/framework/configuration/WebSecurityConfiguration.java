package com.mobigen.framework.configuration;

import com.mobigen.framework.iris.IRISProperties;
import com.mobigen.framework.iris.Token;
import com.mobigen.framework.security.JwtAuthenticationEntryPoint;
import com.mobigen.framework.security.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.Cookie;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${server.servlet.session.cookie.name}")
    private String sessionCookieName;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private Token token;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private IRISProperties properties;

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(properties.getSecurity().getIgnores());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().configurationSource(corsConfigurationSource()).and();

        /** 세션 방식을 사용하지 않을 경우엔!
         http =
         http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
         **/

        // Set CSRF
        if (properties.getSecurity().getCsrf()) {
            http = http.csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                    .ignoringAntMatchers("/api/csrf-token")
                    .and();
        } else {
            http = http.csrf().disable();
        }

        // Set unauthorized requests exception handler
        http = http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and();

        // Set permissions on endpoints
        http = http.authorizeRequests()
                .antMatchers(properties.getSecurity().getPermitAlls())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and();

        // Set logout
        http = http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl(properties.getSecurity().getRedirectUrl())
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler((request, response, auth) -> {
                    for (Cookie cookie : request.getCookies()) {
                        String cookieName = cookie.getName();
                        if (properties.getToken().getName().equals(cookieName)) {
                            Cookie cookieToDelete = new Cookie(cookieName, null);
                            // TO-DO
                            // 기본 Security는 setMaxAge(0)으로 하고 있고, 여타 웹에서도 0으로 해야 쿠키가 사라진다고 했는데
                            // 사라지지 않아서 -1로 하니 사라졌음. 그래서 일단 따로 이렇게 구현했는데 ..
                            // 아직 비밀을 밝히지 못함
                            cookieToDelete.setMaxAge(-1);
                            response.addCookie(cookieToDelete);
                        }
                    }
                }).and();

        // set iframe option
        switch (properties.getSecurity().getIframeOption()) {
            case "same-origin":
                http = http.headers().frameOptions().sameOrigin().and();
                break;
            case "deny":
                http = http.headers().frameOptions().deny().and();
                break;
            case "disable":
                http = http.headers().frameOptions().disable().and();
                break;
            default:
                break;
        }

        // add JWT token filter
        http.apply(new JWTSecurityConfiguration(token, sessionManager, properties));
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(properties.getSecurity().getCors().getAllowedOrigins()));
        configuration.setAllowedMethods(Arrays.asList(properties.getSecurity().getCors().getAllowedMethods()));
        configuration.setAllowedHeaders(Arrays.asList(properties.getSecurity().getCors().getAllowedHeaders()));
        configuration.setAllowCredentials(properties.getSecurity().getCors().getAllowCredentials());

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(properties.getSecurity().getCors().getPattern(), configuration);

        return source;
    }
}
