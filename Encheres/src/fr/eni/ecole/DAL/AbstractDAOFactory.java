package fr.eni.ecole.DAL;


import javax.sql.DataSource;

import fr.eni.ecole.DAL.Impl.ArticleVenduDAO;
import fr.eni.ecole.DAL.Impl.CategorieDAO;
import fr.eni.ecole.DAL.Impl.EnchereDAO;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.DAL.Interface.IDAOCategorie;
import fr.eni.ecole.DAL.Interface.IDAOEnchere;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Retrait;
import fr.eni.ecole.util.AccesBase;

public abstract class AbstractDAOFactory {

	public abstract DAO<Retrait> getRetraitDAO();
	public abstract IDAOUtilisateur getUtilisateurDAO();
	public abstract IDAOEnchere getEnchereDAO();
	public abstract IDAOCategorie getCategorieDAO();
	public abstract IDAOArticleVendu getArticleVenduDAO() ;
		
	/**
	 * M�thode nous permettant de r�cup�rer une factory de DAO
	 * @return AbstractDAOFactory
	 */
	public static AbstractDAOFactory getFactory(){
		try {
			return new DAOFactory(AccesBase.getDataSource());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	public static AbstractDAOFactory getFactory(DataSource ds){
		return new DAOFactory(ds);
	}
}