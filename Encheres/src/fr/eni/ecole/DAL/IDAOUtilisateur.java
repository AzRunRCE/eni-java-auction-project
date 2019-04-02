package fr.eni.ecole.DAL;

import fr.eni.ecole.beans.Utilisateur;

public interface IDAOUtilisateur  extends DAO<Utilisateur>{

	
	
	  /**
	   * Méthode de recherche des informations
	   * @param id
	   * @return T
	   */
	  public Utilisateur findByLogin(String email_or_username, String Password);
}
