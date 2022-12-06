package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import db.DB;
import db.DbException;
import model.dao.AlunoDao;
import model.entities.Aluno;

public class AlunoDaoJPA implements AlunoDao{

	private EntityManager manager;
	
	public AlunoDaoJPA(EntityManager manager) {
		this.manager = manager;
	}
	
	
	@Override
	public void insert(Aluno obj) {
		try {
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
		}catch(DbException e) {
			manager.getTransaction().rollback();
			throw new DbException("Erro ao cadastrar aluno.");
			
		}

	}

	@Override
	public void update(Aluno obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Aluno findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
