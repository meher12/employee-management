package com.mk.springtuto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//
		// Access Bootstrap static resource:

		// http://somedomain/SomeContextPath/bootstrap/css/bootstrap.min.css
		// http://somedomain/SomeContextPath/bootstrap/js/bootstrap.min.js
		//
		registry.addResourceHandler("/bootstrap/**") //
				.addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/5.1.3/");

	}

}
