package hjelpeKlasser;

import javax.servlet.http.HttpSession;

/**
 * 
 * @author Ruben Aadland
 *
 */
public class GyldigSesjon {
	
	public static boolean innlogget(HttpSession sesjon) {
		return sesjon != null;
	}

}
