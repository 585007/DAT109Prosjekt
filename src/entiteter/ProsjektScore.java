package entiteter;

import java.util.List;

import javax.ejb.EJB;

import DAO.StemmeDAO;
import hjelpeKlasser.PoengHjelp;

/**
 * @author Ruben Aadland
 * 
 * Brukes i forbindelse med å vise prosjektet, scoren og antall stemmer
 * i ProsjektListeServlet.
 * 
 * Konstruktøren til klassen tar inn prosjektet og genererer objektet selv
 *
 */
public class ProsjektScore {
	
	@EJB
	private StemmeDAO stemmeDAO;
	
	private int prosjektNr;
	private String prosjektNavn;
	private Integer antallStemmer;
	private double score;

	
	/** 
	 * @param p er prosjektet som en ønsker å regne ut scoren til
	 *
	 */
	public ProsjektScore(Prosjekt p) {
		this.prosjektNr = p.getProsjektNr();
		this.prosjektNavn = p.getProsjektNavn();
		
		List<Stemme> stemmer = stemmeDAO.hentAlleStemmer();
		this.antallStemmer = stemmer.size();
		this.score = PoengHjelp.regnUtProsjektScore(stemmer);
	}

	public int prosjektnr() {
		return prosjektNr;
	}
	
	public String getProsjektNavn() {
		return prosjektNavn;
	}


	public Integer getAntallStemmer() {
		return antallStemmer;
	}


	public double getScore() {
		return score;
	}
	
}
