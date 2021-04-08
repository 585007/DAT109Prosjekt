package DAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entiteter.Prosjekt;
import entiteter.Stemme;

/**
 * @author Håkon Herrevold / Ruben Aadland / Svein Ove Surdal
 *
 */
@Stateless
public class ProsjektDAO {

	
	@PersistenceContext(name = "dat109prosjekt")
	private EntityManager em;
	
	/**
	 * 
	 * @return returnerer liste med alle registrerte prosjekter.
	 */
	public List<Prosjekt> hentAlleProsjekter() {
		return em.createQuery("SELECT p FROM Prosjekt p", Prosjekt.class).getResultList();
	}
	
	/**
	 * ser om Prosjekt med aktuelt prosjektnavn finnes 
	 * @param prosjektnavn
	 * @return boolean true om den finnes. false om den ikke finnes
	 */
	public synchronized boolean prosjektnavnFinnes(String prosjektnavn){
		
		final String qstring = "SELECT p FROM Prosjekt p WHERE p.prosjektnavn = :prosjektnavn";
		TypedQuery<Prosjekt> query = em.createQuery(qstring, Prosjekt.class);
		query.setParameter("prosjektnavn", prosjektnavn);
		
		try{
			query.getSingleResult();  
	    }
	    catch(NoResultException e){
	        return false;
	    }
		return true;
    }
	
	/**
	 * 
	 * @param prosjektNr for prosjektet som skal hentes
	 * @return returnerer prosjektet som har prosjektNr.
	 * Hvis ingen prosjekt ble funnet returneres null.
	 */
	public Prosjekt hentProsjekt(int prosjektNr) {
        return em.find(Prosjekt.class, prosjektNr);
    }
	
	/**
	 * 
	 * @param nyttprosjekt blir lagt til i databasen.
	 */
    public synchronized void lagreNyttProsjekt(Prosjekt nyttprosjekt) {
		em.persist(nyttprosjekt);
    }
    
    /**
     * 
     * @param prosjektNr er prosjektet som skal slettes fra DB. 
     */
    public void slettProsjekt(String prosjektNr) {
    	Prosjekt prosjekt = hentProsjekt(Integer.parseInt(prosjektNr));
    	em.remove(prosjekt);
    }
    
    

}
