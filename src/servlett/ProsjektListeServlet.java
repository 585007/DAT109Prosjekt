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
 * viser en liste over alle lagrede prosjekter
 * @author Ruben Aadland / Svein Ove Surdal
 *
 */
@WebServlet(name = "ProsjektListe", urlPatterns = "/ProsjektListe")
public class ProsjektListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ProsjektDAO prosjektDAO;
	@EJB
	StemmeDAO stemmeDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			List<Prosjekt> prosjekter = prosjektDAO.hentAlleProsjekter();
			
			List<ProsjektScore> scoreListe = ProsjektListeHjelp.hentProsjektScoreListe(prosjekter, stemmeDAO);
			
			sesjon.setAttribute("prosjekter", scoreListe);
			request.getRequestDispatcher("WEB-INF/ProsjektListe.jsp").forward(request, response);
		}else {
			response.sendRedirect("logginn");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(!GyldigSesjon.innlogget(sesjon)) {
			response.sendRedirect("logginn");
		}else {
			response.sendRedirect("kvittering");
		}
	}

}
