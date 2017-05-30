<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="include/header.jsp"%>

<c:url var="add_url" value="${todoAddUrl}"/>
<div>
	<%@ include file="include/menu.jsp" %>
</div>
<h1>Todo list</h1>

<form:form modelAttribute="todoForm" method="post" action="${add_url}">
	<form:hidden path="id" />
		Todo name: <form:input path="name" type="text" />
	<input type="submit" value="Ok">
</form:form>
<div>
	<c:if test="${fn:length(todos) gt 0}">
		<table>
			<c:forEach items="${ todos }" var="todo">
				<tr>
					<td><c:out value="${ todo.id }" /></td>
					<td><c:out value="${ todo.name }" /></td>
					<td><a href="<c:url value="${todoDeleteUrl}?id=${todo.id}"/> ">delete</a>
						&nbsp; <a href="<c:url value="${ todoUpdateUrl }?id=${todo.id}"/> ">modifier</a>
					<td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
<%@ include file="include/footer.jsp"%>