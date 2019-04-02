package model;

public class Comanda {
	
	private int id_com;
	private int id_c;
	private int id_p;
	private int cantitate;
	
	public Comanda() {
		super();

	}
	
	public Comanda(int id_com, int id_c, int id_p, int cantitate) {
		super();
		this.id_com = id_com;
		this.id_c = id_c;
		this.id_p = id_p;
		this.cantitate = cantitate;
	}
	
	public Comanda(int id_c, int id_p, int cantitate) {
		super();
		this.id_c = id_c;
		this.id_p = id_p;
		this.cantitate = cantitate;
	}
	
	public int getId_com() {
		return id_com;
	}
	
	public void setId_com(int id_com) {
		this.id_com = id_com;
	}
	
	public int getId_c() {
		return id_c;
	}
	
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}
	
	public int getId_p() {
		return id_p;
	}
	
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	
	public int getCantitate() {
		return cantitate;
	}
	
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	
	public String toString() {
		return "Comanda [id_com =" + id_com + ", id_c=" + id_c + ", id_p =" + id_p + ", cantitate =" + cantitate	+ "]" ;
				
	}

}
