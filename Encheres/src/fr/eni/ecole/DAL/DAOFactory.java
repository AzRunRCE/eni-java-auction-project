package fr.eni.ecole.DAL;

import fr.eni.ecole.util.AccesBase;

public class DAOFactory {
	public static IDAOUtilisateur getUtilisateurDAO() throws DALException{
		return new UtilisateurDAO(AccesBase.getConnection());
	}
}
