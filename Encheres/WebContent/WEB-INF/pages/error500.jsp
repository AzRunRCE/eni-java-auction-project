<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <fmt:setBundle basename="fr.eni.ecole.messages.error500" var="r"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="msg.title" bundle="${r}"></fmt:message></title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/theme/css/error500.css">
</head>
<body class="loading">
  <h1>500</h1>
  <h2><fmt:message key="msg.message" bundle="${r}"></fmt:message> <b>:(</b></h2>
  <div class="gears">
    <div class="gear one">
      <div class="bar"></div>
      <div class="bar"></div>
      <div class="bar"></div>
    </div>
    <div class="gear two">
      <div class="bar"></div>
      <div class="bar"></div>
      <div class="bar"></div>
    </div>
    <div class="gear three">
      <div class="bar"></div>
      <div class="bar"></div>
      <div class="bar"></div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="${pageContext.request.contextPath }/js/error500.js" type="text/javascript"></script>
</body>
</html>