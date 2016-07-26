package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("financas");
	
	public EntityManager getEntityManager(){
		return entityManager.createEntityManager();
	}
}
