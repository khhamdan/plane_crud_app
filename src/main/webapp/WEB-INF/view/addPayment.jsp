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
    <h2>Create New Payment</h2>
    <form:form method="POST" action="http://localhost:8080/Plane_war_exploded/savePayment.html">
        <table>
                <%--            <tr>--%>
                <%--                <td><form:label path="planeId">Plane ID:</form:label></td>--%>
                <%--                <td><form:input path="planeId" readonly="true"/></td>--%>
                <%--            </tr>--%>
                <%--            <tr>--%>
            <td><form:label path="paymentMethod">Payment Method:</form:label></td>
            <td><form:input path="paymentMethod" value="${payment.paymentMethod}"/></td>
            </tr>
            <tr>
                <td><form:label path="creditCardNumber">Credit Card Number:</form:label></td>
                <td><form:input path="creditCardNumber" value="${payment.creditCardNumber}"/></td>
            </tr>
                    <tr>
                        <td><form:label path="expiryDate">Expiry Date:</form:label></td>
                        <td><form:input path="expiryDate" value="${payment.expiryDate}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="SAVE"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <c:if test="${!empty payments}">
        <table align="center" border="1">
            <tr>
                <th>Payment ID</th>
                <th>Payment Method</th>
                <th>Credit Card Number</th>
                <th>Expiry Date</th>
            </tr>

            <c:forEach items="${payments}" var="payment">
                <tr>
                    <td><c:out value="${payment.paymentId}"/></td>
                    <td><c:out value="${payment.paymentMethod}"/></td>
                    <td><c:out value="${payment.creditCardNumber}" /></td>
                    <td><c:out value="${payment.expiryDate}" /></td>
                    <td align="center"><a href="editPayment.html?paymentId=${payment.paymentId}">Edit</a> | <a href="deletePayment.html?paymentId=${payment.paymentId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <h2><a href="addUser.html">Add User</a></h2>
</center>
</body>
</html>