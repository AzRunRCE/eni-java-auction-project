package fr.eni.ecole.DAL.Interface;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.beans.Utilisateur;

public interface IDAOUtilisateur  extends DAO<Utilisateur>{
	
	  /**
	   * Méthode de recherche des informations
	   * @param email_or_username
	   * @return T
	 * @throws DALException 
	   */
	  public Utilisateur findByLogin(String email_or_username) throws DALException;
	  
	  /**
	   * Methode qui met à jour le credit d'un utilisateur en base
	   * @param noUtilisateur
	   * @return le nombre de ligne affectee
	   */
	  public int updateCredit(int noUtilisateur, int credit) throws DALException;
}
