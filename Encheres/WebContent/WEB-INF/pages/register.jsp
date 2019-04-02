<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    

<jsp:include page="../fragments/header.jsp" >
	<jsp:param value="Accueil" name="title"/>
</jsp:include>
<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Speudo</label>
    <input type="text" pattern="[a-zA-Z0-9\s]+" class="form-control" id="inputSpeudo" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="inputPassword" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" id="inputConfirmPassword" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<script>
var password = document.getElementById("inputPassword")
, confirm_password = document.getElementById("inputConfirmPassword");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
<jsp:include page="../fragments/footer.jsp" ></jsp:include>