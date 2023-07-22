package com.youtube.jwt.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.youtube.jwt.service.JwtService;
import com.youtube.jwt.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private JwtService jwtService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	String name;
	String userName =null;
	final String header =	request.getHeader( name="Authorization");
	
	String jwtToken= null;
	if(header != null && header.startsWith("Bearer " )) {
		jwtToken=header.substring(7);
		
		try {
			userName= jwtUtil.getUserNameFromToken(jwtToken);
			
		}catch(IllegalArgumentException e) {
			
			System.out.println("unable to get awt token");
		}catch(ExpiredJwtException e) {
			System.out.println("Jwt token is expired");
		}
	}else {
		System.out.println("JWT token does not start with bearer");
	}
	if(userName !=null && SecurityContextHolder.getContext().getAuthentication() ==null) {
		UserDetails userDetails = jwtService.loadUserByUsername(userName);
		if(jwtUtil.validateToken(jwtToken, userDetails)) {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		  
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}
	filterChain.doFilter(request, response);
	
	}
}
