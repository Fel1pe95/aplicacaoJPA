package model.service;

import java.util.List;

import model.dao.AlunoDao;
import model.dao.DaoFactory;
import model.entities.Aluno;

public class AlunoService {

	private AlunoDao dao = DaoFactory.creatAlunoDao();

	public List<Aluno> findAll() {
		return dao.findAll();
	}

	public Aluno findById(Integer id) {
		return dao.findById(id);
	}

	public void saveOrUpdate(Aluno obj) {
		if (obj.getMatricula() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}

	public void remove(Aluno obj) {
		dao.removeById(obj.getMatricula());
	}

}
