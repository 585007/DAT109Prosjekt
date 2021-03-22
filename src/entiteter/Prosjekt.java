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
@Table(name = "prosjekt", schema="dat109")
public class Prosjekt {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prosjektnr;
	String prosjektnavn;
	String adresse;

	
	public Prosjekt() {
	}

	public Prosjekt(String prosjektNavn) {
		synchronized(this) {
		this.prosjektnavn = prosjektNavn;
		adresse = "http://localhost:8041/dat109-prosjekt-gr5/ProsjektListe/"+prosjektnr;
		}
	}

	public int getProsjektNr() {
		return prosjektnr;
	}

	public void setProsjektNr(int prosjektNr) {
		this.prosjektnr = prosjektNr;
	}

	public String getProsjektNavn() {
		return prosjektnavn;
	}

	public void setProsjektNavn(String prosjektNavn) {
		this.prosjektnavn = prosjektNavn;
	}
}