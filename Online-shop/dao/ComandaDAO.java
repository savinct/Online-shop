package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;
import model.Comanda;


public class ComandaDAO {
	
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO Comanda (id_c, id_p, cantitate)"
			+ " VALUES (?,?, ?)";
	private final static String findStatementString = "SELECT * FROM Comanda where id_com = ?";
	
	private final static String deleteString = "delete from Comanda where id_com = ?";
	
	public static Comanda findById(int comandaid) {
		Comanda toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, comandaid);
			rs = findStatement.executeQuery();
			rs.next();

			int id_c = rs.getInt("id_c");
			int id_p = rs.getInt("id_p");
			int cantitate = rs.getInt("cantitate");
			toReturn = new Comanda(comandaid, id_c, id_p, cantitate);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProdusDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public static int insert(Comanda comanda) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, comanda.getId_c());
			insertStatement.setInt(2, comanda.getId_p());
			insertStatement.setInt(3, comanda.getCantitate());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	
	public static void delete(int id) throws SQLException{
		
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement deleteStatement = null;
		
		deleteStatement = dbConnection.prepareStatement(deleteString, Statement.RETURN_GENERATED_KEYS);
		deleteStatement.setString(1, "" + id);
		deleteStatement.executeUpdate();
		
		ConnectionFactory.close(deleteStatement);
		ConnectionFactory.close(dbConnection);

		
	}
	
	public void allComanda()
	{
		String statement = "SELECT * FROM Comanda";
		Comanda toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {

			findStatement = dbConnection.prepareStatement(statement);
			rs = findStatement.executeQuery();
			while(rs.next())
			{
				int id_comm = Integer.parseInt(rs.getString("id_com"));
				int id_c = Integer.parseInt(rs.getString("id_c"));
				int id_p = Integer.parseInt(rs.getString("id_p"));
				int cantitate = Integer.parseInt(rs.getString("cantitate"));

				
				toReturn = new Comanda(id_comm, id_c, id_p, cantitate);
				System.out.println(toReturn.getId_com() + " " + toReturn.getId_c() + " " + toReturn.getId_p() + " " + toReturn.getCantitate());
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ComandaDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		
	}

}
