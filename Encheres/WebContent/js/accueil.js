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
				
				//tableau
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
				//dashboard Tiles
				
				var dashboard = document.getElementById('dashboard');

				listeEncheres
						.forEach(function(enchere) {
							//dashboard Tiles
							let dashboardTile = document.createElement('div');
							dashboardTile.setAttribute('class', 'card mb-3 mr-1 ml-1 dashboard-tile');
							
							let dashboardTileRow = document.createElement('div');
							dashboardTileRow.setAttribute('class', 'row no-gutters');
							
							let dashboardTileRowImageContainer = document.createElement('div');
							dashboardTileRowImageContainer.setAttribute('class', 'col-md-4');
							
							let image = document.createElement('img');
							image.setAttribute('src', './img/alienware.jpg');
							image.setAttribute('class', 'card-img');
							
							let container = document.createElement('div');
							container.setAttribute('class', 'col-md-8')
							
							let cardBody = document.createElement('div');
							cardBody.setAttribute('class', 'card-body')
							
							let productName = document.createElement('h5');
							productName.setAttribute('class', 'card-title');
							productName.innerText = enchere.nomProduit;
							
							let endDate = document.createElement('p');
							endDate.setAttribute('class', 'card-text');
							
							let dateEnchere = moment(enchere.dateFinEnchere, moment.ISO_8601);
							dateEnchere.locale('fr');
							
							endDate.innerText = "Fin de l'enchère : " + dateEnchere.format('DD/MM/YYYY - h:mm');

							let amount = document.createElement('p');
							amount.setAttribute('class', 'card-text');
							amount.innerText = 'Prix : ' + enchere.montant + ' points';
							
							let pseudo = document.createElement('p');
							pseudo.setAttribute('class', 'card-text');
							pseudo.innerText = 'Vendeur : ' + enchere.pseudoVendeur;
							
							cardBody.appendChild(productName);
							cardBody.appendChild(endDate);
							cardBody.appendChild(amount);
							cardBody.appendChild(pseudo);
							
							container.appendChild(cardBody);
							
							dashboardTileRowImageContainer.appendChild(image);
							
							dashboardTileRow.appendChild(dashboardTileRowImageContainer);
							dashboardTileRow.appendChild(container);
							
							dashboardTile.appendChild(dashboardTileRow);
							
							// tableau
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
							
							dateEnchereCase.innerText = dateEnchere.format('dddd Do MMMM YYYY - h:mm');

							montantEnchereCase.innerText = enchere.montant;

							pseudoVendeurCase.innerText = enchere.pseudoVendeur;

							enchereLigne.appendChild(nomProduitCase);
							enchereLigne.appendChild(dateEnchereCase);
							enchereLigne.appendChild(montantEnchereCase);
							enchereLigne.appendChild(pseudoVendeurCase);

							tbody.appendChild(enchereLigne);
							dashboard.appendChild(dashboardTile);
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