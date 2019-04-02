package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import bll.ClientBLL;
import connection.ConnectionFactory;
import model.Client;
import presentation.UI;

public class Main {
		
		protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());

		public static void main(String[] args) throws SQLException{
			
	    UI p = new UI();
		p.setTitle("Magazin");
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setSize(700, 500);
		p.setVisible(true);
		p.setResizable(true);

	}

}
