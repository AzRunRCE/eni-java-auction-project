package fr.eni.ecole.bll;
import fr.eni.ecole.DAL.*;
import fr.eni.ecole.beans.Utilisateur;

public class CredentialManager {

	IDAOUtilisateur daoUtilisateurs = DAOFactory.getUtilisateurDAO();
	
	public Boolean register(String email, String pseudo, String motDePasse) throws DALException {
	
		
		try {
		
			Utilisateur new_user = new Utilisateur();
			//Set user rigth
			new_user.setAdministrateur(0);
			new_user.setEmail(email);
			new_user.setMotDePasse(motDePasse);
			new_user.setPseudo(pseudo);
			Utilisateur emailAlreadyUsed =  daoUtilisateurs.findByLogin(email);
			Utilisateur pseudoAlreadyUsed =  daoUtilisateurs.findByLogin(pseudo);
			if (true) {
				
			}
			if (emailAlreadyUsed == null && pseudoAlreadyUsed == null) {
				daoUtilisateurs.create(new_user);
			}
			return true;
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
