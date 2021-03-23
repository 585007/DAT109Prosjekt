package hjelpeKlasser;

import entiteter.Stemme;

import java.util.List;


/**
 * @author Håkon Herrevold / Ruben Aadland
 *
 */
public class PoengHjelp {

	/**
	 * @param stemmer
	 * @return Sum av poeng
	 */
	public static int tellPoengTilProsjekt(List<Stemme> stemmer) {
		int poeng = 0;

		for (Stemme s : stemmer){
			int rating = s.getRating();
			if(rating != 0) {
				poeng += rating;
			}
		}
		return poeng;
	}
	
	/**
	 * 
	 * @param stemmer regner ut score fra listen med stememr som blir sendt inn
	 * @return scoren fra stemmene (teller med 0 stemmer)
	 */
	public static double regnUtGjScore(List<Stemme> stemmer) {
		double antallStemmer = (double) gyldigeStemmer(stemmer);
		
		double poeng = (double) tellPoengTilProsjekt(stemmer);
		
		double score = 0;
		if(antallStemmer != 0) {
			score = poeng/antallStemmer;
		}
		
		return score;
	}
	
	/**
	 * @param stemmer for prosjektet
	 * 
	 * @return returnerer total vektede stemmene delt på antall stemmer (utenom 0)
	 */
	private final static int NULLPUNKT = 3;
	public static double regnUtVektetScore(List<Stemme> stemmer) {
		double vektetScore = 0;
		if(!stemmer.isEmpty()) {
			int antall = 0;
			
			for(Stemme s : stemmer) {
				int rating = s.getRating();
				if(rating != 0) {
					antall++;
					vektetScore += (rating - NULLPUNKT);
				}
			}
		}
		return vektetScore;
	}
	
	/**
	 * 
	 * @param totalScore
	 * @param gjScore
	 * @param vektetScore
	 * @param antallStemmer
	 * @return returnerer (totalscore + gjScore * vektetScore)/antallStemmer
	 * fjerner vektetScore fra utregningen hvis den er 0
	 */
	public static double regnUtGjScore(int totalScore, double gjScore, double vektetScore, int antallStemmer) {
		double score;
		
		if(vektetScore != 0) {
			score = antallStemmer / (totalScore + gjScore * vektetScore);
		}else {
			score = antallStemmer / (totalScore + gjScore) ;
		}
		return score;
	}
	/**
	 * 
	 * @param stemmer stemmer for prosjektet
	 * @return returnerer antall stemmer som er gyldige. Altså de som ikke er stemt 0
	 */
	public static int gyldigeStemmer(List<Stemme> stemmer) {
		int antall = 0;
		
		for(Stemme s : stemmer) {
			int rating = s.getRating();
			if(rating != 0) {
				antall++;
			}
		}
		
		return antall;
	}
}










