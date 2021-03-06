package fr.eni.ecole.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.util.Constantes;

/**
 * Servlet implementation class Deconnexion
 */
@WebServlet(description = "permet de se déconnecter", urlPatterns = { "/Deconnexion" })
public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deconnexion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		Cookie serverCookies[] = request.getCookies();
        for (Cookie cookie : serverCookies) {
            if(cookie.getName().equals("idUtilisateur")) {
                cookie.setMaxAge(0);//delete
                response.addCookie(cookie);
            }
        }
		response.sendRedirect(Constantes.URL_ACCUEIL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
