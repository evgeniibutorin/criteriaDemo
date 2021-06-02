<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<HEAD>
    <!-- JQuerry library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).on("click", "#show_all_courses", function () {
            $("#for_course_list > tbody").remove();
            $.get("http://localhost:9090/criteriaDemo_war_exploded/course", function (responseJson) {
                var $tbody = $("<tbody>").appendTo($("#for_course_list"));
                $.each(responseJson, function (index, course) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(course.id))
                        .append($("<td>").text(course.courseName))
                        .append($("<td>").text(course.cost));
                });
            });
        });
    </script>

    <script type="text/javascript">
        $(document).on("click", "#show_expensive_courses", function () {
            $("#for_course_list > tbody").remove();
            $.get("http://localhost:9090/criteriaDemo_war_exploded/expensive_courses", function (responseJson) {
                var $tbody = $("<tbody>").appendTo($("#for_course_list"));
                $.each(responseJson, function (index, course) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(course.id))
                        .append($("<td>").text(course.courseName))
                        .append($("<td>").text(course.cost));
                });
            });
        });
    </script>

    <script>
        $(document).on("submit", "#find_course_by_student", function () {
            var $form = $(this);
            $("#for_course_list > tbody").remove();
            $.get($form.attr("action"), $form.serialize(), function (response){
                var $tbody = $("<tbody>").appendTo($("#for_course_list"));
                $.each(response, function (index, course) {
                    $("<tr>").appendTo($tbody)
                        .append($("<td>").text(course.id))
                        .append($("<td>").text(course.courseName))
                        .append($("<td>").text(course.cost));
                });
            })
            event.preventDefault();
        });
    </script>

</HEAD>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>
<h3>Find course by Student name</h3>

<button id="show_all_courses" ,>Show all courses</button><br/> <br/>

<button id="show_expensive_courses" ,>Show the most expensive courses</button><br/> <br/>

<form ID="find_course_by_student" method="GET" action="http://localhost:9090/criteriaDemo_war_exploded/courses/find/">
    Student name:
    <input name="name" type="text"/><br/> <br/>
    <input type="submit" name="Find by name" value="Submit"/>
</form>

<h3>List of courses</h3>
<table id="for_course_list" cellpadding="5" cellspacing="5">
    <thead class="title">
    <tr class="title">
        <th class="title">id</th>
        <th class="title">Course</th>
        <th class="title">Cost</th>
    </tr>
    </thead>

</table>
</body>
</html>
