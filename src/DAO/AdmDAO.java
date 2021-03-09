package DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdmDAO {
	
	@PersistenceContext(name = "AdmDAO")
    private EntityManager em;
	
	public String hentBrukernavn() {
		return em.createQuery("SELECT brukernavn FROM admin").toString();
	}
	
	public String hentPassord() {
		return em.createQuery("SELECT brukernavn FROM admin").toString();
	}

//	bare raskt satt opp ikke ferdig
	
}
