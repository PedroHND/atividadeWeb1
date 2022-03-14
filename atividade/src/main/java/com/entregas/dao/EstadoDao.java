package com.entregas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.model.Estado;

public class EstadoDao {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Estado estado) {
		em.getTransaction().begin();
		this.em.persist(estado);
		em.getTransaction().commit();
	}

	public void atualizar(Estado estado) {
		em.getTransaction().begin();
		this.em.merge(estado);
		em.getTransaction().commit();
	}

	public void remover(Estado estado) {
		em.getTransaction().begin();
		estado = em.merge(estado);
		this.em.remove(estado);
		em.getTransaction().commit();
		
	}

	public List<Estado> imprimeSiglas() {
		em.getTransaction().begin();
		String jpql = "SELECT e FROM Estado e ";
		return em.createQuery(jpql, Estado.class).getResultList();
	}
	
	public Estado consultarId(String estado) {
		em.getTransaction().begin();
		String jpql = "Select e FROM Estado e WHERE id = ?1";
		return em.createQuery(jpql, Estado.class).setParameter(1 , estado).getSingleResult();
	    
	  }
}
