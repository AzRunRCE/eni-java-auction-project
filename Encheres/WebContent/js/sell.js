var btnValidSell = document.getElementById("btnValidSell");
btnValidSell.onclick = function(e){
	
	var DateFinEncheres = document.getElementById("DateFinEncheres")
	var DateDebutEncheres = document.getElementById("DateDebutEncheres")
  	DateFinEncheres.setCustomValidity('');
	DateDebutEncheres.setCustomValidity('');
	var pattern = "^([0-9]{4})-([0-9]{2})-([0-9]{2})([a-zA-Z]{1})([0-9]{2}):([0-9]){2}";
  	if (!new RegExp(pattern,"gm").test(DateDebutEncheres.value) ){
  		if (navigator.language === 'fr') {
  			DateDebutEncheres.setCustomValidity("La date saisie n'est par correcte");
  		} else {
  			DateDebutEncheres.setCustomValidity("The date entered is not correct");
  		}
		return;
  	}
  	if (!new RegExp(pattern,"gm").test(DateFinEncheres.value) ){
  		if (navigator.language === 'fr') {
  			DateFinEncheres.setCustomValidity("La date saisie n'est par correcte");
  		} else {
  			DateDebutEncheres.setCustomValidity("The date entered is not correct");
  		}
		return;
  	}
  	
	var Debut = new Date(Date.parse(DateDebutEncheres.value));
  	var Fin = new Date(Date.parse(DateFinEncheres.value));
  	if (Fin < Debut) {
  		if (navigator.language === 'fr') {
  			DateFinEncheres.setCustomValidity("La date de fin ne peut être inférieur à celle de début");
  		} else {
  			DateFinEncheres.setCustomValidity("The end date can not be less than the start date");
  		}
  		return;
  	}
  	Debut.setDate(Debut.getDate() + 720);
  	if (Debut < Fin) {
  		if (navigator.language === 'fr') {
  			DateFinEncheres.setCustomValidity("La date de fin est trop éloignée")
  		} else {
  			DateFinEncheres.setCustomValidity("The end date is too far");
  		}
  		return;
  	}
	DateFinEncheres.setCustomValidity('');
	DateDebutEncheres.setCustomValidity('');
}