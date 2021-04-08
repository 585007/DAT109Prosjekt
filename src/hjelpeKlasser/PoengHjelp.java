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
	
	//TODO - oppdater JavaDoc
	/**
	 * @param stemmer for prosjektet
	 * 
	 * @return returnerer total vektede stemmene delt på antall stemmer (utenom 0)
	 */
	private final static int NULLPUNKT = 3;
	private final static double STANDARDSCORE = 1.00;
	public static double regnUtVektetScore(List<Stemme> stemmer) {
		double positivScore = 0.0;
		double negativScore = 0.0;
		
		if(!stemmer.isEmpty()) {
			for(Stemme s : stemmer) {
				int rating = s.getRating();
				if(rating != 0) {
					if(rating > NULLPUNKT) {
						positivScore += (rating - NULLPUNKT);
					}else {
						negativScore += (rating - NULLPUNKT);
					}
				}
			}
		}
		
		positivScore = (positivScore / 100.0);
		negativScore = (negativScore / 100.0);
		
		return STANDARDSCORE + positivScore + negativScore;
		
	}
	
	
	//TODO - endre til å ta inn en liste med stemmer istedenfor
	/**
	 * 
	 * @param stemmer som skal brukes til å regne ut stemmer
	 * @return returnerer (totalscore + gjScore * vektetScore)/antallStemmer
	 * fjerner vektetScore fra utregningen hvis den er 0
	 */
	public static double regnUtScore(List<Stemme> stemmer) {
		int antallStemmer = gyldigeStemmer(stemmer);
		double gjScore = regnUtGjScore(stemmer);
		double vektetScore = regnUtVektetScore(stemmer);
		
		return gjScore * antallStemmer * vektetScore;
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










