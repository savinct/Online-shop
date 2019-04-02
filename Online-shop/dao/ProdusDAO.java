package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Produs;


public class ProdusDAO {
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO Produs (nume_p,descriere)"
			+ " VALUES (?,?)";
	private final static String findStatementString = "SELECT * FROM Produs where id_p = ?";
	
	private final static String deleteString = "delete from Produs where id_p = ?";
	
	public static Produs findById(int produstid) {
		Produs toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, produstid);
			rs = findStatement.executeQuery();
			rs.next();

			String nume_p = rs.getString("nume_p");
			String descriere = rs.getString("descriere");
			toReturn = new Produs(produstid, nume_p, descriere);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProdusDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public static int insert(Produs produs) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, produs.getNume_p());
			insertStatement.setString(2, produs.getDescriere());
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
	
	public void allProdus()
	{
		String statement = "SELECT * FROM Produs";
		Produs toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {

			findStatement = dbConnection.prepareStatement(statement);
			rs = findStatement.executeQuery();
			while(rs.next())
			{
				int id_p = Integer.parseInt(rs.getString("id_p"));
				String nume_p = rs.getString("nume_p");
				String descriere = rs.getString("descriere");

				
				toReturn = new Produs(id_p, nume_p, descriere);
				System.out.println(toReturn.getId_p() + " " + toReturn.getNume_p() + " " + toReturn.getDescriere());
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
