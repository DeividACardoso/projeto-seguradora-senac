package controller;

import java.util.List;

import model.bo.SinistroBO;
import model.exception.PessoaInvalidaException;
import model.exception.VeiculoInvalidaException;
import model.vo.Pessoa;
import model.vo.Sinistro;
import model.vo.Veiculo;

public class SinistroController {
	
	SinistroBO bo = new SinistroBO();
	
	public Sinistro inserir(Sinistro sinistro) throws PessoaInvalidaException, VeiculoInvalidaException {
		// TODO Auto-generated method stub
		return bo.inserir(sinistro);
	}
	
	public boolean atualizar(Sinistro sinistroAlterado) {
		return bo.atualizar(sinistroAlterado);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Sinistro consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Sinistro> consultarTodos() {
		// TODO Auto-generated method stub
		return bo.consultarTodos();
	}



}
