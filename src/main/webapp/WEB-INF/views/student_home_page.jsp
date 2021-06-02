<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script>
        $(document).on("submit", "#find_student_by_course", function () {
            var $form = $(this);
            $("#for_student_list > tbody").remove();
            $.get($form.attr("action"), $form.serialize(), function (response){
                var $tbody = $("<tbody>").appendTo($("#for_student_list"));
                $.each(response, function (index, student) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(student.id))
                        .append($("<td>").text(student.studentName));
                });
            })
            event.preventDefault();
        });
    </script>

    <script>
        $(document).on("submit", "#find_student_by_cost", function () {
            var $form = $(this);
            $("#for_student_list > tbody").remove();
            $.get($form.attr("action"), $form.serialize(), function (response){
                var $tbody = $("<tbody>").appendTo($("#for_student_list"));
                $.each(response, function (index, student) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(student.id))
                        .append($("<td>").text(student.studentName));
                });
            })
            event.preventDefault();
        });
    </script>

    <script>
        $(document).on("submit", "#find_student_by_cost_more_then", function () {
            var $form = $(this);
            $("#for_student_list > tbody").remove();
            $.get($form.attr("action"), $form.serialize(), function (response){
                var $tbody = $("<tbody>").appendTo($("#for_student_list"));
                $.each(response, function (index, student) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(student.id))
                        .append($("<td>").text(student.studentName));
                });
            })
            event.preventDefault();
        });
    </script>

    <script type="text/javascript">
        $(document).on("click", "#show_all_students", function () {
            $("#for_student_list > tbody").remove();
            $.get("http://localhost:9090/criteriaDemo_war_exploded/student", function (responseJson) {
                var $tbody = $("<tbody>").appendTo($("#for_student_list"));
                $.each(responseJson, function (index, student) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(student.id))
                        .append($("<td>").text(student.studentName));
                });
            });
        });
    </script>

    <script type="text/javascript">
        $(document).on("click", "#show_students_from_list", function () {
            $("#for_student_list > tbody").remove();
            $.get("http://localhost:9090/criteriaDemo_war_exploded/student", function (responseJson) {
                var $tbody = $("<tbody>").appendTo($("#for_student_list"));
                $.each(responseJson, function (index, student) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(student.id))
                        .append($("<td>").text(student.studentName));
                });
            });
        });
    </script>


</head>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>

<h3>Find Students by course</h3>

<form method="GET" ID="find_student_by_course"
      action="http://localhost:9090/criteriaDemo_war_exploded/student/find">
    Course name:
    <input name="name" type="text" /><br/> <br/>
    <input value="Find by course name" type="submit" name="Find by student name"/>
</form>

<form method="GET" id="find_student_by_cost"
      action="http://localhost:9090/criteriaDemo_war_exploded/student/cost">
    Course cost:
    <input name="cost" type="text" /><br/> <br/>
    <input value="Find by course cost" type="submit" />
</form>

<form method="GET" id="find_student_by_cost_more_then"
      action="http://localhost:9090/criteriaDemo_war_exploded/student/cost/more">
    Course with cost more then:
    <input name="cost" type="text" /><br/> <br/>
    <input value="Find by course cost more then" type="submit" />
</form>

<br/>
<button id="show_all_students">Show all students</button><br/>
<br/>
<button id="show_students_from_list">Show students from list</button><br/>


        <h3>List of student</h3>
        <table id="for_student_list" cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>id</th>
                <th>Student</th>
            </tr>
            </tr>
            </thead>

</table>
</body>
</html>

<%--action="<%=request.getContextPath()%>/student/cost">--%>
