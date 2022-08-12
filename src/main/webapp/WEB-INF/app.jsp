<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Medilab</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- ========================================================  -->
</head>

<body style=" background-color:#f1f7fd;">
		    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>


  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="index.html">Medilab</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto active" href="/">Home</a></li>
          <li><a class="nav-link scrollto" href="#departments">Departments</a></li>
          <li><a class="nav-link scrollto" href="#doctors">Doctors</a></li>
          <li><a class="nav-link scrollto" href="/userAppo">Appoiments</a></li>
          <c:choose>
		    <c:when test="${sessionScope.user_id != null}">
	          <li><a class="nav-link scrollto" href="/logout">LogOut</a></li>
		        
		    </c:when>
		    <c:otherwise>
	          <li><a class="nav-link scrollto" href="/index">LogIn</a></li>
		    </c:otherwise>
		</c:choose>
          
          <li></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

      <a href="/index" class="appointment-btn scrollto"><span class="d-none d-md-inline">Make an</span> Appointment</a>

    </div>
    
  </header><!-- End Header -->
	<div class="container " style="margin-top:150px; background-color:#f1f7fd;">
        <div class="section-title">
          <h2 class="m-5">Make an Appointment</h2>
        </div>
        <form action="/index" method="post"   modelAttribute="appointment">
          <div class="row">
          <input type="hidden" name="user" class="form-control" id="name" value="${user.getId()}" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
          
            <div class="col-md-4 form-group">
              <input disabled type="text"  class="form-control" id="name" value="${user.getUsername()}" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
            <div class="col-md-4 form-group mt-3 mt-md-0">
              <input disabled type="email" class="form-control"  id="email" value="${user.getEmail()}" data-rule="email" data-msg="Please enter a valid email">
              <div class="validate"></div>
            </div>
            <div class="col-md-4 form-group mt-3 mt-md-0">
              <input disabled type="tel" class="form-control" name="phone" id="phone" value="${user.getPhone()}" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
              <div class="validate"></div>
            </div>
          </div>
            <div class="col-md-4 form-group mt-3">
              <select name=doctor id="department" class="form-select">
              <option>--select Doctor--</option>
            <c:forEach  items="${allDoctor}" var="i">
                 <option value ="${i.id}">  doctor - <c:out value = "${i.name}"/> department -
			    		 <c:out value = "${i.major}"/>
			     </option>
             </c:forEach>
              </select>
              <div class="validate"></div>
            </div>
       
			<div>
          <div class="form-group mt-3">
            <textarea class="form-control" name="descrition" rows="5" placeholder="Message (Optional)"></textarea>
            <div class="validate"></div>
          </div>
          </div>
          <div class="text-center"><button type="submit" class="btn btn-primary m-3">Make an Appointment</button></div>
        </form>
      </div>
      
</body>
</html>