package com.lazymind.full_stack_todo_app.webservice.restfulwebservice;

import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FullStackTodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackTodoAppApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigure(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry) {
				registry.addMapping("/**") // for mapping
						.allowedMethods("*") // all method
						.allowedOrigins("http://localhost:3000"); // where the request is coming from
			}
		};
	}

}
