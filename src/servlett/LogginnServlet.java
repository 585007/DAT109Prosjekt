package servlett;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdmDAO;
import hjelpeKlasser.PassordHjelp;

@WebServlet(name = "logginn", urlPatterns = "/logginn")
public class LogginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AdmDAO admDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (sesjon != null) {
			sesjon.invalidate();
		}
		sesjon = request.getSession(true);

		String passord = request.getParameter("passord");
		String bruker = request.getParameter("bruker");

		if (!bruker.equals(admDAO.hentBrukernavn())
				|| PassordHjelp.validerMedSalt(passord, admDAO.hentSalt() , admDAO.hentPassord())) {
			String loginMessage = "Ugyldig brukernavn og/eller passord";
			request.setAttribute("loginMessage", loginMessage);
			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
		} else {

			response.sendRedirect("admin");
		}

	}
}
