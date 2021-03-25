package servlett;

import java.io.IOException;

import javax.ejb.EJB;
//import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.StemmeDAO;

//import DAO.AdmDAO;
//import hjelpeKlasser.PassordHjelp;

/**
 * Innlogging med verifisering av brukernavn og passord
 * 
 * @author Svein Ove Surdal
 *
 */
@WebServlet(name = "LogginnServlet", urlPatterns = "/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	// AdmDAO admDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";
		if (request.getParameter("invalidLogin") != null) {
			loginMessage = "Feil login!";
		} else if (request.getParameter("invalidBrukernavn") != null) {
			loginMessage = "Ikke gyldig brukernavn";
		} else if (request.getParameter("invalidPassord") != null) {
			loginMessage = "Ikke gyldig passord";
		}
		request.setAttribute("loginMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bruker = request.getParameter("bruker");
		if (!hjelpeKlasser.GyldigInput.isValidAdmBrukernavn(bruker)) {
			response.sendRedirect("logginn?invalidBrukernavn");
		}
		String passord = request.getParameter("passord");
		if (!hjelpeKlasser.GyldigInput.isValidPass(passord)) {
			response.sendRedirect("logginn?invalidPassord");
		}

		if (!hjelpeKlasser.GyldigInput.isValidAdmLogin(bruker, passord)) {
			response.sendRedirect("logginn?invalidLogin");
		} else {
			HttpSession sesjon = request.getSession(false);
			if (sesjon != null) {
				sesjon.invalidate();
			}
			sesjon = request.getSession(true);

			response.sendRedirect("admin");
		}
//		String brukerHardKodet = "adm";
//		String passordHardKodet = "pass";

//		if (!bruker.equals(admDAO.hentBrukernavn())
//				|| PassordHjelp.validerMedSalt(passord, admDAO.hentSalt() , admDAO.hentPassord())) {
//			String loginMessage = "Ugyldig brukernavn og/eller passord";
//			request.setAttribute("loginMessage", loginMessage);
//			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);

//		if (!bruker.equals(brukerHardKodet) || !passord.equals(passordHardKodet)) {
//			String loginMessage = "Ugyldig brukernavn og/eller passord";
//			request.setAttribute("loginMessage", loginMessage);
//			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
//		} else {
//			HttpSession sesjon = request.getSession(false);
//			if (sesjon != null) {
//				sesjon.invalidate();
//			}
//			sesjon = request.getSession(true);
//			
//			response.sendRedirect("admin");
//		}

	}
}