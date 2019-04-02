package fr.eni.ecole.DAL;

import java.sql.Connection;

import fr.eni.ecole.util.AccesBase;

public class DAOFactory {
	
	public static IDAOUtilisateur getUtilisateurDAO(){
		Connection cnx = null;
		try {
			 cnx = AccesBase.getConnection();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return new UtilisateurDAO(cnx);
	}
}
