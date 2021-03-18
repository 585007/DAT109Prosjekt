package DAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entiteter.Prosjekt;

/**
 * @author Håkon Herrevold
 *
 */
@Stateless
public class ProsjektDAO {

	
	
	@PersistenceContext(name = "ProsjektDAO")
	private EntityManager em;
	
	public List<Prosjekt> hentAlleProsjekter() {
		return em.createQuery("SELECT p from Prosjekt p", Prosjekt.class).getResultList();
	}
	
	public Prosjekt hentProsjekt(int prosjektID) {
        return em.find(Prosjekt.class, prosjektID);
    }

    public synchronized void lagreNyttProsjekt(Prosjekt nyttprosjekt) {
        em.persist(nyttprosjekt);
    }

}
