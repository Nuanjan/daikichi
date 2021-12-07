<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    <h1 class=" text-center">Send an Omikuji!</h1>
    	<p class="text-center text-danger">
	        <c:if test="${error != null}">
	        <c:out value="${error}"></c:out>
	        </c:if>
        </p>
        <form action="/omikuji/process" method="POST" class="w-50 m-auto">
        <div class="d-flex flex-column">
        <label>Pick any number from 5-25</label>
        <input type="number" name="number" />
        </div>
        <div class="d-flex flex-column">
        <label>Enter the name of any city:</label>
        <input type="text" name="city" />
        </div>
        <div class="d-flex flex-column">
        <label>Enter the name of any real person:</label>
        <input type="text" name="person" />
        </div>
        <div class="d-flex flex-column">
        <label>Enter professional endeavor or hobby:</label>
        <input type="text" name="hobby" />
        </div>
        <div class="d-flex flex-column">
        <label>Enter any type of living thing.</label>
        <input type="text" name="thing" />
        </div>
        <div class="d-flex flex-column">
        <label>Say something nice to someone</label>
        <textarea rows="10" cols="10" name="comment"></textarea>
        </div>
        <p>Send and Show a friend</p>
        <input type="submit" value="send">
        </form>
    </div> <!-- End of Container -->
</body>
</html>
