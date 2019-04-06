package fr.eni.ecole.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.ecole.DAL.DALException;


public class AccesBase {
	public static Connection getConnection() throws DALException {
		
		DataSource ds = null;
		InitialContext jndi = null;
		Connection cnx = null;
		
		//Obtenir une reference sur le contecte initiale
		try {
			jndi = new InitialContext();
		} catch (NamingException e) {
			throw new DALException("erreur d'acces au context initial", e);
		}
		
		//rechercher le pool de connexion dans l'annuaire Tomcat
		try {
			ds = (DataSource)jndi.lookup("java:comp/env/jdbc/Encheres");
		} catch (NamingException e) {
			throw new DALException("objet introuvable dans l'annuaire", e);
		}
		
		//obtenir une connexion
		try {
			cnx= ds.getConnection();
			return cnx ;
		} catch (SQLException e) {
			throw new DALException("impossible d'obtenir une connexion", e);
		}	
	}
	
	/**
	 * Methode permettant de fermer le statement et la connexion
	 * @param stmt : le statement
	 * @param cnx : la connexion
	 * @throws DALException : propage le message d'exception
	 */
	public static void closeAll(Statement stmt, Connection cnx) throws DALException {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new DALException("probleme fermeture du statement",e);
			}
		}
		if (cnx != null) {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new DALException("probleme fermeture de la connexion",e);
			}
		}
	}
	
	/**
	 * Methode permettant de fermer le preparedstatement et la connexion
	 * @param pStmt : le preparedstatement
	 * @param cnx : la connexion
	 * @throws DALException : propage le message d'exception
	 */
	public static void closeAll(PreparedStatement pStmt, Connection cnx) throws DALException {
		if (pStmt != null) {
			try {
				pStmt.close();
			} catch (SQLException e) {
				throw new DALException("probleme fermeture du preparedstatement",e);
			}
		}
		if (cnx != null) {
			try {
				cnx.close();
			} catch (SQLException e) {
				throw new DALException("probleme fermeture de la connexion",e);
			}
		}
	}
}
