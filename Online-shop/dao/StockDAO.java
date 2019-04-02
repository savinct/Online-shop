package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Stock;


public class StockDAO {
	
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO Stock (id_s, nr_s)"
			+ " VALUES (?,?)";
	private final static String findStatementString = "SELECT * FROM Stock where idStock = ?";
	
	private final static String deleteString = "delete from Stock where idStock = ?";
	
	public static Stock findById(int stockid) {
		Stock toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, stockid);
			rs = findStatement.executeQuery();
			rs.next();

			int id_s = rs.getInt("id_s");
			int nr_s = rs.getInt("nr_s");
			toReturn = new Stock(id_s, nr_s);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProdusDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public static int insert(Stock stock) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, stock.getId_s());
			insertStatement.setInt(2, stock.getNr_s());

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
	
	public void allStock()
	{
		String statement = "SELECT * FROM Stock";
		Stock toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {

			findStatement = dbConnection.prepareStatement(statement);
			rs = findStatement.executeQuery();
			while(rs.next())
			{
				int idStock = Integer.parseInt(rs.getString("idStock"));
				int id_s = Integer.parseInt(rs.getString("id_s"));
				int nr_s = Integer.parseInt(rs.getString("nr_s"));

				
				toReturn = new Stock(idStock, id_s, nr_s);
				System.out.println(toReturn.getIdStock() + " " + toReturn.getId_s() + " " + toReturn.getNr_s());
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
