package model;

public class Stock {
	
	private int idStock;
	private int id_s;
	private int nr_s;
	
	public Stock() {
		super();

	}
	
	public Stock(int idStock, int id_s, int nr_s) {
		super();
		this.idStock = idStock;
		this.id_s = id_s;
		this.nr_s = nr_s;
	}
	
	public Stock(int id_s, int nr_s) {
		super();
		this.id_s = id_s;
		this.nr_s = nr_s;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getId_s() {
		return id_s;
	}

	public void setId_s(int id_s) {
		this.id_s = id_s;
	}

	public int getNr_s() {
		return nr_s;
	}

	public void setNr_s(int nr_s) {
		this.nr_s = nr_s;
	}

}
