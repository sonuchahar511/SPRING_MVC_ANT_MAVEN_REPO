<html>
	<body>
		<h2>Spring MVC WEB PROJECT</h2>
	
		<a href="${pageContext.request.contextPath}/hello1">Click to see first mvc request response</a> <br>
		<a href="${pageContext.request.contextPath}/customer/registrationPage">Customer Registration page</a> <br>
		
		<a href="${pageContext.request.contextPath}/customer/registrationPage4">Model Attribute POC</a> <br>
		
		<a href="${pageContext.request.contextPath}/customer/profile">RequestBody ResponseBody POC</a> <br>
		
		<a href="${pageContext.request.contextPath}/fileUploader/uploadPage">File Upload POC</a> <br>

		<a href="${pageContext.request.contextPath}/logger/log4j">Logger Configuration Page </a> <br>
		
		<a href="${pageContext.request.contextPath}/exceptionHandling/first">1- Exception Handling at Controller level, catches at Controller level - POC</a> <br>
		<a href="${pageContext.request.contextPath}/exceptionHandling/second">2- Exception throws at Controller level , catches @ControllerAdvice with ModelAndView -  POC</a> <br>
		<a href="${pageContext.request.contextPath}/exceptionHandling/third">3- Exception throws at Controller level , catches @ControllerAdvice with NO view - POC</a> <br>
		<a href="${pageContext.request.contextPath}/exceptionHandling/fourth">4- Exception throws at Controller level , catches at SimpleMappingExceptionResolver + exceptionMappings - POC</a> <br>
		<a href="${pageContext.request.contextPath}/exceptionHandling/fifth">5- Exception throws at Controller level , catches at SimpleMappingExceptionResolver +defaultErrorView -  POC</a> <br>
		
		<a href="${pageContext.request.contextPath}/exceptionHandling/sixth">6- NullPointerException-500 - web.xml - error page location- errorPage POC</a> <br>
		<a href="${pageContext.request.contextPath}/exceptionHandling/123123123123123">7- Invalid Url Mapping - web.xml - error page location- errorPage POC</a> <br>

	</body>
</html>
