package hjelpeKlasser;

import javax.servlet.http.HttpSession;

/**
 * 
 * @author Ruben Aadland
 *
 */
public class GyldigSesjon {
	
	/**
	 * 
	 * @param sesjon som skal testes
	 * @return om sjesjon er gyldig
	 */
	public static boolean innlogget(HttpSession sesjon) {
		return sesjon != null;
	}

}
