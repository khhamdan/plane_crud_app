<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring MVC Form Handling</title>
</head>
<body><center>
    <h2>Create New Plane</h2>
    <form:form method="POST" action="http://localhost:8080/Plane_war_exploded/savePlane.html">
        <table>
<%--            <tr>--%>
<%--                <td><form:label path="planeId">Plane ID:</form:label></td>--%>
<%--                <td><form:input path="planeId" readonly="true"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name" value="${plane.name}"/></td>
            </tr>
            <tr>
                <td><form:label path="seats">Seats:</form:label></td>
                <td><form:input path="seats" value="${plane.seats}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="SAVE"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <c:if test="${!empty planes}">
        <table align="center" border="1">
            <tr>
                <th>PLane ID</th>
                <th>Name</th>
                <th>Seats</th>
            </tr>

            <c:forEach items="${planes}" var="plane">
                <tr>
                    <td><c:out value="${plane.planeId}"/></td>
                    <td><c:out value="${plane.name}"/></td>
                    <td><c:out value="${plane.seats}" /></td>
                    <td align="center"><a href="editPlane.html?planeId=${plane.planeId}">Edit</a> | <a href="deletePlane.html?planeId=${plane.planeId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <h2><a href="addFlight.html">Add Flight</a></h2>
    <h2><a href="addPayment.html">Add Payment</a></h2>

</center>
</body>
</html>