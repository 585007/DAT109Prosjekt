package DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entiteter.Stemme;
/**
 * @author Håkon Herrevold/ Svein Ove Surdal
 *
 */
@Stateless
public class StemmeDAO {

	@PersistenceContext(name = "dat109prosjekt")
	private EntityManager em;

	public List<Stemme> hentAlleStemmer() {
		return em.createQuery("SELECT v from Stemme v", Stemme.class).getResultList();
	}
	
	public Stemme hentStemme(int mobil) {
        return em.find(Stemme.class, mobil);
    }
	public synchronized int sjekkeOmStemmeFinnes(int tlf, int prosjektnr) {
		int stemmeID;
		stemmeID = em.createQuery("Select b.stemmeid FROM Stemme b WHERE b.tlf =" + tlf + "AND b.prosjektnr ="+ prosjektnr, Stemme.class).getFirstResult();
		return stemmeID;
	}
    public synchronized void lagreNyStemme(Stemme nystemme) {
        em.persist(nystemme);
    }

    
    // fjerner stemme
	public void fjern(int mobilNr) {
		// TODO Auto-generated method stub
		
	}


}
