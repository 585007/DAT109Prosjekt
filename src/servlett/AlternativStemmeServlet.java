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
 * @author Håkon Herrevold
 *
 */
@WebServlet("/AlternativStemmeServlet")
public class AlternativStemmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StemmeDAO steDAO = new StemmeDAO();
	@EJB
	ProsjektDAO proDAO = new ProsjektDAO();

	public AlternativStemmeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/AlternativStemmeKvittering.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String mobilNrStr = request.getParameter("tlf");
//		int mobilNr = Integer.parseInt(mobilNrStr);
//		String ratingVerdiStr = request.getParameter("rating");
//		int ratingVerdi = Integer.parseInt(ratingVerdiStr);
//		String prosjektIDStr = request.getParameter("prosjektID"); // denne skal komme fra en hidden i jsp formen
//		int prosjektID = Integer.parseInt(prosjektIDStr);
//
//		Prosjekt pros = proDAO.hentProsjekt(prosjektID);
//
//		// Om det skulle skje et problem og prosjektID ikke er valid
//		if (pros == null) {
//			request.getSession().setAttribute("feil", "Prosjektet du prøver stemme på eksisterer ikke.");
//		}
//
//		Stemme nyStemme = new Stemme(mobilNr, ratingVerdi, prosjektID);
//
//		// steDAO.fjern(mobilNr); fjerner om det allerede eksisterer stemme fra det nr
//		// Nyeste teller.
//		steDAO.lagreNyStemme(nyStemme);
		
		tester();

		response.sendRedirect("AlternativStemmeServlet");
	}
	
	void tester() {
		// tester lagring
		// Må først sjekke om stemmen finnes, Overskrive dersom den finnes eventuelt lage ny dersom ikke.
		int stemmeiden = steDAO.sjekkeOmStemmeFinnes(0, 0); // må paseres inn tlf og prosjektnr;
		Stemme nyStemme = new Stemme(47348606, 5, 1);
		steDAO.lagreNyStemme(nyStemme);
		// tester henting
		System.out.println(steDAO.hentStemme(47348606).getRating());
		
	}

}
