package fr.eni.ecole.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.rest.mo.getAccueil;
import fr.eni.ecole.rest.mo.getDetailEnchere;
import fr.eni.ecole.util.AccesBase;

public class EnchereDAO implements IDAOEnchere {

	private final String SELECT_ALL_WITHOUT_PARAM = "SELECT av.nom_article, av.date_fin_encheres, e.montant_enchere, u.pseudo, u.no_utilisateur, e.no_article " + 
										"FROM ENCHERES e, ARTICLES_VENDUS av, UTILISATEURS u " + 
										"WHERE e.no_utilisateur = u.no_utilisateur AND " + 
										"e.no_article = av.no_article AND " + 
										"e.no_utilisateur = av.no_utilisateur";  
	
	private final String SELECT_BY_ID = "SELECT av.nom_article, av.description, c.libelle, av.date_fin_encheres, av.prix_initial, av.no_utilisateur as vendeur, e.montant_enchere, e.no_utilisateur as acheteur, e.no_article, u.pseudo, r.code_postal, r.rue, r.ville " + 
										"FROM ENCHERES e " + 
										"RIGHT JOIN UTILISATEURS u ON e.no_utilisateur = u.no_utilisateur " + 
										"RIGHT JOIN ARTICLES_VENDUS av  ON e.no_article = av.no_article " + 
										"RIGHT JOIN RETRAITS r ON e.no_article = r.no_article " + 
										"RIGHT JOIN CATEGORIES c ON c.no_categorie = av.no_categorie " + 
										"WHERE e.no_article = ? " + 
										"ORDER BY e.montant_enchere DESC";
								
	@Override
	public boolean create(Enchere obj) {
		return false;
	}

	@Override
	public boolean delete(Enchere obj) {
		return false;
	}

	@Override
	public boolean update(Enchere obj) {
		return false;
	}

	@Override
	public Enchere find(int id) {
		return null;
	}
	

	@Override
	public List<getAccueil> selectAllWithoutParameters() {
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_ALL_WITHOUT_PARAM)) {

			List<getAccueil> listeMsgObjectsAccueil= new ArrayList<>();
			
	    	ResultSet rs = preparedStatement.executeQuery();
	    	while(rs.next()) {
	    		listeMsgObjectsAccueil.add(new getAccueil( 
	    										rs.getString("nom_article"), 
	    										rs.getTimestamp("date_fin_encheres").toLocalDateTime().toString(), 
	    										rs.getInt("montant_enchere"),
	    										rs.getString("pseudo"),	
	    										rs.getInt("no_utilisateur"), 
	    										rs.getInt("no_article")
		    									)
	    		);    
	    	}
	    	return listeMsgObjectsAccueil;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e1) {
			System.out.println("Probleme dans selectAllWithoutParameters");
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<getAccueil> selectAllwithParameters(String[] listeParams) {
		return null;
	}
	
	@Override
	public getDetailEnchere selectById(int noArticle) {
		getDetailEnchere enchere = null;
		ResultSet rs = null;
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,noArticle);
			rs = preparedStatement.executeQuery();
	    	if(rs.next()) {
	    		//rs.first();
	    		enchere = new getDetailEnchere(rs.getString("nom_article"),
	    										rs.getString("description"),
	    										rs.getString("libelle"),
	    										rs.getString("pseudo"),
	    										rs.getString("code_postal"),
	    										rs.getString("rue"),
	    										rs.getString("ville"),
	    										rs.getTimestamp("date_fin_encheres").toLocalDateTime(),
	    										rs.getInt("prix_initial"),
	    										rs.getInt("montant_enchere"),
	    										rs.getInt("no_article"),
	    										rs.getInt("acheteur"),
	    										rs.getInt("vendeur"));
	    	}
	    	return enchere;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DALException e1) {
			System.out.println("Probleme dans le méthode selectById");
			e1.printStackTrace();
			return null;
		}
	}

}
