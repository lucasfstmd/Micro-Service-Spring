package com.microservice.getway.security.filter;

import com.microservice.core.property.JWTConfiguration;
import com.microservice.security.filter.JWTTokenAuthorizationFilter;
import com.microservice.security.token.converter.TokenConverter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.lang.NonNull;

import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;

import java.io.IOException;

public class GetewayJWTTokenAuthorizationFilter extends JWTTokenAuthorizationFilter {

    public GetewayJWTTokenAuthorizationFilter(JWTConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration, tokenConverter);
    }

    @SneakyThrows
    @SuppressWarnings("Duplicates")
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain, @NonNull ServerWebExchange exchange) throws ServletException, IOException {
        String header = request.getHeader(jwtConfiguration.getHeader().getName());

        if(header == null || !header.startsWith(jwtConfiguration.getHeader().getPrefix())){
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace(jwtConfiguration.getHeader().getPrefix(), "").trim();

        String signedToken = tokenConverter.decryptToken(token);
        tokenConverter.validateTokenSignature(signedToken);

        if(jwtConfiguration.getType().equalsIgnoreCase("signed")){
            String headerValue = jwtConfiguration.getHeader().getPrefix() + " " + signedToken;
            exchange.getRequest().mutate().header(HttpHeaders.AUTHORIZATION, headerValue);
            ServerWebExchangeUtils.addOriginalRequestUrl(exchange, exchange.getRequest().getURI());
        }

        chain.doFilter(request, response);

    }
}
