package controller;

import java.util.List;

import model.bo.PessoaBO;
import model.exception.CampoInvalidoException;
import model.vo.Pessoa;


public class PessoaController {

	PessoaBO bo = new PessoaBO();
	
	public Pessoa inserir(Pessoa pessoa) throws CampoInvalidoException {
		String mensagemValidacao = "";
		
		if(pessoa.getNome() == null || pessoa.getNome().trim().length() == 0) {
			mensagemValidacao += "Preencha o nome \n";
		}
		if(pessoa.getDataNascimento() == null) {
			mensagemValidacao += "Preencha a data de nascimento \n";
		}
		if(pessoa.getCpf() == null) {
			mensagemValidacao += "Preencha o CPF \n";
		}
		if(pessoa.getTelefone() == null) {
			mensagemValidacao += "Preencha o telefone \n";
		}
		if(pessoa.getEndereco() == null) {
			mensagemValidacao += "Preencha o endereço \n";
		}

		
		if(mensagemValidacao != "") {
			throw new CampoInvalidoException(mensagemValidacao);
		}
		
		return bo.inserir(pessoa);
	}
	
	public boolean atualizar(Pessoa pessoa) throws CampoInvalidoException {
		String mensagemValidacao = "";
		
		if(pessoa.getNome() == null || pessoa.getNome().trim().length() == 0) {
			mensagemValidacao += "Preencha o nome \n";
		}
		if(pessoa.getDataNascimento() == null) {
			mensagemValidacao += "Preencha a data de nascimento \n";
		}
		if(pessoa.getCpf() == null) {
			mensagemValidacao += "Preencha o CPF \n";
		}
		if(pessoa.getTelefone() == null) {
			mensagemValidacao += "Preencha o telefone \n";
		}
		if(pessoa.getEndereco() == null) {
			mensagemValidacao += "Preencha o endereço \n";
		}
		
		
		if(mensagemValidacao != "") {
			throw new CampoInvalidoException(mensagemValidacao);
		}
		
		return bo.atualizar(pessoa);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Pessoa consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Pessoa> consultarTodos() {
		return bo.consultarTodos();
	}
	
	
}
