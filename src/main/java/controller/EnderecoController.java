package controller;

import java.util.List;

import model.bo.PessoaBO;
import model.dao.EnderecoDAO;
import model.exception.CampoInvalidoException;
import model.vo.Endereco;
import model.vo.Pessoa;


public class EnderecoController {

	EnderecoDAO dao = new EnderecoDAO();
	
	public List<Endereco> consultarTodos() {
		return dao.consultarTodos();
	}
}
