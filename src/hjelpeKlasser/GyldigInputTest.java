package hjelpeKlasser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GyldigInputTest {

	@Test
	public void testProsjektNavn() {
		assertTrue(GyldigInput.isValidProsjektNavn("Per-Olav"));
		assertTrue(GyldigInput.isValidProsjektNavn("Åge aleksandersen"));
		assertFalse(GyldigInput.isValidProsjektNavn("bob"));
		assertFalse(GyldigInput.isValidProsjektNavn("B"));
		assertFalse(GyldigInput.isValidProsjektNavn("B23ait"));
		assertFalse(GyldigInput.isValidProsjektNavn(null));
		assertFalse(GyldigInput.isValidProsjektNavn("Permanente Ørners Kule Prosjekt"));
	}
	
	@Test
	public void testAdminBrukernavn() {
		assertTrue(GyldigInput.isValidAdminBrukernavn("ÅgeAleksandersen"));
		assertTrue(GyldigInput.isValidAdminBrukernavn("bob"));
		assertTrue(GyldigInput.isValidAdminBrukernavn("B23ait"));
		assertTrue(GyldigInput.isValidAdminBrukernavn("1YkkEt1lÅgjEtteDe33eFørD1dEtErL4ngt"));
		assertFalse(GyldigInput.isValidAdminBrukernavn("Per-Olav"));
		assertFalse(GyldigInput.isValidAdminBrukernavn("B"));
		assertFalse(GyldigInput.isValidAdminBrukernavn(null));
		assertFalse(GyldigInput.isValidAdminBrukernavn("2 navn"));
	}
	
	@Test
	public void testPassord() {
		assertTrue(GyldigInput.isValidAdminBrukernavn("ÅgeAleksandersen"));
		assertTrue(GyldigInput.isValidAdminBrukernavn("bob"));
		assertTrue(GyldigInput.isValidAdminBrukernavn("B23ait"));
		assertTrue(GyldigInput.isValidAdminBrukernavn("1YkkEt1lÅgjEtteDe33eFørD1dEtErL4ngt"));
		assertFalse(GyldigInput.isValidAdminBrukernavn("Per-Olav"));
		assertFalse(GyldigInput.isValidAdminBrukernavn("B"));
		assertFalse(GyldigInput.isValidAdminBrukernavn(null));
		assertFalse(GyldigInput.isValidAdminBrukernavn("2 navn"));
	}
	
	@Test
	public void testMobilnummer() {
		assertTrue(GyldigInput.isValidMobilnummer("12354678"));
		assertFalse(GyldigInput.isValidMobilnummer("23463"));
		assertFalse(GyldigInput.isValidMobilnummer("PersOlav"));
		assertFalse(GyldigInput.isValidMobilnummer(null));
		assertFalse(GyldigInput.isValidMobilnummer("222 33 444"));
	}
	
	@Test
	public void testEtternavn() {
		assertTrue(GyldigInput.isValidProsjektNavn("Per-Olav"));
		assertTrue(GyldigInput.isValidProsjektNavn("Åge aleksandersen"));
		assertFalse(GyldigInput.isValidProsjektNavn("bob"));
		assertFalse(GyldigInput.isValidProsjektNavn("B"));
		assertFalse(GyldigInput.isValidProsjektNavn("B23ait"));
		assertFalse(GyldigInput.isValidProsjektNavn(null));
		assertFalse(GyldigInput.isValidProsjektNavn("Permanente Ørners Kule Etternavn"));
	}
	
	@Test
	public void testStemmeInput() {
		int tlf1 = 12345678;
		int tlf2 = 1234;
		int id1 = 1;
		int id2 = -2;
		int rating1 = 3;
		int rating2 = 7;
		boolean akseptert = GyldigInput.stemmeInput(id1, tlf1, rating1);
		boolean tlfFalse = GyldigInput.stemmeInput(id1, tlf2, rating1);
		boolean idFalse = GyldigInput.stemmeInput(id2, tlf1, rating1);
		boolean ratingFalse = GyldigInput.stemmeInput(id1, tlf1, rating2);
		assertTrue(akseptert);
		assertFalse(tlfFalse);
		assertFalse(idFalse);
		assertFalse(ratingFalse);
	}
	
/* hvis vi skal også teste på rating og prosjektid
	@Test
	public void testValidRating() {
		assertTrue(GyldigInput.isValidRating(5));
		assertTrue(GyldigInput.isValidRating(0));
		assertFalse(GyldigInput.isValidRating(23463));
		assertFalse(GyldigInput.isValidRating(-4));
	}
	
	@Test
	public void testValidProsjektId() {
		assertTrue(GyldigInput.isValidProsjektId("1"));
		assertTrue(GyldigInput.isValidProsjektId("23463236463363463467"));
		assertFalse(GyldigInput.isValidProsjektId("325ges346"));
		assertFalse(GyldigInput.isValidProsjektId(null));
		assertFalse(GyldigInput.isValidProsjektId("222 33 444"));
		assertFalse(GyldigInput.isValidProsjektId("-4"));
	}
*/
	
}
