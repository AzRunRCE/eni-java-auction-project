package fr.eni.ecole.DAL.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.beans.Retrait;
import fr.eni.ecole.util.AccesBase;

public class RetraitDAO implements DAO<Retrait> {

	private final String SELECT_ALL= "SELECT no_article, rue, code_postal, ville FROM RETRAITS";
	private final String SELECT_BY_ID = "SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article = ?";
	private final String CREATE = "INSERT INTO [RETRAITS] VALUES (?,?,?,?)";
	private DataSource dataSource = null;
	
	public RetraitDAO(DataSource _dataSource) {
		dataSource = _dataSource;
	}
	public RetraitDAO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int create(Retrait new_retrait) throws DALException{
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1,new_retrait.getNo_article()); 
			preparedStatement.setString(2,new_retrait.getRue()); 
	       	preparedStatement.setString(3,new_retrait.getCode_postal()); 
	       	preparedStatement.setString(4,new_retrait.getVille()); 
	    	preparedStatement.executeUpdate();
             //prest.executeUpdate(query, PreparedStatement.RETURN_GENERATED_KEYS); Throws an error
             //prest.executeQuery(); Throws an error
             ResultSet rs = preparedStatement.getGeneratedKeys();
             if(rs.next())
             {
            	 return  rs.getInt(1);
             }
	    	return -1;
		} catch (SQLException e) {
				throw new DALException(" RetraitDAO probleme avec la methode create",e);
			}
		}

	@Override
	public int delete(Retrait obj) throws DALException {
		return 0;
	}

	@Override
	public boolean update(Retrait new_retrait) throws DALException {
				return false;
	}

	@Override
	public Retrait find(int id) throws DALException {
		try(Connection connect = dataSource.getConnection();
				PreparedStatement preparedStatement = connect.prepareStatement(SELECT_BY_ID)) {
			preparedStatement.setInt(1,id); 
	    	ResultSet rs = preparedStatement.executeQuery();
	    	if(rs.next()) {
	    		return new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));    
	    	}
		} catch (SQLException e) {
			throw new DALException("Problème avec la méthode find",e);
		}
		return null;
	}

}
