package model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
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
		} catch (DbException e) {
			manager.getTransaction().rollback();
			throw new DbException("Erro ao cadastrar exercicio.");

		}

	}

	@Override
	public void update(Exercicio obj) {
		Exercicio updatedExercicio = manager.find(Exercicio.class, obj.getId());
		updatedExercicio.setNome(obj.getNome());
		try {
			manager.getTransaction().begin();
			manager.merge(updatedExercicio);
			manager.getTransaction().commit();
		} catch (DbIntegrityException e) {
			manager.getTransaction().rollback();
			throw new DbIntegrityException("Erro ao atualizar exercicio");
		} finally {
			DB.closeEntityManager(manager);
			DB.closeEntityManagerFactory(DB.getFactory());
		}

	}

	@Override
	public void removeById(Integer id) {
		Exercicio exercicio = manager.find(Exercicio.class, id);
		try {
			manager.getTransaction().begin();
			manager.remove(exercicio);
			manager.getTransaction().commit();
		} catch (DbIntegrityException e) {
			manager.getTransaction().rollback();
			throw new DbIntegrityException("Erro ao remover exercicio");
		}
	}

	@Override
	public Exercicio findById(Integer id) {
		Exercicio exercicio = manager.find(Exercicio.class, id);
		return exercicio;
	}

	@Override
	public List<Exercicio> findAll() {
		List<Exercicio> list = new ArrayList<>();
		try {
			TypedQuery<Exercicio> consulta = manager.createQuery("SELECT e FROM Exercicio e", Exercicio.class);
			list = consulta.getResultList();
		} catch (DbException e) {
			throw new DbException("Erro ao encotrar exercicios");
		} finally {
			DB.closeEntityManager(manager);
			DB.closeEntityManagerFactory(DB.getFactory());
		}

		return list;
	}

}
