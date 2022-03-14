package com.entregas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String senha;
	@OneToOne
	private Endereco endereco;
	
	public Usuario() {
	
	}

	public Usuario(String nome, String senha, Endereco endereco) {
		this.nome = nome;
		this.senha = senha;
		this.endereco = endereco;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Dados do Usuario: <br>"
				+ "Nome: " + getNome() + "<br>"
				+ endereco.toString();
	}
	
}
