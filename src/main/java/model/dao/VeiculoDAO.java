package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.vo.Veiculo;

public class VeiculoDAO {
	
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
			Banco.closeResultSet(null);
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		
		
		return veiculoBuscado;
	}

	private Veiculo montarVeiculoBuscadoComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Veiculo veiculoBuscado = new Veiculo();
		
		veiculoBuscado.setId(resultado.getInt("id"));
		veiculoBuscado.setIdSeguro(resultado.getInt("id_seguro"));
		veiculoBuscado.setPlacaVeiculo(resultado.getString("placa_veiculo"));
		veiculoBuscado.setModelo(resultado.getString("modelo"));
		return veiculoBuscado;
	}
	
}
