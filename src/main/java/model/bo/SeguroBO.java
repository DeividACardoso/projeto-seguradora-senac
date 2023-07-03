package model.bo;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.SeguroDAO;
import model.exception.AtributosFaltantesException;
import model.exception.CampoInvalidoException;
import model.exception.ClienteComSeguroException;
import model.exception.ValidarCamposException;
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

	public List<Seguro> consultarComFiltros(SeguroSeletor seletor) throws CampoInvalidoException {
		return dao.consultarComFiltros(seletor);
	}

	public int contarTotalRegistrosComFiltros(SeguroSeletor seletor) {
		return dao.contarTotalRegistrosComFiltros(seletor);

	}

	public boolean excluir(int id) throws ClienteComSeguroException {
//		Seguro seguroConsultado = dao.consultarPorId(id);
//
//		if (seguroConsultado.getPessoa() != null) {
//			throw new ClienteComSeguroException("Cliente possui seguro(s)");
//		}

		return dao.excluir(id);
	}

	public List<Seguro> consultarTodos() {
		return dao.consultarTodos();
	}

	public boolean atualizar(Seguro seguroAtualizado) {

		return dao.atualizar(seguroAtualizado);
	}

}
