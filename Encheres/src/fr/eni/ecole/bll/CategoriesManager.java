package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.DAL.AbstractDAOFactory;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.Interface.IDAOCategorie;
import fr.eni.ecole.beans.Categorie;


public class CategoriesManager {
	IDAOCategorie daoCategorie = null;
	public CategoriesManager(){
		daoCategorie = AbstractDAOFactory.getFactory().getCategorieDAO();
	}
	
	public List<Categorie> getListeCategories() throws BLLException{
		try {
			return daoCategorie.selectAll();
		} catch (DALException e) {
			throw new BLLException("Probleme dans getListeCategorie()", e);
		}
	}
	
	public Categorie getCategorie(int Id) throws BLLException{
		try {
			return daoCategorie.find(Id);
		} catch (DALException e) {
			throw new BLLException("Problème avec la métohode getCategorie", e);
		}
	}
}
