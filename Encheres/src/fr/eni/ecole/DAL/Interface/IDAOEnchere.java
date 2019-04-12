package fr.eni.ecole.DAL.Interface;

import java.util.List;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;

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
	   * Ajoute une nouvelle enchère en base
	   * @param noUtilisateur
	   * @param noArticle
	   * @param date
	   * @param montant
	   * @return le nombre de ligne inseréé dans la table ENCHERES
	   */
	  public int nouvelleEnchere(int noUtilisateur, int noArticle, int montant) throws DALException;
	  
	  
	  
	  /**
	   * Supprime une enchere 
	   * @param noUtilisateur
	   * @param noArticle
	   * @return le nombre de ligne supprimée
	   */
	  public int deleteEnchere(int noUtilisateur, int noArticle) throws DALException;
}
