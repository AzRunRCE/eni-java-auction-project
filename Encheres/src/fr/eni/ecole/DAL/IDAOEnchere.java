package fr.eni.ecole.DAL;

import java.util.List;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.rest.mo.getAccueil;

public interface IDAOEnchere extends DAO<Enchere>{
	
	  /**
	   * Méthode de recherche des informations
	   * @return T
	 * @throws DALException 
	   */
	  public List<getAccueil> selectAllWithoutParameters();
	  
	  /**
	   * Méthode de recherche des informations
	   * @param list[params]
	   * @return T 
	 * @throws DALException 
	   */
	  public List<getAccueil> selectAllwithParameters(String[] listeParams);
}