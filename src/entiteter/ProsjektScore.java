package entiteter;

import java.util.List;

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
	
	private int prosjektNr;
	private String prosjektNavn;
	private int antallStemmer;
	private double score;

	
	/** 
	 * @param p er prosjektet som en ønsker å regne ut scoren til
	 * @param stemmeDAO stemmeDAO-en til DB-en der vi skal hente stemmene fra
	 *
	 */
	public ProsjektScore(Prosjekt p, StemmeDAO stemmeDAO) {
		this.prosjektNr = p.getProsjektNr();
		this.prosjektNavn = p.getProsjektnavn();
		
		List<Stemme> stemmer = stemmeDAO.hentAlleStemmer();
		this.antallStemmer = stemmer.size();
		this.score = PoengHjelp.regnUtProsjektScore(stemmer);
	}

	public int getProsjektNr() {
		return prosjektNr;
	}
	
	public String getProsjektNavn() {
		return prosjektNavn;
	}


	public int getAntallStemmer() {
		return antallStemmer;
	}


	public double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "ProsjektScore [prosjektNr=" + prosjektNr + ", prosjektNavn=" + prosjektNavn + ", antallStemmer="
				+ antallStemmer + ", score=" + score + "]";
	}
	
	
	
}
