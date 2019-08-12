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
                                
                                
                                <form name="form1" action="insert_airline.do" method="post" class="col-lg-6">
                            	<table class="table table-bordered">
		                              <tr>
		                                  <td><input type="text" class="form-control" placeholder="Airline Name" name="airlineName" required/> </td>
		                              </tr>
		                                <tr>
		                                    <td><input type="submit" name="submit1" class="btn btn-default submit" value="Insert airline details" style="background-color: #00264d; color: white"></td>
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