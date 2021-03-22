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
import hjelpeKlasser.GyldigSesjon;

/**
 * @author Ruben Aadland
 *
 */
@WebServlet(name = "ProsjektListe", urlPatterns = "/ProsjektListe")
public class ProsjektListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ProsjektDAO proDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		System.out.println(proDAO.hentProsjekt(101));
		
		if(true){  //GyldigSesjon.innlogget(sesjon)) {
			//sesjon.setAttribute("prosjekter", proDAO.hentAlleProsjekter());
			request.getRequestDispatcher("WEB-INF/ProsjektListe.jsp").forward(request, response);
		}else {
			response.sendRedirect("logginn");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			response.sendRedirect("ProsjektListe");
		}else {
			response.sendRedirect("logginn");
		}
	}

}
