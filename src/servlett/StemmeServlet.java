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

/**
 * 
 * @author Halvor / Svein Ove Surdal
 *
 */
@WebServlet("/StemmeServlet")
public class StemmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StemmeDAO stemmeDAO;
	@EJB
	ProsjektDAO ProsjektDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginMessage = "";
		if (request.getParameter("invalidTlf") != null) {
			loginMessage = "Ugylig telefonnummer!";
		} else if (request.getParameter("invalidValg") != null) {
			loginMessage = "Ugylig valg!";
		}
		Integer prosjektId = Integer.parseInt(request.getParameter("prosjektId"));
		Prosjekt prosjekt = ProsjektDAO.hentProsjekt(prosjektId);
		String prosjektNavn = prosjekt.getProsjektNavn();
		request.setAttribute("prosjektNavn", prosjektNavn);
		request.setAttribute("prosjektId", prosjektId);

		request.setAttribute("loginMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/Stemme.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer prosjektId = Integer.parseInt(request.getParameter("prosjektId"));

		String prosjektNavn = request.getParameter("prosjektNavn");
		request.setAttribute("prosjektNavn", prosjektNavn);

		String temptlf = request.getParameter("tlf");
		if (!hjelpeKlasser.GyldigInput.isValidMobilnr(temptlf)) {
			response.sendRedirect("StemmeServlet?invalidTlf");
		}
		int tlf = Integer.parseInt(temptlf);

		String temprating = request.getParameter("rating");
		if (temprating == null) {
			response.sendRedirect("StemmeServlet?invalidValg");
		}
		int rating = Integer.parseInt(request.getParameter("rating"));

		if (prosjektId != null) {
			Stemme stemme = new Stemme(prosjektId, tlf, rating);
			stemmeDAO.lagreNyStemme(stemme);
			response.sendRedirect("stemmekvittering");
		}
//		 else {
//			request.setAttribute("errorMessage", "Denne standen finnes ikke!");
//			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
//
//		}
	}

}
