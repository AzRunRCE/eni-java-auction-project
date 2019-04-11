package fr.eni.ecole.bll;

import java.util.List;
import java.util.Map;

import fr.eni.ecole.DAL.AbstractDAOFactory;
import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.Interface.IDAOEnchere;
import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.DetailEnchere;

public class EncheresManager {
	IDAOEnchere daoEncheres = null;
	
	public EncheresManager() {
			daoEncheres = AbstractDAOFactory.getFactory().getEnchereDAO();
	}
	
	/**
	 * 
	 * @return une liste de AccueilDashboardTile
	 * @throws BLLException 
	 */
	public Map<ArticleVendu, Utilisateur> getListeEncheresAccueilWithoutParameters() throws BLLException {
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
	public Map<ArticleVendu, Utilisateur> getListeEncheresAccueilWithParameters(AccueilFilters accueilFilters, Integer idUtilisateur) throws BLLException {
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
	public DetailEnchere getEnchere(int noArticle)throws BLLException {
		try {
			return daoEncheres.selectById(noArticle);
		} catch (DALException e) {
			throw new BLLException("Probleme dans getEnchere", e);
		}
	}
	
	/**
	 * 
	 * @param noArticle
	 * @return
	 */
	public DetailEnchere getArticle(int noArticle) throws BLLException {
		try {
			return daoEncheres.selectByIdArticle(noArticle);
		} catch (DALException e) {
			throw new BLLException("Probleme dans getArticle", e);
		}
	}
	
	/**
	 * Methode permettant d'ajouter en base une enchere
	 * @param noUtilisateur de celui qui fait l'enchere
	 * @param noArticle concerne par l'enchere
	 * @param montant de la nouvelle enchere
	 * @return le nombre de ligne créée
	 */
	public int createEnchere(int noUtilisateur, int noArticle, int montant) throws BLLException {
		try {
			return daoEncheres.nouvelleEnchere(noUtilisateur, noArticle, montant);
		} catch (DALException e) {
			throw new BLLException("Probleme dans createEnchere", e);
		}
	}
	
	/**
	 * Méthode qui supprime l'enchere d'un utilisateur pour un article
	 * @param noUtilisateur
	 * @param noArticle
	 * @return le nombre de ligne supprimmée
	 */
	public int deleteEnchere(int noUtilisateur, int noArticle) throws BLLException {
		try {
			return daoEncheres.deleteEnchere(noUtilisateur, noArticle);
		} catch (DALException e) {
			throw new BLLException("Probleme dans deleteEnchere", e);
		}
	}
}
