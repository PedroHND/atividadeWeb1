package com.entregas.dao;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.model.Estado;

public class EstadoDao {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Estado estado) {
		this.em.persist(estado);
	}

	public void atualizar(Estado estado) {
		this.em.merge(estado);
	}

	public void remover(Estado estado) {
		estado = em.merge(estado);
		this.em.remove(estado);
	}
}


