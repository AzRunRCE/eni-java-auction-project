<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>ENI Enchères - ${param.title} </title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/theme/css/style.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/theme/bootstrap-4.1.3/css/bootstrap.min.css">
	</head>
	<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="${pageContext.request.contextPath }/">ENI Enchères</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active">
		        <a class="nav-link" href="${pageContext.request.contextPath }/">Accueil<span class="sr-only">(current)</span></a>
		      </li>
		    </ul>
		    <ul class="navbar-nav justify-content-end">
		      <c:if test="${id != null}">
		      	<li class ="nav-item ">		      
		      		Bonjour ${prenom} ${nom} - <a class="nav-link" href="./Deconnexion">Déconnexion</a>
		      	</li>
		      </c:if>
		      <c:if test="${id == null}">
			      <li class ="nav-item ">
			      	<a class="nav-link" href="./Login">Connexion</a>
			      </li>
			      <li class ="nav-item ">
			      	<a class="nav-link" href="./Register">Inscription</a>
			      </li>	
		      </c:if>
		    </ul>
		  </div>
		</nav>
		<div class="container">
			<h2>${param.title}</h2>
			<hr>
	