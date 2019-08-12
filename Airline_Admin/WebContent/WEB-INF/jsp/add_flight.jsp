<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                <h2>Plain Page</h2>

                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                
                                
                                <form name="form1" action="insert_flight.do" method="post" class="col-lg-6">
                            	<table class="table table-bordered">
												
		                              <tr>
		                                   <td>
		                                    	<select type="number" class="form-control" name="airplane_id" required>
		                                    	<option value="----" selected disabled >Airline name</option>
		                                    	<c:forEach items="${airplane_list}" var="air">
									    			 <option value="${air.airplane_id}">${air.airlineName}</option>
												</c:forEach>
												</select>
		                                  
		                                  </td>
		                              </tr>
		                                <tr>
		                                    <td><input type="text" class="form-control" placeholder="Source" name="source" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="text" class="form-control" placeholder="Destination" name="dest" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="time" class="form-control" placeholder="Departure Time" name="deptTime" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="time" class="form-control" placeholder="Arrival Time" name="arrivalTime" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td> 
		                                    	<select type="text" class="form-control" name="travelClass" required>
												  <option value="Economy" selected>Economy</option>
												  <option value="Premium Economy">Premium Economy</option>
												  <option value="Business">Business</option>
												  <option value="First Class">First Class</option>
												</select>
		                                    </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="number" class="form-control" placeholder="Total Seats" name="totalSeats" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="number" class="form-control" placeholder="Available Seats" name="availableSeats" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="number" class="form-control" placeholder="Amount" name="amount" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="date" class="form-control" placeholder="Departure date" name="deptDate" required/> </td>
		                                </tr>
		                                <tr>
		                                    <td><input type="submit" name="submit1" class="btn btn-default submit" value="Insert flight details" style="background-color: #00264d; color: white"></td>
		                                </tr>
                            </table>
                            </form>
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

<jsp:include page="footer.jsp" />