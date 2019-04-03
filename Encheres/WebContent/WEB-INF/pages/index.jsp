<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>


<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Liste des encheres" name="title" />
</jsp:include>

<h2>Liste des enchères</h2>
<hr>

<h3>Filtres</h3>
<form>
	<div class="form-row accueil">
		<div class="col-md-8">
			<div class="form-group row">
				<label for="inputPassword" class="col-md-4 col-form-label">Recherche par nom</label>		
				<input 
					type="search" 
					class="form-control col-md-8" 
					placeholder="Le nom de l'article contient"
				>
			</div>
			<div class="form-group row">
				<label for="SelectCategorie" class="col-md-4 col-form-label">Catégorie</label>
			    <select class="form-control col-md-8" id="SelectCategorie">

			    </select>
			</div>

			<fieldset class="form-group">
				<div class="row">
					<div class="col-md-6">
						<div class="custom-control custom-radio custom-control-inline">
							<input 
								type="radio" 
								id="achatsRadio"
								name="radioButtons" 
								class="custom-control-input"
							> 
								<label class="custom-control-label" for="achatsRadio">Mes achats</label>
						</div>
					</div>
					<div class="col-md-6">
						<div class="custom-control custom-radio custom-control-inline col-md-6">
							<input 
								type="radio" 
								id="ventesRadio"
								name="radioButtons" 
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
					  		value="" 
					  		id="mesEncheresCheckbox1"
				  		>
					  <label class="form-check-label" for="mesEncheresCheckbox1">
					    Enchères ouvertes
					  </label>
					</div>
					<div class="form-check">
					  <input 
					  		class="form-check-input" 
					  		type="checkbox" 
					  		value="" 
					  		id="mesEncheresCheckbox2"
			  			>
					  <label class="form-check-label" for="mesEncheresCheckbox2">
					    Mes enchères en cours
					  </label>
					</div>
					<div class="form-check">
					  <input 
					  		class="form-check-input" 
					  		type="checkbox" 
					  		value="" 
					  		id="mesEncheresCheckbox3"
			  			>
					  <label class="form-check-label" for="mesEncheresCheckbox3">
					    Mes enchères remportées
					  </label>
					</div>
				</div>
				<div class="col-md-6" id="MesVentesCheckboxGroup">
					<div class="form-check">
					  <input 
				  			class="form-check-input" 
			  				type="checkbox" 
			  				value="" 
			  				id="MesVentesCheckbox1"
		  				>
					  <label class="form-check-label" for="MesVentesCheckbox1">
					    Mes ventes en cours
					  </label>
					</div>
					<div class="form-check">
					  <input 
					  		class="form-check-input" 
					  		type="checkbox" 
					  		value="" 
					  		id="MesVentesCheckbox2"
				  		>
					  <label class="form-check-label" for="MesVentesCheckbox2">
					    Ventes non remportées
					  </label>
					</div>
					<div class="form-check">
					  <input 
				  			class="form-check-input" 
			  				type="checkbox" 
			  				value="" 
			  				id="MesVentesCheckbox3"
		  				>
					  <label class="form-check-label" for="MesVentesCheckbox3">
					    Ventes terminées
					  </label>
					</div>
				</div>			
			</div>
			
		</div>
		<div class="col-md-4">
			<button type="submit" class="btn btn-light">Rechercher</button>
		</div>
	</div>
</form>
<div id="dashboard" class="justify-content-center">
	<div class="card mb-3 mr-1 ml-1" style="min-width: 320px; max-width: 530px;">
	  <div class="row no-gutters">
	    <div class="col-md-4">
	      <img src="..." class="card-img" alt="...">
	    </div>
	    <div class="col-md-8">
	      <div class="card-body">
	        <h5 class="card-title">Object Name</h5>
	        <p class="card-text">Price</p>
	        <p class="card-text">End date</p>
	        <p class="card-text">Pseudo</p>
	      </div>
	    </div>
	  </div>
	</div>
</div>


<table class="table" id="table">

</table>
<pre id="succes">
	
</pre>

<pre id="echec">

</pre>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/accueil.js"></script>
<jsp:include page="../fragments/footer.jsp"></jsp:include>