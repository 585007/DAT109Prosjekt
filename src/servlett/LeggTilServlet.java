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
 * @author ??? / Svein Ove Surdal / Håkon Herrevold / Ruben Aadland
 *
 */

@WebServlet(name = "LeggTilProsjekt", urlPatterns = "/LeggTilProsjekt")
public class LeggTilServlet extends HttpServlet {

	@EJB
	ProsjektDAO prosjektDAO;

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";
		if(request.getParameter("invalidProsjekt")!=null) {
			loginMessage="Ugyldig prosjekt!";
		}
//		int prosjektNr = prosjektDAO.hentAlleProsjekter().size() +1;
		request.setAttribute("loginMessage", loginMessage);

		HttpSession sesjon = request.getSession(false);

		if (GyldigSesjon.innlogget(sesjon)) {
			request.getRequestDispatcher("WEB-INF/LeggTilProsjekt.jsp").forward(request, response);
		} else {
			response.sendRedirect("logginn");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String prosjektNr = request.getParameter("prosjektnr");
//		int nr = Integer.parseInt(prosjektNr);

		HttpSession sesjon = request.getSession(false);

		if (GyldigSesjon.innlogget(sesjon)) {
			String navn = request.getParameter("navn");
			if (!hjelpeKlasser.GyldigInput.isValidProsjektNavn(navn)) {
				response.sendRedirect("LeggTilProsjekt?invalidProsjekt");
			}
			Prosjekt p = new Prosjekt(navn);

			prosjektDAO.lagreNyttProsjekt(p);

			sesjon.setAttribute("prosjekter", p);
			response.sendRedirect("kvittering");
		} else {
			response.sendRedirect("logginn");
		}
	}

}
