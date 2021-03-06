package servlett;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProsjektDAO;
import DAO.StemmeDAO;
import entiteter.Prosjekt;
import entiteter.Stemme;
import hjelpeKlasser.GyldigInput;

/**
 * brukes for ? registrere stemmer
 * @author Halvor / Svein Ove Surdal / Ruben Aadland
 *
 */
@WebServlet("/StemmeServlet")
public class StemmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StemmeDAO stemmeDAO;
	@EJB
	ProsjektDAO ProsjektDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";
		if (request.getParameter("invalidInput") != null) {
			loginMessage = "Ugylig mobilnummer";
		}
		Integer prosjektId = Integer.parseInt(request.getParameter("prosjektId"));
		Prosjekt prosjekt = ProsjektDAO.hentProsjekt(prosjektId);
		String prosjektNavn = prosjekt.getProsjektnavn();
		request.setAttribute("prosjektNavn", prosjektNavn);
		request.setAttribute("prosjektId", prosjektId);

		request.setAttribute("invalidMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/Stemme.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer prosjektId = Integer.parseInt(request.getParameter("prosjektId"));

		String prosjektNavn = request.getParameter("prosjektNavn");
		request.setAttribute("prosjektNavn", prosjektNavn);
		
		int prosjektID = Integer.parseInt(request.getParameter("prosjektId"));
		int tlf = Integer.parseInt(request.getParameter("tlf"));
		int rating = Integer.parseInt(request.getParameter("rating"));

		if (GyldigInput.stemmeInput(prosjektID, tlf, rating)) {
			int stemmeID = stemmeDAO.sjekkeOmStemmeFinnes(tlf, prosjektID);
			if(stemmeID > 0) {
				stemmeDAO.updateStemme(stemmeID, rating);
			}else {
				Stemme stemme = new Stemme(prosjektId,tlf, rating);
				stemmeDAO.lagreNyStemme(stemme);
			}

			request.getRequestDispatcher("WEB-INF/StemmeKvittering.jsp").forward(request, response);
		}else {
			response.sendRedirect("StemmeServlet?prosjektId="+prosjektId+"&invalidInput");
		}
	}

}
