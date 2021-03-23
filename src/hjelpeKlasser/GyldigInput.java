package hjelpeKlasser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GyldigInput {

	public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
	public static final String ANY_CAPITAL_LETTER = "[A-ZÆØÅ]";
	public static final String ANY_LETTER_WITH_SPACE_HYPHEN = "[a-zA-ZæøåÆØÅ \\-]";
	public static final String ANY_LETTER_WITH_HYPHEN = "[a-zA-ZæøåÆØÅ\\-]";
	public static final String ANY_DIGIT = "[0-9]";
	public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
	public static final String THREE_TIMES = "{3}";
	public static final String EIGHT_TIMES = "{8}";
	public static final String ZERO_OR_MORE_TIMES = "*";
	public static final String TWO_TO_20_TIMES = "{2,20}";
	public static final String ZERO_OR_ONE_TIME = "?";

	static String sql = "SELECT * FROM admLogin.table";

	public static boolean isValidProsjektNavn(String n) {

		if (n == null) {
			return false;
		}
		return n.matches("^" + ANY_CAPITAL_LETTER + ANY_LETTER_WITH_SPACE_HYPHEN + TWO_TO_20_TIMES + "$");
	}
	/**/

	public static boolean isValidAdmBrukernavn(String n) {

		if (n == null) {
			return false;
		}
		return n.matches("^" + ANY_LETTER_OR_DIGIT + THREE_TIMES + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
	}

	public static boolean isValidPass(String n) {

		if (n == null) {
			return false;
		}
		return n.matches("^" + ANY_LETTER_OR_DIGIT + THREE_TIMES + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
	}
	/**@param telefonnr
	 * @return om det er et gyldig nr med 8 siffer
	 * */
	public static boolean isValidMobilnr(String n) {

			if (n == null || !n.matches("^" + ANY_DIGIT + EIGHT_TIMES + "$")) {
				return false;
			}
			return true;
	}
	
		public static boolean isValidEtternavn(String n) {

			if (n == null) {
				return false;
			}
			return n.matches("^" + ANY_CAPITAL_LETTER + ANY_LETTER_WITH_HYPHEN + TWO_TO_20_TIMES + "$");

		}
		/**@param n telefonnr
		 * @return bool om telefonnr ikke har stemt på prosjektet før
		 * */
		public static boolean isNyStemme(String n) {
			sql = "SELECT * FROM public.stemme";
			if (n == null || !n.matches("^" + ANY_DIGIT + EIGHT_TIMES + "$")) {
				return false;
			}
			Connection connection;
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://data1.hib.no:5434/hdat109_v21_prosjekt05", "h590791",
						"pass");
				PreparedStatement pst = connection.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					if (rs.getString("mobil").matches(n)) {
						System.out.println("allerede stemme på mobilnr");
						return false;
					}
				}
			} catch (SQLException e) {
				try {
					connection = DriverManager.getConnection("jdbc:postgresql://data1.hib.no:5434/hdat109_v21_prosjekt05", "h590791",
							"pass");
					PreparedStatement pst = connection.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						if (rs.getString("mobil").matches(n)) {
							System.out.println("allerede stemme på mobilnr");
							return false;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return false;
				}
			}
			return true;
		}


/**@param n brukernavn til adm
 * @param p passord
 * @return bool om brukernavn/pass matcher i login-db
 * */
		public static boolean isValidAdmLogin(String n, String p) {

			if (n == null || p == null) {
				return false;
			}
			try {
				Connection connection = DriverManager.getConnection("jdbc:postgresql://data1.hib.no:5434/h590791",
						"h590791", "pass");

				PreparedStatement pst = connection.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					if (rs.getString("brukernavn").matches(n)) {
						if (rs.getString("passord").matches(SHA.shaEnc(p, rs.getString("salt")))) {
							return true;
						}
					}
				}

			} catch (SQLException e) {
				//hadde problemer med sqlexception men som løste seg ved å prøve en gang ting o_O
				Connection connection;
				try {
					System.out.println("sqlexeption catch nr 1");
					connection = DriverManager.getConnection("jdbc:postgresql://data1.hib.no:5434/h590791",
							"h590791", "pass");


				PreparedStatement pst = connection.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					if (rs.getString("brukernavn").matches(n)) {
						if (rs.getString("passord").matches(SHA.shaEnc(p, rs.getString("salt")))) {
							return true;
						}
					}
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("sqlexeption catch nr 2");
					e1.printStackTrace();
					return false;
				}
			

			}
			return false;
		}
	}

