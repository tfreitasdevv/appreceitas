package com.tfreitsadevv.appreceitas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tfreitsadevv.appreceitas.domain.Conversao;
import com.tfreitsadevv.appreceitas.domain.Ingrediente;
import com.tfreitsadevv.appreceitas.domain.UnidadeDeCompra;
import com.tfreitsadevv.appreceitas.domain.UnidadeDeUso;
import com.tfreitsadevv.appreceitas.domain.enums.UnidadeReferencia;
import com.tfreitsadevv.appreceitas.repositories.ConversaoRepository;
import com.tfreitsadevv.appreceitas.repositories.IngredienteRepository;
import com.tfreitsadevv.appreceitas.repositories.UnidadeDeCompraRepository;
import com.tfreitsadevv.appreceitas.repositories.UnidadeDeUsoRepository;

@SpringBootApplication
public class AppreceitasApplication implements CommandLineRunner {
	
	@Autowired
	private UnidadeDeCompraRepository unidadeDeCompraRepository;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Autowired
	private UnidadeDeUsoRepository unidadeDeUsoRepository;
	
	@Autowired
	private ConversaoRepository conversaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppreceitasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UnidadeDeCompra uc1 = new UnidadeDeCompra(null, "Kg");
		UnidadeDeCompra uc2 = new UnidadeDeCompra(null, "g");
		UnidadeDeCompra uc3 = new UnidadeDeCompra(null, "L");
		
		UnidadeDeUso uu1 = new UnidadeDeUso(null, "Xícara");
		UnidadeDeUso uu2 = new UnidadeDeUso(null, "Colher de chá");
		UnidadeDeUso uu3 = new UnidadeDeUso(null, "Colher de sopa");
		
		Ingrediente i1 = new Ingrediente(null, "Açúcar", "União", "Refinado", 1.00, 4.00, uc1, UnidadeReferencia.G);
		Ingrediente i2 = new Ingrediente(null, "Chocolate em pó", "Nestlé", "Ao leite", 800.00, 6.00, uc2, UnidadeReferencia.G);
		Ingrediente i3 = new Ingrediente(null, "Leite", "Parmalat", "Integral", 1.00, 2.00, uc3, UnidadeReferencia.ML);
		
		unidadeDeCompraRepository.saveAll(Arrays.asList(uc1, uc2, uc3));
		unidadeDeUsoRepository.saveAll(Arrays.asList(uu1,uu2,uu3));
		ingredienteRepository.saveAll(Arrays.asList(i1,i2,i3));
		
		Conversao c1 = new Conversao(i1, uu1, 200.00);
		Conversao c2 = new Conversao(i1, uu2, 4.00);
		Conversao c3 = new Conversao(i1, uu3, 14.00);
		Conversao c4 = new Conversao(i2, uu1, 250.00);
		Conversao c5 = new Conversao(i2, uu2, 5.00);
		Conversao c6 = new Conversao(i2, uu3, 20.00);
		Conversao c7 = new Conversao(i3, uu1, 250.00);
		Conversao c8 = new Conversao(i3, uu3, 15.00);
		
		conversaoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8));
		
				
	}
	
	

}
