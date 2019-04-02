package fr.eni.ecole.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.IDAOUtilisateur;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.AccesBase;

/**
 * Servlet implementation class TestConnexion
 */
@WebServlet("/TestConnexion")
public class TestConnexion extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConnexion() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		Connection cnx = null;
		try {
			cnx = AccesBase.getConnection();
			out.println("Connexion réussie");
			out.flush();
		} catch (DALException e) {
			out.println("Connexion KO " + e.getMessage() + "\n");
			out.println("detail : " + e.getStackTrace()[0].getMethodName() + " - " + e.getLocalizedMessage());
			out.flush();
		}finally {
			out.close();
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		IDAOUtilisateur daoUsers;
		try {
			daoUsers = DAOFactory.getUtilisateurDAO();
			Utilisateur p = daoUsers.findByLogin("ApoZLd","hello");
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
