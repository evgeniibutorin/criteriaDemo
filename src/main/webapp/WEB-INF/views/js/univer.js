$(document).on("click", "#superbutton", function () {//Когда событие "click" HTML DOM вызывается для элемента с идентификатором somebutton, выполните следующую функцию
    $.get("/university", function(responseJson){//Выполните запрос Ajax GET по URL-адресу "/university" и выполните следующую функцию с ответом Ajax JSON.
        var $table = $("<table>").appendTo($("#somediv"));//Создайте элемент HTML <table> и добавьте его к элементу HTML DOM с идентификатором somediv.
        $.each(responseJson, function (index, university) {//Итерировать по массиву JSON
            $("<tr>").appendTo($table) //Создайте элемент HTML <tr>, установите его текстовое содержимое с текущим итерируемым элементом и добавьте его в <table>.
                .append($("<td>").text(university.id))//Создайте элемент HTML <td>, установите его текстовое содержимое с идентификатором текущего итерационного университета и добавьте его в <tr>.
                .append($("<td>").text(university.universityName)) //Создайте элемент HTML <td>, установите его текстовое содержимое с именем текущего итерационного университета и добавьте его в <tr>.
                .append($("<td>").text(university.rating)); //Создайте элемент HTML <td>, установите его текстовое содержимое с рейтингом текущего итерационного университета и добавьте его в <tr>.
        });
    });
});