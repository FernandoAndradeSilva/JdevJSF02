package br.com.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {	
	
	private static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init() {
		
		try {			
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager(); /*Prove a parte de persistência*/
	}
	
	
	public static Object getPrimaryKey(Object entity) {
		// PEGA O PRIMARY KEY DA ENTIDADE
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
		
	}
}
