package com.tfreitsadevv.appreceitas.domain.enums;

public enum UnidadeTempo {
	
	MINUTOS(1, "Minutos", "m"),
	HORAS(2, "Horas", "h");
	
	private int cod;
	private String nome;
	private String sigla;
	
	private UnidadeTempo(int cod, String nome, String sigla) {
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
	
	public static UnidadeTempo toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (UnidadeTempo x : UnidadeTempo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido:" + cod);
	}

}


