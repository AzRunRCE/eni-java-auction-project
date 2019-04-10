<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Detail Vente" name="title" />
</jsp:include>
<div class="container">
	<c:if test="${date < dateFinEnchere }">
		<h2>Détail Vente</h2>
	</c:if>
	<c:if test="${date > dateFinEnchere }">
		<c:if test="${noAcheteur == no_utilisateur }">
			<h2>Vous avez remporté la vente</h2>
		</c:if>
		<c:if test="${noAcheteur != no_utilisateur }">
			<c:if test="${pseudoAcheteur != pseudoVendeur}">
				<h2>${pseudoAcheteur } à remporté la vente</h2>
			</c:if>
			<c:if test="${pseudoAcheteur == pseudoVendeur}">
				<h2>L'article n'a pas été vendu</h2>
			</c:if>
		</c:if>
	</c:if>
	<hr>
	<div class = "col-12">
		<c:if test="${erreur != null}"> 
			<div class="alert alert-danger" role="alert">
		  		${erreur}
			</div>
		</c:if>
		<c:if test="${success != null}"> 
			<div class="alert alert-success" role="alert">
		  		${success}
			</div>
		</c:if>
		<c:if test="${date < dateDebutEnchere}"> 
			<div class="alert alert-warning" role="alert">
		  		L'enchère débutera le <fmt:parseDate value="${dateDebutEnchere }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
					<fmt:formatDate pattern="dd-MM-yyyy 'à' HH:mm" value="${ parsedDateTime }" />
			</div>
		</c:if>
		<c:if test="${credit <= montantEnchere && date < dateFinEnchere  }">
			<div class="alert alert-warning" role="alert">
		  		Vous n'avez pas assez de credit pour enchérir!
			</div>
		</c:if>
		
	</div>
	<div class="row">
		<div class="col-md-3 mb-2">
			<div class="detail">
				<c:if test="${cheminImage != null }">
					<img src="http://localhost:8080/EncheresImages/${cheminImage }" class="img-thumbnail" alt="${cheminImage }">
				</c:if>
				<c:if test="${cheminImage == null }">
					<img src="http://localhost:8080/EncheresImages/default.jpg" class="img-thumbnail" alt="image alternative">
				</c:if>
			</div>
		</div>
		<div class="col-md-9">
			<h4>${nomArticle }</h4>
			<table class="table table-borderless table-sm">
				<thead>
					<tr>
						<th style="width:40%"></th>
						<th style="width:60%"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Description :</td>
						<td>${description}</td>
					</tr>
					<tr>
						<td>Catégorie :</td>
						<td>${categorie }</td>
					</tr>
					<tr>
						<td>Meilleure offre :</td>
						<c:if test="${montantEnchere != 0 }">
							<c:if test="${no_utilisateur != null}">	
								<c:if test="${pseudoAcheteur == pseudoVendeur}">	
									<td>${montantEnchere }</td>
								</c:if>
								<c:if test="${pseudoAcheteur != pseudoVendeur}">
									<td>${montantEnchere } par <a href="/Profil?userId=${noAcheteur }">${pseudoAcheteur}</a></td>
								</c:if>
							</c:if>
							<c:if test="${no_utilisateur == null}">	
								<td>${montantEnchere } par ${pseudoAcheteur}</td>
							</c:if>
						</c:if>
						<c:if test="${montantEnchere == 0 }">
							<td>Aucune enchère n'a été faite.</td>
						</c:if>
					</tr>
					<tr>
						<td>Mise à prix :</td>
						<td>${prixInitial }</td>
					</tr>
					<tr>
						<td>fin de l'enchère :</td>
						<td>
							<fmt:parseDate value="${dateFinEnchere }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
							<fmt:formatDate pattern="dd-MM-yyyy 'à' HH:mm" value="${ parsedDateTime }" />
						</td>
					</tr>
					<tr>
						<td>Retrait :</td>
						<td>
							${rueRetrait }<br>
							${codePostalRetrait }<br>
							${villeRetrait }
						</td>
					</tr>
					<tr>
						<td>Vendeur :</td>
						<c:if test="${no_utilisateur != null}">	
							<td>
								<a href="Profil?userId=${noVendeur }">${pseudoVendeur }</a>
							</td>
						</c:if>
						<c:if test="${no_utilisateur == null}">	
							<td>${pseudoVendeur }</td>
						</c:if>
					</tr>
				</tbody>
			</table>
			<c:if test="${noVendeur != no_utilisateur }">
				<c:if test="${date < dateFinEnchere && date > dateDebutEnchere }">
					<c:if test="${no_utilisateur != null}">
						<div class="row">
							<div class="col-md-8 ">
								<form action="./DetailVente" method="post">
									<div class="form-inline">
										<label for="montant" class="mr-sm-2">Ma Proposition :</label>
										<c:if test="${montantEnchere != 0}">
											<fmt:parseNumber var="montantPropose" type="number" value="${montantEnchere}" />
											<input type="number" class="form-control form-control-sm  mr-sm-2" id="nouveauMontant" name="nouveauMontant" value="${montantPropose +1 }">
										</c:if>
										<c:if test="${montantEnchere == 0}">
											<fmt:parseNumber var="montantPropose" type="number" value="${prixInitial}" />
											<input type="number" class="form-control form-control-sm  mr-sm-2" id="nouveauMontant" name="nouveauMontant" value="${montantPropose +1 }">
										</c:if>
										<input type="hidden" id="noAcheteur" name="noAcheteur" value="${noAcheteur }">
										<input type="hidden" id="noVendeur" name="noVendeur" value="${noVendeur }">
										<input type="hidden" id="noArticle" name="noArticle" value="${noArticle }">
										<input type="hidden" id="prixInitial" name="prixInitial" value="${prixInitial }">
										<input type="hidden" id="ancienMontant" name="ancienMontant" value="${montantEnchere }">
										<c:if test="${noAcheteur != no_utilisateur }">
											<c:if test="${credit <= montantEnchere  }">
												<div>
													<button type="button" class="btn btn-primary" disabled>Enchérir</button>
												</div>
											</c:if>
											<c:if test="${credit > montantEnchere  }">
												<div>
													<button type="submit" class="btn btn-primary">Enchérir</button>
												</div>
											</c:if>
										</c:if>
										<c:if test="${noAcheteur == no_utilisateur }">
											<div>
												<button type="button" class="btn btn-primary" disabled>Enchérir</button>
											</div>
										</c:if>
										<div class="row col-12">
											Il vous reste ${credit } crédits.
										</div>
									</div>
								</form>
							</div>
						</div>
					</c:if>
				</c:if>
			</c:if>
			<c:if test="${noVendeur == no_utilisateur }">
				<c:if test="${date < dateDebutEnchere  }">
					<c:if test="${no_utilisateur != null}">
						<div class="row">
							<div class="col-md-6 mt-2">
								<a href="./Sell?noArticle=${noArticle }" role="button" class="btn btn-light">Modifier</a>
							</div>
						</div>
					</c:if>
				</c:if>
			</c:if>			
		</div>
		
	</div>	
</div>
<jsp:include page="../fragments/footer.jsp"></jsp:include>