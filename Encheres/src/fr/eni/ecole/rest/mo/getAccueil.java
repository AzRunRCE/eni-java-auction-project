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
	


	public getAccueil(String nomProduit, LocalDateTime dateFinEnchere, Integer montant, String nomVendeur) {
		super();
		this.nomProduit = nomProduit;
		this.dateFinEnchere = dateFinEnchere;
		this.montant = montant;
		this.pseudoVendeur = nomVendeur;
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




	public getAccueil() {
		super();
	}
	
	
	
}
