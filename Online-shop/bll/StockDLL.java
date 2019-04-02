package bll;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import dao.StockDAO;
import model.Stock;


public class StockDLL {
	
private static List<Stock> validators;
	
	public static Stock findStockById(int id) {
		Stock st = StockDAO.findById(id);

		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public static int insertStock(Stock stock) {
		
		return StockDAO.insert(stock);

	}
	
	public void deleteConnection(int id) throws SQLException{
		
		StockDAO.delete(id);
		
	}


}
