package fr.eni.ecole.DAL;



public class DAOFactory {
	
	public static IDAOUtilisateur getUtilisateurDAO() {
		return new UtilisateurDAO();
	}
	public static IDAOEnchere getEnchereDAO() {
		return new EnchereDAO();
	}
}
