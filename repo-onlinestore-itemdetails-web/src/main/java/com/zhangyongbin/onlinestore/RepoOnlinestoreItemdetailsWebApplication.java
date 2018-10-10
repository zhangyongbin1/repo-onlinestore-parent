package com.zhangyongbin.onlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class RepoOnlinestoreItemdetailsWebApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RepoOnlinestoreItemdetailsWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RepoOnlinestoreItemdetailsWebApplication.class, args);
	}
}
