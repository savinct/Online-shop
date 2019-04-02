package bll;

import model.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.ValidareClient.*;
import connection.ConnectionFactory;
import dao.ClientDAO;

public class ClientBLL {
	
	private List<Validator<Client>> validators;

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
	}
	
	public Client findClientById(int id) {
		Client st = ClientDAO.findById(id);
		
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public int insertClient(Client client){
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		return ClientDAO.insert(client);

	}
	
	public void deleteConnection(int id) throws SQLException{
		
		 ClientDAO.delete(id);
		
	}


}
