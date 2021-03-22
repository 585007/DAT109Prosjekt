package servlett;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProsjektDAO;
import DAO.StemmeDAO;
import hjelpeKlasser.GyldigSesjon;

/**
 * Servlet implementation class SletteServlet
 */

/**
 * 
 * @author ??? / Ruben Aadland
 *	
 * Sletter prosjektet og stemmene som prosjektet hadde
 * Sender brukeren tilbake til adminsiden
 */

@WebServlet(name = "SlettProsjektServlet", urlPatterns = "/slettProsjekt")
public class SlettProsjektServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	StemmeDAO stemmeDAO;
	@EJB
	ProsjektDAO prosjektDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			request.getRequestDispatcher("WEB-INF/SlettProsjekt.jsp").forward(request, response);
		}else {
			response.sendRedirect("logginn");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			String prosjektNr = request.getParameter("prosjektNr");
			
			if(prosjektNr != null) {
				prosjektDAO.slettProsjekt(prosjektNr);
				
				response.sendRedirect("admin");
			}else {
				response.sendRedirect("slettProsjekt");
			}
		}else {
			response.sendRedirect("logginn");
		}
	}

}
