package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Har tre knapper som sender deg videre til en av tre destinasjoner legg til et posjekt, 
 * liste over prosjekter med poeng og slett et prosjekt
 * @author Svein Ove Surdal
 *
 */
@WebServlet(name = "admin", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession sesjon = request.getSession(false);
//		if (sesjon == null) {
//			response.sendRedirect("logginn");
//		}
		
		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("leggTil") != null) { // knapp for å gå til leggTil
			response.sendRedirect("leggTil");

		} 
		else if (request.getParameter("prosjektListe") != null) { // knapp for å gå til prosjektListe
			response.sendRedirect("prosjektListe");

		} 
		
//		(request.getParameter("slett") != null) { // knapp for å gå til slett
			response.sendRedirect("slett");

//		}
	}

}
