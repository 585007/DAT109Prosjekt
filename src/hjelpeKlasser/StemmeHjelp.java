//package hjelpeKlasser;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import DAO.StemmeDAO;
//import DAO.TilskuerDAO;
//import entiteter.Expo;
//import entiteter.Stand;
//import entiteter.Stemme;
//import entiteter.Tilskuer;
//
//public class StemmeHjelp {
//
//	public static String Stemme(String standId, HttpServletRequest request, Stand stand, StemmeDAO stemmeDAO, TilskuerDAO tilskuerDAO, Expo expo) {
//		String redirect = "";
//		String stemmeVerdi = "1";
//		
//		HttpSession session = request.getSession();			// - ???
//		Tilskuer tilskuer= session.getAttribute(tilskuer);  // - ???
//		
//		if(expo.erStemmeRegistrering≈pen()){
//			if(tilskuer.erRegistrert()) {
//				if(!tilskuerHarAllerdeStemtForStand(tilskuer, stand, stemmeDAO)) {
//					Stemme stemme = new Stemme(stemmeVerdi, stand, tilskuer.get());
//					stemmeDAO.stemForStand(stemme);
//					
//					redirect = "StemmeServlet?stemmeGitt=" + standId;
//				} else {
//					redirect = "StandServlet?standId=" + standId;
//				}
//				
//				
//				
//			} else if(!tilskuer.erRegistrert()) {
//				redirect = "nyTilskuerServlet";
//			} 
//		} else {
//			redirect = "RegistreringStengtServlet?registrering=stemme";
//		}
//		
//		
//		return redirect;
//	}
//
//
//	public static boolean tilskuerHarAllerdeStemtForStand(Tilskuer tilskuer, Stand stand, StemmeDAO stemmeDAO) {
//		List<Stemme> stemmer = tilskuer.get().hentStemtFor();
//		boolean alleredestemt = stemmer.stream()
//			.map(v -> v.hentStand())
//			.anyMatch(v -> v.equals(stand));
//		return alleredestemt;
//	}	
//	
//}