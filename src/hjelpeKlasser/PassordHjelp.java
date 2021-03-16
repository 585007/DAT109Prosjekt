package hjelpeKlasser;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;
/**
 * oppretter og sjekker passord
 * @author Svein Ove Surdal
 *
 */
public class PassordHjelp {
	
	/**
	 * genererer salt til passord
	 * @return salt
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
	 * genererer hash av passord med salt
	 * @param passord
	 * @param salt
	 * @return passordhash
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
	 * Sjekker passord med gitt salt opp mot passordhash 
	 * @param passord
	 * @param salt
	 * @param passordhash
	 * @return true om validert ellers false
	 */
	public static boolean validerMedSalt(String passord, String salt, String passordhash) {
		return passordhash.equals(hashMedSalt(passord, salt));
	}
}
