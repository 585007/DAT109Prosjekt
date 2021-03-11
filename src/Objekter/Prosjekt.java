package Objekter;

import java.util.HashMap;

/**
 * @author Håkon Herrevold
 *
 */
public class Prosjekt {

	// dette er bare middlertidig, endres om det trengs flere attributter
	public int prosjektNr;
	public String prosjektNavn;
	public HashMap<String, Float> stemmer;

	public Prosjekt(int prosjektNr, String prosjektNavn) {
		super();
		this.prosjektNr = prosjektNr;
		this.prosjektNavn = prosjektNavn;
		this.stemmer = new HashMap<String, Float>();
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

	public HashMap<String, Float> getStemmer() {
		return stemmer;
	}

	public void setStemmer(HashMap<String, Float> stemmer) {
		this.stemmer = stemmer;
	}

	

}
