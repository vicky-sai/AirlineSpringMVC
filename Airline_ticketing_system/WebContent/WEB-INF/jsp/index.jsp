<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8" />
        <title>Login and Registration Form</title>
        <link href="css/footer.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style3.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<script>
			function myFunction(v)
			{
				if(v==1)
					document.getElementById("myId").innerHTML="<img src='images/bg1.jpg' style='background-repeat:no-repeat;background-size:cover;'>";
				else
					document.getElementById("myId").innerHTML="";
			}
		</script>
    </head>
    <body>
        <div class="container">
            <div class="codrops-top">
                <div class="clr"></div>
            </div>
            <header>
                <h1>Airline Ticketing <br><span>Login / Registration Form</span></h1>
				
            </header>
					<nav class="codrops-demos">
						<a href="http://vicksub.wordpress.com" class="current-demo">Click to view our blog</a>
					</nav>
					<form:errors path="passenger.*"/>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                        
                            <form  action="login.do" autocomplete="on" method="post"> 
                                <h1>Log in</h1>
                                <h3><span style="color:red">${error}</span></h3> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > Your username </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="Username"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="Password" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register" onclick="myFunction(1)">Join us</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                            <form  action="signup.do" autocomplete="on" method="post"> 
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your name</label>
                                    <input id="usernamesignup" name="passengerName" required="required" type="text" placeholder="Passenger Name" />
                                </p>
                                
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <input id="emailsignup" name="email" required="required" type="email" placeholder="example@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your Mobile Number</label>
                                    <input id="usernamesignup" name="mobileNumber" required="required" type="text" placeholder="8608577937" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your Date of Birth</label>
                                    <input id="usernamesignup" name="dateOfBirth" required="required" type="date" placeholder="DOB" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your Username</label>
                                    <input id="usernamesignup" name="userName" required="required" type="text" placeholder="Username" />
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <input id="passwordsignup" name="password" required="required" type="password" placeholder="Password"/>
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Door number</label>
                                    <input id="usernamesignup" name="address.doorNo" required="required" type="text" placeholder="Eg. 38" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your street</label>
                                    <input id="usernamesignup" name="address.street" required="required" type="text" placeholder="Downing street" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your city</label>
                                    <input id="usernamesignup" name="address.city" required="required" type="text" placeholder="Coimbatore" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your country</label>
                                    <input id="usernamesignup" name="a  ddress.country" required="required" type="text" placeholder="India" />
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your pincode</label>
                                    <input id="usernamesignup" name="address.pincode" required="required" type="number" placeholder="pincode" />
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register" onclick="myFunction(0)"> Go and log in </a>
								</p>
								 
                            </form>
                        
                        </div>						
                    </div>                    
                </div>  
            </section>
        </div>
        <div id="myId"></div>
	<jsp:include page="footer.jsp" />	
    </body>
</html>