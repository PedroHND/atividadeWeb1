package com.entregas.dao;

import javax.persistence.EntityManager;

import com.entregas.model.Endereco;

public class EnderecoDao {

	private EntityManager em;

	public EnderecoDao() {
		this.em = em;
	}

	public void cadastrar(Endereco endereco) {
		this.em.persist(endereco);
	}

	public void atualizar(Endereco endereco) {
		this.em.merge(endereco);
	}

	public void remover(Endereco endereco) {
		endereco = em.merge(endereco);
		this.em.remove(endereco);
	}
}


