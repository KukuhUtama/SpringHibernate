<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="container-fluid text-center">
	<div class="row content">
		<table class="table table-hover">
			<thead>
				<tr>
					<th class="text-center">Roles</th>
					<th class="text-center">Username</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${listRoleUser}" var="roleUser">
					<tr>
						<td>${roleUser.name}</td>
						<c:if test="${not empty roleUser.users}">
							<c:forEach items="${roleUser.users}" var="user">
								<td><span>${user.username}</span></td>
							</c:forEach>
						</c:if>
						<c:if test="${empty roleUser.users}">
							<td><span></span></td>
						</c:if>

						<td><c:choose>
								<c:when test="${not empty roleUser.users}">
									<input type="submit" value="delete" class="btn btn-danger disabled"/>
								</c:when>
								<c:otherwise>
								    <c:url var="deleteUrl" value="/admin/deleterole"/>
								    <%-- <form action="<%=request.getContextPath()%>/admin/deleterole?id=${roleUser.id}" method="get"><input type="submit" value="delete" class="btn btn-danger active"/></form> --%>
								     <form action= "${deleteUrl}" method="get">
								     <input type="hidden" name="id" value="${roleUser.id}"/>
								     <input type="submit" value="delete" class="btn btn-danger active"/>
								     </form>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
</div>