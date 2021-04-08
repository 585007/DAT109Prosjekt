package hjelpeKlasser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJB;

import DAO.ProsjektDAO;

/**
 * 
 * @author Halvor / Ruben Aadland
 *
 */
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
	@EJB
	ProsjektDAO prosjektDAO;

	/**
	 * 
	 * @param prosjektNavn
	 * @return boolean om prosjektNavn er gyldig
	 */
	public static boolean isValidProsjektNavn(String prosjektNavn) {
		return prosjektNavn != null 
				&& prosjektNavn.matches("^" + ANY_CAPITAL_LETTER + ANY_LETTER_WITH_SPACE_HYPHEN + TWO_TO_20_TIMES + "$");
	}

	/**
	 * 
	 * @param brukernavn
	 * @return boolean om brukernavn er gyldig
	 */
	public static boolean isValidAdminBrukernavn(String brukernavn) {
		return brukernavn != null
				&& brukernavn.matches("^" + ANY_LETTER_OR_DIGIT + THREE_TIMES + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
	}

	/**
	 * 
	 * @param passord
	 * @return boolean om passord er gyldig
	 */
	public static boolean isValidPassord(String passord) {
		return passord != null 
				&& passord.matches("^" + ANY_LETTER_OR_DIGIT + THREE_TIMES + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
	}

	/**
	 * @param telefonnr
	 * @return boolean om det er et gyldig nr med 8 siffer
	 */
	public static boolean isValidMobilnummer(String mobilnummer) {
		return mobilnummer != null 
				&& mobilnummer.matches("^" + ANY_DIGIT + EIGHT_TIMES + "$");
	}

	/**
	 * 
	 * @param etternavn
	 * @return boolean om etternavn er gyldig
	 */
	public static boolean isValidEtternavn(String etternavn) {
		return etternavn != null
				&& etternavn.matches("^" + ANY_CAPITAL_LETTER + ANY_LETTER_WITH_HYPHEN + TWO_TO_20_TIMES + "$");

	}

	/**
	 * @param n telefonnr
	 * @return boolean om telefonnr ikke har stemt på prosjektet før
	 */
	@Deprecated
	// Bruk stemmeDAO sin metode istedenfor
	public static boolean isNyStemme(String n) {
		sql = "SELECT * FROM public.stemme";
		if (n == null || !n.matches("^" + ANY_DIGIT + EIGHT_TIMES + "$")) {
			return false;
		}
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://data1.hib.no:5434/hdat109_v21_prosjekt05",
					"h590791", "pass");
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
				connection = DriverManager.getConnection("jdbc:postgresql://data1.hib.no:5434/hdat109_v21_prosjekt05",
						"h590791", "pass");
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

	/**
	 * 
	 * @param prosjektId
	 * @param tlf
	 * @param rating
	 * @return boolean om prosjektId, tlf og rating er gyldig input
	 */
	public static boolean stemmeInput(int prosjektId, int tlf, int rating) {
		return isValidMobilnummer("" + tlf) 
				&& isValidProsjektId("" + prosjektId) && isValidRating(rating);
	}

	/**
	 * 
	 * @param rating
	 * @return boolean om rating er gyldig
	 * 
	 */
	private static boolean isValidRating(int rating) {
		return rating <= 5 
				&& rating >= 0;
	}

	/**
	 * 
	 * @param prosjektId
	 * @return boolean om prosjektId er gyldig
	 */
	private static boolean isValidProsjektId(String prosjektId) {
		return prosjektId != null 
				&& prosjektId.matches(ANY_DIGIT + "+");

	}
}
