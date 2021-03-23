package servlett;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProsjektDAO;
import DAO.StemmeDAO;
import entiteter.Prosjekt;
import entiteter.ProsjektScore;
import hjelpeKlasser.GyldigSesjon;
import hjelpeKlasser.ProsjektListeHjelp;

/**
 * @author Ruben Aadland
 *
 */
@WebServlet(name = "ProsjektListe", urlPatterns = "/ProsjektListe")
public class ProsjektListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ProsjektDAO prosjektDAO;
	@EJB
	StemmeDAO stemmeDAO;
	
	/**
	 * Hvis brukeren ikke er logget blir den sendt til logginn siden
	 * 
	 * Hvis den er logget inn vil servleten hente frem scorListen til prosjektene
	 * og sette den inn i sesjonen som en "prosjekter" attributt
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			List<ProsjektScore> scoreListe = ProsjektListeHjelp.hentProsjektScoreListe(prosjektDAO, stemmeDAO);
			
			sesjon.setAttribute("prosjekter", scoreListe);
			request.getRequestDispatcher("WEB-INF/ProsjektListe.jsp").forward(request, response);
		}else {
			response.sendRedirect("logginn");
		}
	}

	
	/**
	 * Hvis brukeren ikke er logget blir den sendt til logginn siden
	 * 
	 * Hvis den er logget inn vil servleten redirecte til doGet på denne servleten
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(!GyldigSesjon.innlogget(sesjon)) {
			response.sendRedirect("logginn");
		}else {
			
			int prosjektNr = Integer.parseInt(request.getParameter("prosjektnr"));
			Prosjekt p = prosjektDAO.hentProsjekt(prosjektNr);
			response.sendRedirect("kvittering");
		}
	}

}
