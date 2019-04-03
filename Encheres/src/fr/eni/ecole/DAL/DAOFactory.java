package fr.eni.ecole.DAL;



public class DAOFactory {
	
	public static IDAOUtilisateur getUtilisateurDAO(){
		
		return new UtilisateurDAO();
	}
}
