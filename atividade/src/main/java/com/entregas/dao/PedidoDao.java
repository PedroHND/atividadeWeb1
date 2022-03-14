package com.entregas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.model.Pedido;
import com.entregas.model.Produto;

public class PedidoDao {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Pedido pedido) {
		em.getTransaction().begin();
		this.em.persist(pedido);
		em.getTransaction().commit();
	}

	public void atualizar(Pedido pedido) {
		
		
		
		this.em.merge(pedido);
		em.getTransaction().commit();
		
	}

	public void remover(Pedido pedido) {
		em.getTransaction().begin();
		pedido = em.merge(pedido);
		this.em.remove(pedido);
		em.getTransaction().begin();
	}
	
	public Pedido consultarPorId(Long i) {
		em.getTransaction().begin();
		return em.find(Pedido.class, i);
	    
	  }
}

	
