package com.zhangyongbin.onlinestore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.zhangyongbin.onlinestore.mapper")
public class OnlinestoreSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinestoreSearchServiceApplication.class, args);
	}
}
