package model.dao;

import db.DB;
import model.dao.impl.AlunoDaoJPA;
import model.dao.impl.ExercicioDaoJPA;

public class DaoFactory {

	public static AlunoDao creatAlunoDao() {
		return new AlunoDaoJPA(DB.getEntityManager());
	}
	
	public static ExercicioDao createExercicioDao() {
		return new ExercicioDaoJPA(DB.getEntityManager());
	}
}
