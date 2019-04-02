package fr.eni.ecole.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.eni.ecole.beans.Enchere;
import fr.eni.ecole.beans.Utilisateur;

@Path("/utilisateur")
public class GestionEncheres {

	private static List<Enchere> listeEncheres;
	
	static {
		Utilisateur user = new Utilisateur();
		user.addEnchere(new Enchere(LocalDateTime.of(2019, 4, 2, 12, 36), 1200));
		user.addEnchere(new Enchere(LocalDateTime.of(2019, 4, 2, 12, 37), 300));
		listeEncheres = user.getListeEnchere();
	}
	
	@GET
	public List<Enchere> getUtilisateurs() {
		return this.listeEncheres;
	}
	
}