package entiteter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Svein Ove Surdal
 *
 */
@Entity
@Table(name = "stemme")
public class Stemme {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int stemmeID;
	int tlf;
	int rating;
	int prosjektID;
	
	public Stemme() {
	}


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
