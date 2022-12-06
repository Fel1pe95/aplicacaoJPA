package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {

	private static EntityManagerFactory factory = null;
	private static EntityManager manager = null;
	
	public static EntityManager getEntityManager() {
		
		try {
			
			factory = Persistence.createEntityManagerFactory("aplicacaojpa");
			manager = factory.createEntityManager();	
			
		}catch(DbException e) {
			throw new DbException("Erro ao conectar ao banco de dados");
		}
		
		return manager;
	}
	
	public static void closeEntityManager(EntityManager manager) {
		if(manager != null) {
			manager.close();
		}
	}
	
	public static void closeEntityManagerFactory(EntityManagerFactory factory) {
		if(factory != null) {
			factory.close();
		}
	}
	
	
}
