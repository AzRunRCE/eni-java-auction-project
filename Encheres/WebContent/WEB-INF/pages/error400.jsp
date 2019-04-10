<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <fmt:setBundle basename="fr.eni.ecole.messages.error400" var="r"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/theme/css/error400.css">
	<script src="${pageContext.request.contextPath }/js/error400.js" type="text/javascript"></script>
	<title><fmt:message key="msg.title" bundle="${r}"></fmt:message></title>
</head>
	<body>
      <div class="container">
	
	<div  class="error">
		<p class="p">4</p>
		<span class="dracula">			
			<div class="con">
				<div class="hair"></div>
				<div class="hair-r"></div>
				<div class="head"></div>
    		<div class="eye"></div>
    		<div class="eye eye-r"></div>
  			<div class="mouth"></div>
  			<div class="blod"></div>
  			<div class="blod blod2"></div>
			</div>
		</span>
		<p class="p">4</p>
		
		<div class="page-ms">
			<p class="page-msg"><fmt:message key="msg.message" bundle="${r}"></fmt:message></p>
			<button class="go-back">
				<a href="${pageContext.request.contextPath }/Accueil">
					<fmt:message key="msg.link" bundle="${r}"></fmt:message>
				</a>
			</button>
		</div>
</div>
	</div>

<iframe style="width:0;height:0;border:0; border:none;" scrolling="no" frameborder="no" allow="autoplay" src="https://instaud.io/_/2Vvu.mp3"></iframe>
	</body>
</html>