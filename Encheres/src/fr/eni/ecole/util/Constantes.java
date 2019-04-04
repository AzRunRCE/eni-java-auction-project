/**
 * 
 */
package fr.eni.ecole.util;

/**
 * @author fcatin2018
 *
 */
public class Constantes {

	//constantes de session
	public final static String SESS_NUM_UTILISATEUR = "no_utilisateur";
	//public final static String SESS_NOM = "nom";
	//public final static String SESS_PRENOM = "prenom";
	public final static String SESS_PSEUDO = "pseudo";
	
	//Url
	public static final String URL_LOGOUT =  "./EditProfil";
	public static final String URL_EDIT_PROFIL =  "./EditProfil";
	public static final String URL_PROFIL =  "./Profil";
	//pages
	private final static String PAGE_SOURCE = "/WEB-INF/pages/";
	public final static String PAGE_INDEX = PAGE_SOURCE + "index.jsp";
	public final static String PAGE_LOGIN = PAGE_SOURCE + "login.jsp";
	public final static String PAGE_REGISTER =  PAGE_SOURCE + "register.jsp";
	public static final String PAGE_PROFIL =  PAGE_SOURCE + "profil.jsp";
	public static final String PAGE_EDIT_PROFIL =  PAGE_SOURCE + "editProfil.jsp";
	public static final String PAGE_DETAIL_VENTE = PAGE_SOURCE + "detailVente.jsp";
	//attributs
	public final static String ATT_UTILISATEUR = "utilisateur";
	
	//Label & Message
	public final static String LBL_ERROR_REGISTER = "utilisateur";
	

}
