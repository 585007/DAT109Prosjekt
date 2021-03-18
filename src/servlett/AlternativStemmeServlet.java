package servlett;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProsjektDAO;
import entiteter.Prosjekt;
import entiteter.Stemme;

@WebServlet("/AlternativStemmeServlet")
public class AlternativStemmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ProsjektDAO phjelp = new ProsjektDAO();

	public AlternativStemmeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/AlternativStemmeKvittering.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mobilNrStr = request.getParameter("tlf");
		int mobilNr = Integer.parseInt(mobilNrStr);
		String ratingVerdiStr = request.getParameter("rating");
		int ratingVerdi = Integer.parseInt(ratingVerdiStr);
		String prosjektIDStr = request.getParameter("prosjektID"); // denne skal komme fra en hidden i jsp formen
		int prosjektID = Integer.parseInt(prosjektIDStr);

		
		Prosjekt pros = phjelp.getProsjekt(prosjektID);

		// Om det skulle skje et problem og prosjektID ikke er valid
		if (pros == null) {
			request.getSession().setAttribute("feil", "Prosjektet du prøver stemme på eksisterer ikke.");
		}
		
		Stemme nyStemme = new Stemme(mobilNr, ratingVerdi, prosjektID);

		// Nyeste stemme gjelder, så gamle slettes først.

		// Trenger en måte å oppdatere prosjektet og dens stemmer i databasen.
		phjelp.oppdater(pros);

		response.sendRedirect("AlternativStemmeServlet");
	}

}
