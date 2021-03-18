package entiteter;

import java.awt.List;
import java.util.HashMap;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Håkon Herrevold
 *
 */
public class Prosjekt {

	// dette er bare middlertidig, endres om det trengs flere attributter
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int prosjektNr;
	public String prosjektNavn;
	public Stemmer stemmer;

	public Prosjekt(int prosjektNr, String prosjektNavn) {
		super();
		this.prosjektNr = prosjektNr;
		this.prosjektNavn = prosjektNavn;
		this.stemmer = new Stemmer();
		
	}

	public int getProsjektNr() {
		return prosjektNr;
	}

	public void setProsjektNr(int prosjektNr) {
		this.prosjektNr = prosjektNr;
	}

	public String getProsjektNavn() {
		return prosjektNavn;
	}

	public void setProsjektNavn(String prosjektNavn) {
		this.prosjektNavn = prosjektNavn;
	}

	public Stemmer getStemmer() {
		return stemmer;
	}

	public void setStemmer(Stemmer stemmer) {
		this.stemmer = stemmer;
	}



}