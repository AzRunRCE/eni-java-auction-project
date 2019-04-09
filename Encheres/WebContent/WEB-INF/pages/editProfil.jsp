<%@page import="fr.eni.ecole.beans.Utilisateur"%>
<%@page import="fr.eni.ecole.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<jsp:include page="../fragments/header.jsp" ></jsp:include>
<div class="container">
	<h2>Mon profil</h2>
	
	<form id="EditProfilForm"  class="form-inline m-4" action="EditProfil" method="POST">
	
		<div class="col-md-6">
		  <div class="form-group row p-2">
		    <label for="inputPrenom" class="justify-content-start control-label col-5">Prenom</label>
		    <input required="required" type="text" value="<c:out value="${utilisateur.getPrenom()}"></c:out>" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPrenom" id="inputPrenom" placeholder="Entrez votre prenom">
		   </div>
		  <div class="form-group row  p-2">
		    <label for="inputSpeudo" class="justify-content-start control-label col-5">Pseudo</label>
			    <input required="required" type="text" value="<c:out value="${utilisateur.getPseudo()}"></c:out>" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPseudo" id="inputPseudo" placeholder="Entrez votre pseudo">
		    </div>
		    <div class="form-group row  p-2">
		    	<label for="inputTelephone" class="justify-content-start control-label col-5">Telephone</label>
			    <input required="required" type="text" value="<c:out value="${utilisateur.getTelephone()}"></c:out>" class="form-control col-7" name="inputTelephone" id="inputTelephone" placeholder="Entrez votre numéro de téléphone">
		 	</div>
		   <div class="form-group row  p-2">
		    <label for="inputCodePostal" class="justify-content-start control-label col-5">Code Postal</label>
		    		<input required="required" type="text" value="<c:out value="${utilisateur.getCodePostal()}"></c:out>" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" id="inputCodePostal"  name="inputCodePostal" placeholder=" Entrez votre code postal">
	  		</div>
	  		
	  	<div class="form-group row p-2">
		    <label for="inputPassword" class="justify-content-start control-label col-5">Mot de passe</label>
		    	<input type="password" class="form-control col-7" id="inputCurrentPassword"   name="inputPassword" placeholder="Entrez votre mot de passe actuel">
		  </div>
		  <div class="form-group row p-2">
		    <label for="inputPassword" class="justify-content-start control-label col-5">Nouveau mot de passe</label>
		    	<input  type="password" class="form-control col-7" id="inputPassword"   name="inputPassword" placeholder="Entrez votre nouveau mot de passe">
		  </div>
		   <div class="form-group row p-2">
		    <label for="InputCredit" class="justify-content-start control-label col-5">Credit: <c:out value="${utilisateur.getCredit()}"></c:out></label>
		  </div>
		</div>
		
		<div class="col-md-6">
	
	  <div class="form-group row p-2">
	    	<label for="inputNom" class="justify-content-start control-label col-5">Nom</label>
		    <input required="required" type="text" class="form-control col-7" id="inputNom" value="<c:out value="${utilisateur.getNom()}"></c:out>"  name="inputNom" placeholder="Entrez votre nom">
	   </div>
	   <div class="form-group row p-2">
		    <label for="inputEmail" class="justify-content-start control-label col-5">Email address</label>
		    <input  required="required" type="email" class="form-control col-7" id="inputEmail" value="<c:out value="${utilisateur.getEmail()}"></c:out>"   name="inputEmail"aria-describedby="emailHelp" placeholder="Entrez votre email">
		</div>
	   <div class="form-group row p-2">
	    	<label for="inputRue" class="justify-content-start control-label col-5">Rue</label>
	    	<input required="required" type="text" class="form-control col-7" id="inputRue"  value="<c:out value="${utilisateur.getRue()}"></c:out>" name="inputRue" placeholder="Entrez votre rue">
	  </div>
	  
	  <div class="form-group row p-2">
	    <label for="inputVille" class="justify-content-start control-label col-5">Ville</label>	
	    <input required="required" type="text" class="form-control col-7" id="inputVille" value="<c:out value="${utilisateur.getVille()}"></c:out>"  name="inputVille" placeholder="Entrez votre ville">
	  </div>
	
	 	<br><br>
	  	<div class="form-group row p-md-2"> 
		   	<label for="inputConfirmationPassword"  class="justify-content-start control-label col-5">Confirmation</label>
		    <input type="password" class="form-control col-7" id="inputConfirmationPassword"   name="inputConfirmationPassword" placeholder="Entrez à nouveau votre mot de passe ">
		</div>
		
		</div>
		 
		
	
		<div class="col-12">
	  	<div class="d-flex justify-content-center">
	     	<button type="submit" class="btn btn-success p-2 m-2">Enregistrer</button>                   
	       	<button type="button" id="deleteAccountBtn" class="btn btn-danger  p-2 m-2">Suprimer mon compte</button>      
	    </div>
	
		</div>
		
	</form>
		
	<form id="deleteAccountForm" style="display:none;" action="EditProfil" method="POST">
		 <input type="hidden" style="display:none;" value="true"  name="inputDeleteAccount">
	</form>	
</div>
<script>

$( "#deleteAccountBtn" ).click(function() {
	 $("#deleteAccountForm").submit();
	});

var password = document.getElementById("inputPassword")
, confirm_password = document.getElementById("inputConfirmationPassword");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Les mot de passes de correspondent pas.");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
</div>
<jsp:include page="../fragments/footer.jsp" ></jsp:include>