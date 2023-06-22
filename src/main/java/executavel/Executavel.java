package executavel;

import java.sql.SQLException;
import java.time.LocalDate;

import controller.SinistroController;
import model.dao.PessoaDAO;
import model.dao.VeiculoDAO;
import model.exception.PessoaInvalidaException;
import model.exception.VeiculoInvalidaException;
import model.vo.Pessoa;
import model.vo.Sinistro;
import model.vo.Situacao;
import model.vo.TipoSinistro;
import model.vo.Veiculo;

public class Executavel {

	public static void main(String[] args) throws SQLException {
		
		
//		Seguro seguro1 = new SeguroController().consultarPorId(1);
//
//		SeguroController controladorDeSeguros = new SeguroController();
//		//ID_PESSOA, NOMESEGURADO, NUMERO_PROPOSTA, DT_INICIO_VIGENCIA, DT_FIM_VIGENCIA, PLACAVEICULO, "
//		//	+ " RCF_DANOS_MATERIAIS, RCF_DANOS_CORPORAIS, FRANQUIA, ASSISTENCIA, CARRORESERVA
//		Seguro novoSeguro = new Seguro();
//		//novoSeguro.setIdSegurado(1);
//		novoSeguro.setNomeSegurado("Leonardo Coutinho");
//		novoSeguro.setNumeroProposta(12345);
//		novoSeguro.setDtInicioVigencia(LocalDate.of(2023, 6, 5));
//		novoSeguro.setDtFimVigencia(LocalDate.of(2024, 6, 5));
//		novoSeguro.setPlacaVeiculo("MKH0D48");
//		novoSeguro.setRcfDanosMateriais(200.000);
//		novoSeguro.setRcfDanosCorporais(200.000);
//		novoSeguro.setFranquia("Completa");
//		novoSeguro.setAssistencia("Basica");
//		novoSeguro.setCarroReserva("Sim");
//		novoSeguro = controladorDeSeguros.inserir(novoSeguro);
//
//		JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso! Id gerado: " + novoSeguro.getId(), "Sucesso",
//				JOptionPane.INFORMATION_MESSAGE);

		
		//TESTE SINISTRO INSERT E CONSULTA
		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		Pessoa pessoa1 = pessoaDAO.consultarPorId(8);
//		
//		VeiculoDAO veiculoDAO = new VeiculoDAO();
//		Veiculo veiculo1 = veiculoDAO.consultarPorId(7);
//		
		SinistroController sinCon= new SinistroController();
		sinCon.consultarTodos();
//		Sinistro sin1 = new Sinistro(pessoa1, "1", TipoSinistro.CAUSAS_NATURAIS, veiculo1, null, 1533.0, 1322.0, 3555.0, Situacao.CONCLUIDO, "Bateu");
//		try {
//			sinCon.inserir(sin1, pessoa1, veiculo1);
//		} catch (PessoaInvalidaException | VeiculoInvalidaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(sinCon.consultarTodos());
	}
}