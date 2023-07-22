package com.youtube.jwt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfiguration {

	private static final String GET ="GET";
	private static final String POST="POST";
	private static final String	DELETE ="DELETE";
	private static final String	PUT ="PUT";
	protected String pathPattern;
	
	public WebMvcConfigurer corsConfigurer() {
		return new  WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				
				
				registry.addMapping( pathPattern ="/**")
				.allowedMethods(GET,PUT,POST,DELETE)
				.allowedHeaders("*")
				.allowedOriginPatterns("*")
				.allowCredentials(true)
				;
			}
		};
	}
}
