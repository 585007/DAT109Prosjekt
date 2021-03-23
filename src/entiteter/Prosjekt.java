package entiteter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.DBconfig;

/**
 * @author H�kon Herrevold / Svein Ove Surdal / Ruben Aadland
 *
 */
@Entity
@Table(name = "prosjekt", schema=DBconfig.schema)
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