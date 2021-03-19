package servlett;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProsjektDAO;
import DAO.StemmeDAO;
import entiteter.Prosjekt;

/**
 * Servlet implementation class SletteServlet
 */



@WebServlet("/SletteServlet")
public class SletteServlet extends HttpServlet {
	@EJB
	StemmeDAO stemmeDAO;
	@EJB
	ProsjektDAO prosjektDAO;
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
			Prosjekt stand = prosjektDAO.hentProsjekt(Integer.parseInt(standId));
			
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
		
		//Expo expo = (Expo) request.getServletContext().getAttribute("expo");
		String standId = request.getParameter("standId");
		
		
		if(standId != null) {
			
			Prosjekt stand = prosjektDAO.hentProsjekt(Integer.parseInt(standId));
			
			if(stand != null) {
				//String redirect = StemmeHjelp.slettVote(standId, request, stand, stemmeDAO);
				response.sendRedirect("SletteServlet");
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
