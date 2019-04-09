package fr.eni.ecole.bll;


import fr.eni.ecole.DAL.AbstractDAOFactory;

import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Utilisateur;

public class UtilisateursManager {
	IDAOUtilisateur daoUtilisateurs = null;
	public UtilisateursManager() {
			daoUtilisateurs = AbstractDAOFactory.getFactory().getUtilisateurDAO();
	}
	
	public Utilisateur getUtilisateur(int no_utilisateur)  {
		return daoUtilisateurs.find(no_utilisateur);
	}
	
	public Boolean updateUtilisateur(Utilisateur Utilisateur)  {
		return daoUtilisateurs.update(Utilisateur);
	}

	public Boolean deleteUtilisateur(Utilisateur usersManager) {
		return daoUtilisateurs.delete(usersManager);
		
	}
}
