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

import fr.eni.ecole.DAL.AbstractDAOFactory;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.DAL.Interface.IDAOCategorie;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;

public class ArticleVenduDAO implements IDAOArticleVendu {
	private final String CREATE = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_PRIX_VENTE = "UPDATE ARTICLES_VENDUS SET prix_vente = ? WHERE no_article = ?";
	private final String SELECT_BY_ID = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, " +
										"prix_initial, prix_vente, chemin_image, no_utilisateur, no_categorie "+
										"FROM ARTICLES_VENDUS "+
										"WHERE no_article = ?";
	
	private DataSource dataSource = null;
	public ArticleVenduDAO(DataSource _dataSource) {
		dataSource = _dataSource;
	}
	
	@Override
	public int create(ArticleVendu new_article)  throws DALException{
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1,new_article.getNomArticle()); 
	       	preparedStatement.setString(2,new_article.getDescription()); 
	       	preparedStatement.setTimestamp(3, Timestamp.valueOf(new_article.getDateDebutEncheres())); 
	     	preparedStatement.setTimestamp(4,Timestamp.valueOf(new_article.getDateFinEncheres()));
	     	preparedStatement.setFloat(5,new_article.getMiseAPrix());
	     	preparedStatement.setFloat(6,new_article.getPrixVente());
	     	preparedStatement.setString(7, new_article.getChemin_image());
	      	preparedStatement.setInt(8,new_article.getVendeur().getNoUtilisateur());
	     	preparedStatement.setInt(9,new_article.getCategorie().getNoCategorie());
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
	public boolean update(ArticleVendu obj) throws DALException {
		return false;
	}


	@Override
	public ArticleVendu find(int no_article) throws DALException {
		ArticleVendu av = null;
		Utilisateur utilisateur = null;
		IDAOUtilisateur utilisateurDAO = null;
		DAO<Retrait> retraitDAO = null;
		Retrait retrait = null;
		IDAOCategorie categorieDAO = null;
		Categorie categorie = null;
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,no_article); 
	    	ResultSet result = preparedStatement.executeQuery();
	    	if(result.next()) {
	    		av = new ArticleVendu();    
	    		av.setNoArticle(result.getInt("no_article"));
	    		av.setNomArticle(result.getString("nom_article"));
	    		av.setDescription(result.getString("description"));
	    		av.setDateDebutEncheres(result.getTimestamp("date_debut_encheres").toLocalDateTime());
	    		av.setDateFinEncheres(result.getTimestamp("date_fin_encheres").toLocalDateTime());
	    		av.setMiseAPrix(result.getInt("prix_initial"));
	    		av.setPrixVente(result.getInt("prix_vente"));
	    		av.setChemin_image(result.getString("chemin_image"));
	    		categorieDAO = AbstractDAOFactory.getFactory().getCategorieDAO();
	    		categorie = categorieDAO.find(result.getInt("no_categorie"));
	    		av.setCategorie(categorie);
	    		retraitDAO = AbstractDAOFactory.getFactory().getRetraitDAO();
	    		retrait = retraitDAO.find(result.getInt("no_article"));
	    		av.setRetrait(retrait);
	    		utilisateurDAO = AbstractDAOFactory.getFactory().getUtilisateurDAO();
	    		utilisateur = utilisateurDAO.find(result.getInt("no_utilisateur"));
	    		av.setVendeur(utilisateur);
	    	}
		} catch (SQLException e) {
			throw new DALException("Problème avec la méthode find", e);
		} 
		return av;
	}

	@Override
	public int updatePrixVenteArticle(int noArticle, int montant) throws DALException {
		int rs = 0;
		
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(UPDATE_PRIX_VENTE)) {

			preparedStatement.setInt(1, montant);
			preparedStatement.setInt(2, noArticle);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Problème avec la méthode updatePrixVenteArticle", e);
		} 
		return rs;
	}

	@Override
	public int delete(ArticleVendu obj) throws DALException {
		return 0;
	}


}
