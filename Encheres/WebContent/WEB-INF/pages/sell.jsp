<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<fmt:setBundle basename="fr.eni.ecole.messages.sell" var="r"/>
<fmt:message key="msg.title" bundle="${r}" var="title"/>

<c:set var="title" scope="request" value="${ title }"/>
<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
	<h2>${ title }</h2>
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
						<label for="InputArticle">
							<fmt:message key="msg.article_name" bundle="${r}"></fmt:message>
						</label> 
						<fmt:message key="msg.article_name_placeholder" bundle="${r}" var="article_name_placeholder"/>
						<input type="text"
							class="form-control" id="InputArticle" name="inputNomArticle"
							placeholder="${ article_name_placeholder }" required>
					</div>
					<div class="form-group col-12">
						<label for="InputDescription">
							<fmt:message key="msg.description" bundle="${r}"></fmt:message>
						</label>
						<fmt:message key="msg.description_placeholder" bundle="${r}" var="description_placeholder"/>
						<textarea class="form-control" id="InputDescription"
							name="inputDescription" placeholder="${ description_placeholder }"
							required>
						</textarea>
					</div>
					<div class="form-group col-12">
						<label for="InputCategorie">
							<fmt:message key="msg.category" bundle="${r}"></fmt:message>
						</label>
						<select
							class="custom-select" id="inputCategorie" name="inputCategorie">
							<c:forEach var="cat" items="${ listeCategories}">
								<option value="${ cat.getNoCategorie() }">${ cat.getLibelle() }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group col-12">
    					<label for="inputImage">
						 	<fmt:message key="msg.file_upload" bundle="${r}"></fmt:message>
						</label>
    					<input type="file" class="form-control-file" id="inputImage" name="inputImage">
  					</div>
					<div class="form-group col-12">
						<label for="InputPrix">
							<fmt:message key="msg.set_price" bundle="${r}"></fmt:message>
						</label> 
						<fmt:message key="msg.set_price_placeholder" bundle="${r}" var="set_price_placeholder"/>
						<input type="number"
							class="form-control" id="inputPrix" name="inputPrix"
							placeholder="${ set_price_placeholder }" required>
					</div>

					<div class="form-group col-12">
						<label for="debut">
							<fmt:message key="msg.start_of_auction" bundle="${r}"></fmt:message>
						</label> 
						<input
							type="datetime-local" class="form-control"
							name="DateDebutEncheres" id="DateDebutEncheres" value="">
					</div>
					<div class="form-group col-12">
						<label for="fin">
							<fmt:message key="msg.end_of_auction" bundle="${r}"></fmt:message>
						</label> 
						<input
							type="datetime-local" class="form-control" name="DateFinEncheres"
							id="DateFinEncheres" required>
					</div>
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<fmt:message key="msg.calling_off" bundle="${r}"></fmt:message>
							</div>
							<div class="card-body">
								<div class="form-group row col-12 ">
									<label class="col-12 col-lg-3 col-xl-3 m-auto pl-0"
										for="inputRue">
										<fmt:message key="msg.calling_off_place_street" bundle="${r}"></fmt:message>
									</label> 
									<fmt:message key="msg.calling_off_place_street_placeholder" bundle="${r}" var="calling_off_place_street_placeholder"/>
									<input type="text"
										class="form-control col-12 col-lg-9 col-xl-9" name="inputRue"
										id="inputRue" placeholder="${ calling_off_place_street_placeholder }"
										value="<c:out value="${utilisateur.getRue()}"></c:out>"
										required>
								</div>
								<div class="form-group row col-12">
									<label class="col-12 col-lg-3 col-xl-3 m-auto pl-0"
										for="inputCodePostal">
										<fmt:message key="msg.calling_off_zip_code" bundle="${r}"></fmt:message>
									</label> 
									<fmt:message key="msg.calling_off_zip_code_placeholder" bundle="${r}" var="calling_off_zip_code_placeholder"/>
									<input type="text"
										class="form-control col-12 col-lg-9 col-xl-9"
										name="inputCodePostal" id="inputCodePostal"
										placeholder="${ calling_off_zip_code_placeholder }"
										value="<c:out value="${utilisateur.getCodePostal()}"></c:out>"
										required>
								</div>
								<div class="form-group row col-12">
									<label class="col-12 col-lg-3 col-xl-3 m-auto pl-0" for="ville">
										<fmt:message key="msg.calling_off_city" bundle="${r}"></fmt:message>
									</label> 
									<fmt:message key="msg.calling_off_city_placeholder" bundle="${r}" var="calling_off_city_placeholder"/>
									<input type="text"
										class="form-control col-12 col-lg-9 col-xl-9"
										name="inputVille" id="InputVille"
										placeholder="${ calling_off_city_placeholder }"
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
						<button type="submit" class="btn btn-block btn-success">
							<fmt:message key="msg.save_button" bundle="${r}"></fmt:message>
						</button>
					</div>
					<div class="col-6">
						<a class="btn btn-block btn-danger" href="/">
							<fmt:message key="msg.cancel_button" bundle="${r}"></fmt:message>
						</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

<jsp:include page="../fragments/footer.jsp" ></jsp:include>