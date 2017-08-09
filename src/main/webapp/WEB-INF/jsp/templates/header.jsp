<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <c:if test="${empty user}">
        <li><a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
       </c:if>
       <c:if test="${not empty user}">
        <li><a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
        </c:if>
   
      </ul>
    </div>
  </div>
</nav>