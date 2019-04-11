package fr.eni.ecole.DAL.Interface;

import java.util.Map;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.DetailEnchere;

public interface IDAOEnchere extends DAO<Enchere> {
	
	  /**
	   * Methode permettant d'aller chercher tous les enregistrements sans filtres
	   * @return une Map(ArticleVendu, Utilisateur)  
	   * @deprecated
	 * @throws DALException 
	   */ 
	  public Map<ArticleVendu, Utilisateur> selectAllWithoutParameters() throws DALException;
	  

	  /**
	   * Methode permettant d'aller chercher en base les enregistrements respectant les filtres
	   * @param accueilFilters Structure de donnes contenant les filtres saisis
	   * @param idUtilisateur
	   * @return une Map(ArticleVendu, Utilisateur) 
	 * @throws DALException 
	   */
	  public Map<ArticleVendu, Utilisateur> selectArticlesWhoRespectFiltersWithSeller(AccueilFilters accueilFilters, Integer idUtilisateur) throws DALException;
	  
	  /**
	   * Methode de recherche d'une ench�re pour un article
	   * @param noArticle
	   * @return un objet de type getDetailEnchere
	   */
	  public DetailEnchere selectById(int noArticle) throws DALException;
	  
	  /**
	   * Ajoute une nouvelle enchère en base
	   * @param noUtilisateur
	   * @param noArticle
	   * @param montant
	   * @return le nombre de ligne inseréé dans la table ENCHERES
	   */
	  public int nouvelleEnchere(int noUtilisateur, int noArticle, int montant) throws DALException;
	  
	  /**
	   * Méthode qui permet de récupérer les informations si il n'y a pas encore eu d'enchere
	   * @param noArticle
	   * @return
	   */
	  public DetailEnchere selectByIdArticle(int noArticle) throws DALException;
	  
	  /**
	   * Supprime une enchere 
	   * @param noUtilisateur
	   * @param noArticle
	   * @return le nombre de ligne supprimée
	   */
	  public int deleteEnchere(int noUtilisateur, int noArticle) throws DALException;
}
