package model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.AlunoDao;
import model.entities.Aluno;

public class AlunoDaoJPA implements AlunoDao {

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
		} catch (DbException e) {
			manager.getTransaction().rollback();
			throw new DbException("Erro ao cadastrar aluno.");
		} finally {
			DB.closeEntityManager(manager);
			DB.closeEntityManagerFactory(DB.getFactory());
		}

	}

	@Override
	public void update(Aluno obj) {
		Aluno updatedAluno = manager.find(Aluno.class, obj.getMatricula());
		updatedAluno.setNome(obj.getNome());
		updatedAluno.setTelefone(obj.getTelefone());
		try {
			manager.getTransaction().begin();
			manager.merge(updatedAluno);
			manager.getTransaction().commit();
		} catch (DbIntegrityException e) {
			manager.getTransaction().rollback();
			throw new DbIntegrityException("Erro ao atualizar dados do aluno");
		} finally {
			DB.closeEntityManager(manager);
			DB.closeEntityManagerFactory(DB.getFactory());
		}
	}

	@Override
	public void removeById(Integer id) {

		Aluno aluno = manager.find(Aluno.class, id);

		try {
			manager.getTransaction().begin();
			manager.remove(aluno);
			manager.getTransaction().commit();
		} catch (DbIntegrityException e) {
			manager.getTransaction().rollback();
			throw new DbIntegrityException("Erro ao remover aluno");
		} finally {
			DB.closeEntityManager(manager);
			DB.closeEntityManagerFactory(DB.getFactory());
		}

	}

	@Override
	public Aluno findById(Integer id) {
		Aluno obj = manager.find(Aluno.class, id);
		return obj;
	}

	@Override
	public List<Aluno> findAll() {
		List<Aluno> list = new ArrayList<>();

		try {
			TypedQuery<Aluno> consulta = manager.createQuery("SELECT a FROM Aluno a", Aluno.class);
			list = consulta.getResultList();
		} catch (DbException e) {
			throw new DbException("Erro ao encontrar alunos");
		} finally {
			DB.closeEntityManager(manager);
			DB.closeEntityManagerFactory(DB.getFactory());
		}

		return list;
	}

}
