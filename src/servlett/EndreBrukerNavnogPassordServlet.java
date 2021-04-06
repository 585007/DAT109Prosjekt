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
import entiteter.Admin;
import hjelpeKlasser.GyldigInput;
import hjelpeKlasser.GyldigSesjon;
import hjelpeKlasser.PassordHjelp;

/**
 * 
 * @author Svein Ove Surdal
 *
 */
@WebServlet(name = "EndreBrukerNavnogPassordServlet", urlPatterns = "/EndreBrukerNavnogPassord")
public class EndreBrukerNavnogPassordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	AdmDAO adminDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesjon = request.getSession(false);
		if (GyldigSesjon.innlogget(sesjon)) {
			request.getRequestDispatcher("WEB-INF/EndreBrukerNavnogPassord.jsp").forward(request, response);
		} else {
			response.sendRedirect("logginn");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String brukerNavn = request.getParameter("bruker");
		String passord = request.getParameter("passord");
		String nyttPassord = request.getParameter("nyttPassord");
		String bekreftPassord = request.getParameter("bekreftPassord");
		String Message ="";
		Admin admin = adminDAO.getAdmin(brukerNavn);

		if(admin != null){
			if (admin.gyldigPassord(passord)) {
				if (nyttPassord.equals(bekreftPassord)) {
					if (GyldigInput.isValidPassord(nyttPassord)) {

						admin.setPassord(PassordHjelp.hashMedSalt(nyttPassord, admin.getSalt()));
						adminDAO.EndreAdmin(brukerNavn, admin.getPassord());
						response.sendRedirect("admin");
						
					}else {Message = "Nytt passord ikke godkjent";}
				}else {Message = "Passordene er ikke like";}
			}else {Message = "Feil brukernavn/passord";}
		}else {Message = "Feil brukernavn/passord";}
		
		request.setAttribute("EndreBrukerNavnogPassord", Message);
	}
}
