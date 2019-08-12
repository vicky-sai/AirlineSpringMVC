<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Flight Ticket Booking</title>
	  <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/bookingbody.css">
	<link href="css/footer.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>


	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
</head>
<body>

<nav class="navbar navbar-inverse" style="position: fixed;top: 0;width: 100%;z-index:1;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand active" href="mid.do">AMS</a>
    </div>
    <ul class="nav navbar-nav">
    <li><a href="mid.do">Home</a></li>
      <li><a href="searchflight.do">Search</a></li>
       <li><a href="mybooked.do">Cancellation</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Options <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Tourism packages</a></li>
          <li><a href="#">Hotels</a></li>
          <li><a href="#">Our policies</a></li>
        </ul>
      </li>
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="#"><span class="glyphicon glyphicon-envelope"></span> Messages</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome ${sessionScope.passenger.passengerName}</a></li>
      <li><a href="logout.do"><span class="glyphicon glyphicon-log-in"></span> Log out</a></li>
    </ul>
  </div>
</nav>
