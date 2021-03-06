<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>

<br/><a href="<%=request.getContextPath()%>/course">Show all</a><br/>
<c:choose>
    <c:when test="${courses != null}">
        <h3>List of course</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>id</th>
                <th>Course</th>
                <th>Student</th>
            </tr>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${courses}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.courseName.toString()}</td>
                    <td><c:forEach var="s" items="${c.students}">${s.studentName.toString()}</c:forEach></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>
    <c:otherwise>
        No courses found in the DB!
    </c:otherwise>
</c:choose>

</body>
