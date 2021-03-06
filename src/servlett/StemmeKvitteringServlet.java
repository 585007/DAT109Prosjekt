package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Skriver ut kvittering som bekrefter at du har stemt p? et prosjekt.
 * 
 * @author Halvor Edvard Eid/ Svein Ove Surdal
 *
 */

@WebServlet("/stemmekvittering")
public class StemmeKvitteringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/StemmeKvittering.jsp").forward(request, response);}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("stemmekvittering");
	}

}