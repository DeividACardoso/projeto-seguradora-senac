package model.gerador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.util.DateUtil;
import model.vo.Pessoa;
import model.vo.Seguro;

public class GeradorPlanilha {

	public String gerarPlanilhaSeguros(List<Seguro> seguros, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Clientes");

		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Nome");
		linhaCabecalho.createCell(1).setCellValue("CPF");
		linhaCabecalho.createCell(2).setCellValue("Data de Nascimento");
		linhaCabecalho.createCell(3).setCellValue("Endereco resumido (Cidade - UF)");
		linhaCabecalho.createCell(4).setCellValue("Quantidade de telefones");
		linhaCabecalho.createCell(5).setCellValue("Ativo?");

		int contadorLinhas = 1;
			for (Seguro c : seguros) {
				HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
				novaLinha.createCell(0).setCellValue(c.getNomeSegurado());
				novaLinha.createCell(1).setCellValue(c.getNumeroProposta());
				novaLinha.createCell(2).setCellValue(c.getPlacaVeiculo());
				novaLinha.createCell(3).setCellValue(DateUtil.formatarDataPadraoBrasil(c.getDtInicioVigencia()));
				novaLinha.createCell(4).setCellValue(DateUtil.formatarDataPadraoBrasil(c.getDtFimVigencia()));
				novaLinha.createCell(5).setCellValue(c.getRcfDanosMateriais());
				novaLinha.createCell(6).setCellValue(c.getRcfDanosCorporais());
				novaLinha.createCell(4).setCellValue(c.getFranquia());
				novaLinha.createCell(4).setCellValue(c.getAssistencia());
				novaLinha.createCell(4).setCellValue(c.getCarroReserva());
				contadorLinhas++;
			}

			return salvarNoDisco(arquivoExcel, destinoArquivo);
		}


	public String gerarPlanilhaPessoas(List<Pessoa> pessoas, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Clientes");

		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Nome");
		linhaCabecalho.createCell(1).setCellValue("CPF");
		linhaCabecalho.createCell(2).setCellValue("Data de Nascimento");
		linhaCabecalho.createCell(3).setCellValue("Seguros");
		linhaCabecalho.createCell(4).setCellValue("Telefones");
		linhaCabecalho.createCell(5).setCellValue("Endereco resumido (Cidade - UF)");

		int contadorLinhas = 1;
			for (Pessoa p : pessoas) {
				HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
				novaLinha.createCell(0).setCellValue(p.getNome());
				novaLinha.createCell(1).setCellValue(p.getCpf());
				novaLinha.createCell(2).setCellValue(DateUtil.formatarDataPadraoBrasil(p.getDataNascimento()));		
				novaLinha.createCell(4).setCellValue(p.getSeguros().size());
				novaLinha.createCell(4).setCellValue(p.getTelefone());
				novaLinha.createCell(3).setCellValue(p.getEndereco().getCidade() + " - " + p.getEndereco().getEstado());
				contadorLinhas++;
			}
			return salvarNoDisco(arquivoExcel, destinoArquivo);
	}
	
	private String salvarNoDisco(HSSFWorkbook planilha, String caminhoArquivo) {
		String mensagem = "";
		FileOutputStream saida = null;
		String extensao = ".xls";
		
		try {
			saida = new FileOutputStream(new File(caminhoArquivo + extensao));
			planilha.write(saida);
			mensagem = "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			mensagem = "Erro ao tentar salvar planilha (sem acesso): " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} catch (IOException e) {
			mensagem = "Erro de I/O ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} finally {
			if (saida != null) {
				try {
					saida.close();
					planilha.close();
				} catch (IOException e) {
					mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}
		return mensagem;

	}
}