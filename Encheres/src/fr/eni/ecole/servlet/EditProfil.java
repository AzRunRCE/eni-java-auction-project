package fr.eni.ecole.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.bll.BLLException;
import fr.eni.ecole.bll.UtilisateursManager;
import fr.eni.ecole.util.Constantes;

/**
 * Servlet implementation class EditProfil
 */
@WebServlet("/EditProfil")
public class EditProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Boolean isLogged = request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR) != null;
		if (!isLogged) {
			request.getRequestDispatcher(Constantes.PAGE_INDEX).forward(request, response);
			return;
		}
		Integer no_utilisateur = (Integer)request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR);
		
		UtilisateursManager usersManager = new UtilisateursManager();
		Utilisateur user;
		try {
			user = usersManager.getUtilisateur(no_utilisateur);
			request.setAttribute(Constantes.ATT_UTILISATEUR, user);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(Constantes.PAGE_EDIT_PROFIL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Boolean isLogged = request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR) != null;
		if (!isLogged) {
			response.sendRedirect(Constantes.PAGE_INDEX);
			return;
		}
		
	
		
		Integer no_utilisateur = (Integer)request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR);
		UtilisateursManager usersManager = new UtilisateursManager();
		Utilisateur user_update;
		try {
			user_update = usersManager.getUtilisateur(no_utilisateur);
			if (request.getParameter("inputDeleteAccount") != null) {
				response.sendRedirect(Constantes.URL_LOGOUT);
				usersManager.deleteUtilisateur(user_update);
				return;
			}
			String str = request.getParameter("inputPassword");
			if (request.getParameter("inputPassword").equals(user_update.getMotDePasse())) {
				if (request.getParameter("inputConfirmationPassword").equals(request.getParameter("inputNewPassword"))) {
					user_update.setMotDePasse(request.getParameter("inputNewPassword"));
				}
			}
			
			user_update.setEmail(request.getParameter("inputEmail"));
			user_update.setPseudo(request.getParameter("inputPseudo"));
			user_update.setRue(request.getParameter("inputRue"));
			user_update.setVille(request.getParameter("inputVille"));
			user_update.setCodePostal(request.getParameter("inputCodePostal"));
			user_update.setNom(request.getParameter("inputNom"));
			user_update.setPrenom(request.getParameter("inputPrenom"));
			user_update.setTelephone(request.getParameter("inputTelephone"));
		
			
			if (usersManager.updateUtilisateur(user_update)){
				request.setAttribute("editable", true);
				request.setAttribute("message", "Votre profil a été mis a jour");
				request.setAttribute(Constantes.ATT_UTILISATEUR, user_update);
				request.getRequestDispatcher(Constantes.PAGE_PROFIL).forward(request, response);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
	
		
		
	}

}
