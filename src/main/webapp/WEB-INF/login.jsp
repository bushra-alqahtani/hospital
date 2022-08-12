 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
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

<body>
     <section id="appointment" class="appointment section-bg">
      <div class="container">
        <div class="section-title">
          <h2>Medilab</h2>
        </div>
  	<div class= "row">
 	<div class="col m-5">
  	<h1>Register</h1>
	<form:form action="/register" method="post" modelAttribute="newUser" class="php-email-form">
    <p>
        <form:label path="username">username :</form:label><br>
        <form:input path="username" class="form-control"/><br>
        <form:errors path="username" class="danger"/>
    </p> 
    <p>
        <form:label path="email">email :</form:label><br>
        <form:input path="email" class="form-control"/><br>
        <form:errors path="email" class="danger"/>
    </p>
       <p>
        <form:label path="age">age :</form:label><br>
        <form:input path="age" class="form-control"/><br>
        <form:errors path="age" class="danger"/>
    </p>
     <p>
        <form:label path="phone">phone :</form:label><br>
        <form:input path="phone" class="form-control"/><br>
        <form:errors path="phone" class="danger"/>
    </p>
    
       <p>
        <form:label path="password" type="password">password :</form:label><br> 
        <form:input path="password" type="password" class="form-control"/><br>
        <form:errors path="password" class="danger"/>
    </p>
      
    <p>
        <form:label path="confPassword" type="password">confpassword :</form:label><br>
        <form:input path="confPassword" type="password" class="form-control"/><br>
        <form:errors path="confPassword" class="danger"/>
    </p>
      
    <button class="btn btn-primary" type="submit">Register</button>
    
</form:form>
</div> 
	<div class="col m-5">
	<h1>LogIn</h1>
<form:form action="/login" method="post" modelAttribute="userLogin" class="php-email-form">

    <p>
        <form:label path="email" >email:</form:label><br>
        <form:input path="email" class="form-control"/><br>
        <form:errors path="email" />
    </p>
       <p>
        <form:label path="password" type="password" >password :</form:label><br> 
        <form:input path="password" type="password" class="form-control"/><br>
        <form:errors path="password" />
    </p>
      
    <button class="btn btn-primary" type="submit">Login</button>
    
    
</form:form>
	
	
	</div>
</div>
 

</div>
</section>

</body>
</html>


  