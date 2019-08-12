<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />	

<center><h1>${message}</h1>
<br> <br> <br>
	 <div class="btn-group btn-group-lg">
		    <a href="searchflight.do"><button type="button" class="btn btn-primary">Search/Book flights</button></a>
		    <br> <br> <br>
		    <a href="mybooked.do"><button type="button" class="btn btn-primary">View/Print Booked Tickets</button></a>
		    <br> <br> <br>
		    <a href="mybooked.do"><button type="button" class="btn btn-primary">Cancel Ticket</button></a>
		    <br> <br> <br>
		    <a href="mid.do"><button type="button" class="btn btn-primary">Home</button></a>
  	</div></center>
<jsp:include page="footer.jsp" />	
