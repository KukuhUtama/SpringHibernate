<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
        <c:if test = "${fn:containsIgnoreCase(roles, 'SA')}"> 
            <li><a href="<c:url value="/admin/listrole"/>">Role</a></li>
            <li><a href="<c:url value="/admin/listuser"/>">User</a></li>
        </c:if>
        <c:if test ="${fn:containsIgnoreCase(roles,'MODERATOR')}">
              <li><a href="<c:url value=""/>">Publish News</a></li>
        </c:if>
        <c:if test ="${fn:containsIgnoreCase(roles,'USER')}">
              <li><a href="<c:url value=""/>">Read News</a></li>
        </c:if>
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