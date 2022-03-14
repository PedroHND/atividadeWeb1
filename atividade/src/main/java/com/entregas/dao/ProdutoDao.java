package com.entregas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.entregas.control.JPAUtil;
import com.entregas.model.Pedido;
import com.entregas.model.Produto;	

public class ProdutoDao {

	private EntityManager em = JPAUtil.getEntityManager();

	public void cadastrar(Produto produto) {
		em.getTransaction().begin();
		this.em.persist(produto);
		em.getTransaction().commit();
	}

	public void atualizar(Produto produto) {
		em.getTransaction().begin();
		this.em.merge(produto);
		em.getTransaction().commit();
	}

	public void remover(Produto produto) {
		em.getTransaction().begin();
		produto = em.merge(produto);
		this.em.remove(produto);
		em.getTransaction().begin();
	}
	
	public List<Produto> imprimeCatalogo(){
		em.getTransaction().begin();
		String jpql = "SELECT p FROM Produto p ";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public Produto consultarPorId(Long i) {
		em.getTransaction().begin();
		String jpql = "Select p FROM Produto p WHERE id= ?1";
		return em.createQuery(jpql, Produto.class).setParameter(1, i).getSingleResult();
	    
	  }

	
}
