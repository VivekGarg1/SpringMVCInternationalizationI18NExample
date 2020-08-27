<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
<form:errors path="student.*"></form:errors>
	<form:form action="/SpringMVCInternationalizationI18NExample/registerSuccess"
		method="post" modelAttribute="student">
		<h2 align="center"><spring:message code="label.register.header"/></h2>
		<h3 align="center"><a href="/SpringMVCInternationalizationI18NExample?lang=en">English</a> | <a href="/SpringMVCInternationalizationI18NExample?lang=fr">French</a></h3>
		<table align="center">

			<tr>
				<td><spring:message code="label.name"/></td>
				<td><form:input path="studentName" /></td>
			</tr>
			
			<tr>
				<td><spring:message code="label.doj"/></td>
				<td><form:input path="doj" />(yyyy-MM-dd)</td>
			</tr>

			<tr>
				<td><spring:message code="label.gender"/></td>
				<td><form:radiobuttons path="gender" items="${genderList}" />
			</tr>

			<tr>
				<td><spring:message code="label.phone"/></td>
				<td><form:input path="phone" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.technologies"/></td>
				<td><form:select path="technologies">
						<form:options items="${technologyList}" />
					</form:select></td>
			</tr>

			<tr>
				<td><spring:message code="label.city"/></td>
				<td><form:select path="city">
						<form:options items="${citesList}" />
					</form:select></td>
			</tr>

			<tr>
				<td><input type="submit" value="<spring:message code="label.register"/>"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>