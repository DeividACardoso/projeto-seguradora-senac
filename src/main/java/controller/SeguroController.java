package controller;

import java.util.List;

import model.bo.SeguroBO;
import model.seletor.SeguroSeletor;
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
	
	
	public List<Seguro> consultarComFiltros(SeguroSeletor seletor) {
		return bo.consultarComFiltros(seletor);
	}
	
	public int contarTotalRegistrosComFiltros(SeguroSeletor seletor) {
		return bo.contarTotalRegistrosComFiltros(seletor);
	}
}
