package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.vo.Sinistro;

public class SinistroDAO {
	public Sinistro cadastrarSinistro(Sinistro novoSinistro) {
		Connection conn = Banco.getConnection();
		String sql = " INSERT INTO SINISTRO(NUMERO_SINISTRO, TIPO_SINISTRO, IDPESSOA, IDVEICULO, DT_SINISTRO,"
				+ " VALOR_FRANQUIA, VALOR_ORCADO, VALOR_PAGO, SITUACAO, MOTIVO ) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			stmt.setString(1, novoSinistro.getNumeroSinistro());
			stmt.setObject(2, novoSinistro.getTipoSinistro());
			stmt.setInt(3, novoSinistro.getPessoa().getId());
			stmt.setInt(4, novoSinistro.getVeiculo().getId());
			stmt.setObject(5, novoSinistro.getDt_sinistro());
			stmt.setDouble(6, novoSinistro.getValor_franquia());
			stmt.setDouble(7, novoSinistro.getValor_orcado());
			stmt.setDouble(8, novoSinistro.getValor_pago());
			stmt.setString(9, novoSinistro.getSituacao());
			stmt.setString(10, novoSinistro.getMotivo());
			stmt.execute();
			
			ResultSet resultado = stmt.getGeneratedKeys();
			if(resultado.next()) {
				novoSinistro.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar novo Sinistro.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return novoSinistro;
	}
	
	public boolean atualizar(Sinistro sinistro) {
		Connection conn = Banco.getConnection();
		String sql = " UPDATE SINISTRO SET NUMERO_SINISTRO=?, TIPO_SINISTRO=?, IDPESSOA=?, IDVEICULO=?, DT_SINISTRO=? "
				+ ", VALOR_FRANQUIA=?, VALOR_ORCADO=?, VALOR_PAGO=?, SITUACAO=?, MOTIVO=? WHERE ID=? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		int registrosAlterados = 0;
		try {
			stmt.setString(1, sinistro.getNumeroSinistro());
			stmt.setObject(2, sinistro.getTipoSinistro());
			stmt.setInt(3, sinistro.getPessoa().getId());
			stmt.setInt(4, sinistro.getVeiculo().getId());
			stmt.setObject(5, sinistro.getDt_sinistro());
			stmt.setDouble(6, sinistro.getValor_franquia());
			stmt.setDouble(7, sinistro.getValor_orcado());
			stmt.setDouble(8, sinistro.getValor_pago());
			stmt.setString(9, sinistro.getMotivo());
			stmt.setString(10, sinistro.getSituacao());
			stmt.setInt(11, sinistro.getId());
			registrosAlterados = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Sinistro.");
			System.out.println("Erro: " + e.getMessage());
		}  finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return registrosAlterados > 0;
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM SINISTRO WHERE ID = " + id;
		Statement stmt = Banco.getStatement(conn);
		
		int quantidadeLinhasAfetadas = 0;
		
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Erro ao exlcuir Sinistro");
			System.out.println("Erro: " + e.getMessage());
		}  finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		boolean excluiu = quantidadeLinhasAfetadas > 0;
		
		return excluiu;
	}
	
	public Sinistro consultarPorId(int id) {
		Sinistro sinistroBuscado = null;
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM SINISTRO WHERE ID = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado =query.executeQuery();
			
			if(resultado.next()) {
				sinistroBuscado = montarSinistroComResultadoDoBanco(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar Sinistro com id.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		
		return sinistroBuscado;
	}
	
	public List<Sinistro> consultarTodos(){
		List<Sinistro> sinistros = new ArrayList<Sinistro>();
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM SINISTRO";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			
			while(resultado.next()) {
				Sinistro sinistroBuscado = montarSinistroComResultadoDoBanco(resultado);
				sinistros.add(sinistroBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os Sinistros.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		
		return sinistros;
	}

	private Sinistro montarSinistroComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Sinistro sinistroBuscado = new Sinistro();
		sinistroBuscado.setId(resultado.getInt("id"));
		sinistroBuscado.setNumeroSinistro(resultado.getString("numero_sinistro"));
		//TODO Implementar Tipo_Pessoa, IdVeiculo, IdPessoa
		sinistroBuscado.setDt_sinistro((LocalDate) resultado.getObject("dt_sinistro"));
		sinistroBuscado.setValor_franquia(resultado.getDouble("valor_franquia"));
		sinistroBuscado.setValor_orcado(resultado.getDouble("valor_orcado"));
		sinistroBuscado.setValor_pago(resultado.getDouble("valor_pago"));
		
		return sinistroBuscado;
	}
}
