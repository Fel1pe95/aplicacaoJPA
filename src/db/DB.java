package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {

	private static EntityManagerFactory factory = null;
	private static EntityManager manager = null;

	// Cria e retorna o EntityManager
	public static EntityManager getEntityManager() {

		try {
			factory = getFactory();
			manager = factory.createEntityManager();

		} catch (DbException e) {
			throw new DbException("Erro ao conectar ao banco de dados");
		}

		return manager;
	}

	// Cria e retorna o entityManagerFactory
	public static EntityManagerFactory getFactory() {
		try {
			factory = Persistence.createEntityManagerFactory("aplicacaojpa");

		} catch (DbException e) {
			throw new DbException("Erro ao conectar ao banco de Dados");
		}
		return factory;
	}

	// Fecha o EntityManager
	public static void closeEntityManager(EntityManager manager) {
		if (manager != null) {
			manager.close();
		}
	}

	// Fecha o ManagerFactory
	public static void closeEntityManagerFactory(EntityManagerFactory factory) {
		if (factory != null) {
			factory.close();
		}
	}

}
