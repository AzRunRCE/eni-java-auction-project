<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<fmt:setBundle basename="fr.eni.ecole.messages.footer" var="r"/>
		
		<footer>
			<nav class="navbar navbar-light bg-light justify-content-center mt-3">
	  			<fmt:message key="msg.copyright" bundle="${r}"></fmt:message>
			</nav>
		</footer>
		<script src="${pageContext.request.contextPath }/theme/bootstrap-4.1.3/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath }/theme/bootstrap-4.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>