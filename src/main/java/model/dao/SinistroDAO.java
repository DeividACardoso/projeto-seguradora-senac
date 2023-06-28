package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.seletor.SeguroSeletor;
import model.seletor.SinistroSeletor;
import model.vo.Pessoa;
import model.vo.Sinistro;
import model.vo.Situacao;
import model.vo.TipoSinistro;
import model.vo.Veiculo;

public class SinistroDAO {
	
	VeiculoDAO veiculoDAO = new VeiculoDAO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	
	public Sinistro inserir(Sinistro novoSinistro) {
		Connection conn = Banco.getConnection();
		String sql = " INSERT INTO SINISTRO(NUMERO_SINISTRO, TIPO_SINISTRO, IDPESSOA, IDVEICULO, DT_SINISTRO,"
				+ " VALOR_FRANQUIA, VALOR_ORCADO, VALOR_PAGO, SITUACAO, MOTIVO ) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, sql);
		
		try {
			stmt.setString(1, novoSinistro.getNumeroSinistro());
			stmt.setString(2, novoSinistro.getTipoSinistro().toString());		
			stmt.setInt(3, novoSinistro.getPessoa().getId());
			stmt.setInt(4, novoSinistro.getVeiculo().getId());
			stmt.setObject(5, validarDataParaOBanco(novoSinistro.getDataSinistro()));
			stmt.setDouble(6, novoSinistro.getValorFranquia());
			stmt.setDouble(7, novoSinistro.getValorOrcado());
			stmt.setDouble(8, novoSinistro.getValorPago());
			stmt.setString(9, novoSinistro.getSituacao().toString());
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
	
	public boolean atualizar(Sinistro sinistroAtualizado) {
		boolean atualizou = false;
		Connection conn = Banco.getConnection();
		String sql = " UPDATE SINISTRO SET NUMERO_SINISTRO=?, TIPO_SINISTRO=?, IDPESSOA=?, IDVEICULO=?, DT_SINISTRO=? "
				+ ", VALOR_FRANQUIA=?, VALOR_ORCADO=?, VALOR_PAGO=?, SITUACAO=?, MOTIVO=? WHERE ID=? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			stmt.setString(1, sinistroAtualizado.getNumeroSinistro());
			stmt.setObject(2, sinistroAtualizado.getTipoSinistro().toString());
			stmt.setInt(3, sinistroAtualizado.getPessoa().getId());
			stmt.setInt(4, sinistroAtualizado.getVeiculo().getId());
			stmt.setObject(5, sinistroAtualizado.getDataSinistro());
			stmt.setDouble(6, sinistroAtualizado.getValorFranquia());
			stmt.setDouble(7, sinistroAtualizado.getValorOrcado());
			stmt.setDouble(8, sinistroAtualizado.getValorPago());
			stmt.setString(9, sinistroAtualizado.getMotivo());
			stmt.setString(10, sinistroAtualizado.getSituacao().toString());
			stmt.setInt(11, sinistroAtualizado.getId());
			
			int registrosAlterados = stmt.executeUpdate();
			atualizou = registrosAlterados > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Sinistro.");
			System.out.println("Erro: " + e.getMessage());
		}  finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return atualizou;
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
			ResultSet resultado = query.executeQuery();
			
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
		String tipoSinistroDoBanco = resultado.getString("tipo_sinistro");
		sinistroBuscado.setTipoSinistro(TipoSinistro.valueOf(tipoSinistroDoBanco));
		
		int idVeiculo = resultado.getInt("idveiculo");
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		Veiculo veiculo = veiculoDAO.consultarPorId(idVeiculo);
		sinistroBuscado.setVeiculo(veiculo);
		
		int idPessoa = resultado.getInt("idpessoa");
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.consultarPorId(idPessoa);
		sinistroBuscado.setPessoa(pessoa);
		
		String situacaoDoBanco = resultado.getString("situacao");
		sinistroBuscado.setSituacao(Situacao.valueOf(situacaoDoBanco));
		sinistroBuscado.setDataSinistro(resultado.getDate("dt_sinistro").toLocalDate());
		sinistroBuscado.setValorFranquia(resultado.getDouble("valor_franquia"));
		sinistroBuscado.setValorOrcado(resultado.getDouble("valor_orcado"));
		sinistroBuscado.setValorPago(resultado.getDouble("valor_pago"));
		
		return sinistroBuscado;
	}
		
		public List<Sinistro> consultarComFiltros(SinistroSeletor seletor) {
			List<Sinistro> sinistros = new ArrayList<Sinistro>();
			Connection conexao = Banco.getConnection();
			String sql = " select * from sinistro inner join pessoa on sinistro.idpessoa = pessoa.id ";

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
					Sinistro sinistroBuscado = montarSinistroComResultadoDoBanco(resultado);
					sinistros.add(sinistroBuscado);
				}

			} catch (Exception e) {
				System.out.println("Erro ao buscar todos os Sinistros. \n Causa:" + e.getMessage());
			} finally {
				Banco.closePreparedStatement(query);
				Banco.closeConnection(conexao);
			}
			return sinistros;
	}
	
	private String preencherFiltros(String sql, SinistroSeletor seletor) {
			
		boolean primeiro = true;
		if(seletor.getNomeSegurado() != null && !seletor.getNomeSegurado().trim().isEmpty()) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			
			sql += " nome LIKE '%" + seletor.getNomeSegurado() + "%'";
			primeiro = false;
		}
		
		if(seletor.getNumeroSinistro() != null && !seletor.getNumeroSinistro().trim().isEmpty()) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			
			sql += "numero_sinistro LIKE '%"+ seletor.getNumeroSinistro() + "%'";
			primeiro = false;
		}
		if(seletor.getSituacao() != null && seletor.getSituacao().toString().trim().isEmpty()) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			
			sql += "situacao LIKE '%"+ seletor.getSituacao().toString().toUpperCase() + "%'";
			primeiro = false;
		}
		if(seletor.getDtInicio() != null && seletor.getDtInicio().toString().trim().isEmpty()) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}
			
			sql +=  "sinistro where dt_sinistro >= '%"+ validarDataParaOBanco(seletor.getDtInicio()) + "%' ";
		}
		if(seletor.getDtFim() != null && seletor.getDtFim().toString().trim().isEmpty()) {
			if(primeiro) {
				sql += " WHERE ";
			} else {
				sql += " AND ";
			}

			sql +=  "sinistro where dt_sinistro <= '%"+ validarDataParaOBanco(seletor.getDtFim()) + "%' ";
			primeiro = false;
		}		
			
		return sql;
		}

	private String validarDataParaOBanco(LocalDate data) {
		String formatoDataSql = "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoDataSql); 
		return formatter.format(data);
	}

	public int contarTotalRegistrosComFiltros(SinistroSeletor seletor) {
		int total = 0;
		Connection conexao = Banco.getConnection();
		String sql = " select count(*) from sinistro inner join pessoa on sinistro.id = pessoa.id ";

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
			System.out.println("Erro contar o total de sinistros" + "\n Causa:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}

		return total;
	}
	
}
