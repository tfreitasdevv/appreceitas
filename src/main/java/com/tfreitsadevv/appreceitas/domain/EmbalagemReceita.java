package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmbalagemReceita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private EmbalagemReceitaPK id = new EmbalagemReceitaPK();
	
	private Integer quantidade;
	private Double custo;
	
	public EmbalagemReceita() {		
	}

	public EmbalagemReceita(Embalagem embalagem, Receita receita, Integer quantidade, Double custo) {
		super();
		id.setEmbalagem(embalagem);
		id.setReceita(receita);
		this.quantidade = quantidade;
		this.custo = custo;
	}
	
	public Embalagem getEmbalagem() {
		return id.getEmbalagem();
	}
	
	public Receita getReceita() {
		return id.getReceita();
	}

	public EmbalagemReceitaPK getId() {
		return id;
	}

	public void setId(EmbalagemReceitaPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmbalagemReceita other = (EmbalagemReceita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
