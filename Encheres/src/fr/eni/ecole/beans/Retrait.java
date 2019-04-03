package fr.eni.ecole.beans;

import java.io.Serializable;

public class Retrait implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5875689693896847177L;
	String rue;
	String code_postal;
	String ville;
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Retrait() {
		super();
	}
	
}
