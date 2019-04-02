package fr.eni.ecole.DAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.DAL.*;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.AccesBase;

public class UtilisateurDAO implements IDAOUtilisateur {
	
	//constantes
	protected Connection connect = null;
	private final String FIND_SQL = "SELECT * FROM UTILISATEURS WHERE noUtilisateur = ?";    
	private final String FIND_BY_LOGIN = "SELECT * FROM UTILISATEURS WHERE pseudo = ? OR email = ?";
	
	public UtilisateurDAO (Connection conn) {
		this.connect = conn;
	}

	@Override
	public boolean create(Utilisateur obj) {
		return false;
	}

	@Override
	public boolean delete(Utilisateur obj) {
		return false;
	}

	public boolean update(Utilisateur obj) {
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
	public Utilisateur findByLogin(String email_or_username) throws DALException {
		Utilisateur utilisateur = null;   
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
	    try {
	    	preparedStatement = connect.prepareStatement(FIND_BY_LOGIN); 
	    	//on assigne un d�cimal au premier param�tre 
	    	preparedStatement.setString(1,email_or_username); 
	    	preparedStatement.setString(2,email_or_username); 
	    	//preparedStatement.setString(3,Password); 
	    	
	    	result = preparedStatement.executeQuery();
	    	if (result.next()) {
	    	  utilisateur = new Utilisateur();
	    	  utilisateur.setNoUtilisateur(result.getInt("no_utilisateur"));
	    	  result.getString("pseudo");
	    	  if (result.wasNull()) {
	    		  utilisateur.setPseudo("inconnu");
	    	  }else {
	    		  utilisateur.setPseudo(result.getString("pseudo"));
	    	  }
	    	  result.getString("nom");
	    	  if (result.wasNull()) {
	    		  utilisateur.setNom("inconnu");
	    	  }else {
	    		  utilisateur.setNom(result.getString("nom"));
	    	  }
	    	  result.getString("prenom");
	    	  if (result.wasNull()) {
	    		  utilisateur.setPrenom("inconnu");
	    	  }else {
	    		  utilisateur.setPrenom(result.getString("prenom"));
	    	  }
	    	  result.getString("email");
	    	  if (result.wasNull()) {
	    		  utilisateur.setEmail("inconnu");
	    	  }else {
	    		  utilisateur.setEmail(result.getString("email"));
	    	  }
	    	  result.getString("telephone");
	    	  if (result.wasNull()) {
	    		  utilisateur.setTelephone("inconnu");
	    	  }else {
	    		  utilisateur.setTelephone(result.getString("telephone"));
	    	  }
	    	  result.getString("rue");
	    	  if (result.wasNull()) {
	    		  utilisateur.setRue("inconnue");
	    	  }else {
	    		  utilisateur.setRue(result.getString("rue"));
	    	  }
	    	  result.getString("code_postal");
	    	  if (result.wasNull()) {
	    		  utilisateur.setCodePostal("inconnu");
	    	  }else {
	    		  utilisateur.setCodePostal(result.getString("code_postal"));
	    	  }
	    	  result.getString("ville");
	    	  if (result.wasNull()) {
	    		  utilisateur.setVille("inconnue");
	    	  }else {
	    		  utilisateur.setVille(result.getString("ville"));
	    	  }
	    	  result.getString("mot_de_passe");
	    	  if (result.wasNull()) {
	    		  utilisateur.setMotDePasse("inconnu");
	    	  }else {
	    		  utilisateur.setMotDePasse(result.getString("mot_de_passe"));
	    	  }
	    	  result.getInt("credit");
	    	  if (result.wasNull()) {
	    		  utilisateur.setCredit(0);
	    	  }else {
	    		  utilisateur.setCredit(result.getInt("credit"));
	    	  }
	    	  result.getString("administrateur");
	    	  if (result.wasNull()) {
	    		  utilisateur.setAdministrateur(0);
	    	  }else {
	    		  utilisateur.setAdministrateur(result.getInt("administrateur"));
	    	  }
	      }
	    } catch (SQLException e) {
	    	throw new DALException("probleme avec la methode findByLogin",e);
		} finally {
			AccesBase.closeAll(preparedStatement, connect);
		}
	    return utilisateur;
	}

}
