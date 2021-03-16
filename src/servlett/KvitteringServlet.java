package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * lager en QR kode som skal henges opp på stand. QR koden lages av JS i jsp filen. 
 * QR koden sender den som scanner koden til stemme siden for det aktuelle prosjektet.
 * @author Svein Ove Surdal
 *
 */
@WebServlet(name = "kvittering", urlPatterns = "/kvittering")
public class KvitteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		if (sesjon == null) {
			response.sendRedirect("logginn");
		}
		String prosjektNavn = request.getParameter("prosjektId"); // henter prosjektId til bruk for å finne adressen til stemmeside for å lage QR koden
		request.setAttribute("prosjektNavn", prosjektNavn);
		request.getRequestDispatcher("WEB-INF/kvittering.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("admin"); // sender deg tilbake til admin.
	}

}
