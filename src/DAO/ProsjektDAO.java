package DAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entiteter.Prosjekt;

/**
 * @author Håkon Herrevold / Ruben Aadland
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
