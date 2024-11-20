package com.intgracion_comunitaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.intgracion_comunitaria")
@EnableJpaRepositories(basePackages = "com.intgracion_comunitaria.repositories")
public class IntegracionComunatariaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegracionComunatariaWebApplication.class, args);
	}

}
