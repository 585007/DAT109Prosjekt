package hjelpeKlasser;

import java.util.ArrayList;
import java.util.List;

import DAO.ProsjektDAO;
import DAO.StemmeDAO;
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
	
	/**
	 * @param prosjektDAO prosjektDAO for å hente ut prosjektene
	 * 
	 * @param stemmeDAO stemmeDAO for å hente ut stemmene til prosjektene
	 * 
	 * @return returnerer en liste med ProsjektScore som har hvert prosjekt
	 * i DB sitt navn, id, score og antall stemmer
	 * 
	 */
	public static List<ProsjektScore> hentProsjektScoreListe(ProsjektDAO prosjektDAO, StemmeDAO stemmeDAO) {
		List<Prosjekt> prosjekter = prosjektDAO.hentAlleProsjekter();
		
		List<ProsjektScore> prosjektScoreListe= new ArrayList<ProsjektScore>();
		
		for(Prosjekt p : prosjekter) {
			prosjektScoreListe.add(new ProsjektScore(p, stemmeDAO));
		}
		
		return prosjektScoreListe;
	}

}
