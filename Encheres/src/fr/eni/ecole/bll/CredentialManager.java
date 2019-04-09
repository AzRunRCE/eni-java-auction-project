package fr.eni.ecole.bll;
import fr.eni.ecole.DAL.*;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Utilisateur;

public class CredentialManager {

	IDAOUtilisateur daoUtilisateurs = null;
	
	public CredentialManager() {
			daoUtilisateurs = AbstractDAOFactory.getFactory().getUtilisateurDAO();
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
}
