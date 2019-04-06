package fr.eni.ecole.DAL;

import java.util.List;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.getAccueil;
import fr.eni.ecole.rest.mo.getDetailEnchere;

public interface IDAOEnchere extends DAO<Enchere> {
	
	  /**
	   * M�thode de recherche des informations
	   * @return T
	 * @throws DALException 
	   */
	  public List<getAccueil> selectAllWithoutParameters();
	  
	  /**
	   * M�thode de recherche des informations
	   * @param list[params]
	   * @return T 
	 * @throws DALException 
	   */
	  public List<getAccueil> selectAllwithParameters(AccueilFilters accueilFilters, Integer idUtilisateur);
	  
	  /**
	   * Methode de recherche d'une enchère pour un article
	   * @param noArticle
	   * @return un objet de type getDetailEnchere
	   */
	  public getDetailEnchere selectById(int noArticle);
}