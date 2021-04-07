package hjelpeKlasser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PassordHjelpTest {

	@Test
	void testHashMedSalt() {
		String salt1 = PassordHjelp.genererTilfeldigSalt();
		String salt2 = PassordHjelp.genererTilfeldigSalt();
		String pass = "Onyankopan321";
		String hashSalt1 = PassordHjelp.hashMedSalt(pass,salt1);
		String hashSalt2 = PassordHjelp.hashMedSalt(pass,salt2);
		assertFalse(hashSalt1.equals(hashSalt2));
	}

	@Test
	void testValiderMedSalt() {
		String pass1 = "Yelena123";
		String pass2 = "213Pieck";
		String salt = PassordHjelp.genererTilfeldigSalt();
		String hashpass = PassordHjelp.hashMedSalt(pass1, salt);
		boolean lik = PassordHjelp.validerMedSalt(pass1, salt, hashpass);
		boolean ulik = PassordHjelp.validerMedSalt(pass2, salt, hashpass);
		assertTrue(lik);
		assertFalse(ulik);
	}

}
