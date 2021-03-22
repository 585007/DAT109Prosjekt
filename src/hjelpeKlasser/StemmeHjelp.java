//package hjelpeKlasser;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import DAO.StemmeDAO;
//import entiteter.Prosjekt;
//import entiteter.Stemme;
//
//public class StemmeHjelp {
//
//	public static String Stemme(String standId, HttpServletRequest request, Prosjekt prosjekt, StemmeDAO stemmeDAO) {
//		String redirect = "";
//		String stemmeVerdi = "1";
//
//		HttpSession session = request.getSession(); // - ???
//
//				if (!tilskuerHarAllerdeStemtForStand(tilskuer, prosjekt, stemmeDAO)) {
//					Stemme stemme = new Stemme(tlf, rating, prosjekt.getProsjektNr());
//					stemmeDAO.lagreNyStemme(stemme);
//
//					redirect = "StemmeServlet?stemmeGitt=" + standId;
//				} else {
//					redirect = "StandServlet?standId=" + standId;
//				}
//
//			} else if (!tilskuer.erRegistrert()) {
//				redirect = "nyTilskuerServlet";
//			}
//		} else {
//			redirect = "RegistreringStengtServlet?registrering=stemme";
//		}
//
//		return redirect;
//	}
//
//	public static boolean tilskuerHarAllerdeStemtForStand(Tilskuer tilskuer, Stand stand, StemmeDAO stemmeDAO) {
//		List<Stemme> stemmer = tilskuer.get().hentStemtFor();
//		boolean alleredestemt = stemmer.stream().map(v -> v.hentStand()).anyMatch(v -> v.equals(stand));
//		return alleredestemt;
//	}
//
//}