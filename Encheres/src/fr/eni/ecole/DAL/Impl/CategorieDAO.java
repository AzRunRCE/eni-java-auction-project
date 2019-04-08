package fr.eni.ecole.DAL.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.IDAOCategorie;
import fr.eni.ecole.beans.Categorie;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.rest.mo.getAccueil;
import fr.eni.ecole.util.AccesBase;

public class CategorieDAO implements IDAOCategorie {

	private final String SELECT_ALL= "SELECT no_categorie, libelle FROM CATEGORIES";
	private final String SELECT_BY_ID = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";
	
	@Override
	public int create(Categorie obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie find(int id) {
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,id); 
	    	ResultSet rs = preparedStatement.executeQuery();
	    	if(rs.next()) {
	    		return new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));    
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e1) {
			System.out.println("Categorie probleme dans find");
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Categorie> selectAll() {
		try(Connection connect = AccesBase.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_ALL)) {

			List<Categorie> listeCategories= new ArrayList<>();
			
	    	ResultSet rs = preparedStatement.executeQuery();
	    	while(rs.next()) {
	    		listeCategories.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));    
	    	}
	    	return listeCategories;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DALException e1) {
			System.out.println("Probleme dans selectAll");
			e1.printStackTrace();
		}
		return null;
	}

}
