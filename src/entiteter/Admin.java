package entiteter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.DBconfig;
import hjelpeKlasser.PassordHjelp;

/**
 * 
 * @author Tomas Mardal / Ruben Aadland
 *
 */
@Entity
@Table(name = "admin", schema=DBconfig.schema)
public class Admin {

	@Id
	private String brukernavn;
	private String passord;
	private String salt;
	
	public Admin() {
	}
	
	/**
	 * 
	 * @param brukernavn
	 * @param passord lagres i hash tilstand med salt. Kan hashes sammen med salt i PassordHjelp
	 * @param salt lagres i hash tilstand. Salt kan genereres i PassordHjelp
	 */
	public Admin(String brukernavn, String passord, String salt) {
	
		this.brukernavn = brukernavn;
		this.passord = passord;
		this.salt = salt;		
	}
	
	
	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}	
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}	
	
	/**
	 * 
	 * @param passord som skal sammenlignes med brukerens passord
	 * @return bool om passord matcher passord til brukeren.
	 */
	public boolean gyldigPassord(String passord) {
		return this.passord
				.equals(PassordHjelp.hashMedSalt(passord, getSalt()));
	}
}

