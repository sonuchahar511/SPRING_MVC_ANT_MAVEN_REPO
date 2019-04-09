<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:javascript />
<template:css />

<a href="${pageContext.request.contextPath}">Home Page</a> <br>

Select Language: <a href="?language=fr"> FR Locale</a>
<a href="?language=en"> EN Locale</a>

<br>
Select Theme
<a href="?themeName=theme1"> Blue </a> &nbsp;
<a href="?themeName=theme2"> Green </a>

<br>ContextPath===${pageContext.request.contextPath} <br>
<br>========================================================================================= <br><br>
