<%@page import="fr.eni.ecole.beans.Utilisateur"%>
<%@page import="fr.eni.ecole.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<c:set var="title" scope="request" value="${ title }"/>
<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
	<h2>Mon profil</h2>
	<hr>
	<c:if test="${message != null}"> 
		<div class="alert alert-success" role="alert">
	  		${message}
		</div>
	</c:if>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-8">
		<table class="table table-borderless table-sm">
				<thead>
					<tr>
						<th style="width:35%"></th>
						<th style="width:65%"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Pseudo :</td>
						<td>${utilisateur.getPseudo()}</td>
					</tr>
					<tr>
						<td>Nom :</td>
						<td>${utilisateur.getNom()}</td>
					</tr>
					<tr>
						<td>Prenom :</td>
						<td>${utilisateur.getPrenom()}</td>
					</tr>
					<tr>
						<td>Email :</td>
						<td>${utilisateur.getEmail()}</td>
					</tr>
					<tr>
						<td>Telephone :</td>
						<td>${utilisateur.getTelephone()}</td>
					</tr>
					<tr>
						<td>Rue :</td>
						<td>${utilisateur.getRue()}</td>
					</tr>
					<tr>
						<td>Code Postal :</td>
						<td>${utilisateur.getCodePostal()}</td>
					</tr>
					<tr>
						<td>Ville :</td>
						<td>${utilisateur.getVille()}</td>
					</tr>
					<tr>
						<td>Credit :</td>
						<td>${utilisateur.getCredit()}</td>
					</tr>
		</table>
	</div></div>
	<div class="row justify-content-around">
		<c:if test="${editable != null && editable == true}">
	   	 	<a href="EditProfil" class="btn btn-success center p-2 m-2">Modifier</a>         
		</c:if>
	</div>
</div>


<jsp:include page="../fragments/footer.jsp" ></jsp:include>