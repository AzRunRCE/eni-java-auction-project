<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<jsp:include page="../fragments/header.jsp" >
	<jsp:param value="Mon Profil" name="title"/>
</jsp:include>

<c:if test="${erreur != null}"> 
			<div class="alert alert-danger" role="alert">
		  		${erreur}
			</div>
</c:if>
<form id="registerForm"  class="form-inline m-4" action="Register" method="POST">

	<div class="col-md-6">
	  <div class="form-group row p-2">
	    <label for="inputPrenom" class="control-label col-5">Prenom</label>
	    <input required="required" type="text" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPrenom" id="inputPrenom" placeholder="Entrez votre prenom">
	   </div>
	  <div class="form-group row  p-2">
	    <label for="inputSpeudo" class="control-label col-5">Pseudo</label>
		    <input required="required" type="text" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPseudo" id="inputPseudo" placeholder="Entrez votre pseudo">
	    </div>
	    <div class="form-group row  p-2">
	    	<label for="inputTelephone" class="control-label col-5">Telephone</label>
		    <input required="required" type="text" class="form-control col-7" name="inputTelephone" id="inputTelephone" placeholder="Entrez votre numéro de téléphone">
	 	</div>
	   <div class="form-group row  p-2">
	    <label for="inputCodePostal" class="control-label col-5">Code Postal</label>
	    		<input required="required" type="text" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" id="inputCodePostal"  name="inputCodePostal" placeholder=" Entrez votre code postal">
  		</div>
	  <div class="form-group row p-2">
	    <label for="inputPassword" class="control-label col-5">Password</label>
	    	<input required="required" type="password" class="form-control col-7" id="inputPassword"   name="inputPassword" placeholder="Entrez votre mot de passe">
	  </div>
	</div>
	
	<div class="col-md-6">

  <div class="form-group row p-2">
    	<label for="inputNom" class="control-label col-5">Nom</label>
	    <input required="required" type="text" class="form-control col-7" id="inputNom"  name="inputNom" placeholder="Entrez votre nom">
   </div>
   <div class="form-group row p-2">
	    <label for="inputEmail" class="control-label col-5">Email address</label>
	    <input  required="required" type="email" class="form-control col-7" id="inputEmail"  name="inputEmail"aria-describedby="emailHelp" placeholder="Entrez votre email">
	</div>
   <div class="form-group row p-2">
    	<label for="inputRue" class="control-label col-5">Rue</label>
    	<input required="required" type="text" class="form-control col-7" id="inputRue"   name="inputRue" placeholder="Entrez votre rue">
  </div>
  
  <div class="form-group row p-2">
    <label for="inputVille" class="control-label col-5">Ville</label>	
    <input required="required" type="text" class="form-control col-7" id="inputVille"   name="inputVille" placeholder="Entrez votre ville">
  </div>


  	<div class="form-group row p-md-2"> 
	   	<label for="inputConfirmationPassword"  class="control-label col-5">Confirmation</label>
	    <input required="required" type="password" class="form-control col-7" id="inputConfirmationPassword"   name="inputConfirmationPassword" placeholder="Entrez à nouveau votre mot de passe ">
	</div>
	
	</div>
	 
	

	<div class="col-12">
  	<div class="d-flex justify-content-center">
     	<button type="submit" class="btn btn-success p-2 m-2">Créer</button>                   
       	<button type="button" class="btn btn-danger  p-2 m-2">Annuler</button>      
    </div>

	</div>
	
</form>
	
<script>
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
<style>


</style>
<jsp:include page="../fragments/footer.jsp" ></jsp:include>