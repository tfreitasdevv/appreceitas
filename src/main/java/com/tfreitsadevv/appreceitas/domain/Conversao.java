package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conversao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ConversaoPK id = new ConversaoPK();
	
	private Double equivalencia;
	
	public Conversao() {
		
	}

	public Conversao(Ingrediente ingrediente, UnidadeDeUso unidadeDeUso, Double equivalencia) {
		super();
		id.setIngrediente(ingrediente);
		id.setUnidadeDeUso(unidadeDeUso);
		this.equivalencia = equivalencia;
	}
	
	public Ingrediente getIngrediente() {
		return id.getIngrediente();
	}
	
	public UnidadeDeUso getUnidadeDeUso() {
		return id.getUnidadeDeUso();
	}

	public ConversaoPK getId() {
		return id;
	}

	public void setId(ConversaoPK id) {
		this.id = id;
	}

	public Double getEquivalencia() {
		return equivalencia;
	}

	public void setEquivalencia(Double equivalencia) {
		this.equivalencia = equivalencia;
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
		Conversao other = (Conversao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
