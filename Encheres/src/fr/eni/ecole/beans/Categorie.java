package fr.eni.ecole.beans;

import java.io.Serializable;

public class Categorie implements Serializable {

	private static final long serialVersionUID = 3839273316939483795L;
	int noCategorie;
	String libelle;
	/**
	 * 
	 * @return
	 */
	public int getNoCategorie() {
		return noCategorie;
	}
	/**
	 * 
	 * @param noCategorie
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	/**
	 * 
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * 
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	/**
	 * 
	 */
	public Categorie() {
		super();
	}
	
}
