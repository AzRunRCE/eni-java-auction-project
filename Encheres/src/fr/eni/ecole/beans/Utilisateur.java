/**
 * 
 */
package fr.eni.ecole.beans;

/**
 * @author fcatin2018
 *
 */
public class Utilisateur {

	int noUtilisateur;
	String pseudo;
	String nom;
	String prenom;
	String email;
	String telephone;
	String rue;
	String codePostal;
	String ville;
	String motDePasse;
	int credit;
	Boolean administrateur;
	
	
	
	/**
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, Boolean administrateur) {
		setNoUtilisateur(noUtilisateur);
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
	}
	
	/**
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, Boolean administrateur) {
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePastal) {
		this.codePostal = codePastal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
}
