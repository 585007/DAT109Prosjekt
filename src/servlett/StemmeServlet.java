//package servlett;
//
//import java.io.IOException;
//
//import javax.ejb.EJB;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import DAO.standDAO;
//import DAO.StemmeDAO;
//import entiteter.Expo;
//import entiteter.Stand;
//import hjelpeKlasser.StemmeHjelp;
//
//@WebServlet("/StemmeServlet")
//public class StemmeServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	@EJB
//	StemmeDAO stemmeDAO;
//	@EJB
//	StandDAO standDAO;
//	@EJB
//	TilskuerDAO tilskuerDAO;
//	Expo expo;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String standId = request.getParameter("stemmeGitt");
//		if(standId != null) {
//			Stand stand = standDAO.findStand(standId);
//			
//			request.setAttribute("stand", stand);
//			request.getRequestDispatcher("WEB-INF/FerdigStemt.jsp").forward(request, response);
//		} else {
//			response.sendRedirect("login");
//		}
//		
//		
//	}
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Expo expo = (Expo) request.getServletContext().getAttribute("expo");
//		String standId = request.getParameter("standId");
//		
//		
//		if(standId != null) {
//			
//			Stand stand = standDAO.findStand(standId);
//			if(stand != null) {
//				String redirect = StemmeHjelp.handleVote(standId, request, stand,stemmeDAO, expo);
//				response.sendRedirect(redirect);
//			} else {
//				
//				request.setAttribute("errorMessage", "Denne standen finnes ikke!");
//				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
//
//			}
//			
//		} else {
//			request.setAttribute("errorMessage", "Ugyldig stand-id!");
//			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
//		}
//		
//		
//		
//	}
//	
//
//}