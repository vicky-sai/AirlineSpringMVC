<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />	
<h1>${message}</h1>
<br>
	<table class="table table-bordered" background="images/Glass.jpg" style="background-size:cover">
                       <tr>
                       <th style="color:white;background-color:black;">Source</th><th style="color:white;background-color:black;">Destination</th>
                       		<th style="color:white;background-color:black;">Departure</th><th style="color:white;background-color:black;">Arrival</th>
                       		<th style="color:white;background-color:black;">No.of Tickets</th>
                       		<th style="color:white;background-color:black;">Total amount</th>
                       		<th style="color:white;background-color:black;">Date</th>
                       		<th style="color:white;background-color:black;">Action</th><th style="color:white;background-color:black;">Action</th>
                       </tr>
                       		 <c:forEach items="${allTickets}" var="ticket">
					    <tr>
					    <td>${ticket.flightDetails.source}</td><td>${ticket.flightDetails.dest}</td>
									<td>${ticket.flightDetails.deptTime}</td>
				                  <td>${ticket.flightDetails.arrivalTime}</td>
				                  <td>${ticket.count}</td>
				                  <td>${ticket.total_amount}</td>
				                  <td><fmt:formatDate type = "date" value = "${ticket.flightDetails.deptDate}" /></td>
				                  <td><a href="print.do?ticketId=${ticket.ticket_id}" style="color:black;">Print</a></td>
				                  <td><a href="cancel.do?ticketId=${ticket.ticket_id}" style="color:black;">Cancel</a></td>
					    </tr>
							</c:forEach>
                       </table>
<jsp:include page="footer.jsp" />	
