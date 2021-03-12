package servlett;

import java.io.IOException;

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
@WebServlet(name = "ProsjektListeServlet", urlPatterns = "/ProsjektListe")
public class ProsjektListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = request.getSession(false);
		
		if(GyldigSesjon.innlogget(sesjon)) {
			sesjon.setAttribute("prosjekter", ProsjektDAO.getProsjekter());
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
