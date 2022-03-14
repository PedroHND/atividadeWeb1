package com.entregas.dao;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.model.Endereco;

public class EnderecoDao {

	private EntityManager em = JPAUtil.getEntityManager();


	public void cadastrar(Endereco endereco) {
		em.getTransaction().begin();
		this.em.persist(endereco);
		em.getTransaction().commit();
	}

	public void atualizar(Endereco endereco) {
		em.getTransaction().begin();
		this.em.merge(endereco);
		em.getTransaction().commit();
	}

	public void remover(Endereco endereco) {
		em.getTransaction().begin();
		endereco = em.merge(endereco);
		this.em.remove(endereco);
		em.getTransaction().begin();
	}
	
}


