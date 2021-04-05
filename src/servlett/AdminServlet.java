package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hjelpeKlasser.GyldigSesjon;

/**
 * Har tre knapper som sender deg videre til en av tre destinasjoner legg til et posjekt, 
 * liste over prosjekter med poeng og slett et prosjekt
 * @author Svein Ove Surdal / Ruben Aadland
 *
 */
@WebServlet(name = "admin", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (GyldigSesjon.innlogget(sesjon)) {
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
		}else {
			response.sendRedirect("logginn");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("logginn");
		
	}

}
