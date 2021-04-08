package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entiteter.Admin;

/**
 * 
 * @author Svein Ove Surdal / Tomas Mardal / Ruben Aadland
 * 
 */
@Stateless
public class AdmDAO {
	
	@PersistenceContext(name = "dat109prosjekt")
    private EntityManager em;
	
	//Bruk heller getAdmin for så å hente ut de forskjellige verdien derfra
	@Deprecated
	public String hentBrukernavn() {
		return em.createQuery("SELECT a FROM Admin a ", Admin.class).getSingleResult().getBrukernavn();
	}
	@Deprecated
	public String hentPassord() {
		return em.createQuery("SELECT a FROM Admin a ", Admin.class).getSingleResult().getPassord(); 
	}
	@Deprecated
	public String hentSalt() {
		return em.createQuery("SELECT a FROM Admin a", Admin.class).getSingleResult().getSalt();
	}
	/**
	 * 
	 * @param brukernavn til admin brukeren som skal hentes
	 * @return returnerer admin brukeren med brukernavnet. Hvis brukeren ikke finnes returneres null
	 */
	public Admin getAdmin(String brukernavn) {
		return em.find(Admin.class , brukernavn);
	}
	
	public synchronized void EndreAdmin(String brukernavn, String passord) {
	
		Admin a = em.find(Admin.class , brukernavn);
		a.setPassord(passord);
		em.persist(a);
    }

//	mangler metode for å endre passord
	
}
