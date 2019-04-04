package fr.eni.ecole.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.rest.mo.getAccueil;
import fr.eni.ecole.util.AccesBase;

public class EnchereDAO implements IDAOEnchere {

	private final String SELECT_ALL_WITHOUT_PARAM = "SELECT av.nom_article, av.date_fin_encheres, e.montant_enchere, u.pseudo, u.no_utilisateur, e.no_article " + 
										"FROM ENCHERES e, ARTICLES_VENDUS av, UTILISATEURS u " + 
										"WHERE e.no_utilisateur = u.no_utilisateur AND " + 
										"e.no_article = av.no_article AND " + 
										"e.no_utilisateur = av.no_utilisateur";  
	
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

}
