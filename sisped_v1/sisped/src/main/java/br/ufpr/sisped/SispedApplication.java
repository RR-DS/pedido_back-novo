package br.ufpr.sisped;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper.*;

@SpringBootApplication
public class SispedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SispedApplication.class, args);
	}
	
	/*@Configuration
	public class ModelMapperConfig {*/
		
		@Bean
		ModelMapper modelMapper() {
			return new ModelMapper();
	}
	

}
