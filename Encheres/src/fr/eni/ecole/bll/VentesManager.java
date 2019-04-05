package fr.eni.ecole.bll;

import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.beans.ArticleVendu;

public class VentesManager {
	IDAOArticleVendu daoArticleVendus = DAOFactory.getArticleVenduDAO();

	public void create(ArticleVendu new_article) {
		daoArticleVendus.create(new_article);
		
	}
}
