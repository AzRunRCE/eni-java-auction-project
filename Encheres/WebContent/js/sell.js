var btnValidSell = document.getElementById("btnValidSell");
btnValidSell.onclick = function(e){
	
	var DateFinEncheres = document.getElementById("DateFinEncheres")
	var DateDebutEncheres = document.getElementById("DateDebutEncheres")
  	DateFinEncheres.setCustomValidity('');
	DateDebutEncheres.setCustomValidity('');
	var pattern = "^([0-9]{4})-([0-9]{2})-([0-9]{2})([a-zA-Z]{1})([0-9]{2}):([0-9]){2}";
  	if (!new RegExp(pattern,"gm").test(DateDebutEncheres.value) ){
	  	DateDebutEncheres.setCustomValidity("La date saisie n'est par correcte");
		return;
  	}
  	if (!new RegExp(pattern,"gm").test(DateFinEncheres.value) ){
	  	DateFinEncheres.setCustomValidity("La date saisie n'est par correcte");
		return;
  	}
  	
	var Debut = new Date(Date.parse(DateDebutEncheres.value));
  	var Fin = new Date(Date.parse(DateFinEncheres.value));
  	if (Fin < Debut) {
  		DateFinEncheres.setCustomValidity("La date de fin ne peut être inférieur à celle de début")
  		return;
  	}
  	Debut.setDate(Debut.getDate() + 720);
  	if (Debut < Fin) {
  		DateFinEncheres.setCustomValidity("La date de fin est trop éloignée")
  		return;
  	}
	DateFinEncheres.setCustomValidity('');
	DateDebutEncheres.setCustomValidity('');
}