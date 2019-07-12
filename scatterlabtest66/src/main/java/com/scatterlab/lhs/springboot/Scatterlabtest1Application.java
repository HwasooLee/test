package com.scatterlab.lhs.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.scatterlab.lhs.springboot")
public class Scatterlabtest1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Scatterlabtest1Application.class, args);
	}

}
