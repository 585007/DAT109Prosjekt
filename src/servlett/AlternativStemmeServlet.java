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

		String feilmelding = "";

		String mobilNr = request.getParameter("tlf");
		String ratingVerdiStr = request.getParameter("rating");
		float ratingVerdi = Float.parseFloat(ratingVerdiStr);

		String prosjektID = request.getParameter("prosjektID"); // denne skal komme fra en hidden i jsp formen

		Prosjekt pros = phjelp.getProsjekt(prosjektID);

		// Om det skulle skje et problem og prosjektID ikke er valid
		if (pros == null) {
			feilmelding = "Prosjektet du prøver stemme på eksisterer ikke.";
			request.getSession().setAttribute("feil", feilmelding);
		}

		// Nyeste stemme gjelder, så gamle slettes først.
		pros.getStemmer().remove(mobilNr);
		pros.getStemmer().put(mobilNr, ratingVerdi);

		// Trenger en måte å oppdatere prosjektet og dens stemmer i databasen.
		phjelp.oppdater(pros);

		response.sendRedirect("AlternativStemmeServlet");
	}

}
