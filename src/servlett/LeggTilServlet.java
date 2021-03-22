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

 /**
  * 
  * @author ??? / Svein Ove Surdal / Håkon Herrevold
  *
  */

@WebServlet(name = "LeggTilProsjekt", urlPatterns = "/LeggTilProsjekt")
public class LeggTilServlet extends HttpServlet {
	
	@EJB
	ProsjektDAO prosjektDAO = new ProsjektDAO();
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int prosjektNr = prosjektDAO.hentAlleProsjekter().size() +1;
//		request.setAttribute("loginMessage", loginMessage);
		request.getRequestDispatcher("WEB-INF/LeggTilProsjekt.jsp").forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//		String prosjektNr = request.getParameter("prosjektnr");
//		int nr = Integer.parseInt(prosjektNr);
		
		HttpSession sesjon = request.getSession(false);
		
		if (sesjon == null) {
			response.sendRedirect("logginn");
		}
		
		String navn = request.getParameter("navn");
		Prosjekt p = new Prosjekt(navn);
		prosjektDAO.lagreNyttProsjekt(p);
		sesjon.setAttribute("prosjekter", p);
		response.sendRedirect("WEB-INF/kvittering.jsp");
	}

}
