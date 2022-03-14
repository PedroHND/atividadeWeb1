package com.entregas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado  {
	
	@Id 
	private String sigla;
	private String nomeEstado;
	private String regiao;

	public Estado() {

	}

	public Estado(String sigla, String nomeEstado, String regiao) {
		
		this.sigla = sigla;
		this.nomeEstado = nomeEstado;
		this.regiao = regiao;
	}

	public Estado(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nomeEstado;
	}

	public void setNome(String nome) {
		this.nomeEstado = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


}
