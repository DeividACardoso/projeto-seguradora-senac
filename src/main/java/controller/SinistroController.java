package controller;

import java.util.List;

import model.bo.SinistroBO;
import model.exception.CampoInvalidoException;
import model.exception.PessoaInvalidaException;
import model.exception.VeiculoInvalidaException;
import model.gerador.GeradorPlanilha;
import model.seletor.SinistroSeletor;
import model.vo.Pessoa;
import model.vo.Seguro;
import model.vo.Sinistro;
import model.vo.Veiculo;

public class SinistroController {
	
	SinistroBO bo = new SinistroBO();
	
	public Sinistro inserir(Sinistro sinistro) throws PessoaInvalidaException, VeiculoInvalidaException, CampoInvalidoException {
		String mensagemValidacao = "Por favor preencha os seguintes campos: \n";
		
		if(sinistro.getNumeroSinistro() == null || sinistro.getNumeroSinistro().trim().isEmpty()) {
			mensagemValidacao += "Numero Sinistro\n";
		}
		if(sinistro.getDataSinistro() == null || sinistro.getDataSinistro().toString().trim().isEmpty()) {
			mensagemValidacao += "Data Sinistro\n";
		}
		if(sinistro.getPessoa() == null) {
			mensagemValidacao += "Cliente\n";
		}
		if(sinistro.getVeiculo() == null) {
			mensagemValidacao += "Veiculo\n";
		}
		if(sinistro.getMotivo() == null || sinistro.getMotivo().trim().isEmpty()) {
			mensagemValidacao += "Motivo\n";
		}
		if(sinistro.getSituacao() == null || sinistro.getSituacao().toString().trim().isEmpty()) {
			mensagemValidacao += "Situação\n";
		}
		if(sinistro.getValorFranquia() == 0 || String.valueOf(sinistro.getValorFranquia()).isEmpty()) {
			mensagemValidacao += "Valor da Franquia\n";
		}
		if(sinistro.getValorOrcado() == 0 || String.valueOf(sinistro.getValorOrcado()).isEmpty()) {
			mensagemValidacao += "Valor Orçado\n";
		}
		if(sinistro.getValorPago() == 0 || String.valueOf(sinistro.getValorPago()).isEmpty()) {
			mensagemValidacao += "Valor Pago\n";
		}
		if(mensagemValidacao != "") {
			throw new CampoInvalidoException(mensagemValidacao);
		}
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

	public List<Sinistro> consultarComFiltros(SinistroSeletor seletor) {
		return bo.consultarComFiltros(seletor);
	}

	public int contarTotalRegistrosComFiltros(SinistroSeletor seletor) {
		return bo.concontarTotalRegistrosComFiltros(seletor);
	}

	public String gerarPlanilha(List<Sinistro> sinistros, String destinoArquivo) throws CampoInvalidoException {
		if(sinistros == null || destinoArquivo == null || destinoArquivo.trim().isEmpty()) {
			throw new CampoInvalidoException("Preencha todos os campos");
		}
		
		GeradorPlanilha gerador = new GeradorPlanilha();
		return gerador.gerarPlanilhaSinistros(sinistros, destinoArquivo);
	}

}
