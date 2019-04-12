package fr.eni.ecole.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ArticleVendu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5072954489557878512L;
	int noArticle;
	String nomArticle;
	String description;
	LocalDateTime dateDebutEncheres;
	LocalDateTime dateFinEncheres;
	int miseAPrix;
	int prixVente;
	Boolean etatVente;
	Utilisateur vendeur;
	Categorie categorie;
	Retrait retrait;
	String chemin_image;
	
	public ArticleVendu() {
		super();
	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, Boolean etatVente, String chemin_image) {
		setNoArticle(noArticle);
		setNomArticle(nomArticle);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setMiseAPrix(miseAPrix);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
		setChemin_image(chemin_image);
	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, Boolean etatVente, String chemin_image, 
			Utilisateur vendeur, Retrait retrait) {
		setNoArticle(noArticle);
		setNomArticle(nomArticle);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setMiseAPrix(miseAPrix);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
		setChemin_image(chemin_image);
		setVendeur(vendeur);
		setRetrait(retrait);
	}
	
	
	public String getChemin_image() {
		return chemin_image;
	}
	
	public void setChemin_image(String chemin_image) {
		this.chemin_image = chemin_image;
	}
	
	public Retrait getRetrait() {
		return retrait;
	}
	
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Utilisateur getVendeur() {
		return vendeur;
	}
	
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	
	public int getNoArticle() {
		return noArticle;
	}
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	
	public String getNomArticle() {
		return nomArticle;
	}
	
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	
	public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}
	
	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	public int getMiseAPrix() {
		return miseAPrix;
	}
	
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	public int getPrixVente() {
		return prixVente;
	}
	
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	
	public Boolean getEtatVente() {
		return etatVente;
	}
	
	public void setEtatVente(Boolean etatVente) {
		this.etatVente = etatVente;
	}
	
	
	
}
