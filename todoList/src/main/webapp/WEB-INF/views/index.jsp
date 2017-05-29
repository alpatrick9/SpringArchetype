<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC - TODO list</title>
</head>
<body>
	<h1>Todo list</h1>
	<form:form modelAttribute="todoForm" method="post" action="${ todoAddUrl }">
		<form:hidden path="id"/>
		Todo name: <form:input path="name" type="text"/>
		<input type="submit" value="add">
	</form:form>
	<div>
		<c:if test="${fn:length(todos) gt 0}">
			<table>
				<c:forEach items="${ todos }" var="todo">
					<tr>
						<td><c:out value="${ todo.id }" /></td>
						<td><c:out value="${ todo.name }" /></td>
						<td>
							<a href="${ todoDeleteUrl }?id=${todo.id}">delete</a> &nbsp;
							<a href="${ todoUpdateUrl }?id=${todo.id}">modifier</a>
						<td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>