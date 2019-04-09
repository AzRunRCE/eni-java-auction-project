package fr.eni.ecole.bll;

import java.util.List;

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
	 */
	public List<AccueilDashboardTile> getListeEncheresAccueilWithoutParameters() {
		return daoEncheres.selectAllWithoutParameters();
	}
	
    /**
    * Methode permettant d'aller chercher en base les enregistrements respectant les filtres
    * @param accueilFilters Structure de donnees contenant les filtres saisis
    * @param idUtilisateur
    * @return une liste de AccueilDashboardTile
    */
	public List<AccueilDashboardTile> getListeEncheresAccueilWithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) {
		return daoEncheres.selectAllwithParameters(accueilFilters, idUtilisateur);
	}
	
	/**
	 * 
	 * @param noArticle
	 * @return mon objet pour la page détail vente
	 */
	public DetailEnchere getEnchere(int noArticle) {
		return daoEncheres.selectById(noArticle);
	}
	
	/**
	 * 
	 * @param noArticle
	 * @return
	 */
	public DetailEnchere getArticle(int noArticle) {
		return daoEncheres.selectByIdArticle(noArticle);
	}
	
	/**
	 * Methode permettant d'ajouter en base une enchere
	 * @param noUtilisateur de celui qui fait l'enchere
	 * @param noArticle concerne par l'enchere
	 * @param montant de la nouvelle enchere
	 * @return le nombre de ligne créée
	 */
	public int createEnchere(int noUtilisateur, int noArticle, int montant) {
		return daoEncheres.nouvelleEnchere(noUtilisateur, noArticle, montant);
	}
	
	/**
	 * Méthode qui supprime l'enchere d'un utilisateur pour un article
	 * @param noUtilisateur
	 * @param noArticle
	 * @return le nombre de ligne supprimmée
	 */
	public int deleteEnchere(int noUtilisateur, int noArticle) {
		return daoEncheres.deleteEnchere(noUtilisateur, noArticle);
	}
}
