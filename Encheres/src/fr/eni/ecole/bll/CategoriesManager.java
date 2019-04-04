package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.IDAOCategorie;
import fr.eni.ecole.beans.Categorie;


public class CategoriesManager {
	IDAOCategorie daoCategorie = DAOFactory.getCategorieDAO();
	
	public List<Categorie> getListeCategories() {
		return daoCategorie.selectAll();
	}
}
