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
	int stemmeid;
	int tlf;
	int rating;
	int prosjektnr;
	
	public Stemme() {
	}


	public Stemme(int tlf, int stemme, int prosjektID) {
		super();
		this.tlf = tlf;
		this.rating = stemme;
		this.prosjektnr = prosjektID;
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
		return prosjektnr;
	}
	public void setProsjektID(int prosjektID) {
		this.prosjektnr = prosjektID;
	}
	
	

}
