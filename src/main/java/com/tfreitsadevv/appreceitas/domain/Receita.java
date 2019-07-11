package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tfreitsadevv.appreceitas.domain.enums.UnidadeTempo;

@Entity
public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date data;
	private Double rendimento;
	private String modoDePreparo;
	private Double tempoDePreparo;
	private Integer unidadeTempo;
	
	@ManyToOne
	@JoinColumn(name="tipoReceita_id")
	private TipoReceita tipoReceita;
	
	@ManyToOne
	@JoinColumn(name="unidadeDeRendimento_id")
	private UnidadeDeRendimento unidadeDeRendimento;
	
	@OneToMany(mappedBy = "id.receita")
	private Set<IngredienteReceita> ingredientesReceita = new HashSet<>();
	
	public Receita() {
		
	}

	public Receita(Integer id, String nome, Date data, Double rendimento, String modoDePreparo, Double tempoDePreparo,
			UnidadeTempo unidadeTempo, TipoReceita tipoReceita, UnidadeDeRendimento unidadeDeRendimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.rendimento = rendimento;
		this.modoDePreparo = modoDePreparo;
		this.tempoDePreparo = tempoDePreparo;
		this.unidadeTempo = unidadeTempo.getCod();
		this.tipoReceita = tipoReceita;
		this.unidadeDeRendimento = unidadeDeRendimento;
	}
	
	public List<Ingrediente> getIngredientes() {
		List<Ingrediente> listaIngredientes = new ArrayList<>();
		for (IngredienteReceita x : ingredientesReceita) {
			listaIngredientes.add(x.getIngrediente());
		}
		return listaIngredientes;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getRendimento() {
		return rendimento;
	}

	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}

	public String getModoDePreparo() {
		return modoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}

	public Double getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(Double tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	public UnidadeTempo getUnidadeTempo() {
		return UnidadeTempo.toEnum(unidadeTempo);				
	}
	
	public void setUnidadeTempo(UnidadeTempo unidadeTempo) {
		this.unidadeTempo = unidadeTempo.getCod();
	}

	public TipoReceita getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public UnidadeDeRendimento getUnidadeDeRendimento() {
		return unidadeDeRendimento;
	}

	public void setUnidadeDeRendimento(UnidadeDeRendimento unidadeDeRendimento) {
		this.unidadeDeRendimento = unidadeDeRendimento;
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
		Receita other = (Receita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<IngredienteReceita> getIngredientesReceita() {
		return ingredientesReceita;
	}

	public void setIngredientesReceita(Set<IngredienteReceita> ingredientesReceita) {
		this.ingredientesReceita = ingredientesReceita;
	}
	
	

}
