package com.tfreitsadevv.appreceitas.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/unidadesdecompra")
public class UnidadeDeCompraResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST está funcionando!";
	}

}
