package com.luisyepes.lionwallet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.luisyepes.lionwallet.controller",
		"com.luisyepes.lionwallet.service",
		"com.luisyepes.lionwallet.dao",
		"com.luisyepes.lionwallet.domain",
		"com.luisyepes.lionwallet.validation"})
public class LionWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(LionWalletApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
