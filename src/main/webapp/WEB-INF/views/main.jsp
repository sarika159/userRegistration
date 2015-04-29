<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Main - Page</title>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
<h2>My Application</h2>

<form action="${pageContext.request.contextPath}/signup" method="post">
	<table>
		<tr>
			<td><input type="submit" value="Sign-up" name="signup"/></td>
			<td><input type="button" value="Login" id="loginButton"/></td>
		</tr>	
	</table>		
</form>
<div style="display:none" id="loginDiv" title=" Please Login">
	<form action="${pageContext.request.contextPath}/securityQuestion" method="post" id="loginForm">
		<table>
			<tr>
				<td>Name : </td>
				<td> <input type="text" name="userName" id="userName"/></td>
				<td><input type="submit" value="Submit" id="submitButton"/></td>				
			</tr>
		</table>		
	</form>	
</div>
</body>
</html>
