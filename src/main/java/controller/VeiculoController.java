package controller;

import java.util.List;

import model.bo.VeiculoBO;
import model.vo.Veiculo;

public class VeiculoController {
	
	VeiculoBO bo = new VeiculoBO();
	
	public Veiculo inserir(Veiculo novoVeiculo) {
		return bo.inserir(novoVeiculo);
	}
	
	public boolean atualizar(Veiculo veiculoAtualizado) {
		return bo.atualizar(veiculoAtualizado);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Veiculo consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Veiculo> consultarTodos() {
		return bo.consultarTodos();
	}
}
