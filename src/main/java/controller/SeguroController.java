package controller;

import model.bo.SeguroBO;
import model.vo.Seguro;

public class SeguroController {

	private SeguroBO bo = new SeguroBO();

	public Seguro inserir(Seguro novoSeguro) {
		return bo.inserir(novoSeguro);
	}

	public Seguro consultarPorId(int id) {
		// TODO Auto-generated method stub
		return bo.consultarPorId(id);
	}
}
