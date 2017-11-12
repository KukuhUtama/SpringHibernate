<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid text-center">
	<div class="row content">
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="text-center">Username</th>
					<th class="text-center">Roles</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
			
				    <c:url var="detailUserUrl" value="/admin/detailuser"/>
			
					<c:forEach items="${users}" var="user">
					   <tr>
						<c:forEach items="${user.roles}" var="role">
					    <td>${user.username}</td>
						<td>${role.name}</td>
						<td>
						   <div class="btn-group">
						       <a href="${detailUserUrl}?id=${user.id}&isRevoke=false&isGrant=true" class="btn btn-primary">
						           <i class="fa fa-cog" aria-hidden="true"></i> Grant
						       </a>
						        <a href="${detailUserUrl}?id=${user.id}&isRevoke=true&isGrant=false" class="btn btn-danger">
						           <i class="fa fa-cog" aria-hidden="true"></i> Revoke
						       </a>
						   </div>
						   
						</td>
						</tr>
						</c:forEach>
					</c:forEach>
				
			</tbody>
		</table>
	</div>
</div>