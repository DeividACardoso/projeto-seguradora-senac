package model.bo;

import java.util.List;

import model.dao.PessoaDAO;
import model.gerador.GeradorPlanilha;
import model.seletor.PessoaSeletor;
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


	public List<Pessoa> consultarComFiltros(PessoaSeletor seletor) {
		//TODO validar CPF e as datas informadas
		
		return dao.consultarComFiltros(seletor);
	}


	public int contarTotalRegistrosComFiltros(PessoaSeletor seletor) {
		return dao.contarTotalRegistrosComFiltros(seletor);
	}
	
	public String gerarPlanilha(List<Pessoa> pessoas, String destinoArquivo) {
		GeradorPlanilha gerador = new GeradorPlanilha();
		return gerador.gerarPlanilhaPessoas(pessoas, destinoArquivo);
	}
	
}
