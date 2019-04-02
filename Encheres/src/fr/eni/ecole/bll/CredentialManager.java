package fr.eni.ecole.bll;
import fr.eni.ecole.DAL.*;
import fr.eni.ecole.beans.Utilisateur;

public class CredentialManager {

	IDAOUtilisateur daoUtilisateurs = DAOFactory.getUtilisateurDAO();
	
	public Boolean Register(Utilisateur utilisateur) throws DALException {
	
		
  		return null;
	}
	
	
	
	public Utilisateur connexion (String email_login, String mdp) throws DALException {
		Utilisateur utilisateur = daoUtilisateurs.findByLogin(email_login);
		if (utilisateur.getMotDePasse().equals(mdp)) {
			return utilisateur;
		}else {
			return null;
		}
	}
}
