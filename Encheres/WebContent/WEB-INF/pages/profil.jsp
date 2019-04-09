<%@page import="fr.eni.ecole.beans.Utilisateur"%>
<%@page import="fr.eni.ecole.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<jsp:include page="../fragments/header.jsp" ></jsp:include>
<div class="container">
	<h2>Mon profil</h2>
		<c:if test="${message != null}"> 
				<div class="alert alert-success" role="alert">
			  		${message}
				</div>
			</c:if>
	<div class="row justify-content-center">
		<div class="col-sm-12 col-xs-12 col-md-6">
		  	<div class="form-group">
		    	<label for="inputSpeudo">Pseudo: <c:out value="${utilisateur.getPseudo()}"></c:out></label>
		   	</div>
		<div class="form-group">
			<label for="inputNom">Nom: <c:out value="${utilisateur.getNom()}"></c:out></label>
		</div>
		<div class="form-group">
		    <label for="inputPrenom">Prenom: <c:out value="${utilisateur.getPrenom()}"></c:out></label>
		</div>
		<div class="form-group">
		    <label for="inputEmail">Email: <c:out value="${utilisateur.getEmail()}"></c:out></label>
		</div>
		<div class="form-group">
		    <label for="inputTelephone">Telephone: <c:out value="${utilisateur.getTelephone()}"></c:out></label>
		</div>
		<div class="form-group">
		    <label for="inputRue">Rue: <c:out value="${utilisateur.getRue()}"></c:out></label>
		</div>
		<div class="form-group">
		    <label for="inputCodePostal">Code Postal: <c:out value="${utilisateur.getCodePostal()}"></c:out></label>
		</div>
		<div class="form-group">
		    <label for="inputVille">Ville: <c:out value="${utilisateur.getVille()}"></c:out></label>
		</div>
		<div class="form-group">
		    <label for="inputVille">Credit: <c:out value="${utilisateur.getCredit()}"></c:out></label>
		</div>
		<div class="row justify-content-around">
			<c:if test="${editable != null && editable == true}">
		   		<div class="col-4">
		   	 		<a href="EditProfil" class="btn btn-success center p-2 m-2">Modifier</a>         
			    </div>
			</c:if>
		</div>
	</div>
</div>
</div>

<jsp:include page="../fragments/footer.jsp" ></jsp:include>