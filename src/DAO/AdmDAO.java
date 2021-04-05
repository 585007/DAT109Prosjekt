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
	
	public String hentBrukernavn() {
		return em.createQuery("SELECT a FROM Admin a ", Admin.class).getSingleResult().getBrukernavn();
	}
	
	public String hentPassord() {
		return em.createQuery("SELECT a FROM Admin a ", Admin.class).getSingleResult().getPassord(); 
	}
	
	public String hentSalt() {
		return em.createQuery("SELECT a FROM Admin a", Admin.class).getSingleResult().getSalt();
	}
	
	public Admin getAdmin(String brukernavn) {
		return em.find(Admin.class , brukernavn);
	}

//	mangler metode for å endre passord
	
}
