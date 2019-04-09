<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href="${pageContext.request.contextPath}">Home</a> <br>

This is logger jsp page <br>

<c:forEach items="${loggers}" var="logger">
        ${logger.name} --> ${logger.effectiveLevel} <br>
</c:forEach>

<br> <br>

<form action="${pageContext.request.contextPath}/logger/log4j/update" method="POST">
	Package  <input type="text" name="packageName"> <br>
    Log level:   <input type="text" name="logLevel"> <br>
	<input type="submit" value="UPDATE">
</form>



