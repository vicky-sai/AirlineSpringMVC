<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                               		<th>Airplane ID</th><th>Source</th><th>Destination</th><th>Action</th>
                               </tr>
	                               <c:forEach items="${allFlights}" var="flight">
									    <tr>
						                    <td>${flight.airplane_id}</td><td>${flight.source}</td>
						                    <td>${flight.dest}</td><td><a href="deleteFli.do?fId=${flight.flight_id}">Delete</a></td>
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