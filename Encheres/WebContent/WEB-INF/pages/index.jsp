<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<jsp:include page="../fragments/header.jsp" >
	<jsp:param value="Accueil" name="title"/>
</jsp:include>

<table class="table" id="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">date Enchere</th>
      <th scope="col">montant Enchere</th>
    </tr>
  </thead>
</table>
<script>
function createXHR() {
	if (window.XMLHttpRequest) //  Objet standard
	{
		xhr = new XMLHttpRequest(); //  Firefox, Safari, ...
	} else if (window.ActiveXObject) //  Internet Explorer
	{
		xhr = new ActiveXObject("Msxml2.XMLHTTP");
	}

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				succes(xhr.responseText);//xhr.responseXML si réponse XML
			} else {
				echec(xhr.status, xhr.responseText);
			}
		}
	};
	return xhr;
}

var peuplerBase = function {
	var table = document.getElementById('table');
	var thead = document.createElement('thead');
	
	var th1 = document.createElement('th');
	var th2 = document.createElement('th');
	var th3 = document.createElement('th');
	
	th1.innerText = '#';
	th2.innerText = 'date Enchere';
	th3.innerText = 'montant Enchere';
	
	thead.appendChild(th1);
	thead.appendChild(th2);
	thead.appendChild(th3);
	
	var tbody = document.createElement('tbody');
	
	var xhr = createXHR();
	xhr.open("GET", "/Encheres/webapi/utilisateur/", true);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.send(null);
	var tr = document.createElement('tr');

}

</script>
<jsp:include page="../fragments/footer.jsp" ></jsp:include>