
$( "#deleteAccountBtn" ).click(function() {
	 $("#deleteAccountForm").submit();
});
var password = document.getElementById("inputNewPassword")
, confirm_password = document.getElementById("inputConfirmationPassword");


function validatePassword(){
	if(password.value != confirm_password.value) {
		if (navigator.language === 'fr') {
			confirm_password.setCustomValidity("Les mot de passes de correspondent pas.");			
		} else {
			confirm_password.setCustomValidity("Passwords do not match.");	
		}
	} else {
	  confirm_password.setCustomValidity('');
	}
}
document.getElementById("updateProfil").onclick = function(){
	if ($("#inputPassword").val() != '' && ($("#inputNewPassword").val() === '' || $("#inputConfirmationPassword").val() === '')){
		if (navigator.language === 'fr') {
			document.getElementById("inputNewPassword").setCustomValidity("Inserez un nouveau mot de passe");
		} else {
			document.getElementById("inputNewPassword").setCustomValidity("Insert a new password");
		}
		return;
	}
	else {
		document.getElementById("inputNewPassword").setCustomValidity('');
	}
};
password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;