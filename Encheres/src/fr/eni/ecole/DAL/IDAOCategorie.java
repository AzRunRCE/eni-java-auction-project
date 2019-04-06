package fr.eni.ecole.DAL;

import java.util.List;

import fr.eni.ecole.beans.Categorie;

/**
 * 
 * @author romai
 *
 */
public interface IDAOCategorie extends DAO<Categorie>{
	 
	  /**
	   * 
	   * @return all categories
	   */
	  public List<Categorie> selectAll();
}
