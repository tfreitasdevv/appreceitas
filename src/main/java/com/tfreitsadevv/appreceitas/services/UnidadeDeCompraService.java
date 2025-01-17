package com.tfreitsadevv.appreceitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tfreitsadevv.appreceitas.domain.UnidadeDeCompra;
import com.tfreitsadevv.appreceitas.dto.UnidadeDeCompraDTO;
import com.tfreitsadevv.appreceitas.repositories.UnidadeDeCompraRepository;
import com.tfreitsadevv.appreceitas.services.exceptions.DataIntegrityException;
import com.tfreitsadevv.appreceitas.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeDeCompraService {
	
	@Autowired
	private UnidadeDeCompraRepository repo;
	
	public UnidadeDeCompra find(Integer id) {
		Optional<UnidadeDeCompra> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: " + UnidadeDeCompra.class.getName()));
	}
		
	public UnidadeDeCompra insert(UnidadeDeCompra obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public UnidadeDeCompra update(UnidadeDeCompra obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id); }
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Unidade de Compra que possua ingredientes vinculados a ela.");
		}
	}
	
	public List<UnidadeDeCompra> findAll() {
		return repo.findAll();
	}
	
	public Page<UnidadeDeCompra> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public UnidadeDeCompra fromDTO(UnidadeDeCompraDTO objDTO) {
		return new UnidadeDeCompra(objDTO.getId(), objDTO.getNome());
	}

}