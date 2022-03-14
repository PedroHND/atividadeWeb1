package com.entregas.dao;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.model.Usuario;

public class UsuarioDao {
	
	
	private EntityManager em = JPAUtil.getEntityManager();
	
	public UsuarioDao() {
		
	}

	public void cadastrar(Usuario user) {
		em.getTransaction().begin();
		this.em.persist(user);
		em.getTransaction().commit();
	}

	public void atualizar(Usuario user) {
		em.getTransaction().begin();
		this.em.merge(user);
		em.getTransaction().commit();
	}

	public void remover(Usuario user) {
		em.getTransaction().begin();
		user = em.merge(user);
		this.em.remove(user);
		em.getTransaction().commit();
	}
	
	public Usuario consultarLogin(String nome, String senha) {
		em.getTransaction().begin();
		String jpql = "Select u FROM Usuario u WHERE nome = ?1 and senha= ?2";
		return em.createQuery(jpql, Usuario.class).setParameter(1, nome).setParameter(2, senha).getSingleResult();
	    
	  }
	
	public Usuario consultarId(Long i) {
		em.getTransaction().begin();
		String jpql = "Select u FROM Usuario u WHERE id = ?1";
		return em.createQuery(jpql, Usuario.class).setParameter(1 , i).getSingleResult();
	    
	  }
}
