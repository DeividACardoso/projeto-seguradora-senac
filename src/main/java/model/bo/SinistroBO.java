package model.bo;

import java.util.List;

import model.dao.SinistroDAO;
import model.exception.PessoaInvalidaException;
import model.exception.VeiculoInvalidaException;
import model.seletor.SinistroSeletor;
import model.vo.Pessoa;
import model.vo.Sinistro;
import model.vo.Veiculo;

public class SinistroBO {

	SinistroDAO dao = new SinistroDAO(); 
	
	public Sinistro inserir(Sinistro sinistro) throws PessoaInvalidaException, VeiculoInvalidaException {
		if(sinistro.getPessoa() == null) {
			throw new PessoaInvalidaException("Campo de Segurado deve ser Preenchido!");
		}
		if(sinistro.getVeiculo() == null) {
			throw new VeiculoInvalidaException("Campo de veículo deve ser Preenchido!");
		}
		return dao.inserir(sinistro);
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

	public List<Sinistro> consultarComFiltros(SinistroSeletor seletor) {
		return dao.consultarComFiltros(seletor);
	}

	public int concontarTotalRegistrosComFiltros(SinistroSeletor seletor) {
		return dao.contarTotalRegistrosComFiltros(seletor);
	}



}
