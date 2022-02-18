<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Paper Dashboard 2 by Creative Tim
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <!-- CSS Files -->
  <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="../assets/css/paper-dashboard.css?v=2.0.1" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../assets/demo/demo.css" rel="stylesheet" />
</head>

<style>
.left{
    margin-right: 69%;
}

.change{
    background-color: #fff;
    /* background-color: transparent !important; */
    box-shadow: none;
    border-bottom: 1px solid #ddd;
}
</style>

<nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
<div class="container-fluid">
    <div class="navbar-wrapper">
    <div class="navbar-toggle">
        <button type="button" class="navbar-toggler">
        <span class="navbar-toggler-bar bar1"></span>
        <span class="navbar-toggler-bar bar2"></span>
        <span class="navbar-toggler-bar bar3"></span>
        </button>
    </div>
    <%-- <a class="navbar-brand" href="javascript:;">Paper Dashboard 2</a> --%>
    </div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-bar navbar-kebab"></span>
    <span class="navbar-toggler-bar navbar-kebab"></span>
    <span class="navbar-toggler-bar navbar-kebab"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navigation">
   
    <ul class="navbar-nav left">
        <li class="nav-item">
        <a class="nav-link btn-magnify" href="javascript:;">
            <p>
                Home
            </p>
        </a>
        </li>
        <li class="nav-item">
        <a class="nav-link btn-magnify" href="javascript:;">
            <p>
                pricing
            </p>
        </a>
        </li>
        <li class="nav-item">
        <a class="nav-link btn-magnify" href="javascript:;">
            <p>
                Features
            </p>
        </a>
        </li>
        <%-- <li class="nav-item btn-rotate dropdown">
        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <p>
                Features
            </p>
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
        </div>
        </li> --%>
        <li class="nav-item">
        <a class="nav-link btn-rotate" href="javascript:;">
            <p>
                Q&A
            </p>
        </a>
        </li>
    </ul>
    </div>
</div>
</nav>
<!--   Core JS Files   -->
  <script src="../assets/js/core/jquery.min.js"></script>
  <script src="../assets/js/core/popper.min.js"></script>
  <script src="../assets/js/core/bootstrap.min.js"></script>
  <script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="../assets/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../assets/js/paper-dashboard.min.js?v=2.0.1" type="text/javascript"></script><!-- Paper Dashboard DEMO methods, don't include it in your project! -->
  <script src="../assets/demo/demo.js"></script>