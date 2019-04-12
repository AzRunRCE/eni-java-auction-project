'use strict'

var lister = function() {
	hideEchec();
    $.ajax({
        type: "GET",
        url: "/Encheres/webapi/enchere/",
        success: function (data) {
            console.log('download was successful.');
            console.log(data);
            createDashboard(data);
        },
        error: function (data) {
            console.log('An error occurred.'); //error 500
            cleanDashboard();
            console.log(data);
            echec(500)
        },
    });
}

function createDashboard(data) {

	//dashboard Tiles
	
	var dashboard = document.getElementById('dashboard');
	
		if(data && data.length > 0) {
			data.forEach(function(enchere) {
				//dashboard Tiles
				let dashboardTile = document.createElement('div');
				dashboardTile.setAttribute('class', 'card mb-3 mr-1 ml-1 dashboard-tile');
				
				let dashboardTileRow = document.createElement('div');
				dashboardTileRow.setAttribute('class', 'row no-gutters');
				
				let dashboardTileRowImageContainer = document.createElement('div');
				dashboardTileRowImageContainer.setAttribute('class', 'col-4');
				
				let image = document.createElement('img');
				if(enchere.chemin_image) {
					image.setAttribute('src', 'http://localhost:8080/EncheresImages/'+enchere.chemin_image);
				} else {
					image.setAttribute('src', 'http://localhost:8080/EncheresImages/default.jpg');					
				}
				image.setAttribute('class', 'card-img p-1');
				
				let container = document.createElement('div');
				container.setAttribute('class', 'col-8')
				
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
				if (navigator.language.includes('fr') ) {
					dateEnchere.locale('fr');
					endDate.innerText = "Fin de l'enchère : " + dateEnchere.format('DD/MM/YYYY - HH[H]mm');					
				} else {
					dateEnchere.locale('en');
					endDate.innerText = "End of auction : " + dateEnchere.format('DD/MM/YYYY - hh[H]mm A');	
				}

				let amount = document.createElement('p');
				amount.setAttribute('class', 'card-text');
				if (navigator.language.includes('fr') ) {
					amount.innerText = 'Prix : ' + enchere.montant + ' points';					
				} else {
					amount.innerText = 'Price : ' + enchere.montant + ' points';		
				}
				
				let pseudo = document.createElement('p');
				pseudo.setAttribute('class', 'card-text');
				if( getCookie('idUtilisateur') ) {
					let linkVendeur = document.createElement('a');
					let linkDetailVendeur = '/Encheres/Profil?userId=' + enchere.noVendeur;
					linkVendeur.setAttribute('href', linkDetailVendeur);
					
					if (navigator.language.includes('fr') ) {
						linkVendeur.innerText = 'Vendeur : ' + enchere.pseudoVendeur;										
					} else {
						linkVendeur.innerText = 'Seller : ' + enchere.pseudoVendeur;	
					}
					pseudo.appendChild(linkVendeur);	
				} else {
					if (navigator.language.includes('fr') ) {
						pseudo.innerText = 'Vendeur : ' + enchere.pseudoVendeur;										
					} else {
						pseudo.innerText = 'Seller : ' + enchere.pseudoVendeur;	
					}
				}
				
				
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
			//display error pas d'articles a afficher
			echec();
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

function echec(codeReponse) {
	if(codeReponse == '200' || codeReponse == null) {
		if (navigator.language.includes('fr') ) {
			document.getElementById("echec").innerText = 'Aucun article ne semble correspondre aux filtres saisis.';				
		} else {
			document.getElementById("echec").innerText = 'No article seems to match the filters entered.';
		}
	} else if (codeReponse == '500') {
		if (navigator.language.includes('fr') ) {
			document.getElementById("echec").innerText = 'Un problème technique est survenu, veuillez réessayer plus tard.';				
		} else {
			document.getElementById("echec").innerText = 'There was a technical problem, please try again later.';	
		}
	}
	document.getElementById('echec').removeAttribute("hidden");
}
function hideEchec() {
	document.getElementById('echec').setAttribute('hidden', 'true');
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
        hideEchec();
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
                cleanDashboard();
                console.log(data.status);
                echec(500);
            },
        });
    });
}) ();

window.onload = function() {
	if(getCookie('idUtilisateur')){
		$("#filterForm").trigger("submit");
	} else {
		lister();		
	} 
	if (document.getElementById('ventesRadio') && document.getElementById('achatsRadio')) {
		addListeners();		
	}
}