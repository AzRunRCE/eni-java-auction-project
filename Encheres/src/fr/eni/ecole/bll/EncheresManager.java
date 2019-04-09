package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Interface.IDAOEnchere;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.DetailEnchere;

public class EncheresManager {
	IDAOEnchere daoEncheres = DAOFactory.getEnchereDAO();
	
	/**
	 * 
	 * @return une liste de AccueilDashboardTile
	 * @throws BLLException 
	 */
	public List<AccueilDashboardTile> getListeEncheresAccueilWithoutParameters() throws BLLException {
		try {
			return daoEncheres.selectAllWithoutParameters();
		} catch (DALException e) {
			throw new BLLException("Probleme dans getListeWithoutParameters", e);
		}
	}
	
    /**
    * Methode permettant d'aller chercher en base les enregistrements respectant les filtres
    * @param accueilFilters Structure de donnees contenant les filtres saisis
    * @param idUtilisateur
    * @return une liste de AccueilDashboardTile
     * @throws BLLException 
    */
	public List<AccueilDashboardTile> getListeEncheresAccueilWithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) throws BLLException {
		try {
			return daoEncheres.selectAllwithParameters(accueilFilters, idUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Probleme dans getListeWithParameters", e);
		}
	}
	
	/**
	 * 
	 * @param noArticle
	 * @return mon objet pour la page détail vente
	 */
	public DetailEnchere getEnchere(int noArticle) {
		return daoEncheres.selectById(noArticle);
	}
	 
}
