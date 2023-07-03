package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.Pessoa;
import model.vo.Seguro;
import model.seletor.PessoaSeletor;
import model.vo.Endereco;

public class PessoaDAO {

	public Pessoa inserir(Pessoa novaPessoa) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PESSOA(NOME, CPF, DTNASCIMENTO, TELEFONE, ID_ENDERECO) " 
				+ " VALUES (?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		try {
			stmt.setString(1, novaPessoa.getNome());
			stmt.setString(2, novaPessoa.getCpf());
			stmt.setDate(3, java.sql.Date.valueOf(novaPessoa.getDataNascimento()));
			stmt.setString(4, novaPessoa.getTelefone());
			stmt.setInt(5, novaPessoa.getEndereco().getId());
			stmt.execute();
			
			ResultSet resultado = stmt.getGeneratedKeys();
			if(resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
			}

		} catch (SQLException erro) {
			System.out.println("Erro ao inserir nova pessoa.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}
		return novaPessoa;
	}
	
	
	
	public boolean atualizar(Pessoa pessoa) {
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE PESSOA SET NOME=?, CPF=?, DTNASCIMENTO=?, TELEFONE=?, ID_ENDERECO=? "
				+ " WHERE ID = ?";
		PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
		int registrosAlterados = 0;
		try {
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getCpf());
			stmt.setDate(3, java.sql.Date.valueOf(pessoa.getDataNascimento()));
			stmt.setString(4, pessoa.getTelefone());
			stmt.setInt(5, pessoa.getEndereco().getId());
			stmt.setInt(6, pessoa.getId());
			registrosAlterados = stmt.executeUpdate();
			 
		} catch (SQLException erro) {
			System.out.println("Erro ao inserir nova pessoa.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conexao);
		}	
		return registrosAlterados > 0;
	}
	
	
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "DELETE FROM PESSOA WHERE ID= " + id;
		Statement stmt = Banco.getStatement(conn);
		
		int quantidadeLinhasAfetadas = 0;
		
		try {
			quantidadeLinhasAfetadas = stmt.executeUpdate(sql);
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir pessoa.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		boolean excluir = quantidadeLinhasAfetadas > 0;
		return excluir;
	}


	
	public Pessoa consultarPorId(int id) {
		Pessoa pessoaBuscada = null;
		Connection conexao = Banco.getConnection();
		String sql = " select * from pessoa "
				   + " where id = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaBuscada = montarPessoaComResultadoDoBanco(resultado);
			}
			
		}catch (Exception erro) {
			System.out.println("Erro ao buscar pessoa com id: " + id 
					+ "\n Causa:" + erro.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}		
		return pessoaBuscada;
	}
	
	
	
	public List<Pessoa> consultarTodos() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Connection conexao = Banco.getConnection();
		String sql = " select * from pessoa ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();
			
			while(resultado.next()) {
				Pessoa pessoaBuscada = montarPessoaComResultadoDoBanco(resultado);
				pessoas.add(pessoaBuscada);
			}
			
		}catch (Exception erro) {
			System.out.println("Erro ao buscar todas as pessoas. \n Causa:" + erro.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}		
		return pessoas;
	}
	
	
	
	private Pessoa montarPessoaComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Pessoa pessoaBuscada = new Pessoa();
		pessoaBuscada.setId(resultado.getInt("id"));
		pessoaBuscada.setNome(resultado.getString("nome"));
		pessoaBuscada.setCpf(resultado.getString("cpf"));
		pessoaBuscada.setDataNascimento(resultado.getDate("dtNascimento").toLocalDate());
		pessoaBuscada.setTelefone(resultado.getString("telefone"));
		
		int idEnderecoDaPessoa = resultado.getInt("id_endereco");
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.consultarPorId(idEnderecoDaPessoa);
		pessoaBuscada.setEndereco(endereco);
		
		return pessoaBuscada;
	}



	public List<Pessoa> consultarComFiltros(PessoaSeletor seletor) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Connection conexao = Banco.getConnection();
		String sql = " select * from pessoa ";
		
		if(seletor.temFiltro()) {
			sql = preencherFiltros(sql, seletor);
		}
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();
			
			while(resultado.next()) {
				Pessoa pessoaBuscada = montarPessoaComResultadoDoBanco(resultado);
				pessoas.add(pessoaBuscada);
			}			
		}catch (Exception erro) {
			System.out.println("Erro ao buscar todas as pessoas. \n Causa:" + erro.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}		
		return pessoas;
	}



	private String preencherFiltros(String sql, PessoaSeletor seletor) {
		boolean primeiro = true;
		if(seletor.getNome() != null && !seletor.getNome().trim().isEmpty()) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			
			sql += " nome LIKE '%" + seletor.getNome() + "%'";
			primeiro = false;
		}
		
		if(seletor.getCpf() != null && !seletor.getCpf().trim().isEmpty()) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			sql += " cpf LIKE '%" + seletor.getCpf() + "%'";
			primeiro = false;
		}
		
		if(seletor.getDataNascimentoDe() != null
			&& seletor.getDataNascimentoAte() != null) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			sql += " DT_NASCIMENTO BETWEEN '" 
				+ seletor.getDataNascimentoDe() + "' " 
				+ " AND '" + seletor.getDataNascimentoAte() + "' ";
			primeiro = false;
		} else {
			if (seletor.getDataNascimentoDe() != null) {
				if(primeiro) {
					sql += " WHERE ";
				} else {
					sql += " AND ";
				}
				//NASCEU 'A PARTIR' DA DATA INICIAL
				sql += " DT_NASCIMENTO >= '" + seletor.getDataNascimentoDe() + "' "; 
				primeiro = false;
			}
			
			if (seletor.getDataNascimentoAte() != null) {
				if(primeiro) {
					sql += " WHERE ";
				} else {
					sql += " AND ";
				}
				//NASCEU 'ATÉ' A DATA FINAL
				sql += " DT_NASCIMENTO <= '" + seletor.getDataNascimentoAte() + "' "; 
				primeiro = false;
			}
			if(seletor.getTelefone() != null) {
				if(primeiro) {
					sql += " WHERE ";
				} else {
					sql += " AND ";
				}
				
				sql += " telefone LIKE '%" + seletor.getTelefone() + "%'";
				primeiro = false;
			}
			if(seletor.getEndereco() != null) {
				if(primeiro) {
					sql += " WHERE ";
				} else {
					sql += " AND ";
				}
				
				sql += " endereco LIKE '%" + seletor.getEndereco() + "%'";
				primeiro = false;
			}
		}	
		return sql;
	}



	public int contarTotalRegistrosComFiltros(PessoaSeletor seletor) {
		int total = 0;
		Connection conexao = Banco.getConnection();
		String sql = " select count(*) from pessoa ";
		
		if(seletor.temFiltro()) {
			sql = preencherFiltros(sql, seletor);
		}
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				total = resultado.getInt(1);
			}
		}catch (Exception erro) {
			System.out.println("Erro contar o total de pessoas" 
					+ "\n Causa:" + erro.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}		
		return total;
	}
	
}