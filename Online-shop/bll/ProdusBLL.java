package bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.ValidareClient.EmailValidator;
import bll.ValidareClient.Validator;
import dao.ProdusDAO;
import model.Produs;

public class ProdusBLL {
	
	private static List<Produs> validators;
	
	public static Produs findClientById(int id) {
		Produs st = ProdusDAO.findById(id);

		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public static int insertProdus(Produs produs) {
		
		return ProdusDAO.insert(produs);

	}
	
	public void deleteConnection(int id) throws SQLException{
		
		ProdusDAO.delete(id);
		
	}

}
