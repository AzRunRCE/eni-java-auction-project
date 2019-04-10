package fr.eni.ecole.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import fr.eni.ecole.DAL.DALException;


public class AccesBase {
	private static DataSource ds = null;
	
	public static Connection getConnection() throws DALException {
		InitialContext jndi = null;
		Connection cnx = null;
		try {
			if (ds != null)
			{
				return ds.getConnection();
			}
		} catch (SQLException e) {
			throw new DALException("impossible d'obtenir une connexion", e);
		}	
		
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
	
	public static DataSource getDataSource() throws DALException {
		InitialContext jndi = null;
		Connection cnx = null;
		if (ds != null)
		{
			return ds;
		}
	
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
		return ds ;
		
	}

	public static DataSource getMockDataSource() {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setURL("jdbc:sqlserver://10.27.137.24:1433;databasename=DB_ENCHERES_UnitTests");
		ds.setUser("sa");
		ds.setPassword("Pa$$w0rd");	
		return  (DataSource)ds;
	}
}
