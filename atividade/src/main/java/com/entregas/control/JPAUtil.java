package com.entregas.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("entregas");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();

	}
}