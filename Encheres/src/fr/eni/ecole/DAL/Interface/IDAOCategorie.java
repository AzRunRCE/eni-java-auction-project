package fr.eni.ecole.DAL.Interface;

import java.util.List;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.beans.Categorie;

public interface IDAOCategorie extends DAO<Categorie>{
	 
	/**
	   * Méthode de recherche des informations
	   * @return T
	 * @throws DALException 
	   */
	  public List<Categorie> selectAll() throws DALException;
}
