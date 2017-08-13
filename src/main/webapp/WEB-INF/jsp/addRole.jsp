<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/> 
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
<title>Add Role</title>
</head>
<body>
<div class="container">
<form:form class="form-horizontal" modelAttribute="role" action="addrole" method="post" >
      <h2>Add Role</h2>
         <div class="form-group">
            <label class="control-label col-sm-2" for="name">Role Name</label>
            <div class="control-label col-sm-8">
                  <%-- <form:input type="text" class="form-control" id="name" path="name" placeholder="Type Role Name"/>--%>
                  <form:select  class="form-control"  path="name" items="${listRole}">
                  <form:errors path="name" class="text-danger"></form:errors> 
                  </form:select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
</body>
</html>