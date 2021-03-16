//package DAO;
//
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import entiteter.Stand;
//import entiteter.Stemme;
//import entiteter.Tilskuer;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Stateless
//public class StemmeDAO {
//
//	@PersistenceContext(name="expoPU")
//	private EntityManager em;	
//	
//	
//	public void stemForStand(Stemme stemme) {
//		
//		Tilskuer tilskuer = stemme.hentTilskuer();
//		tilskuer.leggTilStemme(stemme);
//		
//		Stand stand = stemme.hentStand();
//		stand.hentStemme().add(stemme);
//		
//		em.persist(stemme);
//	}
//	
//	public List<Stemme> hentStemmerForStand(Stand stand){
//		List<Stemme>standStemmer = em.createQuery("SELECT v FROM Stemme v",Stemme.class).getResultList();
//		standStemmer = standStemmer
//				.stream()
//				.filter(v->v.hentStand().equals(stand))
//				.collect(Collectors.toList());
//		return standStemmer;
//	}
//	
//	public List<Stemme> hentAlleStemmer(){
//		return em.createQuery("SELECT v from Stemme v",Stemme.class).getResultList();
//	}
//	
//}