<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<html>
<title>Spring MVC, Hibernate and criteria Example</title>
<body>
<h2>Spring MVC, Hibernate and criteria Example</h2>

<h3>Find Students by course</h3>
<form method="GET" name="find_student_by_course"
      action="<%=request.getContextPath()%>/student/find">
    Course name: <input name="name" value="${name}" type="text" />
    <br/> <br/>
    <input value="Find by course name" type="submit" />
</form>
<form method="GET" name="find_student_by_cost"
      action="<%=request.getContextPath()%>/student/cost">
    Course cost: <input name="cost" value="${cost}" type="text" />
    <br/> <br/>
    <input value="Find by course cost" type="submit" />
</form>

<form method="GET" name="find_student_by_cost_more_then"
      action="<%=request.getContextPath()%>/student/cost/more">
    Course with cost more then: <input name="cost" value="${cost}" type="text" />
    <br/> <br/>
    <input value="Find by course cost more then" type="submit" />
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
            <c:forEach var="c" items="${students}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.studentName.toString()}</td>
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
