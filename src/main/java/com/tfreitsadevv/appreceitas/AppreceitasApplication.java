package com.tfreitsadevv.appreceitas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tfreitsadevv.appreceitas.domain.UnidadeDeCompra;
import com.tfreitsadevv.appreceitas.repositories.UnidadeDeCompraRepository;

@SpringBootApplication
public class AppreceitasApplication implements CommandLineRunner {
	
	@Autowired
	private UnidadeDeCompraRepository unidadeDeCompraRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppreceitasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UnidadeDeCompra uc1 = new UnidadeDeCompra(null, "Kg");
		UnidadeDeCompra uc2 = new UnidadeDeCompra(null, "g");
		UnidadeDeCompra uc3 = new UnidadeDeCompra(null, "L");
		
		unidadeDeCompraRepository.saveAll(Arrays.asList(uc1, uc2, uc3));
		
	}
	
	

}
