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
	int no_article;
	
	public int getNo_article() {
		return no_article;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
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
	public Retrait(int no_article, String rue, String codePostal, String ville) {
		this.setRue(rue);
		this.setCode_postal(codePostal);
		this.setVille(ville);
	}
	
}
