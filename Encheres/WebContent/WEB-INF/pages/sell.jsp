<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>


<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Vendre" name="title" />
</jsp:include>
<div class="container">
	<h2>Vendre un article</h2>
	<hr>
	<form method="post" action="Sell" enctype="multipart/form-data">
		<div class="row">
			<div
				class="col-12 col-sm-4 col-md-4 col-lg-4 col-xl-4 px-3 pb-3 mt-4 mb-auto">
				<img
					src="http://www.stonyelectrical.com/wp-content/uploads/2018/04/Product_Icon.png"
					class="card-img" alt="...">
			</div>
			<div class="col-12 col-sm-8 col-md-8 col-lg-8 col-xl-8 mx-auto">
				<div class="row">
					<div class="form-group col-12">
						<label for="InputArticle">Article :</label> <input type="text"
							class="form-control" id="InputArticle" name="inputNomArticle"
							placeholder="Entrez le nom de votre article" required>
					</div>

					<div class="form-group col-12">
						<label for="InputDescription">Description :</label>
						<textarea class="form-control" id="InputDescription"
							name="inputDescription" placeholder="Description de l'article"
							required>
						</textarea>
					</div>
					<div class="form-group col-12">
						<label for="InputCategorie">Catégorie :</label> <select
							class="custom-select" id="inputCategorie" name="inputCategorie">
							<c:forEach var="cat" items="${ listeCategories}">
								<option value="${ cat.getNoCategorie() }">${ cat.getLibelle() }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-12">
						<label for="exampleFormControlFile1">Example file input</label> <input
							type="file" class="form-control-file"
							id="exampleFormControlFile1">
					</div>
					<div class="form-group col-12">
						<label for="InputPrix">Mise à prix :</label> <input type="number"
							class="form-control" id="inputPrix" name="inputPrix"
							placeholder="Prix de l'article" required>
					</div>
					<div class="col-12 col-sm-8 col-md-8 col-lg-8 col-xl-8 mx-auto">
						<div class="row">
							<div class="form-group col-12">
								<label for="InputArticle">Article :</label> <input type="text"
									class="form-control" id="InputArticle" name="inputNomArticle"
									placeholder="Entrez le nom de votre article" required>
							</div>
							<div class="form-group col-12">
								<label for="InputDescription">Description :</label>
								<textarea class="form-control" id="InputDescription"
									name="inputDescription" placeholder="Description de l'article"
									required></textarea>
							</div>
							<div class="form-group col-12">
								<label for="InputCategorie">Catégorie :</label> 
								<select class="custom-select" id="inputCategorie" name="inputCategorie">
									<c:forEach var="cat" items="${ listeCategories}">
										<option value="${ cat.getNoCategorie() }">${ cat.getLibelle() }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-12">
								<div class="form-group">
									<label for="inputImage">Choisir une image</label> <input
										type="file" class="form-control-file" id="inputImage"
										name="inputImage">
								</div>
							</div>
							<div class="form-group col-12">
								<label for="InputPrix">Mise à prix :</label> <input
									type="number" class="form-control" id="inputPrix"
									name="inputPrix" placeholder="Prix de l'article" required>
							</div>
							<div class="form-group col-12">
								<label for="debut">Début de l'enchère :</label> <input
									type="datetime-local" class="form-control"
									name="DateDebutEncheres" id="DateDebutEncheres" value="">
							</div>
							<div class="form-group col-12">
								<label for="fin">Fin de l'enchère :</label> <input
									type="datetime-local" class="form-control"
									name="DateFinEncheres" id="DateFinEncheres" required>
							</div>
							<div class="col-12">
								<div class="card">
									<div class="card-header">Retrait</div>
									<div class="card-body">
										<div class="form-group row col-12 ">
											<label class="col-12 col-lg-3 col-xl-3 m-auto pl-0"
												for="inputRue">Rue :</label> <input type="text"
												class="form-control col-12 col-lg-9 col-xl-9"
												name="inputRue" id="inputRue" placeholder="Entrez votre rue"
												value="<c:out value="${utilisateur.getRue()}"></c:out>"
												required>
										</div>
										<div class="form-group row col-12">
											<label class="col-12 col-lg-3 col-xl-3 m-auto pl-0"
												for="inputCodePostal">Code Postal :</label> <input
												type="text" class="form-control col-12 col-lg-9 col-xl-9"
												name="inputCodePostal" id="inputCodePostal"
												placeholder="Entrez votre Code Postal"
												value="<c:out value="${utilisateur.getCodePostal()}"></c:out>"
												required>
										</div>
										<div class="form-group row col-12">
											<label class="col-12 col-lg-3 col-xl-3 m-auto pl-0"
												for="ville">Ville :</label> <input type="text"
												class="form-control col-12 col-lg-9 col-xl-9"
												name="inputVille" id="InputVille"
												placeholder="Entrez votre ville"
												value="<c:out value="${utilisateur.getVille()}"></c:out>"
												required>
										</div>
									</div>
								</div>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-6 pr-3">
								<button type="submit" class="btn btn-block btn-success">Enregistrer</button>
							</div>
							<div class="col-6">
								<a class="btn btn-block btn-danger" href="/">Annuler</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</form>
</div>

<jsp:include page="../fragments/footer.jsp"></jsp:include>