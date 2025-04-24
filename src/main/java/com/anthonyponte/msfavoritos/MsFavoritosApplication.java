package com.anthonyponte.msfavoritos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsFavoritosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFavoritosApplication.class, args);
	}

}
