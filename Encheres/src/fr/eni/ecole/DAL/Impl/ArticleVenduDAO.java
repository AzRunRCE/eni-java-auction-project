package fr.eni.ecole.DAL.Impl;

import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Categorie;
import fr.eni.ecole.beans.Retrait;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.util.AccesBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.sql.DataSource;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;

public class ArticleVenduDAO implements IDAOArticleVendu {
	private final String CREATE = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?)";
	private final String SELECT_BY_ID = 
			"SELECT TOP 1000 [ARTICLES_VENDUS].[no_article]\r\n" + 
			"      ,[nom_article]\r\n" + 
			"      ,[description]\r\n" + 
			"      ,[date_debut_encheres]\r\n" + 
			"      ,[date_fin_encheres]\r\n" + 
			"      ,[prix_initial]\r\n" + 
			"      ,[prix_vente]\r\n" + 
			"      ,[ARTICLES_VENDUS].[no_utilisateur]\r\n" + 
			"      ,[CATEGORIES].[no_categorie]\r\n" + 
			"	  ,[pseudo]\r\n" + 
			"      ,[nom]\r\n" + 
			"      ,[prenom]\r\n" + 
			"      ,[email]\r\n" + 
			"      ,[telephone]\r\n" + 
			"      ,[RETRAITS].[rue]\r\n" + 
			"      ,[RETRAITS].[code_postal]\r\n" + 
			"      ,[RETRAITS].[ville]\r\n" + 
			"      ,[mot_de_passe]\r\n" + 
			"      ,[credit]\r\n" + 
			"      ,[administrateur],\r\n" + 
			"	  [libelle]\r\n" + 
			"  FROM [DB_ENCHERES_UnitTests].[dbo].[ARTICLES_VENDUS]\r\n" + 
			"  inner join UTILISATEURS on [ARTICLES_VENDUS].[no_utilisateur] = [UTILISATEURS].[no_utilisateur]\r\n" + 
			"  inner join CATEGORIES on [ARTICLES_VENDUS].[no_categorie] = CATEGORIES.[no_categorie] \r\n" + 
			"    inner join RETRAITS on RETRAITS.[no_article] = [ARTICLES_VENDUS].[no_article] where [ARTICLES_VENDUS].no_article = ?";
	
	private DataSource dataSource = null;
	
	public ArticleVenduDAO(DataSource _dataSource) {
		dataSource = _dataSource;
	}
	
	@Override
	public int create(ArticleVendu new_article) {
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1,new_article.getNomArticle()); 
	       	preparedStatement.setString(2,new_article.getDescription()); 
	       	preparedStatement.setTimestamp(3, Timestamp.valueOf(new_article.getDateDebutEncheres())); 
	     	preparedStatement.setTimestamp(4,Timestamp.valueOf(new_article.getDateFinEncheres()));
	     	preparedStatement.setFloat(5,new_article.getMiseAPrix());
	     	preparedStatement.setFloat(6,new_article.getPrixVente());
	      	preparedStatement.setInt(7,new_article.getUtilisateur().getNoUtilisateur());
	     	preparedStatement.setInt(8,new_article.getCategorie().getNoCategorie());
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
		}
	}

	@Override
	public boolean delete(ArticleVendu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ArticleVendu obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArticleVendu find(int id) {
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,id); 
	    	ResultSet result = preparedStatement.executeQuery();
	    	if(result.next()) {
	    		ArticleVendu av = new ArticleVendu();    
	    		av.setNomArticle(result.getString("nom_article"));
	    	
	    		av.setNoArticle(result.getInt("no_article"));
	    		av.setDateDebutEncheres(result.getTimestamp("date_debut_encheres").toLocalDateTime());
	    		av.setDateFinEncheres(result.getTimestamp("date_fin_encheres").toLocalDateTime());
	    		av.setCategorie(new Categorie(result.getInt("no_categorie"),result.getString("libelle")));
	    		av.setMiseAPrix(result.getFloat("prix_initial"));
	    		av.setPrixVente(result.getFloat("prix_vente"));	
		    		Utilisateur utilisateur = new Utilisateur();   
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
	    		av.setUtilisateur(utilisateur);
	    		if (result.getString("rue") != null) {
	    			av.setRetrait(new Retrait(result.getInt("no_article"), result.getString("rue"), result.getString("code_postal"), result.getString("ville")));
	    		}
	    		return av;
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	

}
