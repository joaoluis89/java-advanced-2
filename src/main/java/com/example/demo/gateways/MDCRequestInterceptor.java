package com.example.demo.gateways;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(0)
public class MDCRequestInterceptor extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        String userId = request.getHeader("user-id");
        if (userId != null) {
            // Set the user ID in the MDC (Mapped Diagnostic Context)
            MDC.put("userId", userId);
        }

        String sessionId = request.getHeader("session-id");
        if (sessionId != null) {
            // Set the session ID in the MDC (Mapped Diagnostic Context)
            MDC.put("sessionId", sessionId);
        }
        filterChain.doFilter(request, response);
        MDC.clear();
    }
}
