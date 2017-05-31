<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="include/header.jsp"%>

<c:url var="add_url" value="${todoAddUrl}" />
<div class="clearboth"></div>
<form:form modelAttribute="todoForm" method="post" action="${add_url}">
	<form:hidden path="id" />
	<div class="form-group">
		<form:input path="name" type="text" class="form-control" placeholder="Todo name" required="required"/>
		<input type="submit" value="Ok" class="btn btn-success">
	</div>
</form:form>

<h1>Todo list</h1>

<div>
	<c:if test="${fn:length(todos) gt 0}">
		<table class="table table-hover table-bordered table-striped">
			<tr>
				<th class="text-center">#</th>
				<th class="text-center">todo</th>
				<th></th>
			</tr>
			<c:forEach items="${ todos }" var="todo">
				<tr>
					<td class="text-center"><c:out value="${ todo.id }" /></td>
					<td class="text-center"><c:out value="${ todo.name }" /></td>
					<td class="text-center">
						<a href="<c:url value="${ todoUpdateUrl }?id=${todo.id}"/> " > 
							<i class="fa fa-refresh"></i>
						</a> &nbsp; 
						<a href="<c:url value="${todoDeleteUrl}?id=${todo.id}"/> " onclick="return confirm('Are you sure to delete this?')">
							<i class="fa fa-remove"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
<%@ include file="include/footer.jsp"%>
<script>
	var nav = document.getElementById("home-menu");
	nav.className += " active";
</script>