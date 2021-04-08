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

	/**
	 * 
	 * @return alle stemmene
	 */
	public List<Stemme> hentAlleStemmer() {
		List<Stemme> stemmer = em.createQuery("SELECT v from Stemme v", Stemme.class).getResultList();

		if (stemmer == null) {
			stemmer = new ArrayList<Stemme>();
		}

		return stemmer;
	}

	/**
	 * 
	 * @param stemmeId
	 * @return stemmeobjektet som har samme stemmeId
	 */
	public Stemme hentStemme(int stemmeId) {
		return em.find(Stemme.class, stemmeId);
	}

	/**
	 * 
	 * @param tlf
	 * @param prosjektnr
	 * @return stemmeId-en til tlf ?hvis den finnes?
	 */
	public synchronized int sjekkeOmStemmeFinnes(int tlf, int prosjektnr) {
		int stemmeID = 0;
		List<Stemme> stemme = em
				.createQuery("Select s FROM Stemme s WHERE s.tlf = " + tlf + " AND s.prosjektnr = " + prosjektnr,
						Stemme.class)
				.getResultList();
		if (stemme.size() > 0) {
			stemmeID = stemme.get(0).getStemmeid();
		}
		return stemmeID;
	}

	/**
	 * 
	 * @param nyStemme som skal lagres
	 */
	public synchronized void lagreNyStemme(Stemme nystemme) {
		em.persist(nystemme);
	}

	/**
	 * 
	 * @param stemmeId, hvilken stemmeid som skal endre
	 * @param rating    som skal endre til
	 */
	public synchronized void updateStemme(int stemmeId, int rating) {
		Stemme s = hentStemme(stemmeId);
		s.setrating(rating);
		em.persist(s);

	}

	/**
	 * 
	 * @param prosjektNr til prosjektet
	 * @return alle stemmene til prosjektet
	 */
	public List<Stemme> hentProsjektStemmer(int prosjektNr) {
		return em.createQuery("SELECT s from Stemme s WHERE s.prosjektnr = " + prosjektNr, Stemme.class)
				.getResultList();
	}
}
