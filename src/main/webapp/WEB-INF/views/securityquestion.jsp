<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Security Question</title>
</head>
<body>
<span>Please answer the security question</span>
<form:form action="${pageContext.request.contextPath}/User/validateAnswer" method="post" commandName="securityQuestion">
	<form:errors element="div" path="*" cssStyle="color:red"/>
	<table>
		<tr>
			<td>${sessionScope.questionnare.question1}</td>
			<td><form:input path="answer"/></td>
		</tr>
	</table>
	<input type="submit" value="Validate"/>
</form:form>
</body>
</html>