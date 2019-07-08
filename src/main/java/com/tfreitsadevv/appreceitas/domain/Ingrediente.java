package com.tfreitsadevv.appreceitas.domain;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.tfreitsadevv.appreceitas.domain.enums.UnidadeReferencia;

@Entity
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String fabricante;
	private String descricao;
	private Double quantidade;
	private Double custo;
	private UnidadeReferencia unidadeReferencia;
	
	@ManyToOne
	@JoinColumn(name="unidadeDeCompra_id")
	private UnidadeDeCompra unidadeDeCompra;
	
	@OneToMany(mappedBy = "id.ingrediente")
	private Set<Conversao> ingredientes = new HashSet<>();
	
	public Ingrediente() {
		
	}

	public Ingrediente(Integer id, String nome, String fabricante, String descricao, Double quantidade, Double custo,
			UnidadeReferencia unidadeReferencia) {
		super();
		this.id = id;
		this.nome = nome;
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.custo = custo;
		this.unidadeReferencia = unidadeReferencia;
	}
	
	public List<UnidadeDeUso> getUnidadesDeUso() {
		List<UnidadeDeUso> lista = new ArrayList<>();
		for (Conversao x : ingredientes) {
			lista.add(x.getUnidadeDeUso());
		}
		return lista;
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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public UnidadeReferencia getUnidadeReferencia() {
		return unidadeReferencia;
	}

	public void setUnidadeReferencia(UnidadeReferencia unidadeReferencia) {
		this.unidadeReferencia = unidadeReferencia;
	}

	public UnidadeDeCompra getUnidadeDeCompra() {
		return unidadeDeCompra;
	}

	public void setUnidadeDeCompra(UnidadeDeCompra unidadeDeCompra) {
		this.unidadeDeCompra = unidadeDeCompra;
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
		Ingrediente other = (Ingrediente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<Conversao> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Conversao> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	

}
