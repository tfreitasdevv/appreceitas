package com.tfreitsadevv.appreceitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tfreitsadevv.appreceitas.domain.TipoReceita;
import com.tfreitsadevv.appreceitas.dto.TipoReceitaDTO;
import com.tfreitsadevv.appreceitas.repositories.TipoReceitaRepository;
import com.tfreitsadevv.appreceitas.services.exceptions.DataIntegrityException;
import com.tfreitsadevv.appreceitas.services.exceptions.ObjectNotFoundException;

@Service
public class TipoReceitaService {
	
	@Autowired
	private TipoReceitaRepository repo;
	
	public TipoReceita find(Integer id) {
		Optional<TipoReceita> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ", Tipo: " + TipoReceita.class.getName()));
	}
		
	public TipoReceita insert(TipoReceita obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TipoReceita update(TipoReceita obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id); }
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Tipo de Receita que possua receitas vinculadas a ele.");
		}
	}
	
	public List<TipoReceita> findAll() {
		return repo.findAll();
	}
	
	public Page<TipoReceita> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public TipoReceita fromDTO(TipoReceitaDTO objDTO) {
		return new TipoReceita(objDTO.getId(), objDTO.getNome());
	}

}