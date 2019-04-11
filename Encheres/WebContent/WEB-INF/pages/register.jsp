<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<fmt:setBundle basename="fr.eni.ecole.messages.register" var="r"/>
<fmt:message key="msg.title" bundle="${r}" var="title"/>

<c:set var="title" scope="request" value="${ title }"/>
<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
	<h2>${ title }</h2>
	<hr>
	<c:if test="${erreur != null}"> 
				<div class="alert alert-danger" role="alert">
			  		${erreur}
				</div>
	</c:if>
	<form id="registerForm"  class="" action="Register" method="POST">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group row p-2">
			    	<label for="inputPrenom" class="control-label col-5">
						<fmt:message key="msg.first_name" bundle="${r}"></fmt:message>
					</label>
					<fmt:message key="msg.first_name_placeholder" bundle="${r}" var="first_name_placeholder"/>
			    	<input required="required" type="text" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPrenom" id="inputPrenom" placeholder="${ first_name_placeholder }">
				</div>
			 	<div class="form-group row  p-2">
			    	<label for="inputSpeudo" class="control-label col-5">
			    		<fmt:message key="msg.pseudo" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.pseudo_placeholder" bundle="${r}" var="pseudo_placeholder"/>
				    <input required="required" type="text" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPseudo" id="inputPseudo" placeholder="${ pseudo_placeholder }">
			    </div>
			    <div class="form-group row  p-2">
			    	<label for="inputTelephone" class="control-label col-5">
			    		<fmt:message key="msg.phone" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.phone_placeholder" bundle="${r}" var="phone_placeholder"/>
				    <input required="required" type="text" class="form-control col-7" name="inputTelephone" id="inputTelephone" placeholder="${ phone_placeholder }">
			 	</div>
			   	<div class="form-group row  p-2">
			    	<label for="inputCodePostal" class="control-label col-5">
			    		<fmt:message key="msg.zipCode" bundle="${r}"></fmt:message>
   					</label>
   					<fmt:message key="msg.zipCode_placeholder" bundle="${r}" var="zipCode_placeholder"/>
			    	<input required="required" type="text" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" id="inputCodePostal"  name="inputCodePostal" placeholder="${ zipCode_placeholder }">
		  		</div>	
			</div>
			<div class="col-md-6">
				<div class="form-group row p-2">
		    		<label for="inputNom" class="control-label col-5">
		    			<fmt:message key="msg.name" bundle="${r}"></fmt:message>
	    			</label>
	    			<fmt:message key="msg.name_placeholder" bundle="${r}" var="name_placeholder"/>
			    	<input required="required" type="text" class="form-control col-7" id="inputNom"  name="inputNom" placeholder="${ name_placeholder }">
				</div>
		   		<div class="form-group row p-2">
			    	<label for="inputEmail" class="control-label col-5">
			    		<fmt:message key="msg.email" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.email_placeholder" bundle="${r}" var="email_placeholder"/>
			    	<input  required="required" type="email" class="form-control col-7" id="inputEmail"  name="inputEmail"aria-describedby="emailHelp" placeholder="${ email_placeholder }">
				</div>
		   		<div class="form-group row p-2">
		    		<label for="inputRue" class="control-label col-5">
		    			<fmt:message key="msg.street" bundle="${r}"></fmt:message>
	    			</label>
	    			<fmt:message key="msg.street_placeholder" bundle="${r}" var="street_placeholder"/>
		    		<input required="required" type="text" class="form-control col-7" id="inputRue"   name="inputRue" placeholder="${ street_placeholder }">
		  		</div>
		  		<div class="form-group row p-2">
		    		<label for="inputVille" class="control-label col-5">
		    			<fmt:message key="msg.city" bundle="${r}"></fmt:message>
	    			</label>	
	    			<fmt:message key="msg.city_placeholder" bundle="${r}" var="city_placeholder"/>
		    		<input required="required" type="text" class="form-control col-7" id="inputVille"   name="inputVille" placeholder="${ city_placeholder }">
		  		</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group row p-2">
			    	<label for="inputPassword" class="control-label col-5">
			    		<fmt:message key="msg.password" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.password_placeholder" bundle="${r}" var="password_placeholder"/>
			    	<input required="required" type="password" class="form-control col-7" id="inputPassword"   name="inputPassword" placeholder="${ password_placeholder }">
				</div>
			</div>
			<div class="col-md-6">
			 	<div class="form-group row p-2"> 
			   		<label for="inputConfirmationPassword"  class="control-label col-5">
						<fmt:message key="msg.password_confirm" bundle="${r}"></fmt:message>
					</label>
					<fmt:message key="msg.password_confirm_placeholder" bundle="${r}" var="password_confirm_placeholder"/>
			    	<input required="required" type="password" class="form-control col-7" id="inputConfirmationPassword"   name="inputConfirmationPassword" placeholder="${ password_confirm_placeholder }">
				</div>
			</div>
		</div>
		<div class="col-12 mx-auto">
		  	<div class="d-flex justify-content-center">
		     	<button type="submit" class="btn btn-success mr-1 ml-1">
		     		<fmt:message key="msg.create_button" bundle="${r}"></fmt:message>
	     		</button>    
		     	<a class="btn btn-danger mr-1 ml-1" href="./" role="button">
		     		<fmt:message key="msg.cancel_button" bundle="${r}"></fmt:message>
	     		</a>       
		    </div>
		</div>
	</form>
</div>
	
<script>
var password = document.getElementById("inputPassword")
, confirm_password = document.getElementById("inputConfirmationPassword");

function validatePassword(){
if(password.value != confirm_password.value) {
	if( navigator.language === 'fr'){
	  confirm_password.setCustomValidity("Les mot de passes de correspondent pas.");		
	} else {
		confirm_password.setCustomValidity("Passwords do not match.");
	}
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>

<jsp:include page="../fragments/footer.jsp" ></jsp:include>