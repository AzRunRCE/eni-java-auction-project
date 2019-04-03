package fr.eni.ecole.beans;

import java.io.Serializable;

public class Categorie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3839273316939483795L;
	int noCategorie;
	String libelle;
	
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Categorie() {
		super();
	}
	
}
