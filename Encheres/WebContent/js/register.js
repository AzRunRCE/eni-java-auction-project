var password = document.getElementById("inputPassword")
, confirm_password = document.getElementById("inputConfirmationPassword");

function validatePassword(){
if(password.value != confirm_password.value) {
	if (navigator.language.includes('fr') ) {
		confirm_password.setCustomValidity("Les mot de passes de correspondent pas.");		
	} else {
		confirm_password.setCustomValidity("Passwords do not match.");	
	}
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;