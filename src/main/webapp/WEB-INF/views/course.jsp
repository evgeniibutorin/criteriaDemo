<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>

<h3>Find course by Student name</h3>
<form method="GET" name="find_course_by_student"
      action="<%=request.getContextPath()%>/courses/find">
    Student name: <input name="name" value="${name}" type="text" />
    <br/> <br/>
    <input value="Find by name" type="submit" />
</form>
<br/><a href="<%=request.getContextPath()%>/courses">Show course with student</a><br/>
<br/><a href="<%=request.getContextPath()%>/expensive_courses">Show the most expensive </a><br/>
<c:out value="${cost}"></c:out>

<c:choose>
    <c:when test="${courses != null}">
        <h3>List of courses</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>id</th>
                <th>Course</th>
                <th>Cost</th>
            </tr>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${courses}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.courseName.toString()}</td>
                    <td>${c.cost.toString()}
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No Courses found in the DB!
    </c:otherwise>
</c:choose>

</body>
</html>
