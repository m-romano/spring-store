package com.mromanode.springstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringstoreApplication.class, args);
	}
}
