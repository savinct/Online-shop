package model;

public class Client {
	
	private int id_c;
	private String nume_c;
	private String email;
	private String adresa;
	
	public Client() {
		super();
		
	}
	
	public Client(int id_c, String nume_c, String email, String adresa) {
		super();
		this.id_c = id_c;
		this.nume_c = nume_c;
		this.email = email;
		this.adresa = adresa;
	}
	
	public Client(String nume_c, String email, String adresa) {
		super();
		this.nume_c = nume_c;
		this.email = email;
		this.adresa = adresa;
	}
	
	public int getId_c() {
		return id_c;
	}
	
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}
	
	public String getNume_c() {
		return nume_c;
	}
	
	public void setNume_c(String nume_c) {
		this.nume_c = nume_c;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String toString() {
		return "Client [id_c =" + id_c + ", nume_c=" + nume_c + ", email =" + email + ", adresa =" + adresa	+ "]" ;
				
	}

}
