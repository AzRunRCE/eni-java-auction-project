package fr.eni.ecole.bll;

import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Retrait;

public class VentesManager {
	IDAOArticleVendu daoArticleVendus = DAOFactory.getArticleVenduDAO();
	
	DAO<Retrait> daoRetraitDao = DAOFactory.getRetraitDAO();
	public void create(ArticleVendu new_article) {
		int insertId = daoArticleVendus.create(new_article);
		new_article.getRetrait().setNo_article(insertId);
		daoRetraitDao.create(new_article.getRetrait());
	}
	
	public int updatePrixVenteArticle(int noArticle, int montant) {
		return daoArticleVendus.updatePrixVenteArticle(noArticle, montant);
	}
}
