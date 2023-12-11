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
<body>
<center>
    <h2>Create New User</h2>
    <form:form method="POST" action= "http://localhost:8080/Plane_war_exploded/saveUser.html">
        <table>
            <tr>
                <td><form:label path="userId">User ID:</form:label></td>
                <td><form:input path="userId" value="${user.userId}" readonly="true"/></td>
            </tr>
            <tr>
                <td><form:label path="dob">Date of Birth:</form:label></td>
                <td><form:input path="dob" value="${user.dob}"/></td>
            </tr>
            <tr>
                <td><form:label path="email">Email:</form:label></td>
                <td><form:input path="email" value="${user.email}"/></td>
            </tr>
            <tr>
                <td><form:label path="firstName">First Name:</form:label></td>
                <td><form:input path="firstName" value="${user.firstName}"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName">First Name:</form:label></td>
                <td><form:input path="lastName" value="${user.lastName}"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="payment.paymentId">Payment Type:</form:label>
                </td>
                <td>
                    <form:select path="payment.paymentId" cssStyle="width: 150px;">
                        <option value="-1">Select a type</option>
                        <c:forEach items="${payments}" var="payment">
                            <option value="${payment.paymentId}">${payment.paymentMethod}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="phone">Phone:</form:label></td>
                <td><form:textarea path="phone" value="${user.phone}" cssStyle="width: 150px;"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="SAVE"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <c:if test="${!empty users}">
        <table align="center" border="1">
            <tr>
                <th>ID</th>
                <th>Date of Birth</th>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Payment Method</th>
                <th>Phone</th>
                <th>Option</th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userId}"/></td>
                    <td><c:out value="${user.dob}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.payment.paymentMethod}"/></td>
                    <td><c:out value="${user.phone}"/></td>
                    <td align="center"><a href="editUser.html?userId=${user.userId}">Edit</a> | <a href="deleteUser.html?userId=${user.userId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <h2><a href="addPayment.html">Add Payment</a></h2>
    <h2><a href="addPlane.html">Add Plane</a> </h2>

</center>
</body>
</html>
