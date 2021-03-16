package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StemmeDAO;
import hjelpeKlasser.StemmeHjelp;

/**
 * Servlet implementation class SletteServlet
 */

@EJB
StemmeDAO stemmeDAO;
@EJB
StandDAO standDAO;
@EJB
TilskuerDAO tilskuerDAO;
Expo expo;

@WebServlet("/SletteServlet")
public class SletteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SletteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String standId = request.getParameter("stemmeGitt");
		if(standId != null) {
			Stand stand = standDAO.findStand(standId);
			
			request.setAttribute("stand", stand);
			request.getRequestDispatcher("WEB-INF/FerdigSlettet.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Expo expo = (Expo) request.getServletContext().getAttribute("expo");
		String standId = request.getParameter("standId");
		
		
		if(standId != null) {
			
			Stand stand = standDAO.findStand(standId);
			
			if(stand != null) {
				String redirect = StemmeHjelp.slettVote(standId, request, stand, stemmeDAO, expo);
				response.sendRedirect(redirect);
			} else {
				
				request.setAttribute("errorMessage", "Denne standen finnes ikke!");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);

			}
			
		} else {
			request.setAttribute("errorMessage", "Du har ikke stemt på en stand!");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
	}

}
