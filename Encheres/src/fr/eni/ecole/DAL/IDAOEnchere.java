package fr.eni.ecole.DAL;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.DetailEnchere;

public interface IDAOEnchere extends DAO<Enchere> {
	
	  /**
	   * Methode permettant d'aller chercher tous les enregistrements
	   * @return une liste de getAccueil
	   */ 
	  public List<AccueilDashboardTile> selectAllWithoutParameters();
	  

	  /**
	   * Methode permettant d'aller chercher en base les enregistrements respectant les filtres
	   * @param accueilFilters Structure de donn�es contenant les filtres saisis
	   * @param idUtilisateur
	   * @return une liste de AccueilDashboardTile
	   */
	  public List<AccueilDashboardTile> selectAllwithParameters(AccueilFilters accueilFilters, Integer idUtilisateur);
	  
	  /**
	   * Methode de recherche d'une enchère pour un article
	   * @param noArticle
	   * @return un objet de type DetailEnchere
	   */
	  public DetailEnchere selectById(int noArticle);
	  
	  /**
	   * Ajoute une nouvelle enchère en base
	   * @param noUtilisateur
	   * @param noArticle
	   * @param date
	   * @param montant
	   * @return le nombre de ligne inseréé dans la table ENCHERES
	   */
	  public int nouvelleEnchere(int noUtilisateur, int noArticle, int montant);
}