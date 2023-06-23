package controller;

import java.util.List;

import model.bo.SeguroBO;
import model.exception.CampoInvalidoException;
import model.exception.ClienteComSeguroException;
import model.gerador.GeradorPlanilha;
import model.seletor.SeguroSeletor;
import model.vo.Seguro;

public class SeguroController {

	private SeguroBO bo = new SeguroBO();

	public Seguro inserir(Seguro novoSeguro) {
		return bo.inserir(novoSeguro);
	}

	public Seguro consultarPorId(int id) {
		// TODO Auto-generated method stub
		return bo.consultarPorId(id);
	}
	
	
	public List<Seguro> consultarComFiltros(SeguroSeletor seletor) throws CampoInvalidoException {
		return bo.consultarComFiltros(seletor);
	}
	
	public int contarTotalRegistrosComFiltros(SeguroSeletor seletor) {
		return bo.contarTotalRegistrosComFiltros(seletor);
	}

	public boolean excluir(Integer id) throws ClienteComSeguroException {
		return bo.excluir(id);
		
	}

	public List<Seguro> consultarTodos() {
		return bo.consultarTodos();
	}

	public boolean atualizar(Seguro seguroAtualizado) throws ClienteComSeguroException, CampoInvalidoException {
		return bo.atualizar(seguroAtualizado);
		
	}

	public String gerarPlanilha(List<Seguro> seguros, String destinoArquivo) throws CampoInvalidoException {
		if(seguros == null || destinoArquivo == null || destinoArquivo.trim().isEmpty()) {
			throw new CampoInvalidoException("Preencha todos os campos");
		}
		
		GeradorPlanilha gerador = new GeradorPlanilha();
		return gerador.gerarPlanilhaSeguros(seguros, destinoArquivo);
	}
}

