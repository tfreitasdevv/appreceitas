package com.tfreitsadevv.appreceitas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tfreitsadevv.appreceitas.domain.TipoReceita;
import com.tfreitsadevv.appreceitas.dto.TipoReceitaDTO;
import com.tfreitsadevv.appreceitas.services.TipoReceitaService;

@RestController
@RequestMapping(value="/tiposReceita")
public class TipoReceitaResource {
	
	@Autowired
	private TipoReceitaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		TipoReceita obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}		
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TipoReceitaDTO objDTO) {
		TipoReceita obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody TipoReceitaDTO objDTO, @PathVariable Integer id){
		TipoReceita obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}		
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipoReceitaDTO>> findAll() {		
		List<TipoReceita> list = service.findAll();
		List<TipoReceitaDTO> listDTO = list.stream().map(obj -> new TipoReceitaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<TipoReceitaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {		
		Page<TipoReceita> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<TipoReceitaDTO> listDTO = list.map(obj -> new TipoReceitaDTO(obj));
		return ResponseEntity.ok().body(listDTO);	
	}
}
