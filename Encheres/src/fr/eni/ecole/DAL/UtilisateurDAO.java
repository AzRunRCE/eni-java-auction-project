package fr.eni.ecole.DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.DAL.*;
import fr.eni.ecole.beans.Utilisateur;

public class UtilisateurDAO implements IDAOUtilisateur {
	protected Connection connect = null;
	private final String FIND_SQL = "SELECT * FROM UTILISATEURS WHERE noUtilisateur = ?";    
	public UtilisateurDAO (Connection conn) {
		
		this.connect = conn;
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

	public boolean update(Utilisateur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur find(int id) {
		Utilisateur utilisateur = new Utilisateur();        
	    try {
	    	//noUtilisateur
	    	PreparedStatement preparedStatement = connect.prepareStatement(FIND_SQL); 
	    	preparedStatement.setInt(1,id); 
	    	preparedStatement.execute();
	    	ResultSet result = preparedStatement.executeQuery();
	    	if(result.next() == true) {
	    	  utilisateur = new Utilisateur();      
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return utilisateur;
	  }
	
	@Override
	public Utilisateur findByLogin(String email_or_username, String Password) {
		Utilisateur utilisateur = new Utilisateur();        
	    try {
	    	PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM UTILISATEURS WHERE (pseudo = ? or email = ?) and mot_de_passe = ?"); 
	    	//on assigne un décimal au premier paramètre 
	    	preparedStatement.setString(1,email_or_username); 
	    	preparedStatement.setString(2,email_or_username); 
	    	preparedStatement.setString(3,Password); 
	    	preparedStatement.execute();
	    	ResultSet result = preparedStatement.executeQuery();
	    	if (result.next() == true) {
	    	  utilisateur = new Utilisateur();
	    	  utilisateur.setPseudo(result.getString("pseudo"));
	    	  utilisateur.setCodePostal(result.getString("code_postal"));
	    	  Boolean admin =Boolean.parseBoolean(result.getString("administrateur"));
	    	  utilisateur.setAdministrateur(admin);
	    	  utilisateur.setCredit(result.getInt("credit"));
	    	  utilisateur.setVille(result.getString("ville"));
	    	  utilisateur.setRue(result.getString("rue"));
	    	  utilisateur.setTelephone(result.getString("telephone"));
	    	  utilisateur.setEmail(result.getString("email"));
	    	  utilisateur.setNom(result.getString("nom"));
	    	  utilisateur.setPrenom(result.getString("Prenom"));
	    	  utilisateur.setNoUtilisateur(result.getInt("no_utilisateur"));
	    	  //utilisateur.setMotDePasse(result.getString("mot_de_passe"));
	    	  
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return utilisateur;
	}

}
