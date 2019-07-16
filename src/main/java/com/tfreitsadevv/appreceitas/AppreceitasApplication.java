package com.tfreitsadevv.appreceitas;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tfreitsadevv.appreceitas.domain.Conversao;
import com.tfreitsadevv.appreceitas.domain.Embalagem;
import com.tfreitsadevv.appreceitas.domain.EmbalagemReceita;
import com.tfreitsadevv.appreceitas.domain.Ingrediente;
import com.tfreitsadevv.appreceitas.domain.IngredienteReceita;
import com.tfreitsadevv.appreceitas.domain.Receita;
import com.tfreitsadevv.appreceitas.domain.TipoReceita;
import com.tfreitsadevv.appreceitas.domain.UnidadeDeCompra;
import com.tfreitsadevv.appreceitas.domain.UnidadeDeRendimento;
import com.tfreitsadevv.appreceitas.domain.UnidadeDeUso;
import com.tfreitsadevv.appreceitas.domain.enums.UnidadeReferencia;
import com.tfreitsadevv.appreceitas.domain.enums.UnidadeTempo;
import com.tfreitsadevv.appreceitas.repositories.ConversaoRepository;
import com.tfreitsadevv.appreceitas.repositories.EmbalagemReceitaRepository;
import com.tfreitsadevv.appreceitas.repositories.EmbalagemRepository;
import com.tfreitsadevv.appreceitas.repositories.IngredienteReceitaRepository;
import com.tfreitsadevv.appreceitas.repositories.IngredienteRepository;
import com.tfreitsadevv.appreceitas.repositories.ReceitaRepository;
import com.tfreitsadevv.appreceitas.repositories.TipoReceitaRepository;
import com.tfreitsadevv.appreceitas.repositories.UnidadeDeCompraRepository;
import com.tfreitsadevv.appreceitas.repositories.UnidadeDeRendimentoRepository;
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
	
	@Autowired
	private TipoReceitaRepository tipoReceitaRepository;
	
	@Autowired
	private UnidadeDeRendimentoRepository unidadeRendimentoRepository;
	
	@Autowired
	private EmbalagemRepository embalagemRepository;
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private IngredienteReceitaRepository ingredienteReceitaRepository;
	
	@Autowired
	private EmbalagemReceitaRepository embalagemReceitaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppreceitasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UnidadeDeCompra uc1 = new UnidadeDeCompra(null, "Kg");
		UnidadeDeCompra uc2 = new UnidadeDeCompra(null, "g");
		UnidadeDeCompra uc3 = new UnidadeDeCompra(null, "L");
		UnidadeDeCompra uc4 = new UnidadeDeCompra(null, "Teste4");
		UnidadeDeCompra uc5 = new UnidadeDeCompra(null, "Teste5");
		UnidadeDeCompra uc6 = new UnidadeDeCompra(null, "Teste6");
		UnidadeDeCompra uc7 = new UnidadeDeCompra(null, "Teste7");
		
		UnidadeDeUso uu1 = new UnidadeDeUso(null, "Xícara");
		UnidadeDeUso uu2 = new UnidadeDeUso(null, "Colher de chá");
		UnidadeDeUso uu3 = new UnidadeDeUso(null, "Colher de sopa");
		
		Ingrediente i1 = new Ingrediente(null, "Açúcar", "União", "Refinado", 1.00, 4.00, uc1, UnidadeReferencia.G);
		Ingrediente i2 = new Ingrediente(null, "Chocolate em pó", "Nestlé", "Ao leite", 800.00, 6.00, uc2, UnidadeReferencia.G);
		Ingrediente i3 = new Ingrediente(null, "Leite", "Parmalat", "Integral", 1.00, 2.00, uc3, UnidadeReferencia.ML);		
		
		Conversao c1 = new Conversao(i1, uu1, 200.00);
		Conversao c2 = new Conversao(i1, uu2, 4.00);
		Conversao c3 = new Conversao(i1, uu3, 14.00);
		Conversao c4 = new Conversao(i2, uu1, 250.00);
		Conversao c5 = new Conversao(i2, uu2, 5.00);
		Conversao c6 = new Conversao(i2, uu3, 20.00);
		Conversao c7 = new Conversao(i3, uu1, 250.00);
		Conversao c8 = new Conversao(i3, uu3, 15.00);		
		
		TipoReceita tr1 = new TipoReceita(null, "Doce");
		
		UnidadeDeRendimento ur1 = new UnidadeDeRendimento(null, "Unidades");
		
		Embalagem e1 = new Embalagem(null, "Forminha", "Papel", "Genérico", 100, 6.00);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		Receita r1 = new Receita(null, "Receita Maluca", sdf.parse("12/07/2019"), 20.00, "Misturar tudo", 40.00, UnidadeTempo.MINUTOS, tr1, ur1);
		
		IngredienteReceita ir1 = new IngredienteReceita(i1, r1, 1.00, 0.8, uu1);
		IngredienteReceita ir2 = new IngredienteReceita(i2, r1, 8.00, 1.2, uu3);
		IngredienteReceita ir3 = new IngredienteReceita(i3, r1, 2.00, 2.5, uu1);
		
		tr1.getReceitas().addAll(Arrays.asList(r1));
		r1.getIngredientesReceita().addAll(Arrays.asList(ir1, ir2, ir3));
		i1.getReceitas().addAll(Arrays.asList(r1));
		i2.getReceitas().addAll(Arrays.asList(r1));
		i3.getReceitas().addAll(Arrays.asList(r1));
		
		EmbalagemReceita er1 = new EmbalagemReceita(e1, r1, 20, 1.2);
		
		unidadeDeCompraRepository.saveAll(Arrays.asList(uc1, uc2, uc3, uc4, uc5, uc6, uc7));
		unidadeDeUsoRepository.saveAll(Arrays.asList(uu1,uu2,uu3));
		ingredienteRepository.saveAll(Arrays.asList(i1,i2,i3));		
		conversaoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8));		
		tipoReceitaRepository.saveAll(Arrays.asList(tr1));
		unidadeRendimentoRepository.saveAll(Arrays.asList(ur1));
		embalagemRepository.saveAll(Arrays.asList(e1));
		receitaRepository.saveAll(Arrays.asList(r1));
		ingredienteReceitaRepository.saveAll(Arrays.asList(ir1, ir2, ir3));
		embalagemReceitaRepository.saveAll(Arrays.asList(er1));
		
		
				
	}
	
	

}
