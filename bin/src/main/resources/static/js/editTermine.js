/**
* view-controller for zoo.html
* 
* M133: MyZoo
*
* @author Mia Gudelj
*/

/**
* register listeners and load the animal data
*/
$(document).ready(
	function() {
		loadUsers();
		loadTermin();

		/**
		 * listener for submitting the form
		 */
		$("#terminEditForm").submit(saveTermin);

		/**
		 * listener for button [abbrechen], redirects to gehege
		 */
		$("#cancel").click(function () {
			window.location.href = "./index.html";
		});
	}
);

/**
 *  loads the data of this tier
 *
 */
function loadTermin() {
	
	var terminId = $.urlParam("terminId");

	if (terminId !== null && terminId != -1) {
		$.ajax({
			url: "./rest/v1/termin/read?terminId=" + terminId,
			type: "GET",
			dataType: "json"
		})

		.done(showTermin)

		.fail(function (xhr, status, errorThrown) {
			if (xhr.status == 403) {
				window.location.href = "./index.html";
			} else if (xhr.status == 404) {
				$("#message").text("Keine Termine gefunden");
			} else {
				window.location.href = "./ediTermine.html";
			}
		})
	}
}


function showTermin(termin) {
	$("#message").empty();

	$("#terminId").val(termin.terminId);
	$("#beschreibung").val(termin.beschreibung);
	$("#datum").val(termin.datum);
	$("#user").val(termin.user.userId);

	if (Cookies.get("userRole") != "admin") {
		$("#beschreibung, #datum, #user").prop("readonly", true);
		$("#save, #reset").prop("disabled", true);
	}
}

function saveTermin(form) {
	form.preventDefault();
	var terminId = $("#terminId").val();

	var url = "./rest/v1/termin/";
	var type = "";

	if (terminId) {
		url += "update";
		type = "PUT";
	} else {
		url += "create";
		type = "POST";
	}

	$.ajax({
			url: url,
			dataType: "text",
			type: type,
			data: $("#terminEditForm").serialize()
		})

	.done(function (jsonData) {
		window.location.href = "./index.html";
	})

	.fail(function (xhr, status, errorThrown) {
		if (xhr.status == 404) {
			$("#message").text("Dieser Termin existiert nicht");
		} else {
			$("#message").text("Fehler beim Speichern des Termins");
		}
	})
}

function loadUsers() {
	$.ajax({
			url: "./rest/v1/users/list",
			dataType: "json",
			type: "GET"
		})
	.done(showUsers)

	.fail(function (xhr, status, errorThrown) {
		if (xhr.status == 404) {
			$("#message").text("Keine User gefunden");
		} else {
			window.location.href = "./index.html";
		}
	})
}

function showUsers(users) {

	$.each(users, function (userId, user) {
		$('#user').append($('<option>', {
			value: user.userId,
			text : user.username
		}));
	});
}
