package model;

public class Produs {
	
	private int id_p;
	private String nume_p;
	private String descriere;
	
	public Produs() {
		super();
	
	}
	
	public Produs(int id_p, String nume_p, String descriere) {
		super();
		this.id_p = id_p;
		this.nume_p = nume_p;
		this.descriere = descriere;
	}
	
	public Produs(String nume_p, String descriere) {
		super();
		this.nume_p = nume_p;
		this.descriere = descriere;
	}
	
	public int getId_p() {
		return id_p;
	}
	
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	
	public String getNume_p() {
		return nume_p;
	}
	
	public void setNume_p(String nume_p) {
		this.nume_p = nume_p;
	}
	
	public String getDescriere() {
		return descriere;
	}
	
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	
	public String toString() {
		return "Produs [id_p =" + id_p + ", nume_p=" + nume_p + ", descriere =" + descriere + "]" ;
				
	}

}
