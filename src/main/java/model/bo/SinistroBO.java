package model.bo;

import java.util.List;

import model.dao.SinistroDAO;
import model.vo.Pessoa;
import model.vo.Sinistro;
import model.vo.Veiculo;

public class SinistroBO {

	SinistroDAO dao = new SinistroDAO(); 
	
	public Sinistro inserir(Sinistro sinistro, Pessoa pessoa, Veiculo veiculo) {
		// TODO Auto-generated method stub
		return dao.inserir(sinistro, pessoa, veiculo);
	}
	
	public List<Sinistro> consultarTodos() {
		// TODO Auto-generated method stub
		return dao.consultarTodos();
	}

	public boolean atualizar(Sinistro sinistroAlterado) {
		// TODO Auto-generated method stub
		return dao.atualizar(sinistroAlterado);
	}

	public boolean excluir(int id) {
		// TODO Auto-generated method stub
		return dao.excluir(id);
	}

	public Sinistro consultarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.consultarPorId(id);
	}



}
