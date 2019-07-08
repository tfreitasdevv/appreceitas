package com.tfreitsadevv.appreceitas.domain.enums;

public enum UnidadeReferencia {
	
	G(1, "Grama", "g"),
	ML(2, "Mililitro", "ml");
	
	private int cod;
	private String nome;
	private String sigla;
	
	private UnidadeReferencia(int cod, String nome, String sigla) {
		this.cod = cod;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla; 
	}
	
	public static UnidadeReferencia toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (UnidadeReferencia x : UnidadeReferencia.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido:" + cod);
	}

}
