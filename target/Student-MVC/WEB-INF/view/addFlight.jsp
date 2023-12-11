<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Spring MVC Form Handling</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	</head>
	<body>
	<center>
		<h2>Create New Flight</h2>
		<form:form method="POST" action= "http://localhost:8080/Plane_war_exploded/saveFlight.html">
	   		<table>
				<tr>
					<div class="input-box">
						<span class="details">Departure:</span>
						<input type="text" placeholder="Enter departure" name="departure" required>
					</div>

					<td><form:label path="flightId">Flight ID:</form:label></td>
			        <td><form:input path="flightId" value="${flight.flightId}" readonly="true"/></td>
			    </tr>
				<tr>
					<td><form:label path="departure">Department:</form:label></td>
					<td><form:input path="departure" value="${flight.departure}"/></td>
				</tr>
				<tr>
			        <td><form:label path="arrival">Arrival Time:</form:label></td>
			        <td><form:input path="arrival" value="${flight.arrival}"/></td>
			    </tr>
				<tr>
				<td><form:label path="economyAdultPrice">Economy Adult Price:</form:label></td>
				<td><form:input path="economyAdultPrice" value="${flight.economyAdultPrice}"/></td>
				</tr>
				<tr>
				<td><form:label path="businessAdultPrice">Economy Adult Price:</form:label></td>
				<td><form:input path="businessAdultPrice" value="${flight.businessAdultPrice}"/></td>
				</tr>
				<tr>
					<td><form:label path="economyChildPrice">Economy Child Price:</form:label></td>
					<td><form:input path="economyChildPrice" value="${flight.economyChildPrice}"/></td>
				</tr>
				<tr>
					<td><form:label path="businessChildPrice">Business Child Price:</form:label></td>
					<td><form:input path="businessChildPrice" value="${flight.businessChildPrice}"/></td>
				</tr>
				<tr>
				    <td>
				    	<form:label path="plane.planeId">Plane Type:</form:label>
				    </td>
				    <td>
				   		<form:select path="plane.planeId" cssStyle="width: 150px;">
							<option value="-1">Select a type</option>
							<c:forEach items="${planes}" var="plane">
								<option value="${plane.planeId}">${plane.name}</option>
							</c:forEach>
						</form:select>
					</td>
			    </tr>
				<tr>
					<td><form:label path="departureDate">Departure Date:</form:label></td>
					<td><form:input path="departureDate" value="${flight.departureDate}"/></td>
				</tr>
			    <tr>
			      <td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      </tr>
			</table> 
		</form:form>
		<br/>
  <c:if test="${!empty flights}">
	<table align="center" border="1">
		<tr>
			<th>flightId</th>
			<th>departure</th>
			<th>arrival</th>
			<th>Economy Adult Price</th>
			<th>Business Adult Price</th>
			<th>Economy Child Price</th>
			<th>Business Child Price</th>
			<th>Plane</th>
			<th>Departure Date</th>
			<th>Options</th>
		</tr>

		<c:forEach items="${flights}" var="flight">
			<tr>
				<td><c:out value="${flight.flightId}"/></td>
				<td><c:out value="${flight.departure}"/></td>
				<td><c:out value="${flight.arrival}"/></td>
				<td><c:out value="${flight.economyAdultPrice}"/></td>
				<td><c:out value="${flight.businessAdultPrice}"/></td>
				<td><c:out value="${flight.economyChildPrice}"/></td>
				<td><c:out value="${flight.businessChildPrice}"/></td>
				<td><c:out value="${flight.plane.name}"/></td>
				<td><c:out value="${flight.departureDate}"/></td>
				<td align="center"><a href="editFlight.html?flightId=${flight.flightId}">Edit</a> | <a href="deleteFlight.html?flightId=${flight.flightId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<h2><a href="addPlane.html">Adding Plane</a></h2>
</center>
	</body>
</html>
