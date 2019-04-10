package fr.eni.ecole.DAL.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.IDAOCategorie;
import fr.eni.ecole.beans.Categorie;
import fr.eni.ecole.util.AccesBase;

public class CategorieDAO implements IDAOCategorie {

	private final String SELECT_ALL= "SELECT no_categorie, libelle FROM CATEGORIES";
	private final String SELECT_BY_ID = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";
	private DataSource dataSource = null;
	public CategorieDAO(DataSource _dataSource) {
		dataSource = _dataSource;
	}
	
	@Override
	public int create(Categorie obj) throws DALException {
		return 0;
	}

	@Override
	public int delete(Categorie obj) throws DALException {
		return 0;
	}

	@Override
	public boolean update(Categorie obj) throws DALException {
		return false;
	}

	@Override
	public Categorie find(int id) throws DALException {
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,id); 
	    	ResultSet rs = preparedStatement.executeQuery();
	    	if(rs.next()) {
	    		return new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));    
	    	}
		} catch (SQLException e) {
			throw new DALException("Problème avec la méthode find" ,e);
		}
		return null;
	}

	@Override
	public List<Categorie> selectAll() throws DALException {
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_ALL)) {

			List<Categorie> listeCategories= new ArrayList<>();
			
	    	ResultSet rs = preparedStatement.executeQuery();
	    	while(rs.next()) {
	    		listeCategories.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));    
	    	}
	    	return listeCategories;
		} catch (SQLException e) {
			throw new DALException( "Probleme dans categorie selectAll", e);
		}
	}

}
