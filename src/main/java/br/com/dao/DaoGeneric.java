package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpautil.JPAUtil;

public class DaoGeneric<E> { // recebe qualquer tipo de classe
	
	
	public void salvar(E entidade) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();		
		entityManager.persist(entidade);		
		entityTransaction.commit();		
		entityManager.close();
		
	}
	
	public E merge(E entidade) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();		
		E retorno = entityManager.merge(entidade);		
		entityTransaction.commit();		
		entityManager.close();
		
		return retorno;
		
	}
	
	public void remove(E entidade) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();		
		entityManager.remove(entidade);		
		entityTransaction.commit();		
		entityManager.close();
		
	}
	
	public void removePorId(E entidade) {
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();		
		entityManager.remove(entidade);		
		entityTransaction.commit();		
		entityManager.close();
		
	}
	
	

}
