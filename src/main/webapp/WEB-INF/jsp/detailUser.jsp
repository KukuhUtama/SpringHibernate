<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
	$(document).ready(function() {
		$(".btn.btn-danger").on("click", function() {
			var id = this.id;
			$("#input" + id + "").remove();
			$("#" + id + "").remove();
		});
	});
</script>
<div class="container">
	<form:form class="form-horizontal" method="post" modelAttribute="user"
		action="revokeuserrole">
		<h2>Detail User</h2>
		<form:hidden path="password" />
		<form:hidden path="id" />
		<div class="form-group">
			<label class="control-label col-sm-2" for="username">Username</label>
			<div class="control-label col-sm-8">
				<form:input type="text" class="form-control" id="username"
					path="username" value="${user.username}" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" for="roles">Role(s)</label>
		<div class="control-label col-sm-2">
			<c:forEach items="${user.roles}" var="role" varStatus="status">
		
					<tr>
						<td><form:input id="input${status.index}"
								class="form-control" path="roles[${status.index}].name"
								value="${role.name}" /></td>
						<td><button id="${status.index}" type="button"
								class="btn btn-danger" style="display:${isRevoke ? 'block' : 'none'}; width: 100%">Revoke Role</button></td>
					    <td><button id="${status.index}" type="button"
								class="btn btn-primary" style="display:${isGrant ? 'block' : 'none'}; width: 100%">Grant Role</button></td>
					</tr>
			
			</c:forEach>
				</div>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</div>