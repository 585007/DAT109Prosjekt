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
 * Data access objekt for å aksessere stemme data
 *
 */
@Stateless
public class StemmeDAO {

	@PersistenceContext(name = "dat109prosjekt")
	private EntityManager em;

	/**
	 * henter alle stemmer i DB
	 * @return List<Stemme>
	 */
	public List<Stemme> hentAlleStemmer() {
		List<Stemme> stemmer =  em.createQuery("SELECT v from Stemme v", Stemme.class).getResultList();
		
		if(stemmer == null) {
			stemmer = new ArrayList<Stemme>();
		}
		
		return stemmer;
	}
	
	/**
	 * henter en stemme som samsvarer med den aktuelle stemmeIden
	 * @param stemmeId
	 * @return Stemme
	 */
	public Stemme hentStemme(int stemmeId) {
        return em.find(Stemme.class, stemmeId);
    }
	
	/**
	 * Ser om Stemme finnes og retunerer den aktuelle StemmeIden og 0 dersom stemmen ikke finnes.
	 * @param tlf
	 * @param prosjektnr
	 * @return stemmeID
	 */
	public synchronized int sjekkeOmStemmeFinnes(int tlf, int prosjektnr) {
		int stemmeID = 0;
		List<Stemme> stemme = em.createQuery("Select s FROM Stemme s WHERE s.tlf = " + tlf + " AND s.prosjektnr = " +prosjektnr, Stemme.class).getResultList();
		if (stemme.size() > 0) {
			stemmeID =stemme.get(0).getStemmeid();
		}
		return stemmeID;
	}
	
	/**
	 * lagrer ny Stemme
	 * @param nystemme
	 */
    public synchronized void lagreNyStemme(Stemme nystemme) {
        em.persist(nystemme);
    }
    
    /**
     * updaterer Stemme
     * @param stemmeId
     * @param rating
     */
    public synchronized void updateStemme(int stemmeId, int rating) {
    	Stemme s = hentStemme(stemmeId);
    	s.setrating(rating);
    	em.persist(s);
    }
    
    /**
     * henter stemmer med aktuelt prosjektNr
     * @param prosjektNr
     * @return List<Stemme>
     */
    public List<Stemme> hentProsjektStemmer(int prosjektNr){
    	return em.createQuery("SELECT s from Stemme s WHERE s.prosjektnr = " + prosjektNr, Stemme.class).getResultList();
    }
}
