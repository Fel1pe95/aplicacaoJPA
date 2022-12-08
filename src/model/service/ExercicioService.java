package model.service;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ExercicioDao;
import model.entities.Exercicio;

public class ExercicioService {

	private ExercicioDao dao = DaoFactory.createExercicioDao();
	
	public List<Exercicio> findAll(){
		return dao.findAll();
	}
	
	public void saveOrUpdate(Exercicio obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}else {
			dao.update(obj);
		}
	}
	
	public void remove(Exercicio obj) {
		dao.removeById(obj.getId());
	}
}
