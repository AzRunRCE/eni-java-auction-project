package fr.eni.ecole.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.UtilisateurDAO;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.bll.CredentialManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recupLogin = null;
		String recupPassword = null;
		Boolean valide = true;
		Utilisateur utilisateur = null;
		
		if(request.getParameter("login").trim().isEmpty())
			valide = false;
		
		if(request.getParameter("password").trim().isEmpty())
			valide = false;
		
		if (!valide) {
			request.setAttribute("erreur", "L'email et le mot de passe doivent être saisis");
			request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
			
		}
		
		recupLogin = request.getParameter("login").trim();
		recupPassword = request.getParameter("password".trim());
		
		CredentialManager credUse = new CredentialManager();		
		try {
			utilisateur = credUse.connexion(recupLogin, recupPassword);
			
		} catch (DALException e) {
			e.printStackTrace();
		}
		if (utilisateur != null) {
			
		}
	}

}
