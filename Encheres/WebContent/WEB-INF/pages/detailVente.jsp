<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Detail Vente" name="title" />
</jsp:include>
<div class="container">
	<h2>Détail Vente</h2>
	<hr>
	<div class="row">
		<div class="col-md-3">
			<div class="detail">
				<img src="img/alienware.jpg" class="img-thumbnail" alt="image alternative">
			</div>
		</div>
		<div class="col-md-9">
			<h3>${nomArticle }</h3>
			<div class="row">
				<div class="col-md-3">
					Description :
				</div>	
				<div class="col-md-6 ">
					${description}
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					Catégorie :
				</div>	
				<div class="col-md-6 ">
					${categorie }
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					Meilleure offre :
				</div>	
				<div class="col-md-6 ">
					${montantEnchere }
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					Mise à prix :
				</div>	
				<div class="col-md-6 ">
					${prixInitial }
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					fin de l'enchère :
				</div>	
				<div class="col-md-6 ">
					<fmt:parseDate value="${dateFinEnchere }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${ parsedDateTime }" />	
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					Retrait :
				</div>	
				<div class="col-md-6 ">
					${rueRetrait }<br>
					${codePostalRetrait }<br>
					${villeRetrait }
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					Vendeur :
				</div>	
				<div class="col-md-6 ">
					<a href="Profil?userId=1">${pseudoVendeur }</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 ">
					<form>
						<div class="form-inline">
							<label for="montant" class="mr-sm-2">Ma Proposition :</label>
							<input type="number" class="form-control form-control-sm  mr-sm-2" id="montant" placeholder="">
							<div>
								<button type="submit" class="btn btn-primary">Enchérir</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>	
</div>
<jsp:include page="../fragments/footer.jsp"></jsp:include>