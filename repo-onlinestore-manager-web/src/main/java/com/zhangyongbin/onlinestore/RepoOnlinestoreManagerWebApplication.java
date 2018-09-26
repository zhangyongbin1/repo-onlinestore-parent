package com.zhangyongbin.onlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class RepoOnlinestoreManagerWebApplication extends SpringBootServletInitializer {
    //Java EE应用服务器配置
    //如果要使用tomcat来加载jsp的话就必须继承SpringBootServletInitializer类并且重写其中的configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RepoOnlinestoreManagerWebApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(RepoOnlinestoreManagerWebApplication.class, args);
	}

    /**
     * manager-web中依赖的两个项目manager与content都使用了jedis，所以启动这个web时会报could not resolve placeholder
     * 或者将jedis的封装类提取到common模块中
     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        configurer.setIgnoreUnresolvablePlaceholders(true);
//        return configurer;
//    }
}
