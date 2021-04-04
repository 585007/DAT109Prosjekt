package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entiteter.Admin;

/**
 * 
 * @author Svein Ove Surdal / Tomas Mardal
 * 
 */
@Stateless
public class AdmDAO {
	
	@PersistenceContext(name = "dat109prosjekt")
    private EntityManager em;
	
	public String hentBrukernavn() {
		return em.createQuery("SELECT a FROM Admin a ", Admin.class).getSingleResult().brukernavn();
	}
	
	public String hentPassord() {
		return em.createQuery("SELECT a FROM Admin a ", Admin.class).getSingleResult().passord(); 
	}
	
	public String hentSalt() {
		return em.createQuery("SELECT a FROM Admin a", Admin.class).getSingleResult().salt();
	}

//	mangler metode for å endre passord
	
}
