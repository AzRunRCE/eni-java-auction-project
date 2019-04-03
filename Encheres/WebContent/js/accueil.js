'use strict'

function createXHR() {
	var xhr;
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

var lister = function() {

	var xhr = createXHR();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				succes(xhr.responseText);//xhr.responseXML si réponse XML
				var listeEncheres = JSON.parse(xhr.responseText);
				console.log(listeEncheres);
				var table = document.getElementById('table');
				var thead = document.createElement('thead');
				var tbody = document.createElement('tbody');

				var th1 = document.createElement('th');
				var th2 = document.createElement('th');
				var th3 = document.createElement('th');
				var th4 = document.createElement('th');

				th1.innerText = 'Nom produit';
				th2.innerText = 'date Enchere';
				th3.innerText = 'montant Enchere';
				th4.innerText = 'Pseudo vendeur';

				thead.appendChild(th1);
				thead.appendChild(th2);
				thead.appendChild(th3);
				thead.appendChild(th4);

				listeEncheres
						.forEach(function(enchere) {
							let enchereLigne = document.createElement('tr');
							let nomProduitCase = document
									.createElement('td');
							let dateEnchereCase = document
									.createElement('td');
							let montantEnchereCase = document
									.createElement('td');
							let pseudoVendeurCase = document
									.createElement('td');

							nomProduitCase.innerText = enchere.nomProduit;

							dateEnchereCase.innerText = enchere.dateFinEnchere.dayOfMonth
									+ '-'
									+ enchere.dateFinEnchere.monthValue
									+ '-' + enchere.dateFinEnchere.year;

							montantEnchereCase.innerText = enchere.montant;

							pseudoVendeurCase.innerText = enchere.pseudoVendeur;

							enchereLigne.appendChild(nomProduitCase);
							enchereLigne.appendChild(dateEnchereCase);
							enchereLigne.appendChild(montantEnchereCase);
							enchereLigne.appendChild(pseudoVendeurCase);

							tbody.appendChild(enchereLigne);
						});
				table.appendChild(thead);
				table.appendChild(tbody);
			} else {
				echec(xhr.status, xhr.responseText);
			}
		}
	}
	xhr.open("GET", "/Encheres/webapi/utilisateur/", true);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.send(null);
}

function succes(reponse) {
	document.getElementById("succes").innerHTML = reponse;
	document.getElementById("echec").innerHTML = "";

}

function echec(codeReponse, reponse) {
	document.getElementById("echec").innerHTML = reponse;
	document.getElementById("succes").innerHTML = "";
}

window.onload = function() {
	lister();
}