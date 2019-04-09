package fr.eni.ecole.DAL.Interface;

import java.util.List;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Categorie;

public interface IDAOArticleVendu extends DAO<ArticleVendu>{
	
	/**
	 * met à jour le prix de vente de l'article
	 * @param noArticle
	 * @param montant
	 * @return le nombre de ligne affectee
	 */
	public int updatePrixVenteArticle(int noArticle, int montant);
	 
}
