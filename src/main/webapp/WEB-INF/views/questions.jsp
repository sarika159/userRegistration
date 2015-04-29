<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Questions</title>
</head>
<body>
<h1>Security Questions</h1>
	<form:form commandName="securityQuestionnare" action="${pageContext.request.contextPath}/User/saveAnswers" method="post">
		<form:errors element="div" path="*" cssStyle="color:red"/><br/>
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td>Q1:</td>
				<td><form:select path="question1">
					<form:option value="" label="Please Select"></form:option>
					<form:option value="Who is your child hood friend ?"></form:option>
					<form:option value="What is your favourite movie ?"></form:option>
					<form:option value="Which city you were born ?"></form:option>
				</form:select></td>
				<td><form:input path="answer1"/></td>
			</tr>
			<tr>
				<td>Q2:</td>
				<td><form:select path="question2">
					<form:option value="" label="Please Select"></form:option>
					<form:option value="Who is your child hood friend ?"></form:option>
					<form:option value="What is your favourite movie ?"></form:option>
					<form:option value="Which city you were born ?"></form:option>
				</form:select></td>
				<td><form:input path="answer2"/></td>
			</tr>
			<tr>
				<td>Q3:</td>
				<td><form:select path="question3">
					<form:option value="" label="Please Select"></form:option>				
					<form:option value="Who is your child hood friend ?"></form:option>
					<form:option value="What is your favourite movie ?"></form:option>
					<form:option value="Which city you were born ?"></form:option>
				</form:select></td>
				<td><form:input path="answer3"/></td>
			</tr>
		</table><br/>
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>