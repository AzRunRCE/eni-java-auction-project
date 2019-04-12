package fr.eni.ecole.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import fr.eni.ecole.DAL.AbstractDAOFactory;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Retrait;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.Utils;
public class DaoTests {
	
	
	private static DataSource dataSource;
	@BeforeClass
	public static void Create_Connection() throws DALException {
		dataSource = getMockDataSource();
	}
	
	public static DataSource getMockDataSource() {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setURL("jdbc:sqlserver://10.27.137.24:1433;databasename=DB_ENCHERES_UnitTests");
		ds.setUser("sa");
		ds.setPassword("Pa$$w0rd");	
		return  (DataSource)ds;
	}
	
	@Before
	public void Create_Database() throws DALException {
	
		try {
			Connection conn = dataSource.getConnection();
		    Statement stmt = conn.createStatement();
		    String script_Path = System.getProperty("user.dir") + "\\..\\Enonc�\\projetEncheres.org\\04-ModelePhysique\\create_bd_trocencheres.sql";
		    System.out.println("Execute Script: " + script_Path);
		    Utils.executeDBScripts(script_Path, stmt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	@org.junit.Test
	public void DAOUtilisateur_findByLogin_Test() throws DALException, SQLException {
		IDAOUtilisateur daoUsers = AbstractDAOFactory.getFactory(dataSource).getUtilisateurDAO();
		Utilisateur p = daoUsers.findByLogin("fcatin");
		assertNotNull(p);
	}
	//f.catin@gmail.com
	
	@org.junit.Test
	public void DAOUtilisateur_Remove_Cascade_Test() throws DALException, SQLException {
		IDAOUtilisateur daoUsers = AbstractDAOFactory.getFactory(dataSource).getUtilisateurDAO();
		IDAOArticleVendu daoArticleVendu = AbstractDAOFactory.getFactory(dataSource).getArticleVenduDAO();
		DAO<Retrait> daoRetrait = AbstractDAOFactory.getFactory(dataSource).getRetraitDAO();
		
		int id = 1;
		ArticleVendu article = daoArticleVendu.find(id);
		daoUsers.delete(article.getVendeur());
		ArticleVendu resultArticle = daoArticleVendu.find(id);
		Utilisateur resultUser = daoUsers.find(article.getVendeur().getNoUtilisateur());
		Retrait resultRetrait = daoRetrait.find(article.getRetrait().getNo_article());
		
		assertNull(resultArticle);
		assertNull(resultUser);
		assertNull(resultRetrait);
		
		
	}
	
}
