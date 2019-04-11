package fr.eni.ecole.bll;

import fr.eni.ecole.DAL.AbstractDAOFactory;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Utilisateur;

public class UtilisateursManager {
	IDAOUtilisateur daoUtilisateurs = null;
	public UtilisateursManager() {
			daoUtilisateurs = AbstractDAOFactory.getFactory().getUtilisateurDAO();
	}
	
	/**
	 * 
	 * @param no_utilisateur
	 * @return
	 * @throws BLLException
	 */
	public Utilisateur getUtilisateur(int no_utilisateur) throws BLLException  {
		try {
		return daoUtilisateurs.find(no_utilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode getUtilisateur", e);
			
		}
	}
	
	/**
	 * 
	 * @param Utilisateur
	 * @return
	 * @throws BLLException
	 */
	public Boolean updateUtilisateur(Utilisateur Utilisateur) throws BLLException  {
		try {
		return daoUtilisateurs.update(Utilisateur);
		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode updateUtilisateur", e);
	}
	}

	/**
	 * 
	 * @param usersManager
	 * @return
	 * @throws BLLException
	 */
	public int deleteUtilisateur(Utilisateur usersManager) throws BLLException {
		try {
		return daoUtilisateurs.delete(usersManager);
		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode deleteUtilisateur", e);
		}
		
	}
		
	/**
	 * 
	 * @param new_user
	 * @return
	 * @throws BLLException
	 */
	public int register(Utilisateur new_user) throws BLLException {
		//Set user rigth
		new_user.setAdministrateur(0);
		new_user.setCredit(0);
		int result = -1;
		
		Utilisateur emailAlreadyUsed;
		try {
			emailAlreadyUsed = daoUtilisateurs.findByLogin(new_user.getEmail());
			Utilisateur pseudoAlreadyUsed =  daoUtilisateurs.findByLogin(new_user.getPseudo());
			if (emailAlreadyUsed == null && pseudoAlreadyUsed == null) {
				result = daoUtilisateurs.create(new_user);
			}
		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode register", e);
		}
		return result;
	}
	
	/**
	 * 
	 * @param email_login
	 * @param mdp
	 * @return
	 * @throws BLLException
	 */
	public Utilisateur connexion (String email_login, String mdp) throws BLLException {
		Utilisateur utilisateur = null;
		try {
			utilisateur = daoUtilisateurs.findByLogin(email_login);
			if(utilisateur == null || !utilisateur.getMotDePasse().equals(mdp) ) {
				utilisateur = null;
			}

		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode connexion", e);
		}		
		return utilisateur;
	}
	
	
	/**
	 * Met à jour le credit d'un autilisateur
	 * @param noUtilisateur
	 * @param credit
	 * @return le nombre de ligne affectee
	 */
	public int updateCredit(int noUtilisateur, int credit) throws BLLException {
		try {
			return daoUtilisateurs.updateCredit(noUtilisateur, credit);
		} catch (DALException e) {
			throw new BLLException("Problème avec la méthode updateCredit", e);
		}
	}
}
