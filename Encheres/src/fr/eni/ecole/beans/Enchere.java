package fr.eni.ecole.beans;

import java.time.LocalDateTime;

public class Enchere {
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
	
}
