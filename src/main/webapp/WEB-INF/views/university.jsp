<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <!-- JQuerry library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).on("click", "#superbutton", function () {
            $.get("http://localhost:9090/criteriaDemo_war_exploded/university", function(responseJson){
                var $table = $("<table>").appendTo($("#somediv"));
                $.each(responseJson, function (index, university) {
                    $("<tr>").appendTo($table)
                        .append($("<td>").text(university.id))
                        .append($("<td>").text(university.universityName))
                        .append($("<td>").text(university.rating));
                });
            });
        });
    </script>
</head>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>
<button id="superbutton",>Show all universities</button>
<div id="somediv">
</div>

</body>
<footer>

</footer>
</html>
