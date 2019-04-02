<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Connexion" name="title" />
</jsp:include>

<div class="row justify-content-center">
	
	<div class="col-4">
		<c:if test="${erreur != null}"> 
			<div class="alert alert-danger" role="alert">
		  		${erreur}
			</div>
		</c:if>
		<form action="./Login" method="post">
			<div class="form-group">
				<label for="login">Pseudo ou email</label>
				<input type="text" class="form-control form-control-sm" id="login" name="login"
					aria-describedby="emailHelp" placeholder="Entrer le mail ou le pseudo"> 
				<small id="emailHelp" class="form-text text-muted">Ne jamais partager son pseudo ou son mail</small>
			</div>
			<div class="form-group">
				<label for="Password">Mot de passe</label> <input
					type="password" class="form-control form-control-sm" id="Password" name="password"
					placeholder="Mot de passe">
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="souvenir" name="souvenir">
				<label class="form-check-label" for="souvenir">Se souvenir de moi</label>
			</div>
			<button type="submit" class="btn btn-primary">Se connecter</button>
		</form>
	</div>
</div>


<jsp:include page="../fragments/footer.jsp"></jsp:include>
