package fr.eni.ecole.bll;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Retrait;

public class VentesManager {
	IDAOArticleVendu daoArticleVendus = DAOFactory.getArticleVenduDAO();
	
	DAO<Retrait> daoRetraitDao = DAOFactory.getRetraitDAO();
	public void create(ArticleVendu new_article) throws BLLException {
		int insertId;
		try {
			insertId = daoArticleVendus.create(new_article);
			new_article.getRetrait().setNo_article(insertId);
			daoRetraitDao.create(new_article.getRetrait());
		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode create", e);
		}
		
	}
	
	public int updatePrixVenteArticle(int noArticle, int montant) throws BLLException {
		try {
			return daoArticleVendus.updatePrixVenteArticle(noArticle, montant);
		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode updatePrixVenteArticle", e);
		}
	}
}
