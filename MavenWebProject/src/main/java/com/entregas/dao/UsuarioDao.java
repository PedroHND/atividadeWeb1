package com.entregas.dao;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.model.Usuario;

public class UsuarioDao {
	
	private EntityManager em = JPAUtil.getEntityManager();
	public UsuarioDao() {
		
	}

	public void cadastrar(Usuario user) {
		this.em.persist(user);
	}

	public void atualizar(Usuario user) {
		this.em.merge(user);
	}

	public void remover(Usuario user) {
		user = em.merge(user);
		this.em.remove(user);
	}
	
	public Usuario consultarPorId(String nome, String senha) {
	    
	    Usuario user = null;
	    try {
	      
	      user = em.find(Usuario.class, nome);
	    } finally {
	      em.close();
	    }
	    return user;
	  }
}
