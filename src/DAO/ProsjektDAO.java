package DAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import entiteter.Prosjekt;

/**
 * @author Håkon Herrevold
 *
 */
@Stateless
public class ProsjektDAO {

	
	@PersistenceContext(name = "dat109prosjekt")
	private EntityManager em;

	public List<Prosjekt> hentAlleProsjekter() {
		return em.createQuery("SELECT p FROM Prosjekt p", Prosjekt.class).getResultList();
	}
	
	public Prosjekt hentProsjekt(int prosjektID) {
        return em.find(Prosjekt.class, prosjektID);
    }

    public synchronized void lagreNyttProsjekt(Prosjekt nyttprosjekt) {
		em.persist(nyttprosjekt);
    }

}
