package com.web.petfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan(basePackages = "com.web.petfood.models")
public class PetfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetfoodApplication.class, args);
	}

}
