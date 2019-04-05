package fr.eni.ecole.DAL.Interface;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.beans.Utilisateur;

public interface IDAOUtilisateur  extends DAO<Utilisateur>{
	
	  /**
	   * M�thode de recherche des informations
	   * @param id
	   * @return T
	 * @throws DALException 
	   */
	  public Utilisateur findByLogin(String email_or_username);
}
