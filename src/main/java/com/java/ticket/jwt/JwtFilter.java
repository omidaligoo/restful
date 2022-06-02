package com.java.ticket.jwt;

import com.java.ticket.model.GeneralUser;
import com.java.ticket.service.GeneralUserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final GeneralUserService generaluserservice;

    public JwtFilter(JwtUtils jwtUtils, GeneralUserService generaluserservice) {
        this.jwtUtils = jwtUtils;
        this.generaluserservice = generaluserservice;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String jwt = httpServletRequest.getHeader("Authorization");

        if (jwt != null) {
            String username = jwtUtils.getusername(jwt);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                GeneralUser generaluser = (GeneralUser) generaluserservice.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(generaluser, null, generaluser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
