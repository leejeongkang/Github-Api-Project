package com.mobigen.framework.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@Component
public class NuxtSSRStaticUrlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) servletRequest) {
            /**
             * Nuxt를 SSR 모드로 배포 시, NuxtLink 경로에 html 이 없기 때문에
             * 서버쪽에서 강제로 index.html을 추가하여 매핑한다.
             * @TODO sub-page 를 만들면 index.html로 해결이 안되기 때문에 좀더 복잡한 패틴 처리가 필요함
             * @return
             */
            @Override
            public String getRequestURI() {
                String url = ((HttpServletRequest) servletRequest).getRequestURI();
                if (url.indexOf("/sample/") > -1) {
                    return url + "/index.html";
                }
                return url;
            }
        }, servletResponse);
    }
}
