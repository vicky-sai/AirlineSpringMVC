<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp" />
        <!-- page content area main -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h4>Welcome admin</h4>
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
                                <h1>${message}</h1>
								<h3><form:errors path="flightDetails.*"/></h3>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                               <img src="images/bg1.jpg" height="400px" width="700px"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

<jsp:include page="footer.jsp" />