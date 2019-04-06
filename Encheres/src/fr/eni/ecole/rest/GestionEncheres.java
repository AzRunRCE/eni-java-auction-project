package fr.eni.ecole.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import fr.eni.ecole.bll.EncheresManager;
import fr.eni.ecole.rest.mo.AccueilFilters;
import fr.eni.ecole.rest.mo.AccueilDashboardTile;
/**
 * webservice rest qui gere les encheres
 * @author romai
 *
 */
@Path("/enchere")
public class GestionEncheres {

	private static List<AccueilDashboardTile> listeEncheres;
	
	static {
		listeEncheres = new ArrayList<>();
		listeEncheres.add(new AccueilDashboardTile("pc gamer pour travailler", 
				LocalDateTime.of(2018, 4, 3, 23, 24).toString(), 2300, "ApoZLd", 2, 1));			
		listeEncheres.add(new AccueilDashboardTile("Rocket stove pour riz et pates", 
				LocalDateTime.of(2018, 4, 3, 23, 26).toString(), 10, "Fcatin", 3, 2));		
	}
	
	@GET
	public List<AccueilDashboardTile> getListeEncheres() {
		// Find the HttpSession
		EncheresManager enchereManager = new EncheresManager();
		return enchereManager.getListeEncheresAccueilWithoutParameters();
	}
	@POST
	public List<AccueilDashboardTile> getListeEncheresWithParams(
													@FormParam("nameFilter") String nameFilter,
													@FormParam("categorie") int noCategorie,
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
		
//		System.out.println("nameFilter " + nameFilter);
//		System.out.println("noCategorie " + noCategorie);
//		System.out.println("radioButtons " + radioButtons);
//		System.out.println("enchereOuverteChecked " + enchereOuverteChecked);
//		System.out.println("encheresEnCoursChecked " + encheresEnCoursChecked);
//		System.out.println("encheresRemporteesChecked " + encheresRemporteesChecked);
//		System.out.println("ventesEnCoursChecked " + ventesEnCoursChecked);
//		System.out.println("ventesNonDebuteesChecked " + ventesNonDebuteesChecked);
//		System.out.println("ventesTermineesChecked " + ventesTermineesChecked);
		
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
		
		System.out.println(idUtilisateur);
		
		EncheresManager enchereManager = new EncheresManager();
		return enchereManager.getListeEncheresAccueilWithParameters(filtresAccueil, idUtilisateur);
	}

}