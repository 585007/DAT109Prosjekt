package hjelpeKlasser;

import javax.servlet.http.HttpSession;

public class GyldigSesjon {
	
	public static boolean innlogget(HttpSession sesjon) {
		return sesjon != null;
	}

}
