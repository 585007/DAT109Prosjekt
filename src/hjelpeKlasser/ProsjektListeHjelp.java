package hjelpeKlasser;

import java.util.ArrayList;
import java.util.List;

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
	 * @param prosjekter som skal inn i ProsjektScore listen
	 * 
	 * @param stemmeDAO stemmeDAO for å hente ut stemmene til prosjektene
	 * 
	 * @return returnerer en sortert liste med ProsjektScore som har hvert prosjekt
	 * i DB sitt navn, id, score og antall stemmer.
	 * Listen er sortert ut fra Score
	 * 
	 */
	public static List<ProsjektScore> hentProsjektScoreListe(List<Prosjekt> prosjekter, StemmeDAO stemmeDAO) {
		List<ProsjektScore> prosjektScoreListe= new ArrayList<ProsjektScore>();
		
		for(Prosjekt p : prosjekter) {
			prosjektScoreListe.add(new ProsjektScore(p, stemmeDAO));
		}
		prosjektScoreListe.sort((a, b) -> a.compareTo(b));
		
		return prosjektScoreListe;
	}

}
