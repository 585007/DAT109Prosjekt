package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entiteter.Stemme;
/**
 * @author Håkon Herrevold/ Svein Ove Surdal / Ruben Aadland
 *
 */
@Stateless
public class StemmeDAO {

	@PersistenceContext(name = "dat109prosjekt")
	private EntityManager em;

	public List<Stemme> hentAlleStemmer() {
		List<Stemme> stemmer =  em.createQuery("SELECT v from Stemme v", Stemme.class).getResultList();
		
		if(stemmer == null) {
			stemmer = new ArrayList<Stemme>();
		}
		
		return stemmer;
	}
	
	public Stemme hentStemme(int stemmeId) {
        return em.find(Stemme.class, stemmeId);
    }
	public synchronized int sjekkeOmStemmeFinnes(int tlf, int prosjektnr) {
		int stemmeID = 0;
		stemmeID = em.createQuery("Select b.stemmeid FROM Stemme b WHERE b.tlf =" + tlf + " AND b.prosjektnr ="+ prosjektnr, Stemme.class).getFirstResult();
		return stemmeID;
	}
    public synchronized void lagreNyStemme(Stemme nystemme) {
        em.persist(nystemme);
    }
    public synchronized void updateStemme(int stemmeId, int rating) {
    	Stemme s = hentStemme(stemmeId);
    	em.getTransaction().begin();
    	s.setRating(rating);
    	em.persist(s);
    	em.getTransaction().commit();
    	em.close();
    	
    }
    
    // fjerner stemme
	public void fjern(int stemmeId) {
		// TODO Auto-generated method stub
		
	}

	public void fjernStemmerForProsjekt(String prosjektNr) {
		em.createQuery("DELETE FROM Stemme s WHERE s.prosjektnr = " + prosjektNr);
		
	}


}
