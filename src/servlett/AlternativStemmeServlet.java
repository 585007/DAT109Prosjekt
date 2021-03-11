package servlett;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hjelpeKlasser.PoengHjelp;

/**
 * Servlet implementation class AlternativStemmeServlet
 */
@WebServlet("/AlternativStemmeServlet")
public class AlternativStemmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    PoengHjelp hjelp = new PoengHjelp();
	
	
    public AlternativStemmeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("WEB-INF/AlternativStemmeKvittering.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ratingVerdi = request.getParameter("rating");
		String mobilNr = request.getParameter("tlf");
		
		// her skal prosessering av stemmen skje
		
		response.sendRedirect("AlternativStemmeServlet");
	}

}
