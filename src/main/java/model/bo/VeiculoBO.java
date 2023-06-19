package model.bo;

import java.util.List;

import model.dao.VeiculoDAO;
import model.vo.Veiculo;

public class VeiculoBO {

	VeiculoDAO dao = new VeiculoDAO();
	
	public Veiculo inserir(Veiculo novoVeiculo) {
		return dao.inserir(novoVeiculo);
	}

	public boolean atualizar(Veiculo veiculoAtualizado) {
		return dao.atualizar(veiculoAtualizado);
	}

	public boolean excluir(int id) {
		return dao.excluir(id);
	}

	public Veiculo consultarPorId(int id) {
		return dao.consultarPorId(id);
	}

	public List<Veiculo> consultarTodos() {
		return dao.consultarTodos();
	}

}
