package hjelpeKlasser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Deprecated
public class SHA {
	
	public static String shaEnc(String pass, String s){
	       
		byte[] salt = s.getBytes();
		MessageDigest digest;        
		StringBuilder sb = new StringBuilder();
		try {
			digest = MessageDigest.getInstance("SHA-256");
		
		digest.update(salt);
		byte[] hash = digest.digest(pass.getBytes());

        for(int i=0; i< hash.length ;i++)
        {
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String generatedPassword = sb.toString();
		return generatedPassword;
	}
    public static String makeSalt(){   
    SecureRandom sr;
    byte[] salt = new byte[16];
    StringBuilder sb = new StringBuilder();
	try {
		sr = SecureRandom.getInstance("SHA1PRNG");
        sr.nextBytes(salt);
        	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        for(int i=0; i< salt.length ;i++)
        {
            sb.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
        }
        String s = sb.toString();
        return s;
    }
}
