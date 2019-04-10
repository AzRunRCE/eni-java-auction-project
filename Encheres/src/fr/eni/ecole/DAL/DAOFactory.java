package fr.eni.ecole.DAL;

import javax.sql.DataSource;

import fr.eni.ecole.DAL.Impl.ArticleVenduDAO;
import fr.eni.ecole.DAL.Impl.CategorieDAO;
import fr.eni.ecole.DAL.Impl.EnchereDAO;
import fr.eni.ecole.DAL.Impl.RetraitDAO;
import fr.eni.ecole.DAL.Impl.UtilisateurDAO;
import fr.eni.ecole.DAL.Interface.DAO;
import fr.eni.ecole.DAL.Interface.IDAOArticleVendu;
import fr.eni.ecole.DAL.Interface.IDAOCategorie;
import fr.eni.ecole.DAL.Interface.IDAOEnchere;
import fr.eni.ecole.DAL.Interface.IDAOUtilisateur;
import fr.eni.ecole.beans.Retrait;

public class DAOFactory  extends AbstractDAOFactory {
	
	
	public DAOFactory(DataSource _dataSource ) {
		dataSource = _dataSource;
	}
	private DataSource dataSource;

	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public IDAOUtilisateur getUtilisateurDAO()  {
		return new UtilisateurDAO(this.getDataSource());
	}

	public DAO<Retrait> getRetraitDAO() {
		return new RetraitDAO(this.getDataSource());
	}
	public IDAOEnchere getEnchereDAO() {
		return new EnchereDAO();
	}
	public  IDAOCategorie getCategorieDAO() {
		return new CategorieDAO(this.getDataSource());
	}
	public IDAOArticleVendu getArticleVenduDAO() {
		return new ArticleVenduDAO(this.getDataSource());
	}
}
