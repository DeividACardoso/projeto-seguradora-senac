package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.seletor.SeguroSeletor;
import model.vo.Seguro;

public class SeguroDAO {

	public Seguro inserir(Seguro novoSeguro) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO SEGURO(NOME_SEGURADO, NUMERO_PROPOSTA, PLACA_VEICULO, DT_INICIO_VIGENCIA, DT_FIM_VIGENCIA, "
				+ " RCF_DANOS_MATERIAIS, RCF_DANOS_CORPORAIS, FRANQUIA, ASSISTENCIA, CARRO_RESERVA ) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		try {
			// stmt.setInt(1, novoSeguro.getIdSegurado() == null ? 0 :
			// novoSeguro.getIdSegurado());
			stmt.setString(1, novoSeguro.getNomeSegurado());
			stmt.setInt(2, novoSeguro.getNumeroProposta());
			stmt.setString(3, novoSeguro.getPlacaVeiculo());
			stmt.setDate(4, java.sql.Date.valueOf(novoSeguro.getDtInicioVigencia()));
			stmt.setDate(5, java.sql.Date.valueOf(novoSeguro.getDtFimVigencia()));
			stmt.setDouble(6, novoSeguro.getRcfDanosCorporais());
			stmt.setDouble(7, novoSeguro.getRcfDanosMateriais());
			stmt.setString(8, novoSeguro.getFranquia());
			stmt.setString(9, novoSeguro.getAssistencia());
			stmt.setString(10, novoSeguro.getCarroReserva());
			stmt.execute();

			// Preencher o id gerado no banco no objeto
			ResultSet resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				novoSeguro.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo seguro.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// Fechar a conexão
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return novoSeguro;
	}

	public boolean atualizar(Seguro seguroAtualizado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE SEGURO " + " SET NOME_SEGURADO = ?, NUMERO_PROPOSTA = ?, PLACA_VEICULO = ? " + " DT_INICIO_VIGENCIA = ?,"
				+ " DT_FIM_VIGENCIA = ?, RCF_DANOS_MATERIAIS = ?, RCF_DANOS_CORPORAIS = ?, FRANQUIA = ?, ASSISTENCIA = ?, CARRO_RESERVA = ? "
				+ " WHERE ID = ? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
			// stmt.setInt(1, seguroAtualizado.getIdSegurado());
			stmt.setString(1, seguroAtualizado.getNomeSegurado());
			stmt.setInt(2, seguroAtualizado.getNumeroProposta());
			stmt.setString(3, seguroAtualizado.getPlacaVeiculo());
			stmt.setDate(4, java.sql.Date.valueOf(seguroAtualizado.getDtInicioVigencia()));
			stmt.setDate(5, java.sql.Date.valueOf(seguroAtualizado.getDtFimVigencia()));
			stmt.setDouble(6, seguroAtualizado.getRcfDanosCorporais());
			stmt.setDouble(7, seguroAtualizado.getRcfDanosMateriais());
			stmt.setString(8, seguroAtualizado.getFranquia());
			stmt.setString(9, seguroAtualizado.getAssistencia());
			stmt.setString(10, seguroAtualizado.getCarroReserva());
			stmt.setInt(11, seguroAtualizado.getId());

			int quantidadeLinhasAtualizadas = stmt.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar seguro. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}

		return atualizou;
	}

	public Seguro consultarPorId(int id) {
		Seguro seguroConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM SEGURO " + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				seguroConsultado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar seguro com id: + " + id + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return seguroConsultado;
	}

	public boolean excluir(int id) {
		boolean excluiu = false;

		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM SEGURO " + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir seguro. " + "\n Causa: " + excecao.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}

	public List<Seguro> consultarTodos() {
		List<Seguro> seguros = new ArrayList<Seguro>();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM SEGURO ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Seguro seguroConsultado = converterDeResultSetParaEntidade(resultado);
				seguros.add(seguroConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os seguros" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return seguros;
	}

	private Seguro converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Seguro seguroConsultado = new Seguro();
		seguroConsultado.setId(resultado.getInt("id"));
		// seguroConsultado.setIdSegurado(resultado.getInt("id_segurado"));
		seguroConsultado.setNomeSegurado(resultado.getString("nome_Segurado"));
		seguroConsultado.setNumeroProposta(resultado.getInt("numero_proposta"));
		seguroConsultado.setPlacaVeiculo(resultado.getString("placa_Veiculo"));
		seguroConsultado.setDtInicioVigencia(resultado.getTimestamp("dt_inicio_vigencia").toLocalDateTime().toLocalDate());
		seguroConsultado.setDtFimVigencia(resultado.getTimestamp("dt_fim_vigencia").toLocalDateTime().toLocalDate());
		seguroConsultado.setRcfDanosMateriais(resultado.getDouble("rcf_danos_materiais"));
		seguroConsultado.setRcfDanosCorporais(resultado.getDouble("rcf_danos_corporais"));
		seguroConsultado.setFranquia(resultado.getString("franquia"));
		seguroConsultado.setAssistencia(resultado.getString("assistencia"));
		seguroConsultado.setCarroReserva(resultado.getString("carro_Reserva"));
		return seguroConsultado;
	}

	public List<Seguro> consultarPorIdCliente(Integer id) {
		List<Seguro> seguros = new ArrayList<Seguro>();
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM SEGURO " + " WHERE ID_PESSOA = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);

		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				Seguro telefoneConsultado = converterDeResultSetParaEntidade(resultado);
				seguros.add(telefoneConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os seguros do cliente informado" + "\n Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return seguros;
	}

	@SuppressWarnings("finally")
	public List<Seguro> consultarComFiltros(SeguroSeletor seletor) {
		List<Seguro> seguros = new ArrayList<Seguro>();
		Connection conexao = Banco.getConnection();
		String sql = " select * from seguro ";

		if (seletor.temFiltro()) {
			sql = preencherFiltros(sql, seletor);
		}
		if (seletor.temPaginacao()) {
			sql += " LIMIT " + seletor.getLimite() + " OFFSET " + seletor.getOffset();
		}
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();

			while (resultado.next()) {
				Seguro seguroBuscado = converterDeResultSetParaEntidade(resultado);
				seguros.add(seguroBuscado);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar todos os seguros. \n Causa:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
			return seguros;
		}

	}

	

	private String preencherFiltros(String sql, SeguroSeletor seletor) {

		boolean primeiro = true;
		if (seletor.getNomeSegurado() != null && !seletor.getNomeSegurado().trim().isEmpty()) {
			if (primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}

			sql += " nome_segurado LIKE '%" + seletor.getNomeSegurado() + "%'";
			primeiro = false;
		}

		if (seletor.getNumero_proposta() != 0 && !String.valueOf(seletor.getNumero_proposta()).trim().isEmpty()) {
			if (primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			sql += " numero_proposta LIKE '%" + seletor.getNumero_proposta() + "%'";
			primeiro = false;
		}

		if (seletor.getDt_inicio_vigencia() != null && seletor.getDt_inicio_vigencia() != null) {
			if (primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			sql += " DT_INICIO_VIGENCIA BETWEEN '" + seletor.getDt_inicio_vigencia() + "' " + " AND '"
					+ seletor.getDt_inicio_vigencia() + "' ";
			primeiro = false;
		} else {
			if (seletor.getDt_inicio_vigencia() != null) {
				if (primeiro) {
					sql += " WHERE ";
				} else {
					sql += " AND ";
				}
				// CLIENTES QUE NASCERAM 'A PARTIR' DA DATA INICIAL
				sql += " DT_INICIO_VIGENCIA >= '" + seletor.getDt_inicio_vigencia() + "' ";
				primeiro = false;
			}

			if (seletor.getDt_fim_vigencia() != null) {
				if (primeiro) {
					sql += " WHERE ";
				} else {
					sql += " AND ";
				}
				// CLIENTES QUE NASCERAM 'ATÉ' A DATA FINAL
				sql += " DT_FIM_VIGENCIA <= '" + seletor.getDt_fim_vigencia() + "' ";
				primeiro = false;
			}
		}

		return sql;
	}

	public int contarTotalRegistrosComFiltros(SeguroSeletor seletor) {
		int total = 0;
		Connection conexao = Banco.getConnection();
		String sql = " select count(*) from seguro ";

		if (seletor.temFiltro()) {
			sql = preencherFiltros(sql, seletor);
		}

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();

			if (resultado.next()) {
				total = resultado.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Erro contar o total de seguros" + "\n Causa:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return total;
	}
}
