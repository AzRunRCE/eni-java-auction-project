package fr.eni.ecole.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ArticleVendu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5072954489557878512L;
	int noArticle;
	String nomArticle;
	String description;
	Timestamp dateDebutEncheres;
	Timestamp dateFinEncheres;
	float miseAPrix;
	float prixVente;
	Boolean etatVente;
	Utilisateur utilisateur;
	Categorie categorie;
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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
	public Timestamp getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(Timestamp dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public Timestamp getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(Timestamp dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public float getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(float miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public float getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}
	public Boolean getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(Boolean etatVente) {
		this.etatVente = etatVente;
	}
	public ArticleVendu(int noArticle, String nomArticle, String description, Timestamp dateDebutEncheres,
			Timestamp dateFinEncheres, float miseAPrix, float prixVente, Boolean etatVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	public ArticleVendu() {
		super();
	}
	
}
