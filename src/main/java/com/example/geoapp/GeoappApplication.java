package com.example.geoapp;

import com.example.geoapp.service.impl.StructuresServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeoappApplication {
@Autowired
StructuresServiceImpl structuresService;
	public static void main(String[] args) {
		SpringApplication.run(GeoappApplication.class, args);
	}

	@Bean
	public CommandLineRunner runAtStartup() {
		return args -> {

			System.out.println("***********************************************************");
			System.out.println("*      L'application GeoApp a démarré avec succès !       *");
			System.out.println("***********************************************************");
			structuresService.saveCsv();
		};
	}
}
