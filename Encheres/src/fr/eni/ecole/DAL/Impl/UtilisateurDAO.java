package fr.eni.ecole.DAL.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

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
	private final String UPDATE_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
	private DataSource dataSource = null;
	
	public UtilisateurDAO(DataSource _dataSource) {
		dataSource = _dataSource;
	}



	@Override
	public int create(Utilisateur new_user) throws DALException {
		
		try(Connection connect = dataSource.getConnection();
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
				throw new DALException(" DAOUtilisateur probleme avec la methode create",e);
			}
		}

	@Override
	public int delete(Utilisateur obj) throws DALException {
		int rs = 0;
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(DELETE)) {

	    	preparedStatement.setInt(1,obj.getNoUtilisateur());
	    	rs = preparedStatement.executeUpdate();
	    	return rs;
		} catch (SQLException e) {
				throw new DALException("DAOUtilisateur probleme avec la methode delete",e);
		}
	}
	
	@Override
	public boolean update(Utilisateur update_user) throws DALException {
		
		try(Connection connect = dataSource.getConnection();
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
				throw new DALException("DAOUtilisateur probleme avec la methode update",e);
			}
		}

	@Override
	public Utilisateur find(int id) throws DALException {

		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(FIND_SQL)) {

			      
	    	preparedStatement.setInt(1,id); 
	    	preparedStatement.execute();
	    	ResultSet result = preparedStatement.executeQuery();
	    	if(result.next() == true) {
	    		Utilisateur utilisateur = new Utilisateur();  
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
    		  return utilisateur;
	    	}
	    	return null;
		} catch (SQLException e) {
				throw new DALException("problème avec la méhode find", e);
			}
		}
	
	@Override
	public Utilisateur findByLogin(String email_or_username) throws DALException  {
		Utilisateur utilisateur = null;   
		ResultSet result = null;
		try(Connection connect = dataSource.getConnection();
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
				throw new DALException("problème avec la méhode findByLogin", e);
	    }
			}

	@Override
	public int updateCredit(int noUtilisateur, int credit) throws DALException {
		int rs = 0;
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(UPDATE_CREDIT)) {
	    	preparedStatement.setInt(1,credit); 
	    	preparedStatement.setInt(2,noUtilisateur); 
	    		    	
	    	rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("problème avec la méhode updateCredit", e);
	    }
		return rs;
	}

}
