package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class IngredienteReceitaPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="ingrediente_id")
	private Ingrediente ingrediente;
	
	@ManyToOne
	@JoinColumn(name="receita_id")
	private Receita receita;
	
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public Receita getReceita() {
		return receita;
	}
	public void setReceita(Receita receita) {
		this.receita = receita;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
		result = prime * result + ((receita == null) ? 0 : receita.hashCode());
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
		IngredienteReceitaPK other = (IngredienteReceitaPK) obj;
		if (ingrediente == null) {
			if (other.ingrediente != null)
				return false;
		} else if (!ingrediente.equals(other.ingrediente))
			return false;
		if (receita == null) {
			if (other.receita != null)
				return false;
		} else if (!receita.equals(other.receita))
			return false;
		return true;
	}
	
	
	
	

}
