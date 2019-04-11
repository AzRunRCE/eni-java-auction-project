<%@page import="fr.eni.ecole.beans.Utilisateur"%>
<%@page import="fr.eni.ecole.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<fmt:setBundle basename="fr.eni.ecole.messages.profile" var="r"/>
<fmt:message key="msg.title" bundle="${r}" var="title"/>

<c:set var="title" scope="request" value="${ title }"/>
<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
	<h2>${ title }</h2>
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
						<td><fmt:message key="msg.pseudo" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getPseudo()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.name" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getNom()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.first_name" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getPrenom()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.email" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getEmail()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.phone" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getTelephone()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.street" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getRue()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.zipCode" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getCodePostal()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.city" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getVille()}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.points" bundle="${r}"></fmt:message></td>
						<td>${utilisateur.getCredit()}</td>
					</tr>
		</table>
	</div></div>
	<div class="row justify-content-around">
		<c:if test="${editable != null && editable == true}">
	   	 	<a href="EditProfil" class="btn btn-success center p-2 m-2">
				<fmt:message key="msg.modify_button" bundle="${r}"></fmt:message>
			</a>         
		</c:if>
	</div>
</div>


<jsp:include page="../fragments/footer.jsp" ></jsp:include>