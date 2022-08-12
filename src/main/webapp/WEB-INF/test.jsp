<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>hello </h1>
	<c:out value = "${allDoctor}"/>
            <c:forEach  items="${allDoctor}" var="i">
              <select name="department" id="department" class="form-select">
                 <option><c:out value = "${i.name}"/>
			    	
			     </option>
              </select>
             </c:forEach>
</body>
</html>