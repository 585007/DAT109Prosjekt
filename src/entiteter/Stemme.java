package entiteter;

public class Stemme {
	
	public int tlf;
	public int rating;
	public int prosjektID;
	
	public Stemme(int tlf, int rating, int prosjektID) {
		super();
		this.tlf = tlf;
		this.rating = rating;
		this.prosjektID = prosjektID;
	}
	
	
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getProsjektID() {
		return prosjektID;
	}
	public void setProsjektID(int prosjektID) {
		this.prosjektID = prosjektID;
	}
	
	

}
