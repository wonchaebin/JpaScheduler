package com.example.jpaschedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/auth/login", "/users", "/users/*"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httPRequest = (HttpServletRequest) servletRequest;
        String requestURI = httPRequest.getRequestURI();

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        log.info("로그인 필터 로직 실행");

        if (!isWhileList(requestURI)) {
            HttpSession session = httPRequest.getSession(false);

            if (session == null || session.getAttribute("sessionKey") == null) {
                throw new RuntimeException("인증 실패");
            }
            log.info("로그인 성공");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    private boolean isWhileList(String requestURI) {
        return requestURI.startsWith("/users/login");
    }
}
