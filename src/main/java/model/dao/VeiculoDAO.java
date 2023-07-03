package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Veiculo;

public class VeiculoDAO {
	
	public Veiculo inserir(Veiculo novoVeiculo) {
		Connection conn = Banco.getConnection();
		String sql = " INSERT INTO VEICULO (PLACA_VEICULO, MARCA) VALUES (?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conn, sql);
		
		try {
			stmt.setString(1, novoVeiculo.getPlacaVeiculo());
			stmt.setString(2, novoVeiculo.getModelo());
			stmt.execute();
			
			ResultSet resultado = stmt.getGeneratedKeys();
			if(resultado.next()) {
				novoVeiculo.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar veiculo.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);			
		}
		
		return novoVeiculo;
	}
	
	public boolean atualizar(Veiculo veiculoAtualizado) {
		boolean atualizou = false;
		Connection conn = Banco.getConnection();
		String sql = " UPDATE VEICULO SET PLACA_VEICULO = ?, MODELO = ? "
				+ " WHERE ID = ? ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql);
		
		try {
			stmt.setString(1, veiculoAtualizado.getPlacaVeiculo());
			stmt.setString(2, veiculoAtualizado.getModelo());
			stmt.setInt(3, veiculoAtualizado.getId());
			
			int quantLinhasAtualizadas = stmt.executeUpdate();
			atualizou = quantLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar veiculos.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return atualizou;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		
		Connection conn = Banco.getConnection();
		String sql = " DELETE FROM VEICULO WHERE ID = ?";	
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			query.setInt(1, id);

			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir seguro. ");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}		
		return excluiu;
	}
	
	public Veiculo consultarPorId(int id){
		Veiculo veiculoBuscado = null;
		Connection conn = Banco.getConnection();
		String sql = "SELECT * FROM VEICULO WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				veiculoBuscado = montarVeiculoBuscadoComResultadoDoBanco(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar veiculo por id");
			System.out.println("Erro: " + e.getMessage());			
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		
		
		return veiculoBuscado;
	}
	
	public List<Veiculo> consultarTodos(){
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		Connection conn = Banco.getConnection();
		String sql = " SELECT * FROM VEICULO ";
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Veiculo veiculoConsultado = montarVeiculoBuscadoComResultadoDoBanco(resultado);
				veiculos.add(veiculoConsultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os veículos");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		return veiculos;
	}

	private Veiculo montarVeiculoBuscadoComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Veiculo veiculoBuscado = new Veiculo();
		
		veiculoBuscado.setId(resultado.getInt("id"));
		veiculoBuscado.setPlacaVeiculo(resultado.getString("placa_veiculo"));
		veiculoBuscado.setModelo(resultado.getString("modelo"));
		return veiculoBuscado;
	}
	
}
