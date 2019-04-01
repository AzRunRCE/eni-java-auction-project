package fr.eni.ecole.beans;

import microsoft.sql.DateTimeOffset;

public class Enchere {
	DateTimeOffset date;
	float montant;
	public DateTimeOffset getDate() {
		return date;
	}
	public void setDate(DateTimeOffset date) {
		this.date = date;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	
}
