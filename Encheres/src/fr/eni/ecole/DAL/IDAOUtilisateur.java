package fr.eni.ecole.DAL;

import fr.eni.ecole.beans.Utilisateur;

public interface IDAOUtilisateur  extends DAO<Utilisateur>{
	
	  /**
	   * M�thode de recherche des informations
	   * @param email_or_username
	   * @return T
	   */
	  public Utilisateur findByLogin(String email_or_username);
}
