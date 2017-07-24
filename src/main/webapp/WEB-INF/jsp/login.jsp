<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
<form class="form-horizontal"  method="post" action="login" >
        <h2>Login Form</h2>
         <div class="form-group">
            <label class="control-label col-sm-2" for="username">Username</label>
            <div class="control-label col-sm-8">
                  <input type="text" class="form-control" id="username" name="username" placeholder="Type Username"/>
            </div>
        </div>
        
         <div class="form-group">
              <label class="control-label col-sm-2" for="password">Password</label>
              <div class="control-label col-sm-8">
                   <input type="password" class="form-control" id="password" name="password" placeholder="Type Password"/>
              </div>
        </div>
        <span>${error}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>