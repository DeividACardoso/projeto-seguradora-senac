package model.bo;

import java.util.List;

import model.dao.PessoaDAO;
import model.vo.Pessoa;

public class PessoaBO {

	PessoaDAO dao = new PessoaDAO(); 
	
	public Pessoa inserir(Pessoa pessoa) {
		return dao.inserir(pessoa);
	}
	

	public boolean atualizar(Pessoa pessoa) {
		return dao.atualizar(pessoa);
	}

	public boolean excluir(int id) {
		return dao.excluir(id);
	}

	public Pessoa consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Pessoa> consultarTodos() {
		return dao.consultarTodos();
	}
	
}
