package br.com.dao;

import java.util.List;

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
		
		Object id = JPAUtil.getPrimaryKey(entidade);
		entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = " +id).executeUpdate();

		entityTransaction.commit();		
		entityManager.close();
		
	}
	
	public List<E> getListEntity(Class<E> entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();	
		
		
		
		List<E> lista = entityManager.createQuery("Select e from " + entidade.getName() + " e").getResultList();
		//List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();		
		
		entityTransaction.commit();		
		entityManager.close();
		
		return lista;
	}
	

}
