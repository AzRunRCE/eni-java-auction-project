package fr.eni.ecole.bll;
import fr.eni.ecole.DAL.*;
import fr.eni.ecole.beans.Utilisateur;

public class CredentialManager {

public Boolean Register(Utilisateur utilisateur) throws DALException {
	
  DAO<Utilisateur> daoUtilisateurs  = DAOFactory.getUtilisateurDAO();
  
  
  return null;
}
}
