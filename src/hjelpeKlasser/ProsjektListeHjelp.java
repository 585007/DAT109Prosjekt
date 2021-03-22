package hjelpeKlasser;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import DAO.ProsjektDAO;
import entiteter.Prosjekt;
import entiteter.ProsjektScore;

/**
 * @author Ruben Aadland
 * 
 * Brukes av ProsjektListeServlet for å få listen av prosjekter 
 * med prosjekt navn, score, stemmer og prosjekt id inn i en liste
 * som brukes i ProsjektListe.jsp
 *
 */
public class ProsjektListeHjelp {
	
	@EJB
	private ProsjektDAO prosjektDAO;
	
	/**
	 * @return returnerer en liste med ProsjektScore som har hvert prosjekt
	 * i DB sitt navn, id, score og antall stemmer
	 * 
	 */
	public List<ProsjektScore> hentProsjektScoreListe(){
		List<Prosjekt> prosjekter = prosjektDAO.hentAlleProsjekter();
		
		List<ProsjektScore> prosjektScoreListe= new ArrayList<ProsjektScore>();
		for(Prosjekt p : prosjekter) {
			prosjektScoreListe.add(new ProsjektScore(p));
		}
		
		return prosjektScoreListe;
	}

}
