package com.entregas.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	@ManyToOne
	private Usuario usuario;
	private BigDecimal valor;
	private BigDecimal frete;
	@ManyToMany
	private List<Produto> listaProduto = new ArrayList<Produto>();
	private int prazo;
	
	public Pedido() {
	}
	
	public Pedido(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public BigDecimal getFrete() {
		return frete;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
	public void addProduto(Produto prod) {
		listaProduto.add(prod);
	}
}
