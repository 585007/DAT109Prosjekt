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
import entiteter.Prosjekt;
import hjelpeKlasser.GyldigSesjon;

/**
 * 
 * @author Svein Ove Surdal / Ruben Aadland
 *
 */
@WebServlet(name = "kvittering", urlPatterns = "/kvittering")
public class KvitteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ProsjektDAO prosjektDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if (GyldigSesjon.innlogget(sesjon)) {
			if (request.getParameter("prosjektnr") != null) {
				int prosjektNr = Integer.parseInt(request.getParameter("prosjektnr"));
				Prosjekt p = prosjektDAO.hentProsjekt(prosjektNr);
				request.setAttribute("prosjekter", p);
			}else {
				response.sendRedirect("logginn");
			}
		}else {
			response.sendRedirect("logginn");
		}
		
			
		
		request.getRequestDispatcher("WEB-INF/kvittering.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("admin");
	}

}
