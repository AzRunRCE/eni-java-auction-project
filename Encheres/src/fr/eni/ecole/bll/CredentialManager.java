package fr.eni.ecole.bll;
import fr.eni.ecole.DAL.*;
import fr.eni.ecole.beans.Utilisateur;

public class CredentialManager {

	IDAOUtilisateur daoUtilisateurs = DAOFactory.getUtilisateurDAO();
	
	public Boolean register(Utilisateur new_user) throws DALException {
	
		
		try {
		
			
			//Set user rigth
			new_user.setAdministrateur(0);
			new_user.setCredit(0);
		
			Utilisateur emailAlreadyUsed =  daoUtilisateurs.findByLogin(new_user.getEmail());
			Utilisateur pseudoAlreadyUsed =  daoUtilisateurs.findByLogin(new_user.getPseudo());
			if (emailAlreadyUsed == null && pseudoAlreadyUsed == null) {
				daoUtilisateurs.create(new_user);
				return true;
			}
			else {
				return false;
			}
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Utilisateur connexion (String email_login, String mdp) throws DALException {
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
