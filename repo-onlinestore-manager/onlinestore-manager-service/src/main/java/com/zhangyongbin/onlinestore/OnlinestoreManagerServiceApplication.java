package com.zhangyongbin.onlinestore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(basePackages="com.zhangyongbin.onlinestore.mapper")
//@ImportResource("classpath:spring-trans.xml")//dubbo需要升级到2.6.x版本，springboot才能同时支持事务和dubbo的service注解同时使用
public class OnlinestoreManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinestoreManagerServiceApplication.class, args);
	}
}
