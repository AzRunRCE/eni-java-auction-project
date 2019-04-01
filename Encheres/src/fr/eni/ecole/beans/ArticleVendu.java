package fr.eni.ecole.beans;

import microsoft.sql.DateTimeOffset;

public class ArticleVendu {
	int noArticle;
	String nomArticle;
	String description;
	DateTimeOffset dateDebutEncheres;
	DateTimeOffset dateFinEncheres;
	float miseAPrix;
	float prixVente;
	Boolean etatVente;
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
	public DateTimeOffset getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(DateTimeOffset dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public DateTimeOffset getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(DateTimeOffset dateFinEncheres) {
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
}
