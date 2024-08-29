package com.dat.furni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dat.furni")
public class FurniApplication {

	public static void main(String[] args) {
		SpringApplication.run(FurniApplication.class, args);
	}

}
