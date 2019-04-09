package fr.eni.ecole.DAL.Impl;

import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.util.AccesBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;

public class ArticleVenduDAO implements IDAOArticleVendu {
	private final String CREATE = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?)";
	private final String UPDATE_PRIX_VENTE = "UPDATE ARTICLES_VENDUS SET prix_vente = ? WHERE no_article = ?";
	
	@Override
	public int create(ArticleVendu new_article) {
		try(Connection connect = AccesBase.getConnection();
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
		} catch (DALException e1) {
			e1.printStackTrace();
			return -1;
		}
	}

	@Override
	public int delete(ArticleVendu obj) {
		return 0;
	}

	@Override
	public boolean update(ArticleVendu obj) {
		return false;
	}

	@Override
	public ArticleVendu find(int id) {
		return null;
	}

	@Override
	public int updatePrixVenteArticle(int noArticle, int montant) {
		int rs = 0;
		
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(UPDATE_PRIX_VENTE)) {

			preparedStatement.setInt(1, montant);
			preparedStatement.setInt(2, noArticle);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return rs;
	}

	

}
