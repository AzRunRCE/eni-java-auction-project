package fr.eni.ecole.DAL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.DAL.*;
import fr.eni.ecole.beans.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {

	public UtilisateurDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur find(int id) {
		Utilisateur utilisateur = new Utilisateur();        
	    try {
	    	ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Utilisateur WHERE noUtilisateur = " + id);
	      if(result.first()) {
	    	  utilisateur = new Utilisateur();      
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return utilisateur;
	  }

}
