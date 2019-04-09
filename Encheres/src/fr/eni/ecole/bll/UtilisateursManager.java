package fr.eni.ecole.bll;


import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Utilisateur;

public class UtilisateursManager {
	IDAOUtilisateur daoUtilisateurs = DAOFactory.getUtilisateurDAO();
	
	public Utilisateur getUtilisateur(int no_utilisateur)  {
		return daoUtilisateurs.find(no_utilisateur);
	}
	
	public Boolean updateUtilisateur(Utilisateur Utilisateur)  {
		return daoUtilisateurs.update(Utilisateur);
	}

	public int deleteUtilisateur(Utilisateur usersManager) {
		return daoUtilisateurs.delete(usersManager);
		
	}
	
	public int register(Utilisateur new_user) throws DALException {
	
		
		//Set user rigth
		new_user.setAdministrateur(0);
		new_user.setCredit(0);

		Utilisateur emailAlreadyUsed =  daoUtilisateurs.findByLogin(new_user.getEmail());
		Utilisateur pseudoAlreadyUsed =  daoUtilisateurs.findByLogin(new_user.getPseudo());
		if (emailAlreadyUsed == null && pseudoAlreadyUsed == null) {
			return daoUtilisateurs.create(new_user);
		}
		else {
			return -1;
		}
	}
	
	public Utilisateur connexion (String email_login, String mdp) {
		Utilisateur utilisateur = daoUtilisateurs.findByLogin(email_login);
		if(utilisateur != null) {
			if (utilisateur.getMotDePasse().equals(mdp)) {
				return utilisateur;
			}else {
				return null;
			}
		}else {
			return null;
		}		
	}
	
	
	/**
	 * Met à jour le credit d'un autilisateur
	 * @param noUtilisateur
	 * @param credit
	 * @return le nombre de ligne affectee
	 */
	public int updateCredit(int noUtilisateur, int credit) {
		return daoUtilisateurs.updateCredit(noUtilisateur, credit);
	}
}
