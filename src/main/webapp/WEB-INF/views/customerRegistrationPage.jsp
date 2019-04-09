<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<spring:theme code='styleSheet' var="styleSheetUrl"/>
<spring:theme code='background' var="backgroundColor"/>

<html>
	<head>
		<title> Customer Registration Page </title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/${styleSheetUrl}" type="text/css"/>
		
		<!-- <link rel="stylesheet" href="resources/themes/style2.css" type="text/css"/> -->
		
	</head>
	
	<body>
			<template:master />
			
			<br> Theme background Value: <b> ${backgroundColor} </b> <br>
			
			<h3> Customer Registration page <br><br><br> </h3>
			
			======================================================================================== <br>
			createAccount1 + GET : RequestParam POC - Localization<br>
			<form action="createAccount1" method="GET" >
				 
				 <spring:message code="customer.registration.firstName" /> <input type="text" name="firstname"> <br>
			     <spring:message code="customer.registration.lastName" />   <input type="text" name="lastname"> <br>
			     <spring:message code="customer.registration.email" /> <input type="text" name="email"> <br>
				
				<input type="submit" value="CREATE ACCOUNT">
			</form>
			<br>======================================================================================== <br>
			createAccount2 + POST : Form Bean POC<br>
			<form action="createAccount2" method="POST" >
				 
				 First name: <input type="text" name="firstname"> <br>
			     Last name:   <input type="text" name="lastname"> <br>
			     Email: <input type="text" name="email"> <br>
				
				<input type="submit" value="CREATE ACCOUNT">
			</form>
			<br>========================================================================================== <br>
			Path Variable POC: <br>
			<a href="${pageContext.request.contextPath}/customer/accountProfile/sonu.singh/addresses/noidaHome12"> Customer Address Detail</a>
			<br>========================================================================================== <br>
			<%-- ${registerForm} --%>
			${registrationForm} <br>
			${abcForm} <br>
			
			registrationPage4 + GET : ModelAttribute POC<br>
			<form action="registrationPage4" method="POST" >
				 
				 First name: <input type="text" name="firstname" value="${abcForm.firstname}"> <br>
			     Last name:   <input type="text" name="lastname"> <br>
			     Email: <input type="text" name="email"> <br>
				
				<input type="submit" value="CREATE ACCOUNT">
			</form>
			======================================================================================== <br>
			
			========================================================================================== <br>
		
	</body>

</html>


