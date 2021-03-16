package servlett;

import java.io.IOException;

//import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import DAO.AdmDAO;
//import hjelpeKlasser.PassordHjelp;

/**
 * Innlogging med verifisering av brukernavn og passord
 * 
 * @author Svein Ove Surdal
 *name = "LogginnServlet", urlPatterns = 
 */
@WebServlet("/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

<<<<<<< HEAD
	// @EJB
	// AdmDAO admDAO;

=======
	//@EJB
	//AdmDAO admDAO;
	
@Override
>>>>>>> branch 'main' of https://github.com/585007/DAT109Prosjekt.git
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
		sesjon = request.getSession(true);

<<<<<<< HEAD
		String passord = request.getParameter("passord");
		String bruker = request.getParameter("bruker");
		
		System.out.println("du skrev inn passord " + passord);
		System.out.println("du skrev inn brukernavn " + bruker);
		
		String passordHardKodet = "pass";
		String brukerHardKodet = "adm";
		if (!bruker.equals(brukerHardKodet) || !passord.equals(passordHardKodet)) { // til bruk under test med hardkoding av passord og brukernavn
=======
//		String passord = request.getParameter("passord");
//		String bruker = request.getParameter("bruker");

//		if (!bruker.equals(admDAO.hentBrukernavn())
//				|| PassordHjelp.validerMedSalt(passord, admDAO.hentSalt() , admDAO.hentPassord())) {
			
		if(false) {
>>>>>>> branch 'main' of https://github.com/585007/DAT109Prosjekt.git
			String loginMessage = "Ugyldig brukernavn og/eller passord";
			request.setAttribute("loginMessage", loginMessage);
			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
		} else {
			response.sendRedirect("admin");
		}
		
//		if (!bruker.equals(admDAO.hentBrukernavn())
//				|| PassordHjelp.validerMedSalt(passord, admDAO.hentSalt() , admDAO.hentPassord())) {
			
//		if(false) {
//			String loginMessage = "Ugyldig brukernavn og/eller passord";
//			request.setAttribute("loginMessage", loginMessage);
//			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
//		} else {

//			response.sendRedirect("admin");
//		}

	}
}
