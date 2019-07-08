package com.tfreitsadevv.appreceitas.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tfreitsadevv.appreceitas.domain.UnidadeDeCompra;

@RestController
@RequestMapping(value="/unidadesdecompra")
public class UnidadeDeCompraResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UnidadeDeCompra> listar() {
		
		UnidadeDeCompra uc1 = new UnidadeDeCompra(1, "Kg");
		UnidadeDeCompra uc2 = new UnidadeDeCompra(2, "g");
		UnidadeDeCompra uc3 = new UnidadeDeCompra(3, "L");
		
		List<UnidadeDeCompra> lista = new ArrayList<>();
		lista.add(uc1);
		lista.add(uc2);
		lista.add(uc3);
		
		return lista;
	}

}
