<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />	
<h1>${message}</h1>
<br>
	<table class="table table-bordered" background="images/Glass.jpg" style="background-size:cover">
                       <tr>
                       		<th bgcolor="#574DFA">Airplane ID</th><th bgcolor="#574DFA">Departure</th><th bgcolor="#574DFA">Arrival</th>
                       		<th bgcolor="#574DFA">Total seats</th><th bgcolor="#574DFA">Available</th><th bgcolor="#574DFA">Amount</th>
                       		<th bgcolor="#574DFA">Date</th><th bgcolor="#574DFA">Action</th>
                       </tr>
                        <c:forEach items="${allFlights}" var="flight">
					    <tr>
				                  <td>${flight.airplane_id}</td><td>${flight.deptTime}</td>
				                  <td>${flight.arrivalTime}</td><td>${flight.totalSeats}</td>
				                  <td>${flight.availableSeats}</td><td>${flight.amount}</td>
				                  <td><fmt:formatDate type = "date" value = "${flight.deptDate}" /></td>
				                  <td><a href="bookFlight.do?flightId=${flight.flight_id}&count=${count}">Book</a></td>
					    </tr>
	</c:forEach>
                       </table>
<jsp:include page="footer.jsp" />	
