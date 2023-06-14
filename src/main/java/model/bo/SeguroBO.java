package model.bo;

import java.util.List;

import model.dao.SeguroDAO;
import model.seletor.SeguroSeletor;
import model.vo.Seguro;

public class SeguroBO {

	private SeguroDAO dao = new SeguroDAO();

	public Seguro inserir(Seguro novoSeguro) {
		return dao.inserir(novoSeguro);
	}

	public Seguro consultarPorId(int id) {
		return dao.consultarPorId(id);
	}

	public List<Seguro> consultarComFiltros(SeguroSeletor seletor) {
		// TODO Auto-generated method stub
		return dao.consultarComFiltros(seletor);
	}

	public int contarTotalRegistrosComFiltros(SeguroSeletor seletor) {
		return dao.contarTotalRegistrosComFiltros(seletor);
		
	}
	
}


