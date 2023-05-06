<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Welcome ${name}</h1>
		
		<!-- below href div is added to show the scope of the request in browser tools -> Network -> Doc -->
		<!-- see the payload data is not available after clicking the manage link, that data is specific to the request -->
		<a href="list-todos">Manage</a> your todos
	</div>  
<%@ include file="common/footer.jspf" %>