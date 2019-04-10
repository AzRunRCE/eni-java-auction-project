package fr.eni.ecole.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.bll.BLLException;
import fr.eni.ecole.bll.EncheresManager;
import fr.eni.ecole.bll.UtilisateursManager;
import fr.eni.ecole.bll.VentesManager;
import fr.eni.ecole.rest.mo.DetailEnchere;
import fr.eni.ecole.util.Constantes;

/**
 * Servlet implementation class DetailVente
 */
@WebServlet("/DetailVente")
public class DetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailVente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recupNoArticle;
		EncheresManager managerEnchere = null;
		DetailEnchere enchere = null;
		UtilisateursManager managerUtilisiateur = null;
		Utilisateur vendeur = null;
		Utilisateur acheteur = null;
		String pseudoVendeur = null;
		int creditAcheteur;
		
		recupNoArticle = Integer.parseInt(request.getParameter("noArticle"));
		managerEnchere = new EncheresManager();
		try {
			enchere = managerEnchere.getEnchere(recupNoArticle);
			if(enchere != null) {
				request.setAttribute("nomArticle", enchere.getNomArticle());
				request.setAttribute("description", enchere.getDescriptionArticle());
				request.setAttribute("categorie", enchere.getNomCategorie());
				request.setAttribute("pseudoAcheteur", enchere.getPseudoUtilisateur());
				request.setAttribute("codePostalRetrait", enchere.getCodePostalRetrait());
				request.setAttribute("rueRetrait", enchere.getRueRetrait());
				request.setAttribute("villeRetrait", enchere.getVilleRetrait());
				request.setAttribute("dateDebutEnchere", enchere.getDateDebutEnchere());
				request.setAttribute("dateFinEnchere", enchere.getDateFinEnchere());
				request.setAttribute("prixInitial", enchere.getPrixInitial());
				request.setAttribute("montantEnchere", enchere.getMontantEnchere());
				request.setAttribute("noArticle", enchere.getNoArticle());
				request.setAttribute("noAcheteur", enchere.getNoAcheteur());
				request.setAttribute("noVendeur", enchere.getNoVendeur());
			}else {
				enchere = managerEnchere.getArticle(recupNoArticle);
				if(enchere != null) {
					request.setAttribute("nomArticle", enchere.getNomArticle());
					request.setAttribute("description", enchere.getDescriptionArticle());
					request.setAttribute("categorie", enchere.getNomCategorie());
					request.setAttribute("pseudoAcheteur", enchere.getPseudoUtilisateur());
					request.setAttribute("codePostalRetrait", enchere.getCodePostalRetrait());
					request.setAttribute("rueRetrait", enchere.getRueRetrait());
					request.setAttribute("villeRetrait", enchere.getVilleRetrait());
					request.setAttribute("dateDebutEnchere", enchere.getDateDebutEnchere());
					request.setAttribute("dateFinEnchere", enchere.getDateFinEnchere());
					request.setAttribute("prixInitial", enchere.getPrixInitial());
					request.setAttribute("montantEnchere", "0");
					request.setAttribute("noArticle", enchere.getNoArticle());
					request.setAttribute("noVendeur", enchere.getNoVendeur());
				}
			}
			if(enchere != null) {
				managerUtilisiateur = new UtilisateursManager();
				vendeur = managerUtilisiateur.getUtilisateur(enchere.getNoVendeur());
				pseudoVendeur = vendeur.getPseudo();
				if(request.getSession().getAttribute("no_utilisateur")!= null) {
					int noUtilisateur = (int) request.getSession().getAttribute("no_utilisateur");
					acheteur = managerUtilisiateur.getUtilisateur(noUtilisateur);
					creditAcheteur = acheteur.getCredit();
					request.setAttribute("credit", creditAcheteur);
				}
				request.setAttribute("pseudoVendeur", pseudoVendeur);
				request.setAttribute("date", LocalDateTime.now());
				request.getRequestDispatcher(Constantes.PAGE_DETAIL_VENTE).forward(request, response);
			}else {
				response.sendError(404);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nouveauMontant = null;
		int recupNouveauMontant;
		int recupAncienMontnant;
		int recupNoAncienAcheteur;
		int nouveauNoAcheteur;
		int recupNoVendeur;
		int recupNoArticle;
		int recupPrixInital;
		int deleteEnchere, newEnchere, newPrixVente, newCreditAncienAcheteur, newCreditNouveauAcheteur, newCreditVendeur, creditNouveauAcheteur, creditAncienAcheteur, creditVendeur;
		Utilisateur nouveauAcheteur = null;
		Utilisateur ancienAcheteur = null;
		Utilisateur vendeur = null;
		
		recupNoArticle = Integer.valueOf(request.getParameter("noArticle"));
		nouveauMontant = (request.getParameter("nouveauMontant"));
		if (nouveauMontant != null && nouveauMontant != "") {
			recupNouveauMontant = Integer.valueOf(request.getParameter("nouveauMontant"));
			recupPrixInital = Integer.valueOf(request.getParameter("prixInitial"));
			recupAncienMontnant = Integer.valueOf(request.getParameter("ancienMontant"));
			nouveauNoAcheteur = (int) request.getSession().getAttribute("no_utilisateur");
			if (recupNouveauMontant < recupPrixInital || recupNouveauMontant < recupAncienMontnant) {
				request.setAttribute("erreur", "Vous devez saisir un montant supérieur au prix initial ou à la meilleur offre");
				request.setAttribute("noArticle", recupNoArticle);
				doGet(request, response);
				
			}else {
				//on récupère les info du nouvel acheteur
				UtilisateursManager managerUtilisateurs = new UtilisateursManager();
				try {
					nouveauAcheteur = managerUtilisateurs.getUtilisateur(nouveauNoAcheteur);
					creditNouveauAcheteur = nouveauAcheteur.getCredit();
					
					if (recupNouveauMontant > creditNouveauAcheteur) {
						request.setAttribute("erreur", "Vous n'avez pas assez de credit pour faire une telle offre!");
						request.setAttribute("noArticle", recupNoArticle);
						doGet(request, response);
					}else {
						//on ajoute l'enchere a la base
						EncheresManager managerEncheres = new EncheresManager();
						deleteEnchere = managerEncheres.deleteEnchere(nouveauNoAcheteur, recupNoArticle);
						newEnchere = managerEncheres.createEnchere(nouveauNoAcheteur, recupNoArticle, recupNouveauMontant);
						//on met à jour le prix de vente
						VentesManager managerVentes = new VentesManager();
						newPrixVente = managerVentes.updatePrixVenteArticle(recupNoArticle, recupNouveauMontant);
						if(recupAncienMontnant != 0) {
							//on récupère les info de l'ancien acheteur et met à jour son credit
							recupNoAncienAcheteur = Integer.valueOf(request.getParameter("noAcheteur"));
							ancienAcheteur = managerUtilisateurs.getUtilisateur(recupNoAncienAcheteur);
							creditAncienAcheteur = ancienAcheteur.getCredit();
							creditAncienAcheteur += recupAncienMontnant;
							newCreditAncienAcheteur = managerUtilisateurs.updateCredit(recupNoAncienAcheteur, creditAncienAcheteur);
						}
						//on met à jour le credit du nouvel acheteur
						creditNouveauAcheteur -= recupNouveauMontant;
						newCreditNouveauAcheteur = managerUtilisateurs.updateCredit(nouveauNoAcheteur, creditNouveauAcheteur);
						//on récupère les info du vendeur et met à jour son credit
						recupNoVendeur = Integer.valueOf(request.getParameter("noVendeur"));
						vendeur = managerUtilisateurs.getUtilisateur(recupNoVendeur);
						creditVendeur = vendeur.getCredit();
						creditVendeur += recupNouveauMontant;
						newCreditVendeur = managerUtilisateurs.updateCredit(recupNoVendeur, creditVendeur);
						request.setAttribute("success", "Votre enchère a été prise en compte");
						request.setAttribute("noArticle", recupNoArticle);
						doGet(request, response);
					}
				
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		}else {
			request.setAttribute("erreur", "Vous devez saisir un montant supérieur au prix initial ou à la meilleur offre");
			request.setAttribute("noArticle", recupNoArticle);
			doGet(request, response);
		}	
	}
}


