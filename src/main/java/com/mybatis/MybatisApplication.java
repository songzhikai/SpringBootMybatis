package com.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.mybatis.mapper")
public class MybatisApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

}
