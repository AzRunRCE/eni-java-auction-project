package fr.eni.ecole.bll;

import java.util.List;

import fr.eni.ecole.DAL.DALException;
import fr.eni.ecole.DAL.DAOFactory;
import fr.eni.ecole.DAL.IDAOEnchere;
import fr.eni.ecole.beans.Utilisateur;
import fr.eni.ecole.rest.mo.getAccueil;


public class EncheresManager {
	IDAOEnchere daoEncheres = DAOFactory.getEnchereDAO();
	
	public List<getAccueil> getListeEncheresAccueil() {
		return daoEncheres.selectAllWithoutParameters();
	}
}
