package fr.eni.ecole.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Categorie;
import fr.eni.ecole.beans.Retrait;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.bll.BLLException;
import fr.eni.ecole.bll.CategoriesManager;
import fr.eni.ecole.bll.UtilisateursManager;
import fr.eni.ecole.bll.VentesManager;
import fr.eni.ecole.util.Constantes;
import fr.eni.ecole.util.Utils;

/**
 * Servlet implementation class Sell
 */
@WebServlet("/Sell")
public class Sell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sell() {
        super();
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
		CategoriesManager categoriesManager = new CategoriesManager();
		
	
		try {
			request.setAttribute("listeCategories", categoriesManager.getListeCategories());
			Utilisateur user = usersManager.getUtilisateur(no_utilisateur);
		
			request.setAttribute(Constantes.ATT_UTILISATEUR, user);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(Constantes.PAGE_SELL).forward(request, response);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Boolean isLogged = request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR) != null;
		if (!isLogged) {
			
			request.getRequestDispatcher(Constantes.PAGE_INDEX).forward(request, response);
			return;
		}
		Integer no_utilisateur = (Integer)request.getSession().getAttribute(Constantes.SESS_NUM_UTILISATEUR);
	
		VentesManager ventesManagers = new VentesManager() ;
		CategoriesManager categoriesManager = new CategoriesManager();
		
		ArticleVendu new_ArticleVendu = new ArticleVendu();
		Utilisateur user = new Utilisateur();
		user.setNoUtilisateur(no_utilisateur);
		
		Retrait retrait = new Retrait(0,request.getParameter("inputRue"),request.getParameter("inputCodePostal"),
				request.getParameter("inputVille"));
		
		new_ArticleVendu.setNomArticle(request.getParameter("inputNomArticle"));
		new_ArticleVendu.setDescription(request.getParameter("inputDescription"));
		Categorie categorie;
		try {
			categorie = categoriesManager.getCategorie(Integer.parseInt(request.getParameter("inputCategorie")));
			new_ArticleVendu.setCategorie(categorie);
			new_ArticleVendu.setMiseAPrix(Float.parseFloat(request.getParameter("inputPrix")));
			new_ArticleVendu.setPrixVente(Float.parseFloat(request.getParameter("inputPrix")));
			String str = request.getParameter("DateDebutEncheres");
			new_ArticleVendu.setDateDebutEncheres(Utils.parseDateTime(request.getParameter("DateDebutEncheres")));
			new_ArticleVendu.setDateFinEncheres(Utils.parseDateTime(request.getParameter("DateFinEncheres")));
			
			
			new_ArticleVendu.setUtilisateur(user);
			new_ArticleVendu.setEtatVente(false);
			new_ArticleVendu.setRetrait(retrait);
			
			ventesManagers.create(new_ArticleVendu);
			System.out.println("Description article : "+new_ArticleVendu.getDescription());
			response.sendRedirect(Constantes.URL_ACCUEIL);
			} catch (NumberFormatException | BLLException e) {
				e.printStackTrace();
		}
	}

}
