package bll;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import dao.ComandaDAO;
import model.Comanda;


public class ComandaBLL {
	
private static List<Comanda> validators;
	
	public static Comanda findClientById(int id) {
		Comanda st = ComandaDAO.findById(id);

		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public static int insertComanda(Comanda comanda) {
		
		return ComandaDAO.insert(comanda);

	}
	
	public void deleteConnection(int id) throws SQLException{
		
		ComandaDAO.delete(id);
		
	}

}
