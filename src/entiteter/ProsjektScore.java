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
	
	private int totalScore;
	private double gjScore;
	private double vektetScore;
	private double score;
	
	/** 
	 * @param p er prosjektet som en ønsker å regne ut scoren til
	 * @param stemmeDAO stemmeDAO-en til DB-en der vi skal hente stemmene fra
	 *
	 */
	public ProsjektScore(Prosjekt p, StemmeDAO stemmeDAO) {
		this.prosjektNr = p.getProsjektNr();
		this.prosjektNavn = p.getProsjektnavn();
		
		List<Stemme> stemmer = stemmeDAO.hentProsjektStemmer(prosjektNr);
		this.antallStemmer = PoengHjelp.gyldigeStemmer(stemmer);
		
		this.totalScore = PoengHjelp.tellPoengTilProsjekt(stemmer);
		this.gjScore = PoengHjelp.regnUtGjScore(stemmer);
		this.vektetScore = PoengHjelp.regnUtVektetScore(stemmer);
		this.score = PoengHjelp.regnUtGjScore(totalScore, gjScore, vektetScore, antallStemmer);
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


	public double getGjScore() {
		return gjScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public double getVektetScore() {
		return vektetScore;
	}

	public double getScore() {
		return score;
	}

	public int compareTo(ProsjektScore b) {
		int sammenlignet;
		
		if(score == b.getScore()) {
			sammenlignet = 0;
		}else if(score >= b.getScore()) {
			sammenlignet = -1;
		}else {
			sammenlignet = 1;
		}
		
		return sammenlignet;
	}
	
}
