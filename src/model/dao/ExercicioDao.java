package model.dao;

import java.util.List;

import model.entities.Exercicio;

public interface ExercicioDao {

	void insert(Exercicio obj);
	void update(Exercicio obj);
	void removeById(Integer id);
	Exercicio findById(Integer id);
	List<Exercicio> findAll();
	
	
	
}
