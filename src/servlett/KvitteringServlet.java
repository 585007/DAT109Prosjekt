package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "kvittering", urlPatterns = "/kvittering")
public class KvitteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		if (sesjon == null) {
			response.sendRedirect("logginn");
		}
		String prosjektNavn = request.getParameter("prosjektNavn");
		request.setAttribute("prosjektNavn", prosjektNavn);
		request.getRequestDispatcher("WEB-INF/kvittering.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prosjektNavn = request.getParameter("prosjektNavn");
		response.sendRedirect("kvittering?prosjektNavn="+prosjektNavn);
	}

}
