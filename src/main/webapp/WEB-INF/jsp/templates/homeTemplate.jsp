<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
  <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
  <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
  <style>
  
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
      color: black;
      background-color: #33DAFF;
     
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 550px}
    
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #33DAFF;
      color: black;
      padding-top: 10px;
      height: 60px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body><div class="flex-container">
       <tiles:insertAttribute name="header" /> 
       <tiles:insertAttribute name="content" /> 
       <tiles:insertAttribute name="footer" /> 
       </div>
</body>
</html>
