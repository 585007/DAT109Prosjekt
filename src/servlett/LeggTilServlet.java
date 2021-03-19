package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProsjektDAO;
import entiteter.Prosjekt;

/**
 * Servlet implementation class LeggTilProsjekt
 */
@WebServlet("/LeggTilProsjekt")
public class LeggTilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeggTilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/LeggTilProsjekt.jsp").forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String prosjektNr = request.getParameter("prosjektnr");
		int nr = Integer.parseInt(prosjektNr);
		
		String navn = request.getParameter("navn");
		Prosjekt p = new Prosjekt(nr, navn);
		ProsjektDAO.lagreNyttProsjekt(p);
		
		response.sendRedirect("WEB-INF/LeggTilKvittering.jsp");
	}

}
