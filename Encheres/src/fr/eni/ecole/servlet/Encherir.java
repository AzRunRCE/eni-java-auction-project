package fr.eni.ecole.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.util.Constantes;

/**
 * Servlet implementation class Encherir
 */
@WebServlet("/Encherir")
public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encherir() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recupNouveauMontant;
		int recupAncienMontnant;
		int recupNoAcheteur;
		int recupNoVendeur;
		int recupNoArticle;
		int recupPrixInital;
		
		recupNouveauMontant = Integer.valueOf(request.getParameter("nouveauMontant"));
		recupPrixInital = Integer.valueOf(request.getParameter("prixInitial"));
		recupAncienMontnant = Integer.valueOf(request.getParameter("ancienMontant"));
		if (recupNouveauMontant < recupPrixInital || recupNouveauMontant < recupAncienMontnant) {
			request.setAttribute("erreur", "Vous devez saisir un montant supérieur au prix initial ou à la meilleur offre");
			request.getRequestDispatcher(Constantes.PAGE_DETAIL_VENTE).forward(request, response);
		}
		
	}

}
