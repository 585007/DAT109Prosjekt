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
			poeng += s.getRating();
		}
		return poeng;
	}
	
	/**
	 * 
	 * @param stemmer regner ut score fra listen med stememr som blir sendt inn
	 * @return scoren fra stemmene
	 */
	public static double regnUtProsjektScore(List<Stemme> stemmer) {
		int antallStemmer = stemmer.size();
		
		int poeng = tellPoengTilProsjekt(stemmer);
		
		return (double) (poeng/antallStemmer);
	}

}
