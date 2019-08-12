<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />
        <!-- page content area main -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Plain Page</h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                                <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>
                <div class="row" style="min-height:500px">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>${message}</h2>

                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                               
                               <table class="table table-bordered">
                               <tr>
                               		<th>Airplane ID</th><th>Source</th><th>Destination</th><th>Departure</th><th>Arrival</th>
                               		<th>Travel Class</th><th>Total seats</th><th>Available</th><th>Amount</th><th>Date</th>
                               </tr>
	                               <c:forEach items="${allFlights}" var="flight">
									    <tr>
						                    <td>${flight.airplane_id}</td><td>${flight.source}</td>
						                    <td>${flight.dest}</td><td>${flight.deptTime}</td>
						                    <td>${flight.arrivalTime}</td><td>${flight.travelClass}</td>
						                    <td>${flight.totalSeats}</td><td>${flight.availableSeats}</td>
						                    <td>${flight.amount}</td><td><fmt:formatDate type = "date" value = "${flight.deptDate}" /></td>
									    </tr>
									</c:forEach>
                               </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

<jsp:include page="footer.jsp" />