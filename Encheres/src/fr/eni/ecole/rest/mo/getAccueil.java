package fr.eni.ecole.rest.mo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class getAccueil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8844648449092072102L;
	
	private String nomProduit;
	private LocalDateTime dateFinEnchere;
	private Integer montant;
	private String pseudoVendeur;
	private Integer noVendeur;
	private Integer noArticle;
	private transient String photo; //base64
	

	public Integer getNoVendeur() {
		return noVendeur;
	}




	public void setNoVendeur(Integer noVendeur) {
		this.noVendeur = noVendeur;
	}

	
	
	public String  getPhoto() {
		return photo;
	}




	public Integer getNoArticle() {
		return noArticle;
	}




	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}




	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getNomProduit() {
		return nomProduit;
	}




	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}




	public LocalDateTime getDateFinEnchere() {
		return dateFinEnchere;
	}




	public void setDateFinEnchere(LocalDateTime dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}




	public Integer getMontant() {
		return montant;
	}




	public void setMontant(Integer montant) {
		this.montant = montant;
	}




	public String getPseudoVendeur() {
		return pseudoVendeur;
	}




	public void setPseudoVendeur(String pseudoVendeur) {
		this.pseudoVendeur = pseudoVendeur;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public getAccueil(String nomProduit, LocalDateTime dateFinEnchere, Integer montant, String pseudoVendeur,
			Integer noVendeur, Integer noArticle) {
		super();
		this.nomProduit = nomProduit;
		this.dateFinEnchere = dateFinEnchere;
		this.montant = montant;
		this.pseudoVendeur = pseudoVendeur;
		this.noVendeur = noVendeur;
		this.noArticle = noArticle;
	}




	public getAccueil(String nomProduit, LocalDateTime dateFinEnchere, Integer montant, String pseudoVendeur,
			Integer noVendeur, Integer noArticle, String photo) {
		super();
		this.nomProduit = nomProduit;
		this.dateFinEnchere = dateFinEnchere;
		this.montant = montant;
		this.pseudoVendeur = pseudoVendeur;
		this.noVendeur = noVendeur;
		this.noArticle = noArticle;
		this.photo = photo;
	}




	public getAccueil() {
		super();
	}
	
	
	
}
