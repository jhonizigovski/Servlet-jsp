package br.edu.ifms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.dao.util.Conexao;
import br.edu.ifms.modelo.Carro;

public class CarroDAO {
	
	private Connection connection;
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	public Carro inserirCarro(Carro carro) throws SQLException {
		String sql = "INSERT INTO carro (marca, nome, modelo, cor, fabricacao, chassi, ativo)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";		    
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, carro.getMarca());
		statement.setString(2, carro.getNome());
		statement.setString(3, carro.getModelo());
		statement.setString(4, carro.getCor());
		java.sql.Date fabricacao = new java.sql.Date(carro.getFabricacao().getTime());
		statement.setDate(5, fabricacao);
		statement.setString(6, carro.getChassi());
		statement.setBoolean(7, carro.isAtivo());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();
		
		carro.setId(id);
		return carro;
	}
	
public List<Carro> listarTodosCarros() throws SQLException {
		
		List<Carro> listaCarros = new ArrayList<Carro>();

		String sql = "SELECT * FROM carro";

		conectar();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			long id = resultSet.getLong("id");
			String marca = resultSet.getString("marca");
			String nome = resultSet.getString("nome");
			String modelo = resultSet.getString("modelo");
			String cor = resultSet.getString("cor");
			Date fabricacao = new Date(resultSet.getDate("fabricacao").getTime());
			String chassi = resultSet.getString("chassi");
			boolean ativo = resultSet.getBoolean("ativo");

			Carro carro = new Carro(marca, nome, modelo, cor, fabricacao, chassi, ativo);
			carro.setId(id);
			listaCarros.add(carro);
		}
		resultSet.close();
		statement.close();

		desconectar();

		return listaCarros;
	}

	public boolean apagarCarro(Carro carro) throws SQLException {
    String sql = "DELETE FROM carro where id = ?";
    
    conectar();
     
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, carro.getId());
     
    boolean linhaApagada = statement.executeUpdate() > 0;
    statement.close();
    
    desconectar();
    
    return linhaApagada;     
}
	
	public Carro getCarroById(long id) throws SQLException {
	    String sql = "SELECT * FROM carro WHERE id = ?";
	    
	    conectar();
	    
	    PreparedStatement statement = connection.prepareStatement(sql);
	    statement.setLong(1, id);
	    
	    ResultSet resultSet = statement.executeQuery();
	    Carro carro = null;
	    
	    if (resultSet.next()) {
	        String marca = resultSet.getString("marca");
	        String nome = resultSet.getString("nome");
	        String modelo = resultSet.getString("modelo");
	        String cor = resultSet.getString("cor");
	        Date fabricacao = new Date(resultSet.getDate("fabricacao").getTime());
	        String chassi = resultSet.getString("chassi");
	        boolean ativo = resultSet.getBoolean("ativo");
	        
	        carro = new Carro(marca, nome, modelo, cor, fabricacao, chassi, ativo);
	        carro.setId(resultSet.getLong("id"));
	    }
	    
	    resultSet.close();
	    statement.close();
	    
	    desconectar();
	    
	    return carro;
	}




}
