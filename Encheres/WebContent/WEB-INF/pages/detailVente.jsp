<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="fr.eni.ecole.messages.detailEnchere" var="r"/>
<fmt:message key="msg.title" bundle="${r}" var="title"/>

<c:set var="title" scope="request" value="${ title }"/>
<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
	<c:if test="${ date < dateFinEnchere }">
		<h2>${ title }</h2>
	</c:if>
	<c:if test="${ date > dateFinEnchere }">
		<c:if test="${ noAcheteur == no_utilisateur }">
			<h2><fmt:message key="msg.sale_won" bundle="${r}"></fmt:message></h2>
		</c:if>
		<c:if test="${noAcheteur != no_utilisateur }">
			<c:if test="${ pseudoAcheteur != pseudoVendeur }">
				<h2>
					<fmt:message key="msg.sale_lost" bundle="${ r }">
						<fmt:param value="${ pseudoAcheteur }"></fmt:param>
					</fmt:message>
				</h2>
			</c:if>
			<c:if test="${ pseudoAcheteur == pseudoVendeur }">
				<h2><fmt:message key="msg.article_not_sale" bundle="${r}"></fmt:message></h2>
			</c:if>
		</c:if>
	</c:if>
	<hr>
	<div class = "col-12">
		<c:if test="${ erreur != null }"> 
			<div class="alert alert-danger" role="alert">
		  		${erreur}
			</div>
		</c:if>
		<c:if test="${ success != null }"> 
			<div class="alert alert-success" role="alert">
		  		${success}
			</div>
		</c:if>
		<c:if test="${ date < dateDebutEnchere }"> 
			<div class="alert alert-warning" role="alert">
				<fmt:message key="msg.at" bundle="${r}" var="at"/>
		  		<fmt:message key="msg.auction_not_started" bundle="${r}"></fmt:message> <fmt:parseDate value="${ dateDebutEnchere }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
					<fmt:formatDate pattern="dd-MM-yyyy '${at}' HH:mm" value="${ parsedDateTime }" />
			</div>
		</c:if>
		<c:if test="${ credit <= montantEnchere && date < dateFinEnchere  }">
			<div class="alert alert-warning" role="alert">
		  		<fmt:message key="msg.no_enought_points" bundle="${r}"></fmt:message>
			</div>
		</c:if>
		
	</div>
	<div class="row">
		<div class="col-md-3 mb-2">
			<div class="detail">
				<img src="img/alienware.jpg" class="img-thumbnail" alt="image alternative">
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
						<td><fmt:message key="msg.description" bundle="${r}"></fmt:message></td>
						<td>${ description}</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.category" bundle="${r}"></fmt:message></td>
						<td>${ categorie }</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.best_offer" bundle="${r}"></fmt:message></td>
						<c:if test="${ montantEnchere != 0 }">
							<c:if test="${ no_utilisateur != null }">	
								<c:if test="${ pseudoAcheteur == pseudoVendeur }">	
									<td>${ montantEnchere }</td>
								</c:if>
								<c:if test="${pseudoAcheteur != pseudoVendeur}">
									<td>${ montantEnchere } <fmt:message key="msg.by" bundle="${r}"></fmt:message> <a href="/Profil?userId=${noAcheteur }">${pseudoAcheteur}</a></td>
								</c:if>
							</c:if>
							<c:if test="${ no_utilisateur == null }">	
								<td>${ montantEnchere } <fmt:message key="msg.by" bundle="${r}"></fmt:message> ${ pseudoAcheteur }</td>
							</c:if>
						</c:if>
						<c:if test="${ montantEnchere == 0 }">
							<td><fmt:message key="msg.no_auction_made" bundle="${r}"></fmt:message></td>
						</c:if>
					</tr>
					<tr>
						<td><fmt:message key="msg.set_price" bundle="${r}"></fmt:message></td>
						<td>${ prixInitial }</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.end_of_auction" bundle="${r}"></fmt:message></td>
						<td>
							<fmt:parseDate value="${ dateFinEnchere }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
							<fmt:formatDate pattern="dd-MM-yyyy '${ at }' HH'H'mm" value="${ parsedDateTime }" />
						</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.calling_off" bundle="${r}"></fmt:message></td>
						<td>
							${ rueRetrait }<br>
							${ codePostalRetrait }<br>
							${ villeRetrait }
						</td>
					</tr>
					<tr>
						<td><fmt:message key="msg.seller" bundle="${r}"></fmt:message></td>
						<c:if test="${ no_utilisateur != null }">	
							<td>
								<a href="Profil?userId=${ noVendeur }">${ pseudoVendeur }</a>
							</td>
						</c:if>
						<c:if test="${ no_utilisateur == null }">	
							<td>${ pseudoVendeur }</td>
						</c:if>
					</tr>
				</tbody>
			</table>
			<c:if test="${ noVendeur != no_utilisateur }">
				<c:if test="${ date < dateFinEnchere && date > dateDebutEnchere }">
					<c:if test="${ no_utilisateur != null }">
						<div class="row">
							<div class="col-md-8 ">
								<form action="./DetailVente" method="post">
									<div class="form-inline">
										<label for="montant" class="mr-sm-2"><fmt:message key="msg.my_offer" bundle="${r}"></fmt:message></label>
										<c:if test="${ montantEnchere != 0 }">
											<fmt:parseNumber var="montantPropose" type="number" value="${ montantEnchere }" />
											<input type="number" class="form-control form-control-sm  mr-sm-2" id="nouveauMontant" name="nouveauMontant" value="${montantPropose +1 }">
										</c:if>
										<c:if test="${ montantEnchere == 0}">
											<fmt:parseNumber var="montantPropose" type="number" value="${ prixInitial }" />
											<input type="number" class="form-control form-control-sm  mr-sm-2" id="nouveauMontant" name="nouveauMontant" value="${montantPropose +1 }">
										</c:if>
										<input type="hidden" id="noAcheteur" name="noAcheteur" value="${ noAcheteur }">
										<input type="hidden" id="noVendeur" name="noVendeur" value="${ noVendeur }">
										<input type="hidden" id="noArticle" name="noArticle" value="${ noArticle }">
										<input type="hidden" id="prixInitial" name="prixInitial" value="${ prixInitial }">
										<input type="hidden" id="ancienMontant" name="ancienMontant" value="${ montantEnchere }">
										<c:if test="${ noAcheteur != no_utilisateur }">
											<c:if test="${ credit <= montantEnchere  }">
												<div>
													<button type="button" class="btn btn-primary" disabled>
														<fmt:message key="msg.auction_button" bundle="${r}"></fmt:message>
													</button>
												</div>
											</c:if>
											<c:if test="${ credit > montantEnchere  }">
												<div>
													<button type="submit" class="btn btn-primary">
														<fmt:message key="msg.auction_button" bundle="${r}"></fmt:message>
													</button>
												</div>
											</c:if>
										</c:if>
										<c:if test="${ noAcheteur == no_utilisateur }">
											<div>
												<button type="button" class="btn btn-primary" disabled>
													<fmt:message key="msg.auction_button" bundle="${r}"></fmt:message>
												</button>
											</div>
										</c:if>
										<div class="row col-12">
											<fmt:message key="msg.points_left" bundle="${ r }">
												<fmt:param value="${ credit }"></fmt:param>
											</fmt:message>
										</div>
									</div>
								</form>
							</div>
						</div>
					</c:if>
				</c:if>
			</c:if>
			<c:if test="${ noVendeur == no_utilisateur }">
				<c:if test="${ date < dateFinEnchere }">
					<c:if test="${ no_utilisateur != null }">
						<div class="row">
							<div class="col-md-6 mt-2">
								<button type="button" class="btn btn-primary" disabled><fmt:message key="msg.modify_button" bundle="${r}"></fmt:message></button>
							</div>
						</div>
					</c:if>
				</c:if>
			</c:if>			
		</div>
		
	</div>	
</div>
<jsp:include page="../fragments/footer.jsp"></jsp:include>