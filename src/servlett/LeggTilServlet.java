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
import hjelpeKlasser.GyldigInput;
import hjelpeKlasser.GyldigSesjon;
import hjelpeKlasser.ProsjektListeHjelp;

/**
 * Legger til et prosjekt i databasen
 * @author Halvor Edvard Eid / Svein Ove Surdal / Håkon Herrevold / Ruben Aadland
 *
 */

@WebServlet(name = "LeggTilProsjekt", urlPatterns = "/LeggTilProsjekt")
public class LeggTilServlet extends HttpServlet {

	@EJB
	ProsjektDAO prosjektDAO;
	@EJB
	StemmeDAO stemmeDAO;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";
		if(request.getParameter("invalidProsjekt")!=null) {
			loginMessage="Ugyldig prosjektnavn!";
		}
		request.setAttribute("loginMessage", loginMessage);

		HttpSession sesjon = request.getSession(false);

		if (GyldigSesjon.innlogget(sesjon)) {
			List<Prosjekt> prosjekter = prosjektDAO.hentAlleProsjekter();
						
			sesjon.setAttribute("prosjekter", prosjekter);
			
			request.getRequestDispatcher("WEB-INF/LeggTilProsjekt.jsp").forward(request, response);
		} else {
			response.sendRedirect("logginn");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);

		if (GyldigSesjon.innlogget(sesjon)) {
			String navn = request.getParameter("navn");
			if (!GyldigInput.isValidProsjektNavn(navn) || prosjektDAO.prosjektnavnFinnes(navn)) {
				response.sendRedirect("LeggTilProsjekt?invalidProsjekt");
			}else {
				Prosjekt p = new Prosjekt(navn);

				prosjektDAO.lagreNyttProsjekt(p);

				request.setAttribute("prosjekter", p);
				request.getRequestDispatcher("WEB-INF/kvittering.jsp").forward(request, response);
			}
			
		} else {
			response.sendRedirect("logginn");
		}
	}

}
