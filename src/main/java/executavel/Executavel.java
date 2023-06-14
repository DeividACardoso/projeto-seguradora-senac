package executavel;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import controller.SeguroController;
import model.vo.Seguro;

public class Executavel {
	public static void main(String[] args) throws SQLException {

		//Seguro seguro1 = new SeguroController().consultarPorId(1);

		SeguroController controladorDeSeguros = new SeguroController();
		//ID_PESSOA, NOMESEGURADO, NUMERO_PROPOSTA, DT_INICIO_VIGENCIA, DT_FIM_VIGENCIA, PLACAVEICULO, "
			//	+ " RCF_DANOS_MATERIAIS, RCF_DANOS_CORPORAIS, FRANQUIA, ASSISTENCIA, CARRORESERVA
		Seguro novoSeguro = new Seguro();
		//novoSeguro.setIdSegurado(1);
		novoSeguro.setNomeSegurado("Leonardo Coutinho");
		novoSeguro.setNumero_proposta(12345);
		novoSeguro.setDt_inicio_vigencia(LocalDate.of(2023, 6, 5));
		novoSeguro.setDt_fim_vigencia(LocalDate.of(2024, 6, 5));
		novoSeguro.setPlacaVeiculo("MKH0D48");
		novoSeguro.setRcf_danos_materiais(200.000);
		novoSeguro.setRcf_danos_corporais(200.000);
		novoSeguro.setFranquia("Completa");
		novoSeguro.setAssistencia("Basica");
		novoSeguro.setCarroReserva("Sim");
	
	novoSeguro = controladorDeSeguros.inserir(novoSeguro);

	JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso! Id gerado: " + novoSeguro.getId(), "Sucesso",
			JOptionPane.INFORMATION_MESSAGE);

	
	}
}
