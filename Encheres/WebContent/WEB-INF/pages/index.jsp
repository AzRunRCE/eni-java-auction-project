<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>


<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Liste des encheres" name="title" />
</jsp:include>
<div class="container">
<h2>Liste des enchères</h2>
<hr>
	<h3>Filtres</h3>
	<form id="filterForm" action="/Encheres/webapi/enchere/" method="post">
		<div class="form-row accueil">
			<div class="col-md-8">
				<div class="form-group row">
					<label for="inputPassword" class="col-md-4 col-form-label">Recherche par nom</label>		
					<input 
						type="search"
						name="nameFilter" 
						class="form-control col-md-8" 
						placeholder="Le nom de l'article contient"
						pattern="^\w[\w|\s]*\w$"
						maxlength="20"
						title="Caractères alphanumériques uniquement" 
					>
				</div>
				<div class="form-group row">
					<label for="SelectCategorie" class="col-md-4 col-form-label">Catégorie</label>
				    <select 
				    	class="form-control col-md-8" 
				    	id="SelectCategorie"
				    	name="categorie" 
				    >
						<option value="-1">Toutes</option>
						<c:forEach var="cat" items="${ listeCategories}">
							<option value="${ cat.getNoCategorie() }">${ cat.getLibelle() }</option>
						</c:forEach>
				    </select>
				</div>
				<c:if test = "${ sessionScope['no_utilisateur'] != null }" >
					<fieldset class="form-group">
						<div class="row">
							<div class="col-md-6">
								<div class="custom-control custom-radio custom-control-inline">
									<input 
										type="radio" 
										id="achatsRadio"
										name="radioButtons" 
										value="mesAchats"
										class="custom-control-input"
										checked
									> 
										<label class="custom-control-label" for="achatsRadio">Achats</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="custom-control custom-radio custom-control-inline col-md-6">
									<input 
										type="radio" 
										id="ventesRadio"
										name="radioButtons" 
										value="mesVentes"
										class="custom-control-input"
									> 
										<label class="custom-control-label" for="ventesRadio">Mes ventes</label>
								</div>
							</div>
						</div>
					</fieldset>
					<div class="form-group row">
						<div class="col-md-6" id="mesEncheresCheckboxGroup">
							<div class="form-check">
							  <input 
							  		class="form-check-input" 
							  		type="checkbox" 
							  		name="encheresOuvertes" 
							  		id="encheresOuvertes"
						  		>
							  <label class="form-check-label" for="encheresOuvertes">
							    Enchères ouvertes
							  </label>
							</div>
							<div class="form-check">
							  <input 
							  		class="form-check-input" 
							  		type="checkbox" 
							  		name="encheresEnCours" 
							  		id="encheresEnCours"
					  			>
							  <label class="form-check-label" for="encheresEnCours">
							    Mes enchères en cours
							  </label>
							</div>
							<div class="form-check">
							  <input 
							  		class="form-check-input" 
							  		type="checkbox" 
							  		name="encheresRemportees" 
							  		id="encheresRemportees"
					  			>
							  <label class="form-check-label" for="encheresRemportees">
							    Mes enchères remportées
							  </label>
							</div>
						</div>
						<div class="col-md-6" id="mesVentesCheckboxGroup">
							<div class="form-check">
							  <input 
						  			class="form-check-input" 
					  				type="checkbox" 
					  				name="ventesEnCours" 
					  				id="ventesEnCours"
					  				disabled
				  				>
							  <label class="form-check-label" for="ventesEnCours">
							    Mes ventes en cours
							  </label>
							</div>
							<div class="form-check">
							  <input 
							  		class="form-check-input" 
							  		type="checkbox" 
							  		name="ventesNonDebutees" 
							  		id="ventesNonDebutees"
							  		disabled
						  		>
							  <label class="form-check-label" for="ventesNonDebutees">
							    Ventes non débutées
							  </label>
							</div>
							<div class="form-check">
							  <input 
						  			class="form-check-input" 
					  				type="checkbox" 
					  				name="ventesTerminees" 
					  				id="ventesTerminees"
					  				disabled
				  				>
							  <label class="form-check-label" for="ventesTerminees">
							    Ventes terminées
							  </label>
							</div>
						</div>			
					</div>
				</c:if>	
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-light">Rechercher</button>
			</div>
		</div>
	</form>
	<hr>
	<div id="dashboard" class="justify-content-center">
	
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/accueil.js"></script>
<jsp:include page="../fragments/footer.jsp"></jsp:include>