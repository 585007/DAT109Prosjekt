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


@WebServlet(name = "kvittering", urlPatterns = "/kvittering")
public class KvitteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ProsjektDAO prosjektDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		if (sesjon == null) {
			response.sendRedirect("logginn");
		}
		if (request.getParameter("prosjektnr") != null) {
			int prosjektNr = Integer.parseInt(request.getParameter("prosjektnr"));
			Prosjekt p = prosjektDAO.hentProsjekt(prosjektNr);
			request.setAttribute("prosjekter", p);
		}else {}
			
		
		request.getRequestDispatcher("WEB-INF/kvittering.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String prosjektNavn = request.getParameter("prosjektNavn");
		response.sendRedirect("admin");
	}

}
