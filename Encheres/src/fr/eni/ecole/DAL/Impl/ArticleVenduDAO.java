package fr.eni.ecole.DAL.Impl;

import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.util.AccesBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;

public class ArticleVenduDAO implements IDAOArticleVendu {
	private final String CREATE = "INSERT INTO ARTICLE_VENDU VALUES (?,?,?,?,?,?,?)";
	
	@Override
	public boolean create(ArticleVendu new_article) {
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(CREATE)) {

			preparedStatement.setString(1,new_article.getNomArticle()); 
	       	preparedStatement.setString(2,new_article.getDescription()); 
	       	preparedStatement.setTimestamp(3, Timestamp.valueOf(new_article.getDateDebutEncheres())); 
	     	preparedStatement.setTimestamp(4,Timestamp.valueOf(new_article.getDateDebutEncheres()));
	     	preparedStatement.setFloat(5,new_article.getMiseAPrix());
	     	preparedStatement.setFloat(6,new_article.getPrixVente());
	      	preparedStatement.setInt(7,new_article.getUtilisateur().getNoUtilisateur());

	    	preparedStatement.execute();
	    	return true;
		} catch (SQLException e) {
			try {
				throw new DALException(" DAOUtilisateur probleme avec la methode create",e);
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
		// TODO Auto-generated method stub
		return null;
	}

	

}
