package fr.eni.ecole.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Enchere implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -938194704855814866L;
	LocalDateTime date;
	float montant;
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public Enchere(LocalDateTime date, float montant) {
		super();
		this.date = date;
		this.montant = montant;
	}
	public Enchere() {
		super();
	}
	
}
