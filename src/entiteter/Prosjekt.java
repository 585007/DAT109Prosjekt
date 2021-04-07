package entiteter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.DBconfig;

/**
 * @author Håkon Herrevold / Svein Ove Surdal / Ruben Aadland
 *
 */
@Entity
@Table(name = "prosjekt", schema=DBconfig.schema)
public class Prosjekt {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prosjektnr;
	String prosjektnavn;
	

	
	public Prosjekt() {
	}
	/**
	 * 
	 * @param prosjektNavn er navnet på prosjektet
	 */
	public Prosjekt(String prosjektNavn) {
		synchronized(this) {
		this.prosjektnavn = prosjektNavn;
		}
	}

	public int getProsjektNr() {
		return prosjektnr;
	}

	public void setProsjektNr(int prosjektNr) {
		this.prosjektnr = prosjektNr;
	}

	public String getProsjektnavn() {
		return prosjektnavn;
	}

	public void setProsjektNavn(String prosjektNavn) {
		this.prosjektnavn = prosjektNavn;
	}
}