package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.IDAOEnchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.getDetailEnchere;

public class EncheresManager {
	IDAOEnchere daoEncheres = DAOFactory.getEnchereDAO();
	
	/**
	 * 
	 * @return une liste de AccueilDashboardTile
	 */
	public List<AccueilDashboardTile> getListeEncheresAccueilWithoutParameters() {
		return daoEncheres.selectAllWithoutParameters();
	}
	
    /**
    * Methode permettant d'aller chercher en base les enregistrements respectant les filtres
    * @param accueilFilters Structure de données contenant les filtres saisis
    * @param idUtilisateur
    * @return une liste de AccueilDashboardTile
    */
	public List<AccueilDashboardTile> getListeEncheresAccueilWithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) {
		return daoEncheres.selectAllwithParameters(accueilFilters, idUtilisateur);
	}
	
	public getDetailEnchere getEnchere(int noArticle) {
		return daoEncheres.selectById(noArticle);
	}
}
