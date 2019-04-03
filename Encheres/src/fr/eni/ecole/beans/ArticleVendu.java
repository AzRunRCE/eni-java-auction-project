package fr.eni.ecole.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ArticleVendu implements Serializable {
	int noArticle;
	String nomArticle;
	String description;
	LocalDateTime dateDebutEncheres;
	LocalDateTime dateFinEncheres;
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
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, float miseAPrix, float prixVente, Boolean etatVente) {
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
