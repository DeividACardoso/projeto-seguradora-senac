package model.gerador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.dao.SeguroDAO;
import model.vo.Endereco;
import model.vo.Seguro;


	/**
	 * 
	 * @author Vilmar C. Pereira Junior Classe respons�vel por importar planilhas
	 *         xls
	 * 
	 *         Tutorial dispon�vel em:
	 *         http://www.codejava.net/coding/how-to-read-excel-files-in-java-using-apache-poi
	 *
	 */
	public class ImportadorPlanilha {

		public void importar(InputStream fis) {
			try {

				// Create Workbook instance holding reference to .xlsx file
				HSSFWorkbook planilha = new HSSFWorkbook(fis);

				// Pega a primeira aba da planilha
				HSSFSheet abaPlanilha = planilha.getSheetAt(0);

				// Obt�m o iterador de linhas da planilha escolhida
				Iterator<Row> iteradorLinha = abaPlanilha.iterator();

				// Pula a primeira linha (cabe�alho da planilha)
				iteradorLinha.next();

				int i = 1;
				while (iteradorLinha.hasNext()) {
					Row linhaAtual = iteradorLinha.next();

					Endereco endereco = criarEndereco(linhaAtual);
					Seguro seguro = criarSeguro(linhaAtual);

					if (seguro != null) {
						seguro.setIdPessoa(null);

						SeguroDAO seguroDAO = new SeguroDAO();
						seguroDAO.inserir(seguro);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// return Response.ok().build();
		}

		private Endereco criarEndereco(Row linhaAtual) {
			Endereco e = null;

			if (linhaAtual.getCell(2) != null && linhaAtual.getCell(3) != null && linhaAtual.getCell(4) != null) {
				// L� somente as c�lulas n�o-nulas
				Cell celulaRua = linhaAtual.getCell(2);
				Cell celulaBairro = linhaAtual.getCell(3);
				Cell celulaNumero = linhaAtual.getCell(4);

				String numero = celulaNumero.toString();
				String rua = celulaRua.toString();
				String bairro = celulaBairro.toString();

				e = new Endereco();
				e.setRua(rua);
				e.setBairro(bairro);
				e.setNumero(numero);
			}
			return e;
		}

		private Seguro criarSeguro(Row linhaAtual) {
			Seguro s = null;

			if (linhaAtual.getCell(0) != null && linhaAtual.getCell(1) != null) {
				Cell celulaNome = linhaAtual.getCell(0);
				Cell celulaSobrenome = linhaAtual.getCell(1);

				// TODO incluir mais campos da planilha
				s = new Seguro();
				s.setIdPessoa(null);
			}

			return s;
		}
	}

