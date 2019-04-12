package fr.eni.ecole.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Enchere implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -938194704855814866L;
	
	LocalDateTime date;
	int montantEnchere;
	Utilisateur acheteur;
	
	public Enchere(LocalDateTime date, int montantEnchere, Utilisateur acheteur) {
		setDate(date);
		setMontantEnchere(montantEnchere);
		setAcheteur(acheteur);
	}
	
	public Enchere() {
		super();
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public int getMontantEnchere() {
		return montantEnchere;
	}
	
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @return the acheteur
	 */
	public Utilisateur getAcheteur() {
		return acheteur;
	}

	/**
	 * @param acheteur the acheteur to set
	 */
	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	
	
	
}
