package com.entregas.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private BigDecimal preco;

	public Produto() {
	}
	
	public Produto(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
			return "<li>" + getNome() + " R$"+ getPreco()+ "</li> <hr>" ;
	}
}
