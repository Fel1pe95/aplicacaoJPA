package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import db.DbException;
import model.dao.ExercicioDao;
import model.entities.Exercicio;

public class ExercicioDaoJPA implements ExercicioDao {

	private EntityManager manager;

	public ExercicioDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void insert(Exercicio obj) {
		try {
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
		}catch(DbException e) {
			manager.getTransaction().rollback();
			throw new DbException("Erro ao cadastrar exercicio.");
			
		}

	}

	@Override
	public void update(Exercicio obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Exercicio findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exercicio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
