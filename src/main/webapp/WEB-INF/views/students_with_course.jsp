<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>


<br/><a href="<%=request.getContextPath()%>/students">Show all</a><br/>
<c:choose>
    <c:when test="${students != null}">
        <h3>List of student</h3>
        <table cellpadding="5" cellspacing="5">
            <thead>
            <tr>
                <th>id</th>
                <th>Student</th>
                <th>Courses</th>
            </tr>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${students}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.studentName.toString()}</td>
                    <td><c:forEach var="c" items="${s.courses}">${c.courseName.toString()}</c:forEach></td>
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
