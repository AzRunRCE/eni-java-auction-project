package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.IDAOEnchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.getAccueil;
import fr.eni.ecole.rest.mo.getDetailEnchere;


public class EncheresManager {
	IDAOEnchere daoEncheres = DAOFactory.getEnchereDAO();
	
	public List<getAccueil> getListeEncheresAccueilWithoutParameters() {
		return daoEncheres.selectAllWithoutParameters();
	}
	public List<getAccueil> getListeEncheresAccueilWithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) {
		return daoEncheres.selectAllwithParameters(accueilFilters, idUtilisateur);
	}
	
	public getDetailEnchere getEnchere(int noArticle) {
		return daoEncheres.selectById(noArticle);
	}
}
