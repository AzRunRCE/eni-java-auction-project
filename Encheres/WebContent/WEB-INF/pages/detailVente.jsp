<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../fragments/header.jsp">
	<jsp:param value="Detail Vente" name="title" />
</jsp:include>
<h2>Détail Vente</h2>
<hr>


<p>Du <fmt:formatDate value="${f.getDebut()}" pattern="dd/MM/yyyy"/> au <fmt:formatDate value="${f.getFin()}" pattern="dd/MM/yyyy"/></p>

<jsp:include page="../fragments/footer.jsp"></jsp:include>