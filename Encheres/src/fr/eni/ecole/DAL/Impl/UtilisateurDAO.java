package fr.eni.ecole.DAL.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.ecole.DAL.*;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.AccesBase;

public class UtilisateurDAO implements IDAOUtilisateur {
	
	//constantes
	
	private final String FIND_SQL = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";    
	private final String FIND_BY_LOGIN = "SELECT * FROM UTILISATEURS WHERE pseudo = ? OR email = ?";
	private final String CREATE = "INSERT INTO UTILISATEURS VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE [dbo].[UTILISATEURS] SET [pseudo] = ? ,[nom] = ? ,[prenom] = ? ,[email] = ?,[telephone] = ?,[rue] = ?,[code_postal] = ?,[ville] = ?,[mot_de_passe] = ?,[credit] = ?,[administrateur] = ? WHERE no_utilisateur = ?";
	private final String DELETE = "delete UTILISATEURS where no_utilisateur = ?";
	
	public UtilisateurDAO () {
	}

	@Override
	public int create(Utilisateur new_user) {
		
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1,new_user.getPseudo()); 
	       	preparedStatement.setString(2,new_user.getNom()); 
	       	preparedStatement.setString(3,new_user.getPrenom()); 
	     	preparedStatement.setString(4,new_user.getEmail());
	     	preparedStatement.setString(5,new_user.getTelephone());
	     	preparedStatement.setString(6,new_user.getRue());
	      	preparedStatement.setString(7,new_user.getCodePostal());
	    	preparedStatement.setString(8,new_user.getVille());
	    	preparedStatement.setString(9,new_user.getMotDePasse());
	    	preparedStatement.setInt(10,new_user.getCredit());
	     	preparedStatement.setInt(11,new_user.getAdministrateur());
	    	preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
	        if(rs.next())
	        {
	        	return  rs.getInt(1);
	        }
	    	return -1;
		} catch (SQLException e) {
			try {
				throw new DALException(" DAOUtilisateur probleme avec la methode create",e);
			} catch (DALException e1) {
				e1.printStackTrace();
				return -1;
			}
		} catch (DALException e1) {
			e1.printStackTrace();
			return -1;
		}
	}

	@Override
	public boolean delete(Utilisateur obj) {
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(DELETE)) {

	    	preparedStatement.setInt(1,obj.getNoUtilisateur());
	    	preparedStatement.execute();
	    	return true;
		} catch (SQLException e) {
			try {
				throw new DALException("DAOUtilisateur probleme avec la methode delete",e);
			} catch (DALException e1) {
				e1.printStackTrace();
				return false;
			}
		} catch (DALException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Utilisateur update_user) {
		
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(UPDATE)) {

			preparedStatement.setString(1,update_user.getPseudo()); 
	       	preparedStatement.setString(2,update_user.getNom()); 
	       	preparedStatement.setString(3,update_user.getPrenom()); 
	     	preparedStatement.setString(4,update_user.getEmail());
	     	preparedStatement.setString(5,update_user.getTelephone());
	     	preparedStatement.setString(6,update_user.getRue());
	      	preparedStatement.setString(7,update_user.getCodePostal());
	    	preparedStatement.setString(8,update_user.getVille());
	    	preparedStatement.setString(9,update_user.getMotDePasse());
	    	preparedStatement.setInt(10,update_user.getCredit());
	     	preparedStatement.setInt(11,update_user.getAdministrateur());
	    	preparedStatement.setInt(12,update_user.getNoUtilisateur());
	    	preparedStatement.execute();
	    	return true;
		} catch (SQLException e) {
			try {
				throw new DALException("DAOUtilisateur probleme avec la methode update",e);
			} catch (DALException e1) {
				e1.printStackTrace();
				return false;
			}
		} catch (DALException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Utilisateur find(int id) {

		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(FIND_SQL)) {

			Utilisateur utilisateur = new Utilisateur();        
	    	preparedStatement.setInt(1,id); 
	    	preparedStatement.execute();
	    	ResultSet result = preparedStatement.executeQuery();
	    	if(result.next() == true) {
	    	  utilisateur = new Utilisateur();   

    		  utilisateur.setPseudo(result.getString("pseudo"));

    		  utilisateur.setNom(result.getString("nom"));
    
    		  utilisateur.setPrenom(result.getString("prenom"));
    
    		  utilisateur.setEmail(result.getString("email"));
    
    		  utilisateur.setTelephone(result.getString("telephone"));
    
    		  utilisateur.setRue(result.getString("rue"));
    	
    		  utilisateur.setCodePostal(result.getString("code_postal"));
    	 
    		  utilisateur.setVille(result.getString("ville"));
    	
    		  utilisateur.setMotDePasse(result.getString("mot_de_passe"));
    	 
    		  utilisateur.setCredit(result.getInt("credit"));
    		  utilisateur.setNoUtilisateur(result.getInt("no_utilisateur"));
    		  utilisateur.setAdministrateur(result.getInt("administrateur"));
	    	}
	    	return utilisateur;
		} catch (SQLException e) {
			try {
				throw new DALException("problème avec la méhode find", e);
			} catch (DALException e1) {
				e1.printStackTrace();
				return null;
			}
		} catch (DALException e1) {
			e1.printStackTrace();
			return null;
		}
	  }
	
	@Override
	public Utilisateur findByLogin(String email_or_username)  {
		Utilisateur utilisateur = null;   
		ResultSet result = null;
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(FIND_BY_LOGIN)) {
	    	preparedStatement.setString(1,email_or_username); 
	    	preparedStatement.setString(2,email_or_username); 
	    		    	
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
	    return utilisateur;
	    } catch (SQLException e) {
	    	try {
				throw new DALException("problème avec la méhode findByLogin", e);
			} catch (DALException e1) {
				e1.printStackTrace();
				return null;
			}
	    } catch (DALException e1) {
	    	e1.printStackTrace();
	    	return null;
	    }
	}

}
