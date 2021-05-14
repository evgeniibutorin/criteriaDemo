<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Spring Boot MVC and Hibernate CRUD Example</title>
<body>
<h2>Spring Boot MVC and Hibernate CRUD Example</h2>

<h3>Find Students by course</h3>
<form method="GET" name="find_student_by_course"
      action="<%=request.getContextPath()%>/student/find">
    Student name: <input name="name" value="${name}" type="text" />
    <br/> <br/>
    <input value="Find by course" type="submit" />
</form>
<br/><a href="<%=request.getContextPath()%>/students">Show all</a><br/>
<c:choose>
    <c:when test="${students != null}">
        <h3>List of student</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>id</th>
                <th>Student</th>
            </tr>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${students}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.studentName.toString()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No Students found in the DB!
    </c:otherwise>
</c:choose>

</body>
