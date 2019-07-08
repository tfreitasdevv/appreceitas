package com.tfreitsadevv.appreceitas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfreitsadevv.appreceitas.domain.UnidadeDeCompra;
import com.tfreitsadevv.appreceitas.repositories.UnidadeDeCompraRepository;

@Service
public class UnidadeDeCompraService {
	
	@Autowired
	private UnidadeDeCompraRepository repo;
	
	public UnidadeDeCompra find(Integer id) {
		Optional<UnidadeDeCompra> obj = repo.findById(id);
		return obj.orElse(null);
	}
	

}
