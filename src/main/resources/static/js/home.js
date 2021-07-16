/**
 * view-controller for index.html
 *
 * M133: MyZoo
 *
 * @author Mia Gudelj
 */

$(document).ready(
    function () {
		
        loadTermine();

        /**
         * listener for buttons within tierForm
         */
        $("#terminForm").on("click", "button", function () {
            if (confirm("Wollen Sie diesen Termin wirklich löschen?")) {
                deleteTermin(this.value);
            }
        });
    }
);

function loadTermine() {

    $.ajax({
        url: "./rest/v1/users/list",
        type: "GET",
        dataType: "json"
    })

    .done(showTermine)

    .fail(function (xhr, status, errorThrown) {
        if (xhr.status == 403) {
          	window.location.href("./");
        } else if (xhr.status == 404) {
            $("#message").text("keine termine vorhanden");
        }else {
            $("#message").text("Fehler beim Lesen der Termine");
        }
    })
}

function showTermine(terminData) {

    $("#message").empty();
    $("#home > tbody").html("");

    var tableData = "";

    $.each(terminData, function (userId, user) {

        tableData += `<tr>`;
        tableData += `<td> ${user.termin.beschreibung}</td>`;
        tableData += `<td> ${user.termin.datum}</td>`;
        tableData += `<td> ${user.username}</td>`;

        if (Cookies.get("userRole") == "admin") {
            tableData += "<td><a class='btn' role='button' href='./editTermin.html?userId=" + userId + "'>Bearbeiten</a></td>";
            tableData += "<td><button class='btn' type='button' id='delete_" + userId + "' value='" + userId + "'>Löschen</button></td>";

        } else {
            tableData += "<td><a href='./editTermin.html?userId=" + userId + "'>Ansehen</a></td>";

        }
        tableData += "</tr>";
    })
    $("#home > tbody").html(tableData);
}

function deleteTermin(terminId) {
    $.ajax({
        url: "./rest/v1/termin/delete?terminId=" + terminId,
        dataType: "text",
        type: "DELETE",
    })

    .done(function (data) {
        loadTermine();
        $("#message").text("Termin gelöscht");

    })

    .fail(function (xhr, status, errorThrown) {
        $("#message").text("Fehler beim Löschen des Termins");
    })
}
