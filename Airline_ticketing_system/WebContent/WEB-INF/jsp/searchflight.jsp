<jsp:include page="header.jsp" /><br>	
	<h1>Flight Ticket Booking</h1>
	<div class="main-agileinfo">
		<div class="sap_tabs">			
			<div id="horizontalTab">
				<ul class="resp-tabs-list">
					<li class="resp-tab-item"><span>Round Trip</span></li>
					<li class="resp-tab-item"><span>One way</span></li>
					<li class="resp-tab-item"><span>Multi city</span></li>				
				</ul>	
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
					<div class="tab-1 resp-tab-content roundtrip">
						<form action="#" method="post">
							<div class="from">
								<h3>From</h3>
								<input type="text" name="city" class="city1" placeholder="Type Departure City" required="">
							</div>
							<div class="to">
								<h3>To</h3>
								<input type="text" name="city" class="city2" placeholder="Type Destination City" required="">
							</div>
							<div class="clear"></div>
							<div class="date">
								<div class="depart">
									<h3>Depart</h3>
									<input  id="datepicker" name="Text" type="text" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}" required="">
									<span class="checkbox1">
										<label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Flexible with date</label>
									</span>
								</div>
								<div class="return">
									<h3>Return</h3>
									<input  id="datepicker1" name="Text" type="text" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}" required="">
									<span class="checkbox1">
										<label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Flexible with date</label>
									</span>
								</div>
								<div class="clear"></div>
							</div>
							<div class="class">
								<h3>Class</h3>
								<select id="w3_country1" onchange="change_country(this.value)" class="frm-field required">
									<option value="null">Economy</option>  
									<option value="null">Premium Economy</option>   
									<option value="null">Business</option>   
									<option value="null">First class</option>   						
								</select>

							</div>
							<div class="clear"></div>
							<div class="numofppl">
								<div class="adults">
									<h3>Adult:(12+ yrs)</h3>
									<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value"><span>0</span></div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</div>
								<div class="child">
									<h3>Child:(2-11 yrs)</h3>
									<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value"><span>0</span></div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<input type="submit" value="Search Flights">
						</form>						
					</div>		
					<div class="tab-1 resp-tab-content oneway">
						<form action="display_availability.do" method="post">
							<div class="from">
								<h3>From</h3>
								<input type="text" name="source" class="city1" placeholder="Type Source City" required>
							</div>
							<div class="to">
								<h3>To</h3>
								<input type="text" name="dest" class="city2" placeholder="Type Destination City" required>
							</div>
							<div class="clear"></div>
							<div class="date">
								<div class="depart">
									<h3>Depart</h3>
									<input class="date" id="datepicker2" name="date" type="text" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}" required="">
									<span class="checkbox1">
										<label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Flexible with date</label>
									</span>
								</div>
							</div>
							<div class="class">
								<h3>Class</h3>
								<select id="w3_country1" onchange="change_country(this.value)" class="frm-field required"  name="travelClass" required>
									<option value="Economy" selected>Economy</option>
								  <option value="Premium Economy">Premium Economy</option>
								  <option value="Business">Business</option>
								  <option value="First Class">First Class</option>   						
								</select>

							</div>
							<div class="clear"></div>
							<div class="numofppl">
								<div class="adults">
									<h3>Adult:(12+ yrs)</h3>
									<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value" id="adult">0</div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</div>
								<div class="child">
									<h3>Child:(2-11 yrs)</h3>
									<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value" id="child">0</div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<input type="text" name="count" value="1" style="display:none;" id="count"/>
							<input type="submit" value="Search Flights" onclick="myFunction()">
						</form>	
					</div>
					<script>
					function myFunction() {
					    document.getElementById("count").value = parseInt(document.getElementById("adult").innerText) + parseInt(document.getElementById("child").innerText);
					}
					</script>
					
					<div class="tab-1 resp-tab-content multicity">
						
									<form action="#" method="post">
										<div class="from">
											<h3>From</h3>
											<input type="text" name="city" class="city1" placeholder="Type Departure City" required="">
										</div>
										<div class="to">
											<h3>To</h3>
											<input type="text" name="city" class="city2" placeholder="Type Destination City" required="">
										</div>
										<div class="clear"></div>
										<div class="date">
											<div class="depart">
												<h3>Depart</h3>
												<input class="date" id="datepicker3" name="Text" type="text" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}" required="">
												<span class="checkbox1">
													<label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Flexible with date</label>
												</span>
											</div>
										</div>
										<div class="class">
											<h3>Class</h3>
											<select id="w3_country1" onchange="change_country(this.value)" class="frm-field required">
												<option value="null">Economy</option>  
												<option value="null">Premium Economy</option>   
												<option value="null">Business</option>   
												<option value="null">First class</option>   						
											</select>
										</div>
										<div class="clear"></div>
										<div id="loadMore">Add City+</div>
										<div id="showLess">Remove</div>
									</form>
				<div class="load_more">	
						<ul id="myList">
							<li>
			
								<div class="l_g spcl">
									<form action="#" method="post" class="blackbg">
										<div class="from">
											<h3>From</h3>
											<input type="text" name="city" class="city1" placeholder="Type Departure City" required="">
										</div>
										<div class="to">
											<h3>To</h3>
											<input type="text" name="city" class="city2" placeholder="Type Destination City" required="">
										</div>
										<div class="clear"></div>
										<div class="date">
											<div class="depart">
												<h3>Depart</h3>
												<input class="date" id="datepicker" name="Text" type="text" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}" required="">
												<span class="checkbox1">
													<label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Flexible with date</label>
												</span>
											</div>
										</div>
										<div class="clear"></div>
									</form>
					
								</div>
								
							</li>
							<form action="#" method="post">
							<div class="numofppl">
								<div class="adults">
									<h3>Adult:(12+ yrs)</h3>
									<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value"><span>1</span></div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</div>
								<div class="child">
									<h3>Child:(2-11 yrs)</h3>
									<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value"><span>1</span></div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<input type="submit" value="Search Flights">
							</form>
						</ul>
					</div>
					</div>
		
				</div>						
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp" />		
	