package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logginn
 */
@WebServlet("/Logginn")
public class Logginn extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@EJB

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

		if (!bruker.equals(brukernavn som er i databasen)
				|| passord sjekkes opp mot passor på databasen "må gjennom hash") {
			String loginMessage = "Ugyldig brukernavn og/eller passord";
			request.setAttribute("loginMessage", loginMessage);
			request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
		} else {

			response.sendRedirect("admin");
		}

	}
}
