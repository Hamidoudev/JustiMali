package com.glm1.JustiMali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class JustiMaliApplication {
	public static void main(String[] args) {
		SpringApplication.run(JustiMaliApplication.class, args);
	}
}
