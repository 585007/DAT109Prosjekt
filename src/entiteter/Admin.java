package entiteter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import DAO.DBconfig;

/**
 * 
 * @author Tomas Mardal
 *
 */
@Entity
@Table(name = "admin", schema=DBconfig.schema)
public class Admin {

	@Id
	String brukernavn;
	String passord;
	String salt;
	
	public Admin() {
	}

	public Admin(String brukernavn, String passord, String salt) {
	
		this.brukernavn = brukernavn;
		this.passord = passord;
		this.salt = salt;		
	}
	
	
	public String brukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String passord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}	
	
	public String salt() {
		return salt;
	}

	public void setsalt(String salt) {
		this.salt = salt;
	}	
}

