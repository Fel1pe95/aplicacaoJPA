package application;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

public class TestConsole {

	public static void main(String[] args) {

		AlunoDao aluno = DaoFactory.creatAlunoDao();

		aluno.insert(new Aluno(null, "Luis", "988344849"));
	}

}
