<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../include/header.jsp"%>

<c:url var="add_user_url" value="${addUser}" />
<div>
	<%@ include file="../include/menu.jsp"%>
</div>


<h1>User liste</h1>

<form:form modelAttribute="userRoleForm" method="post"
	action="${add_user_url}">
	<form:hidden path="id" />
	<form:input path="user.username" placeholder="Username" />
	<br />
	<form:password path="user.password" placeholder="Password" />
	<br />
	<form:select path="role">
		<br />
		<form:option value="ROLE_USER">simple user</form:option>
		<form:option value="ROLE_ADMIN">administrateur</form:option>
	</form:select>
	<input type="submit" value="Ok">
</form:form>

<c:if test="${fn:length(users) gt 0}">
	<table border="1">
		<tr>
			<th>Username</th>
			<th>Role</th>
			<th>Status</th>
			<th></th>
		</tr>
		<c:forEach items="${users}" var="item">
			<tr>
				<td>${item.user.username}</td>
				<td>${item.role}</td>
				<td>
					<c:if test="${item.user.enabled }">
						Activé
					</c:if>
					<c:if test="!${item.user.enabled }">
						Inactivé
					</c:if>
				</td>
				<td>
					<a href="<c:url value="${deleteUser}"/>?id=${item.id}">del</a> &nbsp; <a href="">modif pass</a>
				</td>
			<tr>
		</c:forEach>
	</table>
</c:if>
<%@ include file="../include/footer.jsp"%>