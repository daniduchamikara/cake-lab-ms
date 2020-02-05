package com.icbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CakeLabMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeLabMsApplication.class, args);
	}

}
