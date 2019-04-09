package fr.eni.ecole.DAL.Interface;

import java.util.List;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.getDetailEnchere;

public interface IDAOEnchere extends DAO<Enchere> {
	
	  /**
	   * Methode permettant d'aller chercher tous les enregistrements
	   * @return une liste de getAccueil
	 * @throws DALException 
	   */ 
	  public List<AccueilDashboardTile> selectAllWithoutParameters() throws DALException;
	  

	  /**
	   * Methode permettant d'aller chercher en base les enregistrements respectant les filtres
	   * @param accueilFilters Structure de donnes contenant les filtres saisis
	   * @param idUtilisateur
	   * @return une liste de AccueilDashboardTile
	 * @throws DALException 
	   */
	  public List<AccueilDashboardTile> selectAllwithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) throws DALException;
	  
	  /**
	   * Methode de recherche d'une enchère pour un article
	   * @param noArticle
	   * @return un objet de type getDetailEnchere
	   */
	  public getDetailEnchere selectById(int noArticle);
}
