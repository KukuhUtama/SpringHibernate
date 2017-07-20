<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
<form:form  class="form-horizontal" modelAttribute="user" action="registration">
        <h2>Registration Form</h2>
         <div class="form-group">
            <label class="control-label col-sm-2" for="username">Username</label>
            <div class="control-label col-sm-8">
                  <form:input type="text" class="form-control" id="username" path="username" placeholder="Type Username"/>
                  <form:errors path="username" class="text-danger"></form:errors>
            </div>
        </div>
        
         <div class="form-group">
              <label class="control-label col-sm-2" for="password">Password</label>
              <div class="control-label col-sm-8">
                   <form:input type="password" class="form-control" id="password" path="password" placeholder="Type Password"/>
                   <form:errors path="password" class="text-danger"></form:errors>
              </div>
        </div>
        
        <div class="form-group">
              <label class="control-label col-sm-2" for="confirm-password">Confirm Password</label>
              <div class="control-label col-sm-8">
                  <form:input type="password" class="form-control" id="confirm-password" path="passwordConfirm" placeholder="Re-type Password"/>
                  <form:errors path="passwordConfirm" class="text-danger"></form:errors>
              </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>