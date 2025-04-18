package com.example.demo.gateways;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class MDCRequestInterceptorTest {

    @InjectMocks
    private MDCRequestInterceptor mdcRequestInterceptor;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doFilterInternal() throws ServletException, IOException {
        //Arrange
        Mockito.when(request.getHeader("user-id")).thenReturn("123");
        //Act
        mdcRequestInterceptor.doFilterInternal(request, response, filterChain);

        //Assert
    }
}