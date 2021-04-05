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
import hjelpeKlasser.GyldigSesjon;

/**
 * 
 * @author ??? / Ruben Aadland
 *	
 * Sletter prosjektet og stemmene som prosjektet hadde
 * Sender brukeren tilbake til adminsiden
 */

@Deprecated
//Skal slettes fra prosjekt liste, og ikke fra egen side
@WebServlet(name = "SlettProsjektServlet", urlPatterns = "/slettProsjekt")
public class SlettProsjektServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ProsjektDAO prosjektDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			request.getRequestDispatcher("WEB-INF/SlettProsjekt.jsp").forward(request, response);
		}else {
			response.sendRedirect("logginn");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			String prosjektNr = request.getParameter("prosjektNr");
			
			if(prosjektNr != null) {
				prosjektDAO.slettProsjekt(prosjektNr);
				
				response.sendRedirect("ProsjektListe");
			}else {
				response.sendRedirect("slettProsjekt");
			}
		}else {
			response.sendRedirect("logginn");
		}
	}

}
