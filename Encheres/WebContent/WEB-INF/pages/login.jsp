<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setBundle basename="fr.eni.ecole.messages.login" var="r"/>

<fmt:message key="msg.title" bundle="${r}" var="title"/>

<c:set var="title" scope="request" value="${ title }"/>
<jsp:include page="../fragments/header.jsp"></jsp:include>

<div class="container">
	<h2>${ title }</h2>
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
					<label for="login"><fmt:message key="msg.pseudo_or_email" bundle="${r}"></fmt:message></label>
					<fmt:message key="msg.pseudo_or_email_placeholder" bundle="${r}" var="pseudo_or_email_placeholder"/>
					<input type="text" class="form-control form-control-sm" id="login" name="login"
						aria-describedby="emailHelp" placeholder="${ pseudo_or_email_placeholder }" value="${login }"> 
					<small id="emailHelp" class="form-text text-muted">
						<fmt:message key="msg.pseudo_or_email_instruction" bundle="${r}"></fmt:message>
					</small>
				</div>
				<div class="form-group">
				<fmt:message key="msg.password" bundle="${r}" var="password"/>
					<label for="Password">${ password }</label> 
					<input
						type="password" class="form-control form-control-sm" id="Password" name="password"
						placeholder="${ password }"
					>
				</div>
				<div class = "row">
					<div class ="col-sm-6 align-self-center">
						<button type="submit" class="btn btn-primary">
							<fmt:message key="msg.connect" bundle="${r}"></fmt:message>
						</button>
					</div>
					<div class ="col-sm-6">
						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe">
							<label class="form-check-label" for="souvenir">
								<fmt:message key="msg.remember_me" bundle="${r}"></fmt:message>
							</label>
						</div>
						<div>
							<a href="#"><fmt:message key="msg.forgotten_password" bundle="${r}"></fmt:message></a>
						</div>
					</div>
				</div>
			</form>
			<div class="col-sm-12 mt-3">
				<a class="btn btn-light btn-lg btn-block" href="./Register" role="button">
					<fmt:message key="msg.create_account_button" bundle="${r}"></fmt:message>
				</a>
			</div>
		</div>
	</div>
</div>



<jsp:include page="../fragments/footer.jsp"></jsp:include>
