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
public class getDetailEnchere implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomArticle, descriptionArticle, nomCategorie, pseudoUtilisateur;
	private String codePostalRetrait, rueRetrait, villeRetrait;
	private LocalDateTime dateFinEnchere;
	private int prixInitial, montantEnchere, noArticle, noAcheteur, noVendeur;
	
	/**
	 * Constructeur par defaut
	 */
	public getDetailEnchere() {
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
	public getDetailEnchere(String nomArticle, String descriptionArticle, String nomCategorie, String pseudoUtilisateur,
			String codePostalRetrait, String rueRetrait, String villeRetrait, LocalDateTime dateFinEnchere,
			int prixInitial, int montantEnchere, int noArticle,int noAcheteur, int noVendeur ) {
		setNomArticle(nomArticle);
		setDescriptionArticle(descriptionArticle);
		setNomCategorie(nomCategorie);
		setPseudoUtilisateur(pseudoUtilisateur);
		setCodePostalRetrait(codePostalRetrait);
		setRueRetrait(rueRetrait);
		setVilleRetrait(villeRetrait);
		setDateFinEnchere(dateFinEnchere);
		setPrixInitial(prixInitial);
		setMontantEnchere(montantEnchere);
		setNoArticle(noArticle);
		setNoAcheteur(noAcheteur);
		setNoVendeur(noVendeur);
		
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
	 * @return the noUtilisaeur
	 */
	public int getNoAchateur() {
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
	
	
	
	
	
	
	
	
}
