package fr.eni.ecole.bll;

import fr.eni.ecole.DAL.AbstractDAOFactory;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Retrait;

public class VentesManager {
	IDAOArticleVendu daoArticleVendus = null;
	DAO<Retrait> daoRetraitDao = null;
	
	public VentesManager() {
			daoArticleVendus = AbstractDAOFactory.getFactory().getArticleVenduDAO();
			daoRetraitDao  = AbstractDAOFactory.getFactory().getRetraitDAO();
	}
	
	public void create(ArticleVendu new_article) {
		int insertId = daoArticleVendus.create(new_article);
		new_article.getRetrait().setNo_article(insertId);
		daoRetraitDao.create(new_article.getRetrait());
	}
}
