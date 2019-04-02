package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bll.ClientBLL;
import connection.ConnectionFactory;
import model.Client;

public class ClientDAO {
	
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO client (nume_c,email,adresa)"
			+ " VALUES ";
	private final static String findStatementString = "SELECT * FROM client";
	
	private final static String deleteString = "delete from client where id_c = ?";
	
	public static Client findById(int clientid) {
		Client toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		System.out.println("ok");
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			rs = findStatement.executeQuery();
			while(rs.next())
			{
				int idClient = Integer.parseInt(rs.getString("id_c"));
				if(idClient == clientid)
				{
					String nume_c = rs.getString("nume_c");
					String email = rs.getString("email");
					String adresa = rs.getString("adresa");
					toReturn = new Client(clientid, nume_c, email, adresa);
				}
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	
	public void allClient()
	{
		String statement = "SELECT * FROM client";
		Client toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			System.out.println("ok");
			findStatement = dbConnection.prepareStatement(statement);
			rs = findStatement.executeQuery();
			while(rs.next())
			{
				int clientid = Integer.parseInt(rs.getString("id_c"));
				String nume_c = rs.getString("nume_c");
				String email = rs.getString("email");
				String adresa = rs.getString("adresa");
				
				toReturn = new Client(clientid, nume_c, email, adresa);
				System.out.println(toReturn.getId_c() + " " + toReturn.getNume_c() + " " + toReturn.getEmail() + " " + toReturn.getAdresa());
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		
	}
	
	
	public static int insert(Client client) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		Statement stmt = null;
		try {
			stmt = dbConnection.createStatement();
			String sql2 = insertStatementString + "('" + client.getNume_c() + "','" +client.getEmail() + "','" + client.getAdresa() + "')";
			stmt = dbConnection.createStatement();
			stmt.executeUpdate(sql2);
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
	
}
