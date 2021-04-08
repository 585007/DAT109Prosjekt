package entiteter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.DBconfig;

/**
 * 
 * @author Svein Ove Surdal / Håkon Herrevold / Ruben Aadland
 *
 * Klasse for stemmes entiteter
 * 
 * Brukes i forbindelse med StemmeDAO og StemmeServlet
 * for å opprette og oppdatere stemmer.
 *
 */
@Entity
@Table(name = "stemme", schema = DBconfig.schema)
public class Stemme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int stemmeid;
	int prosjektnr;
	int tlf;
	int rating;

	public Stemme() {
	}
	
	/**
	 * Oppretter en ny stemme
	 * 
	 * @param prosjektID som stemmen hører til
	 * @param tlf til den som stemte
	 * @param stemme stemme verdien som ble gitt
	 */
	public Stemme(int prosjektID, int tlf, int stemme) {
		super();
		this.prosjektnr = prosjektID;
		this.tlf = tlf;
		this.rating = stemme;

	}
	public int getStemmeid() {
		return stemmeid;
	}

	public void setStemmeid(int stemmeid) {
		this.stemmeid = stemmeid;
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

	public void setrating(int rating) {
		this.rating = rating;
	}

	public int getProsjektID() {
		return prosjektnr;
	}

	public void setProsjektID(int prosjektID) {
		this.prosjektnr = prosjektID;
	}

}
