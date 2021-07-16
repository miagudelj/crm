/**
 * Kurzbeschreibung
 *
 * @author  Mia Gudelj
 * @since   2020-04-10
 * @version 1.0
 */
$(document).ready(
    function () {
        $("#logout").click(sendLogout);
    });

function sendLogout() {

    $.ajax({
        url: "./rest/v1/user/",
        type: "DELETE",
        dataType: "text"
    })

        .done(function (jsonData) {
            window.location.href = ""
        })

        .fail(function (xhr, status, errorThrown) {
            $("#message").text("Es ist ein Fehler aufgetreten");
        })
}