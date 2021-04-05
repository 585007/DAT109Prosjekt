package servlett;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdmDAO;
import entiteter.Admin;
import hjelpeKlasser.GyldigInput;

/**
 * Innlogging med verifisering av brukernavn og passord
 * 
 * @author Svein Ove Surdal / ??? / Ruben Aadland
 *
 */
@WebServlet(name = "LogginnServlet", urlPatterns = "/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AdmDAO adminDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";
		if (request.getParameter("invalidLogginn") != null) {
			loginMessage = "Feil brukernavn/passord";
		}
		request.setAttribute("loginMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bruker = request.getParameter("bruker");
		String passord = request.getParameter("passord");
		
		Admin admin = adminDAO.getAdmin(bruker);
		
		if(admin != null){
			if(admin.gyldigPassord(passord)) {
				HttpSession sesjon = request.getSession(false);
				if (sesjon != null) {
						sesjon.invalidate();
				}
				sesjon = request.getSession(true);
			
				response.sendRedirect("admin");
			}else {
				response.sendRedirect("logginn?invalidLogginn=true");
			}
		}else {
			response.sendRedirect("logginn?invalidLogginn=true");
		}	
	}
}