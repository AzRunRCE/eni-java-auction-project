package fr.eni.ecole.DAL.Interface;

import java.util.List;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.getDetailEnchere;

public interface IDAOEnchere extends DAO<Enchere> {
	
	  /**
	   * Methode permettant d'aller chercher tous les enregistrements
	   * @return une liste de getAccueil
	   */ 
	  public List<AccueilDashboardTile> selectAllWithoutParameters();
	  

	  /**
	   * Methode permettant d'aller chercher en base les enregistrements respectant les filtres
	   * @param accueilFilters Structure de donnes contenant les filtres saisis
	   * @param idUtilisateur
	   * @return une liste de AccueilDashboardTile
	   */
	  public List<AccueilDashboardTile> selectAllwithParameters(AccueilFilters accueilFilters, Integer idUtilisateur);
	  
	  /**
	   * Methode de recherche d'une enchère pour un article
	   * @param noArticle
	   * @return un objet de type getDetailEnchere
	   */
	  public getDetailEnchere selectById(int noArticle);
}
