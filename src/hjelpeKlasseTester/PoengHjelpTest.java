package hjelpeKlasseTester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import hjelpeKlasser.PoengHjelp;

class PoengHjelpTest {

	PoengHjelp hjelper = new PoengHjelp();

	@Test
	void test() {

		HashMap<String, Float> map = new HashMap<String, Float>();
		map.put("47348605", (float) 4);
		map.put("47348606", (float) 5);
		map.put("47348607", (float) 1);

		assertEquals(hjelper.tellPoengTilProsjekt(map), 10);
	}

}
