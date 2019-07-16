package com.tfreitsadevv.appreceitas.dto;

import java.io.Serializable;

import com.tfreitsadevv.appreceitas.domain.TipoReceita;

public class TipoReceitaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public  TipoReceitaDTO() {		
	}
	
	public TipoReceitaDTO(TipoReceita obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
