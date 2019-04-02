package fr.eni.ecole.DAL;

import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.AccesBase;

public class DAOFactory {
	public static DAO<Utilisateur> getUtilisateurDAO() throws DALException{
		return new UtilisateurDAO(AccesBase.getConnection());
	}
}
