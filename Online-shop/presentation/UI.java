package presentation;

import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import bll.ClientBLL;
import bll.ComandaBLL;
import bll.ProdusBLL;
import bll.StockDLL;
import connection.ConnectionFactory;
import dao.ClientDAO;
import dao.ComandaDAO;
import dao.ProdusDAO;
import dao.StockDAO;
import model.Client;
import model.Comanda;
import model.Produs;
import model.Stock;


public class UI extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	protected static final Logger LOGGER = Logger.getLogger(UI.class.getName());
	
	private JPanel panou = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panouT = new JPanel();
	private JTable table = new JTable();
	DefaultTableModel tableModel = new DefaultTableModel();
	
	
	
	private JPanel tabele = new JPanel();
	private JButton client = new JButton("Client");
	private JButton comanda = new JButton("Comanda");
	private JButton produs = new JButton("Produs");
	private JButton stoc = new JButton("Stoc");
	
	private JPanel meniu1 = new JPanel();
	private JButton cautare1 = new JButton("cautare");
	private JButton stergere1 = new JButton("stergere");
	private JButton add1 = new JButton("add");
	private JButton update1 = new JButton("update");
	
	private JPanel meniu1C = new JPanel();
	private JLabel labelmeniu1C= new JLabel("Cautare: ");
	private JTextField textmeniu1C = new JTextField("", 10);
	private JButton buttonmeniu1C= new JButton("OK");
	
	private JPanel meniu1S = new JPanel();
	private JLabel labelmeniu1S= new JLabel("Stergere: ");
	private JTextField textmeniu1S = new JTextField("", 10);
	private JButton buttonmeniu1s = new JButton("OK");
	
	private JPanel meniu1A = new JPanel();
	private JLabel labelmeniu1A1 = new JLabel("ADD:   Nume: ");
	private JTextField textmeniu1A1 = new JTextField("", 10);
	private JLabel labelmeniu1A2 = new JLabel("email: ");
	private JTextField textmeniu1A2 = new JTextField("", 10);
	private JLabel labelmeniu1A3 = new JLabel("adresa: ");
	private JTextField textmeniu1A3 = new JTextField("", 10);
	private JButton buttonmeniu1A = new JButton("OK");
	
	private JPanel meniu1U = new JPanel();
	private JLabel labelmeniu1U1 = new JLabel("ADD:   ID: ");
	private JTextField textmeniu1U1 = new JTextField("", 10);
	private JLabel labelmeniu1U3 = new JLabel("adresa: ");
	private JTextField textmeniu1U3 = new JTextField("", 10);
	private JButton buttonmeniu1U = new JButton("OK");
	
	private JPanel meniu2 = new JPanel();
	private JButton cautare2 = new JButton("cautare");
	private JButton stergere2 = new JButton("stergere");
	private JButton add2 = new JButton("add");
	private JButton update2 = new JButton("update");
	
	private JPanel meniu2C = new JPanel();
	private JLabel labelmeniu2C= new JLabel("Cautare: ");
	private JTextField textmeniu2C = new JTextField("", 10);
	private JButton buttonmeniu2C= new JButton("OK");
	
	private JPanel meniu2S = new JPanel();
	private JLabel labelmeniu2S= new JLabel("Stergere: ");
	private JTextField textmeniu2S = new JTextField("", 10);
	private JButton buttonmeniu2s = new JButton("OK");
	
	private JPanel meniu2A = new JPanel();
	private JLabel labelmeniu2A2 = new JLabel("Comanda: id_Client: ");
	private JTextField textmeniu2A2 = new JTextField("", 10);
	private JLabel labelmeniu2A3 = new JLabel("id_Produs: ");
	private JTextField textmeniu2A3 = new JTextField("", 10);
	private JLabel labelmeniu2A4 = new JLabel("Cantitate: ");
	private JTextField textmeniu2A4 = new JTextField("", 10);
	private JButton buttonmeniu2A = new JButton("OK");
	
	private JPanel meniu2U = new JPanel();
	private JLabel labelmeniu2U1 = new JLabel("ADD:   id_Comanada: ");
	private JTextField textmeniu2U1 = new JTextField("", 10);
	private JLabel labelmeniu2U3 = new JLabel("Cantitate: ");
	private JTextField textmeniu2U3 = new JTextField("", 10);
	private JButton buttonmeniu2U = new JButton("OK");
	
	
	
	
	private JPanel meniu3 = new JPanel();
	private JButton cautare3 = new JButton("cautare");
	private JButton stergere3 = new JButton("stergere");
	private JButton add3 = new JButton("add");
	private JButton update3 = new JButton("update");
	
	private JPanel meniu3C = new JPanel();
	private JLabel labelmeniu3C= new JLabel("Cautare: ");
	private JTextField textmeniu3C = new JTextField("", 10);
	private JButton buttonmeniu3C= new JButton("OK");
	
	private JPanel meniu3S = new JPanel();
	private JLabel labelmeniu3S= new JLabel("Stergere: ");
	private JTextField textmeniu3S = new JTextField("", 10);
	private JButton buttonmeniu3s = new JButton("OK");
	
	private JPanel meniu3A = new JPanel();
	private JLabel labelmeniu3A1 = new JLabel("ADD:   Nume_Produs: ");
	private JTextField textmeniu3A1 = new JTextField("", 10);
	private JLabel labelmeniu3A2 = new JLabel("descriere: ");
	private JTextField textmeniu3A2 = new JTextField("", 10);
	private JButton buttonmeniu3A = new JButton("OK");
	
	private JPanel meniu3U = new JPanel();
	private JLabel labelmeniu3U1 = new JLabel("ADD:   id_Produs: ");
	private JTextField textmeniu3U1 = new JTextField("", 10);
	private JLabel labelmeniu3U2 = new JLabel("descriere: ");
	private JTextField textmeniu3U2 = new JTextField("", 10);
	private JButton buttonmeniu3U = new JButton("OK");
	
	
	
	
	private JPanel meniu4 = new JPanel();
	private JButton cautare4 = new JButton("cautare");
	private JButton stergere4 = new JButton("stergere");
	private JButton add4 = new JButton("add");
	private JButton update4 = new JButton("update");
	
	private JPanel meniu4C = new JPanel();
	private JLabel labelmeniu4C= new JLabel("Cautare: ");
	private JTextField textmeniu4C = new JTextField("", 10);
	private JButton buttonmeniu4C= new JButton("OK");
	
	private JPanel meniu4S = new JPanel();
	private JLabel labelmeniu4S= new JLabel("Stergere: ");
	private JTextField textmeniu4S = new JTextField("", 10);
	private JButton buttonmeniu4s = new JButton("OK");
	
	private JPanel meniu4A = new JPanel();
	private JLabel labelmeniu4A1 = new JLabel("ADD:   id_Produs: ");
	private JTextField textmeniu4A1 = new JTextField("", 10);
	private JLabel labelmeniu4A2 = new JLabel("Cantitate: ");
	private JTextField textmeniu4A2 = new JTextField("", 10);
	private JButton buttonmeniu4A = new JButton("OK");
	
	private JPanel meniu4U = new JPanel();
	private JLabel labelmeniu4U1 = new JLabel("ADD:   id_Produs: ");
	private JTextField textmeniu4U1 = new JTextField("", 10);
	private JLabel labelmeniu4U2 = new JLabel("Cantitate: ");
	private JTextField textmeniu4U2 = new JTextField("", 10);
	private JButton buttonmeniu4U = new JButton("OK");
	
	
	
	public UI() {
		
		

		panou.setLayout(new BoxLayout(panou, BoxLayout.PAGE_AXIS));
		
		
		
		

		tabele.add(client);
		tabele.add(comanda);
		tabele.add(produs);
		tabele.add(stoc);
		
		meniu1.add(cautare1);
		meniu1.add(stergere1);
		meniu1.add(add1);
		meniu1.add(update1);
		meniu1.setVisible(false);
		
		meniu1C.add(labelmeniu1C);
		meniu1C.add(textmeniu1C);
		meniu1C.add(buttonmeniu1C);
		meniu1C.setVisible(false);
		
		meniu1S.add(labelmeniu1S);
		meniu1S.add(textmeniu1S);
		meniu1S.add(buttonmeniu1s);
		meniu1S.setVisible(false);
		
		meniu1A.add(labelmeniu1A1);
		meniu1A.add(textmeniu1A1);
		meniu1A.add(labelmeniu1A2);
		meniu1A.add(textmeniu1A2);
		meniu1A.add(labelmeniu1A3);
		meniu1A.add(textmeniu1A3);
		meniu1A.add(buttonmeniu1A);
		meniu1A.setVisible(false);
		
		meniu1U.add(labelmeniu1U1);
		meniu1U.add(textmeniu1U1);
		meniu1U.add(labelmeniu1U3);
		meniu1U.add(textmeniu1U3);
		meniu1U.add(buttonmeniu1U);
		meniu1U.setVisible(false);
		
		
		meniu2.add(cautare2);
		meniu2.add(stergere2);
		meniu2.add(add2);
		meniu2.add(update2);
		meniu2.setVisible(false);
		
		meniu2C.add(labelmeniu2C);
		meniu2C.add(textmeniu2C);
		meniu2C.add(buttonmeniu2C);
		meniu2C.setVisible(false);
		
		meniu2S.add(labelmeniu2S);
		meniu2S.add(textmeniu2S);
		meniu2S.add(buttonmeniu2s);
		meniu2S.setVisible(false);
		
		
		
		meniu2A.add(labelmeniu2A2);
		meniu2A.add(textmeniu2A2);
		meniu2A.add(labelmeniu2A3);
		meniu2A.add(textmeniu2A3);
		meniu2A.add(labelmeniu2A4);
		meniu2A.add(textmeniu2A4);;
		meniu2A.add(buttonmeniu2A);
		meniu2A.setVisible(false);
		
		meniu2U.add(labelmeniu2U1);
		meniu2U.add(textmeniu2U1);
		meniu2U.add(labelmeniu2U3);
		meniu2U.add(textmeniu2U3);
		meniu2U.add(buttonmeniu2U);
		meniu2U.setVisible(false);
		
		
		meniu3.add(cautare3);
		meniu3.add(stergere3);
		meniu3.add(add3);
		meniu3.add(update3);
		meniu3.setVisible(false);
		
		meniu3C.add(labelmeniu3C);
		meniu3C.add(textmeniu3C);
		meniu3C.add(buttonmeniu3C);
		meniu3C.setVisible(false);
		
		meniu3S.add(labelmeniu3S);
		meniu3S.add(textmeniu3S);
		meniu3S.add(buttonmeniu3s);
		meniu3S.setVisible(false);
		
		meniu3A.add(labelmeniu3A1);
		meniu3A.add(textmeniu3A1);
		meniu3A.add(labelmeniu3A2);
		meniu3A.add(textmeniu3A2);
		meniu3A.add(buttonmeniu3A);
		meniu3A.setVisible(false);
		
		meniu3U.add(labelmeniu3U1);
		meniu3U.add(textmeniu3U1);
		meniu3U.add(labelmeniu3U2);
		meniu3U.add(textmeniu3U2);
		meniu3U.add(buttonmeniu3U);
		meniu3U.setVisible(false);
		
		
		meniu4.add(cautare4);
		meniu4.add(stergere4);
		meniu4.add(add4);
		meniu4.add(update4);
		meniu4.setVisible(false);
		
		meniu4C.add(labelmeniu4C);
		meniu4C.add(textmeniu4C);
		meniu4C.add(buttonmeniu4C);
		meniu4C.setVisible(false);
		
		meniu4S.add(labelmeniu4S);
		meniu4S.add(textmeniu4S);
		meniu4S.add(buttonmeniu4s);
		meniu4S.setVisible(false);
		
		meniu4A.add(labelmeniu4A1);
		meniu4A.add(textmeniu4A1);
		meniu4A.add(labelmeniu4A2);
		meniu4A.add(textmeniu4A2);
		meniu4A.add(buttonmeniu4A);
		meniu4A.setVisible(false);
		
		
		meniu4U.add(labelmeniu4U1);
		meniu4U.add(textmeniu4U1);
		meniu4U.add(labelmeniu4U2);
		meniu4U.add(textmeniu4U2);
		meniu4U.add(buttonmeniu4U);
		meniu4U.setVisible(false);
		
		//panouT.add(table);
		

		client.addActionListener(this);
		comanda.addActionListener(this);
		produs.addActionListener(this);
		stoc.addActionListener(this);
		
		cautare1.addActionListener(this);
		stergere1.addActionListener(this);
		add1.addActionListener(this);
		buttonmeniu1s.addActionListener(this);
		buttonmeniu1A.addActionListener(this);
		update1.addActionListener(this);
		cautare2.addActionListener(this);
		stergere2.addActionListener(this);
		add2.addActionListener(this);
		update2.addActionListener(this);
		cautare3.addActionListener(this);
		stergere3.addActionListener(this);
		add3.addActionListener(this);
		update3.addActionListener(this);
		buttonmeniu3s.addActionListener(this);
		buttonmeniu3A.addActionListener(this);
		cautare4.addActionListener(this);
		stergere4.addActionListener(this);
		add4.addActionListener(this);
		update4.addActionListener(this);
		
		buttonmeniu2A.addActionListener(this);
		buttonmeniu2s.addActionListener(this);
		buttonmeniu4s.addActionListener(this);
		buttonmeniu4A.addActionListener(this);
		buttonmeniu1C.addActionListener(this);
		
		
		panou.add(tabele);
		
		panou.add(meniu1);
		panou.add(meniu1C);
		panou.add(meniu1S);
		panou.add(meniu1A);
		panou.add(meniu1U);
		
		panou.add(meniu2);
		panou.add(meniu2C);
		panou.add(meniu2S);
		panou.add(meniu2A);
		panou.add(meniu2U);
		
		panou.add(meniu3);
		panou.add(meniu3C);
		panou.add(meniu3S);
		panou.add(meniu3A);
		panou.add(meniu3U);
		
		panou.add(meniu4);	
		panou.add(meniu4C);
		panou.add(meniu4S);
		panou.add(meniu4A);
		panou.add(meniu4U);
		
		panou.add(panouT);

		add(panou);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == client) { 
			meniu1.setVisible(true);
			meniu2.setVisible(false);
			meniu3.setVisible(false);
			meniu4.setVisible(false);
			
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			
			ClientDAO x = new ClientDAO();
			x.allClient();			
			
			ArrayList<Client> clienti = new ArrayList<Client>();
			String statement = "SELECT * FROM client";
			Client toReturn = null;
			
			ArrayList <String> coloane = new ArrayList <String> (10);
			String[] col = new String [coloane.size()];
			

			Connection dbConnection = ConnectionFactory.getConnection();
			PreparedStatement findStatement = null;
			ResultSet rs = null;

			DefaultTableModel tableModel = new DefaultTableModel();
			Object client = new Client ();
			Field[] fields = client.getClass().getDeclaredFields();
			for (Field f : fields )
			{	
				coloane.add(f.getName());
			
			}
			for (int i=0;i<coloane.size();i++)
			{
				System.out.println(coloane.get(i));
			}
				

				
				
					try {
						findStatement = dbConnection.prepareStatement(statement);
						rs = findStatement.executeQuery();
						while(rs.next())
						{
							int clientid = Integer.parseInt(rs.getString("id_c"));
							String nume_c = rs.getString("nume_c");
							String email = rs.getString("email");
							String adresa = rs.getString("adresa");
							
							toReturn = new Client(clientid, nume_c, email, adresa);
							clienti.add(toReturn);
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					
					col=coloane.toArray(col);
					
					for(String s : col)
					    System.out.println(s);
					

					MyTableModel m = new MyTableModel ();
					tableModel=m.creare(client.getClass(),clienti);
					
					if(scrollPane != null)
						panou.remove(scrollPane);
					scrollPane = new JScrollPane();
					scrollPane.setBounds(356, 109, 329, 154);
					panou.add(scrollPane);
					
					table = new JTable(tableModel);
					//panouT.setVisible(true);
					//scrollPane.add(table);
					scrollPane.setViewportView(table);
			
		}
		
		if(arg0.getSource() == comanda){ 
			meniu1.setVisible(false);
			meniu2.setVisible(true);
			meniu3.setVisible(false);
			meniu4.setVisible(false);
			
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			
			ComandaDAO x = new ComandaDAO();
			x.allComanda();	
			
			ArrayList<Comanda> clienti = new ArrayList<Comanda>();
			String statement = "SELECT * FROM Comanda";
			Comanda toReturn = null;
			
			ArrayList <String> coloane = new ArrayList <String> (10);
			String[] col = new String [coloane.size()];
			

			Connection dbConnection = ConnectionFactory.getConnection();
			PreparedStatement findStatement = null;
			ResultSet rs = null;

			DefaultTableModel tableModel = new DefaultTableModel();
			Object client = new Client ();
			Field[] fields = client.getClass().getDeclaredFields();
			for (Field f : fields )
			{	
				coloane.add(f.getName());
			
			}
			for (int i=0;i<coloane.size();i++)
			{
				System.out.println(coloane.get(i));
			}
				

				
				
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
							clienti.add(toReturn);
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					
					col=coloane.toArray(col);
					
					for(String s : col)
					    System.out.println(s);
					

					MyTableModel m = new MyTableModel ();
					tableModel=m.creare(client.getClass(),clienti);
					
					if(scrollPane != null)
						panou.remove(scrollPane);
					scrollPane = new JScrollPane();
					scrollPane.setBounds(356, 109, 329, 154);
					panou.add(scrollPane);
					if(table != null)
						scrollPane.remove(table);
					
					table = new JTable(tableModel);
					//panouT.setVisible(true);
					
					
					
					scrollPane.setViewportView(table);

			

		}	

		
		if(arg0.getSource() == stoc){ 
			meniu1.setVisible(false);
			meniu2.setVisible(false);
			meniu3.setVisible(false);
			meniu4.setVisible(true);
			
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			
			StockDAO x = new StockDAO();
			x.allStock();
			
			ArrayList<Stock> clienti = new ArrayList<Stock>();
			String statement = "SELECT * FROM Stock";
			Stock toReturn = null;
			
			ArrayList <String> coloane = new ArrayList <String> (10);
			String[] col = new String [coloane.size()];
			

			Connection dbConnection = ConnectionFactory.getConnection();
			PreparedStatement findStatement = null;
			ResultSet rs = null;

			DefaultTableModel tableModel = new DefaultTableModel();
			Object client = new Stock();
			Field[] fields = client.getClass().getDeclaredFields();
			for (Field f : fields )
			{	
				coloane.add(f.getName());
			
			}
			for (int i=0;i<coloane.size();i++)
			{
				System.out.println(coloane.get(i));
			}
				

				
				
					try {
						findStatement = dbConnection.prepareStatement(statement);
						rs = findStatement.executeQuery();
						while(rs.next())
						{
							int idStock = Integer.parseInt(rs.getString("idStock"));
							int id_s = Integer.parseInt(rs.getString("id_s"));
							int nr_s = Integer.parseInt(rs.getString("nr_s"));


							
							toReturn = new Stock(idStock, id_s, nr_s);
							clienti.add(toReturn);
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					
					col=coloane.toArray(col);
					
					for(String s : col)
					    System.out.println(s);
					

					MyTableModel m = new MyTableModel ();
					tableModel=m.creare(client.getClass(),clienti);
					if(scrollPane != null)
						panou.remove(scrollPane);
					scrollPane = new JScrollPane();
					scrollPane.setBounds(356, 109, 329, 154);
					panou.add(scrollPane);
					
					table = new JTable(tableModel);
					//panouT.setVisible(true);
					scrollPane.setViewportView(table);
			
			

		}	

		
		if(arg0.getSource() == produs){ 
			meniu1.setVisible(false);
			meniu2.setVisible(false);
			meniu3.setVisible(true);
			meniu4.setVisible(false);
			
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			
			ProdusDAO x = new ProdusDAO();
			x.allProdus();
			
			ArrayList<Produs> clienti = new ArrayList<Produs>();
			String statement = "SELECT * FROM Produs";
			Produs toReturn = null;
			
			ArrayList <String> coloane = new ArrayList <String> (10);
			String[] col = new String [coloane.size()];
			

			Connection dbConnection = ConnectionFactory.getConnection();
			PreparedStatement findStatement = null;
			ResultSet rs = null;

			DefaultTableModel tableModel = new DefaultTableModel();
			Object client = new Client ();
			Field[] fields = client.getClass().getDeclaredFields();
			for (Field f : fields )
			{	
				coloane.add(f.getName());
			
			}
			for (int i=0;i<coloane.size();i++)
			{
				System.out.println(coloane.get(i));
			}
				

				
				
					try {
						findStatement = dbConnection.prepareStatement(statement);
						rs = findStatement.executeQuery();
						while(rs.next())
						{
							int id_p = Integer.parseInt(rs.getString("id_p"));
							String nume_p = rs.getString("nume_p");
							String descriere = rs.getString("descriere");


							
							toReturn = new Produs(id_p, nume_p, descriere);
							clienti.add(toReturn);
							
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					
					col=coloane.toArray(col);
					
					for(String s : col)
					    System.out.println(s);
					

					MyTableModel m = new MyTableModel ();
					tableModel=m.creare(client.getClass(),clienti);
					if(scrollPane != null)
						panou.remove(scrollPane);
					scrollPane = new JScrollPane();
					scrollPane.setBounds(356, 109, 329, 154);
					panou.add(scrollPane);
					
					table = new JTable(tableModel);
					//panouT.setVisible(true);
					scrollPane.setViewportView(table);
			
			

		}
		
		if(arg0.getSource() == cautare1) {
			meniu1C.setVisible(true);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == stergere1) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(true);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == add1) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(true);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == cautare2) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(true);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == stergere2) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(true);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == add2) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(true);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == cautare3) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(true);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == stergere3) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(true);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == add3) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(true);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == cautare4) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(true);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			

		}
		
		if(arg0.getSource() == stergere4) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(true);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			
		}
		
		if(arg0.getSource() == add4) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(true);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);
			
		}
		
		if(arg0.getSource() == update1) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(true);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);

			
		}
		
		if(arg0.getSource() == update2) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(true);
			meniu3U.setVisible(false);
			meniu4U.setVisible(false);

			
		}
		
		if(arg0.getSource() == update3) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(true);
			meniu4U.setVisible(false);

			
		}
		
		if(arg0.getSource() == update4) {
			meniu1C.setVisible(false);
			meniu1S.setVisible(false);
			meniu1A.setVisible(false);
			
			meniu2C.setVisible(false);
			meniu2S.setVisible(false);
			meniu2A.setVisible(false);
			
			meniu3C.setVisible(false);
			meniu3S.setVisible(false);
			meniu3A.setVisible(false);
			
			meniu4C.setVisible(false);
			meniu4S.setVisible(false);
			meniu4A.setVisible(false);
			
			meniu1U.setVisible(false);
			meniu2U.setVisible(false);
			meniu3U.setVisible(false);
			meniu4U.setVisible(true);

			
		}
		
		if(arg0.getSource() == buttonmeniu1A) {
			
			
			Client client = new Client(textmeniu1A1.getText(), textmeniu1A2.getText(),  textmeniu1A3.getText());

			ClientBLL ClientBll = new ClientBLL();
			int id = ClientBll.insertClient(client);
			
			System.out.println(id + "\n");
			if (id > 0) {
				ClientBll.findClientById(id);
			}
			
			
			// Generate error
			try {
				ClientBll.findClientById(1);
			} catch (Exception ex) {
				
				LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			
			meniu1A.setVisible(false);

			
		}
		
		if(arg0.getSource() == buttonmeniu1s) {				

			ClientBLL ClientBll = new ClientBLL();
			try {
				ClientBll.deleteConnection(Integer.parseInt(textmeniu1S.getText()));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			meniu1S.setVisible(false);
			
		}
		
		if(arg0.getSource() == buttonmeniu3A) {
			
			Produs produs = new Produs(textmeniu3A1.getText(), textmeniu3A2.getText());

			ProdusBLL ClientBll = new ProdusBLL();
			int id = ProdusBLL.insertProdus(produs);
			
			System.out.println(id + "\n");
			if (id > 0) {
				ProdusBLL.findClientById(id);
			}
			
			
			// Generate error
			try {
				ProdusBLL.findClientById(1);
			} catch (Exception ex) {
				
				LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			
			meniu3A.setVisible(false);

		}
		
		if(arg0.getSource() == buttonmeniu3s) {	

			ProdusBLL produsBLL = new ProdusBLL();
			try {
				produsBLL.deleteConnection(Integer.parseInt(textmeniu3S.getText()));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			meniu3S.setVisible(false);
			
		}
		
		if(arg0.getSource() == buttonmeniu2A) {			
						
			Comanda comanda = new Comanda(Integer.parseInt(textmeniu2A2.getText()), Integer.parseInt(textmeniu2A3.getText()), Integer.parseInt(textmeniu2A4.getText()));

			ComandaBLL comandaBll = new ComandaBLL();
			int id = comandaBll.insertComanda(comanda);
			
			System.out.println(id + "\n");
			if (id > 0) {
				comandaBll.findClientById(id);
			}
			
			
			// Generate error
			try {
				comandaBll.findClientById(1);
			} catch (Exception ex) {
				
				LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			
			meniu2A.setVisible(false);

		}
		
		
		
		if(arg0.getSource() == buttonmeniu2s) {	
			
			ComandaBLL comandaBLL = new ComandaBLL();
			try {
				comandaBLL.deleteConnection(Integer.parseInt(textmeniu2S.getText()));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			meniu2S.setVisible(false);
			
		}
		
		if(arg0.getSource() == buttonmeniu4A) {	
			
			
			Stock stock = new Stock(Integer.parseInt(textmeniu4A1.getText()), Integer.parseInt(textmeniu4A2.getText()));

			StockDLL stockBll = new StockDLL();
			int id = StockDLL.insertStock(stock);
			
			System.out.println(id + "\n");
			if (id > 0) {
				stockBll.findStockById(id);
			}
			
			
			// Generate error
			try {
				stockBll.findStockById(1);
			} catch (Exception ex) {
				
				LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			
			meniu4A.setVisible(false);

		}
		
		
		
		if(arg0.getSource() == buttonmeniu4s) {	
			
			StockDLL stockBLL = new StockDLL();
			try {
				stockBLL.deleteConnection(Integer.parseInt(textmeniu4S.getText()));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			meniu4S.setVisible(false);
			
		}
		
		if(arg0.getSource() == buttonmeniu1C) {	
			
			ClientDAO x = new ClientDAO();
			Client user;
			user = x.findById(Integer.parseInt(textmeniu1C.getText()));
			System.out.println(user.getNume_c() + " " + user.getEmail());
			
		}
		
	}


}
