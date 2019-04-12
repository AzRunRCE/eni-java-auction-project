package fr.eni.ecole.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import fr.eni.ecole.beans.ArticleVendu;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.bll.BLLException;
import fr.eni.ecole.bll.EncheresManager;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
import fr.eni.ecole.rest.mo.AccueilFilters;
/**
 * webservice rest qui gere les encheres
 * @author romai
 *
 */
@Path("/enchere")
public class GestionEncheres {

	//private static List<AccueilDashboardTile> listeEncheres;
	
	static {
//		listeEncheres = new ArrayList<>();
//		listeEncheres.add(new AccueilDashboardTile("pc gamer pour travailler", 
//				LocalDateTime.of(2018, 4, 3, 23, 24).toString(), 2300, "ApoZLd", 2, 1));			
//		listeEncheres.add(new AccueilDashboardTile("Rocket stove pour riz et pates", 
//				LocalDateTime.of(2018, 4, 3, 23, 26).toString(), 10, "Fcatin", 3, 2));		
	}
	/**
	 * Methode qui permet de recuperer tous les articles avec le vendeur
	 * @deprecated
	 * @return
	 */
	@GET
	public List<AccueilDashboardTile> getListeEncheres() {
		EncheresManager enchereManager = new EncheresManager();
		try {
			
				List<AccueilDashboardTile> listeDashboardsTiles= new ArrayList<AccueilDashboardTile>();
		      Set<Entry<ArticleVendu, Utilisateur>> entrySet = enchereManager.getListeEncheresAccueilWithoutParameters().entrySet();
		      Iterator<Entry<ArticleVendu, Utilisateur>> iterator = entrySet.iterator();
		      while(iterator.hasNext()){
		         Entry<ArticleVendu, Utilisateur> entry = iterator.next();
		         listeDashboardsTiles.add(new AccueilDashboardTile(
		        		 entry.getKey().getNomArticle(), 
		        		 entry.getKey().getDateFinEncheres().toString(),
		        		 (int) entry.getKey().getPrixVente(),
		        		 entry.getValue().getPseudo(),
		        		 entry.getValue().getNoUtilisateur(),
		        		 entry.getKey().getNoArticle(),
		        		 entry.getKey().getChemin_image()
		        		 )
        		 );
		      }
			return listeDashboardsTiles;
		} catch (BLLException e) {
			return null;
		}
	}
	/**
	 * Methode qui gere la soumission du formulaire de l'accueil avec filtres
	 * @param nameFilter
	 * @param noCategorie
	 * @param radioButtons
	 * @param enchereOuverte
	 * @param encheresEnCours
	 * @param encheresRemportees
	 * @param ventesEnCours
	 * @param ventesNonDebutees
	 * @param ventesTerminees
	 * @param idUtilisateur
	 * @return
	 */
	@SuppressWarnings("unused")
	@POST
	public List<AccueilDashboardTile> getListeEncheresWithParams(
													@FormParam("nameFilter") String nameFilter,
													@FormParam("categorie") Integer noCategorie,
													@FormParam("radioButtons") String radioButtons,
													@FormParam("encheresOuvertes") String enchereOuverte,
													@FormParam("encheresEnCours") String encheresEnCours,
													@FormParam("encheresRemportees") String encheresRemportees,
													@FormParam("ventesEnCours") String ventesEnCours,
													@FormParam("ventesNonDebutees") String ventesNonDebutees,
													@FormParam("ventesTerminees") String ventesTerminees,
													@CookieParam("idUtilisateur") Integer idUtilisateur
													) {
		
		Boolean enchereOuverteChecked = enchereOuverte != null ? enchereOuverte.equals("on") ? true: false : false;
		Boolean encheresEnCoursChecked = encheresEnCours != null ? encheresEnCours.equals("on") ? true: false : false;
		Boolean encheresRemporteesChecked = encheresRemportees != null ? encheresRemportees.equals("on") ? true: false : false;
		Boolean ventesEnCoursChecked = ventesEnCours != null ? ventesEnCours.equals("on") ? true: false : false;
		Boolean ventesNonDebuteesChecked = ventesNonDebutees != null ? ventesNonDebutees.equals("on") ? true: false : false;
		Boolean ventesTermineesChecked = ventesTerminees  != null ? ventesTerminees.equals("on") ? true: false : false;
		
		if(nameFilter == null) { 
			nameFilter = "";
		}
		if(radioButtons == null) {
			radioButtons = "";
		}
		if(noCategorie == null) {
			noCategorie = -1;
		}
		if(idUtilisateur == null) {
			idUtilisateur = -1;
		}
		Pattern patternNameFilter = Pattern.compile("^(\\w(\\w|\\s)*\\w)|(\\w)$"); // il faut echapper les '\'
	    Matcher matcherNameFilter = patternNameFilter.matcher(nameFilter);
	    
	    Pattern patternRadioBtn = Pattern.compile("^(mesVentes|mesAchats)$"); // il faut echapper les '\'
	    Matcher matcherRadioBtn = patternRadioBtn.matcher(radioButtons);
	    
		if ( (matcherNameFilter.matches() || nameFilter.equals("")) &&
				(matcherRadioBtn.matches() || radioButtons.equals("")) ) {
			AccueilFilters filtresAccueil = 
					new AccueilFilters(	nameFilter, 
							noCategorie, 
							radioButtons, 
							enchereOuverteChecked, 
							encheresEnCoursChecked, 
							encheresRemporteesChecked, 
							ventesEnCoursChecked, 
							ventesNonDebuteesChecked, 
							ventesTermineesChecked );
			
			
			EncheresManager enchereManager = new EncheresManager();
			try {
				List<AccueilDashboardTile> listeDashboardsTiles= new ArrayList<AccueilDashboardTile>();
			      Set<Entry<ArticleVendu, Utilisateur>> entrySet = enchereManager.getListArticlesWithSellerWithFilters(filtresAccueil, idUtilisateur).entrySet();
			      Iterator<Entry<ArticleVendu, Utilisateur>> iterator = entrySet.iterator();
			      while(iterator.hasNext()){
			         Entry<ArticleVendu, Utilisateur> entry = iterator.next();
			         listeDashboardsTiles.add(new AccueilDashboardTile(
			        		 entry.getKey().getNomArticle(), 
			        		 entry.getKey().getDateFinEncheres().toString(),
			        		 (int) entry.getKey().getPrixVente(),
			        		 entry.getValue().getPseudo(),
			        		 entry.getValue().getNoUtilisateur(),
			        		 entry.getKey().getNoArticle(),
			        		 entry.getKey().getChemin_image()
			        		 )
	        		 );
			      }
			      return listeDashboardsTiles;
			} catch (BLLException e) {
				throw new InternalServerErrorException();
			}			
		} else {
			throw new BadRequestException();
		}
	}

}