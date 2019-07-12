package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EmbalagemReceitaPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="embalagem_id")
	private Embalagem embalagem;
	
	@ManyToOne
	@JoinColumn(name="receita_id")
	private Receita receita;
	
	public Embalagem getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
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
		result = prime * result + ((embalagem == null) ? 0 : embalagem.hashCode());
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
		EmbalagemReceitaPK other = (EmbalagemReceitaPK) obj;
		if (embalagem == null) {
			if (other.embalagem != null)
				return false;
		} else if (!embalagem.equals(other.embalagem))
			return false;
		if (receita == null) {
			if (other.receita != null)
				return false;
		} else if (!receita.equals(other.receita))
			return false;
		return true;
	}
	
	

}
