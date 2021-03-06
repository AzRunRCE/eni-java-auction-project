/**
 * 
 */
package fr.eni.ecole.rest.mo;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @author fcatin2018
 *
 */
public class DetailEnchere implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomArticle, descriptionArticle, nomCategorie, pseudoUtilisateur, chemin_image;
	private String codePostalRetrait, rueRetrait, villeRetrait;
	private LocalDateTime dateDebutEnchere, dateFinEnchere;
	private int prixInitial, montantEnchere, prixVente, noArticle, noAcheteur, noVendeur;
	
	/**
	 * Constructeur par defaut
	 */
	public DetailEnchere() {
		super();
	}

/**
 * 
 * @param nomArticle
 * @param descriptionArticle
 * @param nomCategorie
 * @param pseudoUtilisateur
 * @param codePostalRetrait
 * @param rueRetrait
 * @param villeRetrait
 * @param dateFinEnchere
 * @param prixInitial
 * @param montantEnchere
 * @param noArticle
 * @param noAcheteur
 * @param noVendeur
 */
	public DetailEnchere(String nomArticle, String descriptionArticle, String nomCategorie, String pseudoUtilisateur,
			String codePostalRetrait, String rueRetrait, String villeRetrait,LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere,
			int prixInitial, int montantEnchere, int noArticle,int noAcheteur, int noVendeur ) {
		setNomArticle(nomArticle);
		setDescriptionArticle(descriptionArticle);
		setNomCategorie(nomCategorie);
		setPseudoUtilisateur(pseudoUtilisateur);
		setCodePostalRetrait(codePostalRetrait);
		setRueRetrait(rueRetrait);
		setVilleRetrait(villeRetrait);
		setDateDebutEnchere(dateDebutEnchere);
		setDateFinEnchere(dateFinEnchere);
		setPrixInitial(prixInitial);
		setMontantEnchere(montantEnchere);
		setNoArticle(noArticle);
		setNoAcheteur(noAcheteur);
		setNoVendeur(noVendeur);
		
	}
	
	/**
	 * 
	 * @param nomArticle
	 * @param descriptionArticle
	 * @param nomCategorie
	 * @param pseudoUtilisateur
	 * @param codePostalRetrait
	 * @param rueRetrait
	 * @param villeRetrait
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param noArticle
	 * @param noVendeur
	 */
	public DetailEnchere(String nomArticle, String descriptionArticle, String nomCategorie, String pseudoUtilisateur,
			String codePostalRetrait, String rueRetrait, String villeRetrait, LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere,
			int prixInitial, int prixVente, int noArticle, int noVendeur ) {
		setNomArticle(nomArticle);
		setDescriptionArticle(descriptionArticle);
		setNomCategorie(nomCategorie);
		setPseudoUtilisateur(pseudoUtilisateur);
		setCodePostalRetrait(codePostalRetrait);
		setRueRetrait(rueRetrait);
		setVilleRetrait(villeRetrait);
		setDateDebutEnchere(dateDebutEnchere);
		setDateFinEnchere(dateFinEnchere);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setNoArticle(noArticle);
		setNoVendeur(noVendeur);
		
	}
	
	/**
	 * 
	 * @param nomArticle
	 * @param descriptionArticle
	 * @param nomCategorie
	 * @param pseudoUtilisateur
	 * @param codePostalRetrait
	 * @param rueRetrait
	 * @param villeRetrait
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param montantEnchere
	 * @param noArticle
	 * @param noAcheteur
	 * @param noVendeur
	 * @param chemin_image
	 */
	public DetailEnchere(String nomArticle, String descriptionArticle, String nomCategorie, String pseudoUtilisateur,
			String codePostalRetrait, String rueRetrait, String villeRetrait,LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere,
			int prixInitial, int montantEnchere, int noArticle,int noAcheteur, int noVendeur, String chemin_image) {
		setNomArticle(nomArticle);
		setDescriptionArticle(descriptionArticle);
		setNomCategorie(nomCategorie);
		setPseudoUtilisateur(pseudoUtilisateur);
		setCodePostalRetrait(codePostalRetrait);
		setRueRetrait(rueRetrait);
		setVilleRetrait(villeRetrait);
		setDateDebutEnchere(dateDebutEnchere);
		setDateFinEnchere(dateFinEnchere);
		setPrixInitial(prixInitial);
		setMontantEnchere(montantEnchere);
		setNoArticle(noArticle);
		setNoAcheteur(noAcheteur);
		setNoVendeur(noVendeur);
		setChemin_image(chemin_image);
		
	}
	
	/**
	 * 
	 * @param nomArticle
	 * @param descriptionArticle
	 * @param nomCategorie 
	 * @param pseudoUtilisateur
	 * @param codePostalRetrait
	 * @param rueRetrait
	 * @param villeRetrait
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param noArticle
	 * @param noVendeur
	 * @param chemin_image
	 */
	public DetailEnchere(String nomArticle, String descriptionArticle, String nomCategorie, String pseudoUtilisateur,
			String codePostalRetrait, String rueRetrait, String villeRetrait, LocalDateTime dateDebutEnchere, LocalDateTime dateFinEnchere,
			int prixInitial, int prixVente, int noArticle, int noVendeur, String chemin_image ) {
		setNomArticle(nomArticle);
		setDescriptionArticle(descriptionArticle);
		setNomCategorie(nomCategorie);
		setPseudoUtilisateur(pseudoUtilisateur);
		setCodePostalRetrait(codePostalRetrait);
		setRueRetrait(rueRetrait);
		setVilleRetrait(villeRetrait);
		setDateDebutEnchere(dateDebutEnchere);
		setDateFinEnchere(dateFinEnchere);
		setPrixInitial(prixInitial);
		setPrixVente(prixVente);
		setNoArticle(noArticle);
		setNoVendeur(noVendeur);
		setChemin_image(chemin_image);
	}

	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * @return the descriptionArticle
	 */
	public String getDescriptionArticle() {
		return descriptionArticle;
	}

	/**
	 * @param descriptionArticle the descriptionArticle to set
	 */
	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}

	/**
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * @param nomCategorie the nomCategorie to set
	 */
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	/**
	 * @return the pseudoUtilisateur
	 */
	public String getPseudoUtilisateur() {
		return pseudoUtilisateur;
	}

	/**
	 * @param pseudoUtilisateur the pseudoUtilisateur to set
	 */
	public void setPseudoUtilisateur(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	}

	/**
	 * @return the codePostalRetrait
	 */
	public String getCodePostalRetrait() {
		return codePostalRetrait;
	}

	/**
	 * @param codePostalRetrait the codePostalRetrait to set
	 */
	public void setCodePostalRetrait(String codePostalRetrait) {
		this.codePostalRetrait = codePostalRetrait;
	}

	/**
	 * @return the rueRetrait
	 */
	public String getRueRetrait() {
		return rueRetrait;
	}

	/**
	 * @param rueRetrait the rueRetrait to set
	 */
	public void setRueRetrait(String rueRetrait) {
		this.rueRetrait = rueRetrait;
	}

	/**
	 * @return the villeRetrait
	 */
	public String getVilleRetrait() {
		return villeRetrait;
	}

	/**
	 * @param villeRetrait the villeRetrait to set
	 */
	public void setVilleRetrait(String villeRetrait) {
		this.villeRetrait = villeRetrait;
	}

	/**
	 * @return the dateFinEnchere
	 */
	public LocalDateTime getDateFinEnchere() {
		return dateFinEnchere;
	}

	/**
	 * @param dateFinEnchere the dateFinEnchere to set
	 */
	public void setDateFinEnchere(LocalDateTime dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	/**
	 * @return the prixInitial
	 */
	public int getPrixInitial() {
		return prixInitial;
	}

	/**
	 * @param prixInitial the prixInitial to set
	 */
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	/**
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * @return the noAcheteur
	 */
	public int getNoAcheteur() {
		return noAcheteur;
	}
	
	/**
	 * @param noAcheteur the noAcheteur to set
	 */
	public void setNoAcheteur(int noAcheteur) {
		this.noAcheteur = noAcheteur;
	}

	/**
	 * @return the noVendeur
	 */
	public int getNoVendeur() {
		return noVendeur;
	}

	/**
	 * @param noVendeur the noVendeur to set
	 */
	public void setNoVendeur(int noVendeur) {
		this.noVendeur = noVendeur;
	}

	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	/**
	 * @return the dateDebutEncheres
	 */
	public LocalDateTime getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEnchere(LocalDateTime dateDebutEncheres) {
		this.dateDebutEnchere = dateDebutEncheres;
	}

	/**
	 * @return the chemin_image
	 */
	public String getChemin_image() {
		return chemin_image;
	}

	/**
	 * @param chemin_image the chemin_image to set
	 */
	public void setChemin_image(String chemin_image) {
		this.chemin_image = chemin_image;
	}

	
	
	
	
	
	
	
	
	
}
