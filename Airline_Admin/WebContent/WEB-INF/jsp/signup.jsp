<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Admin Registration Form | AMS </title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/custom.min.css" rel="stylesheet">
</head>

<br>

<div class="col-lg-12 text-center ">
    <h1 style="font-family:Lucida Console">Airline Management System</h1>
</div>


<body class="login" style="margin-top: -20px;">



    <div class="login_wrapper">

            <section class="login_content" style="margin-top: -40px;">
                <form name="form1" action="registration.do" method="post">
                    <h2>Admin Registration Form</h2><br>

                    <div>
                        <input type="text" class="form-control" placeholder="Admin Name" name="adminName" required=""/>
                    </div>
                    <div>
                        <input type="text" class="form-control" placeholder="Username" name="userName" required=""/>
                    </div>
                    <div>
                        <input type="password" class="form-control" placeholder="Password" name="password" required=""/>
                    </div>

                    <div class="col-lg-12  col-lg-push-3">
                        <input class="btn btn-default submit " type="submit" name="submit1" value="Register">
                    </div>

                </form>
            </section>



    </div>

</body>
</html>
