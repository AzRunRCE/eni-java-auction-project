package fr.eni.ecole.DAL;

import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.AccesBase;

public class Factory {
	public static DAO<Utilisateur> getUlitidateurDAO() throws DALException{
		return new UtilisateurDAO(AccesBase.getConnection());
	}
}
