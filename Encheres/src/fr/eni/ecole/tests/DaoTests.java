package fr.eni.ecole.tests;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Impl.*;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.AccesBase;;

public class DaoTests {
	@Test
	public void AccesDB_test() throws DALException {
		Connection daoUsers = AccesBase.getConnection();
		assertNotNull("Must be null", daoUsers);
	
	}
	
	@Test
	public void DAOFactory_test() throws DALException {
		IDAOUtilisateur daoUsers = DAOFactory.getUtilisateurDAO();
		Utilisateur p = daoUsers.findByLogin("");
		
	}
}
