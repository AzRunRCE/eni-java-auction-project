package fr.eni.ecole.DAL;

import fr.eni.ecole.DAL.Impl.ArticleVenduDAO;
import fr.eni.ecole.DAL.Impl.CategorieDAO;
import fr.eni.ecole.DAL.Impl.EnchereDAO;
import fr.eni.ecole.DAL.Impl.UtilisateurDAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.DAL.Interface.IDAOCategorie;
import fr.eni.ecole.DAL.Interface.IDAOEnchere;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;

public class DAOFactory {
	
	public static IDAOUtilisateur getUtilisateurDAO() {
		return new UtilisateurDAO();
	}
	public static IDAOEnchere getEnchereDAO() {
		return new EnchereDAO();
	}
	public static IDAOCategorie getCategorieDAO() {
		return new CategorieDAO();
	}
	public static IDAOArticleVendu getArticleVenduDAO() {
		return new ArticleVenduDAO();
	}
}
