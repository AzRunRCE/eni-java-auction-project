package fr.eni.ecole.DAL;



public class DAOFactory {
	
	public static IDAOUtilisateur getUtilisateurDAO() {
		return new UtilisateurDAO();
	}
	/**
	 * @return new EnchereDAO();
	 */
	public static IDAOEnchere getEnchereDAO() {
		return new EnchereDAO();
	}
	public static IDAOCategorie getCategorieDAO() {
		return new CategorieDAO();
	}
}
