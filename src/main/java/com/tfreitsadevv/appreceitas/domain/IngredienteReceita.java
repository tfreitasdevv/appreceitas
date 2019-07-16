package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IngredienteReceita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private IngredienteReceitaPK id = new IngredienteReceitaPK();
	
	private Double quantidade;
	private Double custo;
	
	@ManyToOne
	@JoinColumn(name="unidadeDeUso_id")
	private UnidadeDeUso unidadeDeUso;
	
	public IngredienteReceita( ) {		
	}

	public IngredienteReceita(Ingrediente ingrediente, Receita receita, Double quantidade, Double custo, UnidadeDeUso unidadeDeUso) {
		super();
		id.setIngrediente(ingrediente);
		id.setReceita(receita);
		this.quantidade = quantidade;
		this.custo = custo;
		this.unidadeDeUso = unidadeDeUso;
	}
	
	public Ingrediente getIngrediente() {
		return id.getIngrediente();
	}
	
	public Receita getReceita() {
		return id.getReceita();
	}

	public IngredienteReceitaPK getId() {
		return id;
	}

	public void setId(IngredienteReceitaPK id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
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
		IngredienteReceita other = (IngredienteReceita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public UnidadeDeUso getUnidadeDeUso() {
		return unidadeDeUso;
	}

	public void setUnidadeDeUso(UnidadeDeUso unidadeDeUso) {
		this.unidadeDeUso = unidadeDeUso;
	}
	
	

}
