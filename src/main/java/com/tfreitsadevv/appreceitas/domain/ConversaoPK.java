package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ConversaoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="ingrediente_id")
	private Ingrediente ingrediente;
	
	@ManyToOne
	@JoinColumn(name="unidadeDeUso_id") //verificar se "unidade de uso" precisar ser separado por ___
	private UnidadeDeUso unidadeDeUso;
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public UnidadeDeUso getUnidadeDeUso() {
		return unidadeDeUso;
	}
	public void setUnidadeDeUso(UnidadeDeUso unidadeDeUso) {
		this.unidadeDeUso = unidadeDeUso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
		result = prime * result + ((unidadeDeUso == null) ? 0 : unidadeDeUso.hashCode());
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
		ConversaoPK other = (ConversaoPK) obj;
		if (ingrediente == null) {
			if (other.ingrediente != null)
				return false;
		} else if (!ingrediente.equals(other.ingrediente))
			return false;
		if (unidadeDeUso == null) {
			if (other.unidadeDeUso != null)
				return false;
		} else if (!unidadeDeUso.equals(other.unidadeDeUso))
			return false;
		return true;
	}
	
	

}
