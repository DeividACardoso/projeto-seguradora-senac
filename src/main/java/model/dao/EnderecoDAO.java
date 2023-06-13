package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Endereco;

public class EnderecoDAO {

	public Endereco inserir(Endereco novoEndereco) {
		Connection conexao = Banco.getConnection();
		String sql =  " INSERT INTO ENDERECO (NUMERO, CEP, RUA, BAIRRO, CIDADE, ESTADO) "
				    + " VALUES (?,?,?,?,?,?) ";

		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			

		try {
			query.setString(1, novoEndereco.getNumero());
			query.setString(2, novoEndereco.getCep());
			query.setString(3, novoEndereco.getRua());
			query.setString(4, novoEndereco.getBairro());
			query.setString(5, novoEndereco.getCidade());
			query.setString(6, novoEndereco.getEstado());
			query.execute();
			
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novoEndereco.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o endereço. "
					+ "\nCausa: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return novoEndereco;
	}
	
	
	
	public boolean atualizar(Endereco enderecoEditado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE ENDERECO "
				   + " SET NUMERO = ?, CEP = ?, RUA = ?, "
				   + " BAIRRO = ?, CIDADE = ?, ESTADO = ? "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, enderecoEditado.getNumero());
			query.setString(2, enderecoEditado.getCep());
			query.setString(3, enderecoEditado.getRua());
			query.setString(4, enderecoEditado.getBairro());
			query.setString(5, enderecoEditado.getCidade());
			query.setString(6, enderecoEditado.getEstado());
			query.setInt(7, enderecoEditado.getId());
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar o endereço. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return atualizou;
	}
	
	
	
	public Endereco consultarPorId(int id) {
		Endereco enderecoConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM ENDERECO "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				enderecoConsultado = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao buscar endereço com id: + " + id 
								+ "\n Causa: " + erro.getMessage());	
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}	
		return enderecoConsultado;
	}
	
	
	
	public boolean excluir(int id) {
		boolean excluir = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM ENDERECO "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluir = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir o endereço. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluir;
	}
	
	
	
	public List<Endereco> consultarTodos() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM ENDERECO ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Endereco enderecoConsultado = converterDeResultSetParaEntidade(resultado);
				enderecos.add(enderecoConsultado);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao buscar todos os endereços" 
								+ "\n Causa: " + erro.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}		
		return enderecos;
	}
	
	
	
	private Endereco converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Endereco enderecoConsultado = new Endereco(); 
		enderecoConsultado.setId(resultado.getInt("id"));
		enderecoConsultado.setNumero(resultado.getString("numero"));
		enderecoConsultado.setCep(resultado.getString("cep"));
		enderecoConsultado.setRua(resultado.getString("rua"));
		enderecoConsultado.setBairro(resultado.getString("bairro"));
		enderecoConsultado.setCidade(resultado.getString("cidade"));
		enderecoConsultado.setEstado(resultado.getString("estado"));
		return enderecoConsultado;
	}
	
}