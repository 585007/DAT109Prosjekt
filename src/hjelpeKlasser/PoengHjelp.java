package hjelpeKlasser;

import entiteter.Stemme;

import java.util.List;


/**
 * @author H�kon Herrevold
 *
 */
public class PoengHjelp {

	/***
	 * @param stemmer
	 * @return Sum av poeng
	 */
	public int tellPoengTilProsjekt(List<Stemme> stemmer) {
		int poeng = 0;

		for (Stemme s : stemmer){
			poeng += s.getRating();
		}
		return poeng;
	}

}
