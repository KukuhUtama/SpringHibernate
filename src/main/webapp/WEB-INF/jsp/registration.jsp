<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
</head>
</head>
<title>Registration</title>
</head>
<body>
<div class="container">
<form:form  class="form-horizontal" modelAttribute="user" action="registration">
        <h2>Registration Form</h2>
         <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="control-label col-sm-2" for="username">Username</label>
            <div class="control-label col-sm-8">
                  <form:input type="text" class="form-control" id="username" path="username" placeholder="Type Username"/>
                  <form:errors path="username"></form:errors>
            </div>
        </div>
        
         <div class="form-group ${status.error ? 'has-error' : ''}">
              <label class="control-label col-sm-2" for="password">Password</label>
              <div class="control-label col-sm-8">
                   <form:input type="password" class="form-control" id="password" path="password" placeholder="Type Password"/>
                   <form:errors path="password"></form:errors>
              </div>
        </div>
        
        <div class="form-group ${status.error ? 'has-error' : ''}">
              <label class="control-label col-sm-2" for="confirm-password">Confirm Password</label>
              <div class="control-label col-sm-8">
                  <form:input type="password" class="form-control" id="confirm-password" path="passwordConfirm" placeholder="Re-type Password"/>
                  <form:errors path="passwordConfirm"></form:errors>
              </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
</body>
</html>