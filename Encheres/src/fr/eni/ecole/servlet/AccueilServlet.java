package fr.eni.ecole.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.bll.BLLException;
import fr.eni.ecole.bll.CategoriesManager;
import fr.eni.ecole.util.Constantes;




/**
 * 
 * @author romai
 *
 */
@WebServlet( urlPatterns = {"/Accueil"} )
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriesManager categoriesManager = new CategoriesManager();
		
				try {
//					throw new BLLException("Hey this is an error 500");
					request.setAttribute("listeCategories", categoriesManager.getListeCategories());
					RequestDispatcher dispatcher = request.getRequestDispatcher(Constantes.PAGE_INDEX);
					dispatcher.forward(request, response);
				} catch (BLLException e) {
					response.sendError(404);
				}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
