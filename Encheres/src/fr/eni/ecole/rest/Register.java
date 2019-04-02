package fr.eni.ecole.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.eni.ecole.beans.Utilisateur;

public class Register {
	@Path("/utilisateur")
	@GET
	public void getUtilisateurs(Utilisateur user ) {
	  System.out.println("");
	  return;
	}
}
