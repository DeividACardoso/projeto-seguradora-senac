package model.bo;

import model.dao.SeguroDAO;
import model.vo.Seguro;

public class SeguroBO {

	private SeguroDAO dao = new SeguroDAO();

	public Seguro inserir(Seguro novoSeguro) {
		return dao.inserir(novoSeguro);
	}

	public Seguro consultarPorId(int id) {
		return dao.consultarPorId(id);
	}

}


