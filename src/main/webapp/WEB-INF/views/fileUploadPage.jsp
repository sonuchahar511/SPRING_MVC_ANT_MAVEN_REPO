<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:master />

Upload File Page <br><br><br>

<!-- enctype=”multipart/form-data”: indicates that this form may contain multipart data (file upload) 
	so the web browser and the server know how to handle the request.
 -->

<c:if test="${not empty success}">
    Message: ${message}
</c:if>

<form action="singleUpload" method="POST" enctype="multipart/form-data">
	File Name: <input type="text"  name="name"/> <br>
	File: <input type="file" name="attachment"> <br> <br>
	<input type="submit" value="UPLOAD File Button" id="uploadSubmitButtonId"/>
</form>

<br><br><br>

<div id="progressCheckId">Custom Progress bar: </div> <br>
<div id="progressbar">
    <div class="progress-label">Jquery Progress bar:</div>
</div>