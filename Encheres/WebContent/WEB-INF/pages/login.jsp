<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Connexion" name="title" />
</jsp:include>
<h2>Connexion</h2>
<hr>
<div class="row justify-content-center">
	<div class = "col-12">
		<c:if test="${erreur != null}"> 
			<div class="alert alert-danger" role="alert">
		  		${erreur}
			</div>
		</c:if>
	</div>
	<div class="col-md-4">
		<form action="./Login" method="post">
			<div class="form-group">
				<label for="login">Pseudo ou email</label>
				<input type="text" class="form-control form-control-sm" id="login" name="login"
					aria-describedby="emailHelp" placeholder="Entrer le mail ou le pseudo" value="${login }"> 
				<small id="emailHelp" class="form-text text-muted">Ne jamais partager son pseudo ou son mail</small>
			</div>
			<div class="form-group">
				<label for="Password">Mot de passe</label> <input
					type="password" class="form-control form-control-sm" id="Password" name="password"
					placeholder="Mot de passe">
			</div>
			<div class = "row">
				<div class ="col-sm-6 align-self-center">
					<button type="submit" class="btn btn-primary">Se connecter</button>
				</div>
				<div class ="col-sm-6">
					<div class="form-group form-check">
						<input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
						<label class="form-check-label" for="souvenir">Se souvenir de moi</label>
					</div>
					<div>
						<a href="#">Mot de passe oublié</a>
					</div>
				</div>
			</div>
		</form>
		
			<div class="col-sm-12 mt-3">
				<a class="btn btn-light btn-lg btn-block" href="./Register" role="button">Créer un compte</a>
			</div>
		
	</div>
	
</div>



<jsp:include page="../fragments/footer.jsp"></jsp:include>
