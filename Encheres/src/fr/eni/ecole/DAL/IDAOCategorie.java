package fr.eni.ecole.DAL;

import java.util.List;

import fr.eni.ecole.beans.Categorie;

public interface IDAOCategorie extends DAO<Categorie>{
	 
	/**
	   * Méthode de recherche des informations
	   * @return T
	 * @throws DALException 
	   */
	  public List<Categorie> selectAll();
}
