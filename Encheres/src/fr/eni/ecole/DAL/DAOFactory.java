package fr.eni.ecole.DAL;

import java.sql.Connection;

import fr.eni.ecole.util.AccesBase;

public class DAOFactory {
	
	public static IDAOUtilisateur getUtilisateurDAO(){
		
		return new UtilisateurDAO();
	}
}
