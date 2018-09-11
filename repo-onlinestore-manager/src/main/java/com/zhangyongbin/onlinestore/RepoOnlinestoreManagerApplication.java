package com.zhangyongbin.onlinestore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.zhangyongbin.onlinestore.mapper")
public class RepoOnlinestoreManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoOnlinestoreManagerApplication.class, args);
	}
}
