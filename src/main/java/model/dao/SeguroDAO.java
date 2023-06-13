package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Seguro;

public class SeguroDAO {

	public Seguro inserir(Seguro novoSeguro) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO SEGURO(NOME_SEGURADO, NUMERO_PROPOSTA, DT_INICIO_VIGENCIA, DT_FIM_VIGENCIA, PLACA_VEICULO, "
				+ " RCF_DANOS_MATERIAIS, RCF_DANOS_CORPORAIS, FRANQUIA, ASSISTENCIA, CARRO_RESERVA ) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		try {
		//	stmt.setInt(1, novoSeguro.getIdSegurado() == null ? 0 : novoSeguro.getIdSegurado());
			stmt.setString(1, novoSeguro.getNomeSegurado());
			stmt.setInt(2, novoSeguro.getNumero_proposta());
			stmt.setDate(3, java.sql.Date.valueOf(novoSeguro.getDt_inicio_vigencia()));
			stmt.setDate(4, java.sql.Date.valueOf(novoSeguro.getDt_fim_vigencia()));
			stmt.setString(5, novoSeguro.getPlacaVeiculo());
			stmt.setDouble(6, novoSeguro.getRcf_danos_materiais());
			stmt.setDouble(7, novoSeguro.getRcf_danos_corporais());
			stmt.setString(8, novoSeguro.getFranquia());
			stmt.setString(9, novoSeguro.getAssistencia());
			stmt.setInt(10, novoSeguro.getCarroReserva());
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
		String sql = " UPDATE SEGURO " + " SET NOME_SEGURADO = ?, NUMERO_PROPOSTA = ?, "
				+ " DT_INICIO_VIGENCIA = ?,"
				+ " DT_FIM_VIGENCIA = ?, PLACA_VEICULO = ?, RCF_DANOS_MATERIAIS = ?, RCF_DANOS_CORPORAIS = ?, FRANQUIA = ?, ASSISTENCIA = ?, CARRO_RESERVA = ? "
				+ " WHERE ID = ? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		try {
		//	stmt.setInt(1, seguroAtualizado.getIdSegurado());
			stmt.setString(1, seguroAtualizado.getNomeSegurado());
			stmt.setInt(2, seguroAtualizado.getNumero_proposta());
			stmt.setDate(3, java.sql.Date.valueOf(seguroAtualizado.getDt_inicio_vigencia()));
			stmt.setDate(4, java.sql.Date.valueOf(seguroAtualizado.getDt_fim_vigencia()));
			stmt.setString(5, seguroAtualizado.getPlacaVeiculo());
			stmt.setDouble(6, seguroAtualizado.getRcf_danos_materiais());
			stmt.setDouble(7, seguroAtualizado.getRcf_danos_corporais());
			stmt.setString(8, seguroAtualizado.getFranquia());
			stmt.setString(9, seguroAtualizado.getAssistencia());
			stmt.setInt(10, seguroAtualizado.getCarroReserva());
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
		//seguroConsultado.setIdSegurado(resultado.getInt("id_segurado"));
		seguroConsultado.setNomeSegurado(resultado.getString("nome_Segurado"));
		seguroConsultado.setNumero_proposta(resultado.getInt("numero_proposta"));
		seguroConsultado.setDt_inicio_vigencia(resultado.getTimestamp("dt_inicio_vigencia").toLocalDateTime().toLocalDate());
		seguroConsultado.setDt_fim_vigencia(resultado.getTimestamp("dt_fim_vigencia").toLocalDateTime().toLocalDate());
		seguroConsultado.setPlacaVeiculo(resultado.getString("placa_Veiculo"));
		seguroConsultado.setRcf_danos_materiais(resultado.getDouble("rcf_danos_materiais"));
		seguroConsultado.setRcf_danos_corporais(resultado.getDouble("rcf_danos_corporais"));
		seguroConsultado.setFranquia(resultado.getString("franquia"));
		seguroConsultado.setAssistencia(resultado.getString("assistencia"));
		seguroConsultado.setCarroReserva(resultado.getInt("carro_Reserva"));
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

}
