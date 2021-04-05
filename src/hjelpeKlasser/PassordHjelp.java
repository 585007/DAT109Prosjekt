package hjelpeKlasser;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * 
 * @author Svein Ove Surdal
 *
 */
public class PassordHjelp {
	
	/**
	 * 
	 * @return returnerer en String med tilfeldig salt
	 */
	public synchronized static String genererTilfeldigSalt() {
	    SecureRandom sr;
	    byte[] salt = new byte[16];
		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
		    sr.nextBytes(salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    return DatatypeConverter.printHexBinary(salt);
	}
	
	/**
	 * 
	 * @param passord i String format
	 * @param salt til passordet
	 * @return returnerer hashet og saltet passord
	 */
	public synchronized static String hashMedSalt(String passord, String salt) { 
		
		char[] passchar = passord.toCharArray();
		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
		
		byte[] keyhash = null;
		try {
			PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			keyhash = skf.generateSecret(pks).getEncoded();
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(keyhash);
	}
	
	/**
	 * 
	 * @param passord som skal valideres
	 * @param salt salt til originale passord
	 * @param passordhash originale passord
	 * @return om passord er det samme som passordHash
	 */
	public static boolean validerMedSalt(String passord, String salt, String passordHash) {
		return passordHash.equals(hashMedSalt(passord, salt));
	}
}
