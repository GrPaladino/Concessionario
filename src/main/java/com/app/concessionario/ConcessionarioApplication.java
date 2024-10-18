package com.app.concessionario;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Concessionario API",
		version = "1.0",
		description = "API per recuperare dati dei concessionari"),
		servers = {
				@Server(url = "/", description = "Default url"),
				@Server(url = "http://localhost:8080", description = "Development server")
		})
public class ConcessionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcessionarioApplication.class, args);
	}

}
