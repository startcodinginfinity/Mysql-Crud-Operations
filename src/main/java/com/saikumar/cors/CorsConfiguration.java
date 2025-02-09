package com.saikumar.cors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CorsConfiguration implements WebMvcConfigurer{


	    public void addCorsFilter(CorsRegistry registry){
	    	
	        registry.addMapping("**")
	                .allowCredentials(true)
	                .allowedOrigins("**")
	                .allowedHeaders("**")
	                .allowedMethods("**")
	                .allowedOriginPatterns("**");

	    }


	
}
