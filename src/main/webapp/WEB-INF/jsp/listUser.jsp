<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div class="container-fluid text-center">    
  <div class="row content">
 <c:forEach items="${users}" var="user"> 
  <tr>
      <td>${user.username}</td>
      <td>${user.password}</td>
  </tr>
</c:forEach>
 
  </div>
</div>