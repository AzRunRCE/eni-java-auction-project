<%@page import="fr.eni.ecole.beans.Utilisateur"%>
<%@page import="fr.eni.ecole.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<fmt:setBundle basename="fr.eni.ecole.messages.editProfile" var="r"/>
<fmt:message key="msg.title" bundle="${r}" var="title"/>

<c:set var="title" scope="request" value="${ title }"/>
<jsp:include page="../fragments/header.jsp"></jsp:include>
<div class="container">
	<h2>${ title }</h2>
	<hr>
	<form id="EditProfilForm"  class="" action="EditProfil" method="POST">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group row p-2">
			    	<label for="inputPrenom" class="justify-content-start control-label col-5">
			    		<fmt:message key="msg.first_name" bundle="${r}"></fmt:message>
			    	</label>
			    	<fmt:message key="msg.first_name_placeholder" bundle="${r}" var="first_name_placeholder"/>
			    	<input required="required" type="text" value="<c:out value="${utilisateur.getPrenom()}"></c:out>" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPrenom" id="inputPrenom" placeholder="${ first_name_placeholder }">
				</div>
				<div class="form-group row  p-2">
			    	<label for="inputPseudo" class="justify-content-start control-label col-5">
			    		<fmt:message key="msg.pseudo" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.pseudo_placeholder" bundle="${r}" var="pseudo_placeholder"/>
				    <input required="required" type="text" value="<c:out value="${utilisateur.getPseudo()}"></c:out>" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" name="inputPseudo" id="inputPseudo" placeholder="${ pseudo_placeholder }">
			    </div>
			    <div class="form-group row  p-2">
			    	<label for="inputTelephone" class="justify-content-start control-label col-5">
			    		<fmt:message key="msg.phone" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.phone_placeholder" bundle="${r}" var="phone_placeholder"/>
				    <input required="required" type="text" value="<c:out value="${utilisateur.getTelephone()}"></c:out>" class="form-control col-7" name="inputTelephone" id="inputTelephone" pattern="^(?:0|\(?\+33\)?\s?|0033\s?)[1-79](?:[\.\-\s]?\d\d){4}$" placeholder="${ phone_placeholder }">
			 	</div>
				<div class="form-group row  p-2">
			    	<label for="inputCodePostal" class="justify-content-start control-label col-5">
			    		<fmt:message key="msg.zipCode" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.zipCode_placeholder" bundle="${r}" var="zipCode_placeholder"/>
			    	<input required="required" type="text" value="<c:out value="${utilisateur.getCodePostal()}"></c:out>" pattern="[a-zA-Z0-9\s]+" class="form-control col-7" id="inputCodePostal"  pattern="[0-9]{5}" name="inputCodePostal" placeholder="${ zipCode_placeholder }">
		  		</div>
			</div>
			<div class="col-md-6">
				<div class="form-group row p-2">
		    		<label for="inputNom" class="justify-content-start control-label col-5">
		    			<fmt:message key="msg.name" bundle="${r}"></fmt:message>
	    			</label>
	    			<fmt:message key="msg.name_placeholder" bundle="${r}" var="name_placeholder"/>
			    	<input required="required" type="text" class="form-control col-7" id="inputNom" value="<c:out value="${utilisateur.getNom()}"></c:out>"  name="inputNom" placeholder="${ name_placeholder }">
		   		</div>
		   		<div class="form-group row p-2">
			    	<label for="inputEmail" class="justify-content-start control-label col-5">
			    		<fmt:message key="msg.email" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.email_placeholder" bundle="${r}" var="email_placeholder"/>
			    	<input  required="required" type="email" class="form-control col-7" id="inputEmail" value="<c:out value="${utilisateur.getEmail()}"></c:out>"   name="inputEmail"aria-describedby="emailHelp" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="${ email_placeholder }">
				</div>
		   		<div class="form-group row p-2">
		    		<label for="inputRue" class="justify-content-start control-label col-5">
		    			<fmt:message key="msg.street" bundle="${r}"></fmt:message>
	    			</label>
	    			<fmt:message key="msg.street_placeholder" bundle="${r}" var="street_placeholder"/>
		    		<input required="required" type="text" class="form-control col-7" id="inputRue"  value="<c:out value="${utilisateur.getRue()}"></c:out>" name="inputRue" placeholder="${ street_placeholder }">
		  		</div>
		  		<div class="form-group row p-2">
		    		<label for="inputVille" class="justify-content-start control-label col-5">
		    			<fmt:message key="msg.city" bundle="${r}"></fmt:message>
	    			</label>	
	    			<fmt:message key="msg.city_placeholder" bundle="${r}" var="city_placeholder"/>
		    		<input required="required" type="text" class="form-control col-7" id="inputVille" value="<c:out value="${utilisateur.getVille()}"></c:out>"  name="inputVille" placeholder="${ city_placeholder }">
		  		</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group row p-2">
			    	<label for="inputPassword" class="justify-content-start control-label col-5">
			    		<fmt:message key="msg.password" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.password_placeholder" bundle="${r}" var="password_placeholder"/>
			    	<input type="password" class="form-control col-7" id="inputPassword"   name="inputPassword" placeholder="${ password_placeholder }">
			  	</div>
			</div>
			<div class="col-md-6">
				<div class="form-group row p-2">
			    	<label for="inputNewPassword" class="justify-content-start control-label col-5">
			    		<fmt:message key="msg.new_password" bundle="${r}"></fmt:message>
		    		</label>
		    		<fmt:message key="msg.new_password_placeholder" bundle="${r}" var="new_password_placeholder"/>
			    	<input  type="password" class="form-control col-7" id="inputNewPassword"   name="inputNewPassword" placeholder="${ new_password_placeholder }">
			  	</div>
				<div class="form-group row p-2"> 
				   	<label for="inputConfirmationPassword"  class="justify-content-start control-label col-5">
				   		<fmt:message key="msg.new_password_confirm" bundle="${r}"></fmt:message>
			   		</label>
			   		<fmt:message key="msg.new_password_confirm_placeholder" bundle="${r}" var="new_password_confirm_placeholder"/>
				    <input type="password" class="form-control col-7" id="inputConfirmationPassword"   name="inputConfirmationPassword" placeholder="${ new_password_confirm_placeholder }">
				</div>
			</div>
		</div>
		<div class="col-12">
	  		<div class="d-flex justify-content-center">
	     		<button type="submit" id="updateProfil" class="btn btn-success p-2 m-2">
	     			<fmt:message key="msg.save_button" bundle="${r}"></fmt:message>
     			</button>                   
	       		<button type="button" id="deleteAccountBtn" class="btn btn-danger  p-2 m-2">
	       			<fmt:message key="msg.delete_account_button" bundle="${r}"></fmt:message>
       			</button>      
	    	</div>
		</div>
	</form>
		
	<form id="deleteAccountForm" style="display:none;" action="EditProfil" method="POST">
		 <input type="hidden" style="display:none;" value="true"  name="inputDeleteAccount">
	</form>	
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/editProfil.js"></script>
<jsp:include page="../fragments/footer.jsp" ></jsp:include>