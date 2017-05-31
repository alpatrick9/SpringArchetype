<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../include/header.jsp"%>

<c:url var="add_user_url" value="${addUser}" />
<div class="clearboth"></div>

<form:form modelAttribute="userRoleForm" method="post"
	action="${add_user_url}">
	<form:hidden path="id" />
	<div class="form-group">
		<form:input path="user.username" placeholder="Username" class="form-control" required="required"/>
		<form:password path="user.password" placeholder="Password" class="form-control" required="required"/>
		<form:select path="role" class="form-control" required="required">
			<form:option value="">choise one rule</form:option>
			<form:option value="ROLE_USER">Simple user</form:option>
			<form:option value="ROLE_ADMIN">Administrateur</form:option>
		</form:select>
		<input type="submit" value="Ok" class="btn btn-success">
	</div>
</form:form>

<h1>User list</h1>
<c:if test="${fn:length(users) gt 0}">
	<table class="table table-hover table-bordered table-striped">
		<tr>
			<th class="text-center">Username</th>
			<th class="text-center">Role</th>
			<th class="text-center">Status</th>
			<th></th>
		</tr>
		<c:forEach items="${users}" var="item">
			<tr>
				<td class="text-center">${item.user.username}</td>
				<td class="text-center">${item.role}</td>
				<td class="text-center">
					<c:if test="${item.user.enabled }">
						Activé
					</c:if>
					<c:if test="!${item.user.enabled }">
						Inactivé
					</c:if>
				</td>
				<td class="text-center">
					<a href=""><i class="fa fa-refresh"></i></a> &nbsp;
					<a href="<c:url value="${deleteUser}"/>?id=${item.id}" onclick="return confirm('Are you sure to delete this?')"><i class="fa fa-remove"></i></a>  
				</td>
			<tr>
		</c:forEach>
	</table>
</c:if>
<%@ include file="../include/footer.jsp"%>
<script>
	var nav = document.getElementById("admin-menu");
	nav.className += " active";
</script>