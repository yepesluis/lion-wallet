package com.luisyepes.lionwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.luisyepes.lionwallet.controller",
		"com.luisyepes.lionwallet.service",
		"com.luisyepes.lionwallet.domain"})
public class LionWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(LionWalletApplication.class, args);
	}

}
