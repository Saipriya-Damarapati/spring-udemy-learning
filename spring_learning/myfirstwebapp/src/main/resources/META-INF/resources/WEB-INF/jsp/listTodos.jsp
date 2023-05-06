<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<!-- ${name} value is model specific (only for that jsp) and it is not available here -->
<!-- if we want the value to live longer, we need to add it in Session in the controller class -->
<div class="container">
	<h1>Your todos </h1>
	
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>