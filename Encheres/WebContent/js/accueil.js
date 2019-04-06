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
				//succes(xhr.responseText);//xhr.responseXML si réponse XML
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
				//succes(xhr.responseText);
				var listeEncheres = JSON.parse(xhr.responseText);
				createDashboard(JSON.parse(xhr.responseText))
			} else {
				echec(xhr.status, xhr.responseText);
			}
		}
	}
	xhr.open("GET", "/Encheres/webapi/enchere/", true);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.send(null);
}
function createDashboard(data) {
	
	console.log(data);

	//dashboard Tiles
	
	var dashboard = document.getElementById('dashboard');
		if(data) {
			data.forEach(function(enchere) {
				//dashboard Tiles
				let dashboardTile = document.createElement('div');
				dashboardTile.setAttribute('class', 'card mb-3 mr-1 ml-1 dashboard-tile');
				
				let dashboardTileRow = document.createElement('div');
				dashboardTileRow.setAttribute('class', 'row no-gutters');
				
				let dashboardTileRowImageContainer = document.createElement('div');
				dashboardTileRowImageContainer.setAttribute('class', 'col-md-4');
				
				let image = document.createElement('img');
				image.setAttribute('src', './img/alienware.jpg');
				image.setAttribute('class', 'card-img p-1');
				
				let container = document.createElement('div');
				container.setAttribute('class', 'col-md-8')
				
				let cardBody = document.createElement('div');
				cardBody.setAttribute('class', 'card-body')
				
				let productName = document.createElement('h5');
				productName.setAttribute('class', 'card-title');
				
				let linkProduct = document.createElement('a');
				let linkDetailArticle = '/Encheres/DetailVente?noArticle=' + enchere.noArticle;
				linkProduct.setAttribute('href', linkDetailArticle);
				
				linkProduct.innerText = enchere.nomProduit;
				
				productName.appendChild(linkProduct);
				
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
				
				let linkVendeur = document.createElement('a');
				let linkDetailVendeur = '/Encheres/Profil?userId=' + getCookie('idUtilisateur');
				linkVendeur.setAttribute('href', linkDetailVendeur);
				
				linkVendeur.innerText = 'Vendeur : ' + enchere.pseudoVendeur;
				
				pseudo.appendChild(linkVendeur);
				
				cardBody.appendChild(productName);
				cardBody.appendChild(endDate);
				cardBody.appendChild(amount);
				cardBody.appendChild(pseudo);
				
				container.appendChild(cardBody);
				
				dashboardTileRowImageContainer.appendChild(image);
				
				dashboardTileRow.appendChild(dashboardTileRowImageContainer);
				dashboardTileRow.appendChild(container);
				
				dashboardTile.appendChild(dashboardTileRow);
				
				dashboard.appendChild(dashboardTile);
			});
		} else {
			//display error
		}
		
}
function getCookie(name) {
    var v = document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
    return v ? v[2] : null;
}
function cleanDashboard() {
	let dashboard = document.getElementById("dashboard");
	while (dashboard.firstChild) {
		dashboard.firstChild.remove();
	}
}

function succes(reponse) {
	document.getElementById("succes").innerHTML = reponse;
	document.getElementById("echec").innerHTML = "";
}

function echec(codeReponse, reponse) {
	document.getElementById("echec").innerHTML = reponse;
	document.getElementById("succes").innerHTML = "";
}

function addListeners() {

	document.getElementById('achatsRadio').addEventListener('click', function(event){
		let checkboxGroup = document.getElementById('mesEncheresCheckboxGroup');
		checkboxGroup.childNodes.forEach( function(e1) {

			if(e1.tagName === 'DIV'){
				e1.childNodes.forEach( function(e2) {
					if(e2.tagName === 'INPUT'){
						e2.removeAttribute("disabled");
					}
				});
			}
		});
		checkboxGroup = document.getElementById('mesVentesCheckboxGroup');
		checkboxGroup.childNodes.forEach( function(e1) {

			if(e1.tagName === 'DIV'){
				e1.childNodes.forEach( function(e2) {

					if(e2.tagName === 'INPUT'){
						e2.checked = false;
						e2.setAttribute('disabled', true);
					}
				});
			}
		});
	});
	document.getElementById('ventesRadio').addEventListener('click', function(event){
		let checkboxGroup = document.getElementById('mesEncheresCheckboxGroup');
		checkboxGroup.childNodes.forEach( function(e1) {

			if(e1.tagName === 'DIV'){
				e1.childNodes.forEach( function(e2) {

					if(e2.tagName === 'INPUT'){
						e2.checked = false;
						e2.setAttribute('disabled', true);
					}
				});
			}
		});
		checkboxGroup = document.getElementById('mesVentesCheckboxGroup');
		checkboxGroup.childNodes.forEach( function(e1) {

			if(e1.tagName === 'DIV'){
				e1.childNodes.forEach( function(e2) {

					if(e2.tagName === 'INPUT'){
						e2.removeAttribute("disabled");
					}
				});
			}
		});
	});
}

(function submitForm () {
	var frm = $('#filterForm');

    frm.submit(function (e) {

        e.preventDefault();
        console.log(frm.serialize());
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function (data) {
                console.log('Submission was successful.');
                console.log(data);
                cleanDashboard();
                createDashboard(data);
            },
            error: function (data) {
                console.log('An error occurred.');
                console.log(data);
            },
        });
    });
}) ();

window.onload = function() {
	lister();
	if (document.getElementById('ventesRadio') && document.getElementById('achatsRadio')) {
		addListeners();		
	}
}