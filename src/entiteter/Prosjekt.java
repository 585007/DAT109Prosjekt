package entiteter;

import java.awt.List;
import java.util.HashMap;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Håkon Herrevold/ Svein Ove Surdal
 *
 */
@Entity
@Table(name = "prosjekt")
public class Prosjekt {

	// dette er bare middlertidig, endres om det trengs flere attributter
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int prosjektNr;
	String prosjektNavn;
	String adresse;

	
	public Prosjekt() {
	}

	public Prosjekt(String prosjektNavn) {
		synchronized(this) {
		this.prosjektNavn = prosjektNavn;
		adresse = "http://localhost:8041/dat109-prosjekt-gr5/ProsjektListe/"+prosjektNr;
		}
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



}