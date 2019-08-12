<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Admin Login Form | AMS </title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/custom.min.css" rel="stylesheet">
</head>

<br>

<div class="col-lg-12 text-center ">
    <h1 style="font-family:Lucida Console">Airline Management System</h1>
</div>

<br>

<body class="login">


<div class="login_wrapper">

    <section class="login_content">
        <form name="form1" action="validateLogin.do" method="post">
            <h1>Admin Login Form</h1>
			<h2 style="color:red">${error}</h2>	

            <div>
                <input type="text" name="userName" class="form-control" placeholder="Username" required/>
            </div>
            <div>
                <input type="password" name="password" class="form-control" placeholder="Password" required/>
            </div>
            <div>

                <input class="btn btn-default submit" type="submit" name="submit1" value="Login" >
                <a class="reset_pass" href="#">Lost your password?</a>
            </div>

            <div class="clearfix"></div>

            <div class="separator">


                <div class="clearfix">If you are an auhthorized person and need an account</div>
                <br/>
                <p class="change_link">then -->
                    <a href="signup.do">Click here for registration</a>
                </p>
            </div>
        </form>
    </section>


</div>
</body>
</html>
