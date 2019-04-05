package fr.eni.ecole.servlet;
import fr.eni.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import fr.eni.ecole.util.Utils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Categorie;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.bll.CategoriesManager;
import fr.eni.ecole.bll.VentesManager;
import fr.eni.ecole.util.Constantes;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(Constantes.PAGE_SELL).forward(request, response);
		VentesManager ventesManagers;
		CategoriesManager categoriesManager;
		ArticleVendu new_ArticleVendu = new ArticleVendu();
		
		new_ArticleVendu.setNomArticle(request.getParameter("inputNomArticle"));
		new_ArticleVendu.setDescription(request.getParameter("inputDescription"));
		Categorie categorie = categoriesManager.getCategorie(Integer.parseInt(request.getParameter("inputDescription")));
		new_ArticleVendu.setCategorie(categorie);
		new_ArticleVendu.setMiseAPrix(Float.parseFloat(request.getParameter("inputDescription")));
	    LocalDateTime DateDebutEncheres =
	            LocalDateTime.ofInstant(Instant.ofEpochMilli(Utils.getTimestamp(request.getParameter("DateDebutEncheres")).getTime()), TimeZone
	                    .getDefault().toZoneId());  
	    LocalDateTime DateFinEncheres =
	            LocalDateTime.ofInstant(Instant.ofEpochMilli(Utils.getTimestamp(request.getParameter("DateFinEncheres")).getTime()), TimeZone
	                    .getDefault().toZoneId());  
		new_ArticleVendu.setDateDebutEncheres(Utils.getTimestamp(request.getParameter("inputDescription")));
		new_ArticleVendu.setDateDebutEncheres(Utils.getTimestamp(request.getParameter("inputDescription")));
	    LocalDateTime DateDebutEncheres =
	            LocalDateTime.ofInstant(Instant.ofEpochMilli(Utils.getTimestamp(request.getParameter("DateDebutEncheres")).getTime()), TimeZone
	                    .getDefault().toZoneId());  
	    LocalDateTime DateFinEncheres =
	            LocalDateTime.ofInstant(Instant.ofEpochMilli(Utils.getTimestamp(request.getParameter("DateFinEncheres")).getTime()), TimeZone
	                    .getDefault().toZoneId());  
		
		ventesManagers.create();
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
