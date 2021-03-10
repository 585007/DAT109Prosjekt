package hjelpeKlasser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Håkon Herrevold
 *
 */
public class PoengHjelp {

	/**
	 * @param map
	 * @return TotalPoeng
	 */
	public float tellPoengTilProsjekt(HashMap map) {
		float poeng = 0;

		HashMap<String, Float> hashmap = map;

		for (float p : hashmap.values()) {
			poeng += p;
		}
		return poeng;
	}

}
