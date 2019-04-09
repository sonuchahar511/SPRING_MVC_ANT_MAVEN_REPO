XML Response POC: https://howtodoinjava.com/spring-restful/spring-rest-hello-world-xml-example/

Read properties(Project configuration) in spring mvc:
	https://stackoverflow.com/questions/9259819/how-to-read-values-from-properties-file
	

Exception Handling:
	1- Controller Based: mark method @ExceptionHandler , throws that exception based on business logic.
	 	works at the Controller level and it is only active for that particular Controller.
	 
	2- Global Exception Handler: @ControllerAdvice used for global error handling in the Spring MVC application.
			It also has full control over the body of the response and the status code.
			
	3- HandlerExceptionResolver: For generic exceptions, most of the times we serve static pages.
		SimpleMappingExceptionResolver is the default implementation class
		This will resolve any exception thrown by the application. 
		It is used to resolve standard Spring exceptions to their corresponding HTTP Status Codes. 
		It does not have control over the body of the response, means it does not set anything to the body of the Response.
		It does map the status code on the response but the body is null.


Reference:
	https://stackoverflow.com/questions/35323174/what-are-the-advantages-of-controlleradvice-over-exceptionhandler-or-handlerex
	