<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<template:master />

Account Profile Page <br><br><br>

<br>============================================================================================================= <br>
JSON RequestBody , JSON Response Body POC <br>
<form action="profile/updateProfile" method="POST" id="updateProfileForm">
	 
	 First name: <input type="text" name="firstName" id="firstNameId"> <br>
     Last name:   <input type="text" name="lastName" id="lastNameId"> <br>
     Email: <input type="text" name="email" id="emailId" > <br>
	
	<input type="submit" value="UPDATE PROFILE" id="updateProfileFormSubmitButtonId">
</form>

<br>============================================================================================================= <br>
JSON RequestBody , XML Response Body POC <br>

<form action="profile/employeeListXml" method="POST" id="updateProfileXmlForm">
	 
	 First name: <input type="text" name="firstName" id="firstNameId1"> <br>
     Last name:   <input type="text" name="lastName" id="lastNameId1"> <br>
     Email: <input type="text" name="email" id="emailId1" > <br>
	
	<input type="submit" value="UPDATE PROFILE 1" id="updateProfileXmlFormSubmitButtonXmlId">
</form>
<br>============================================================================================================= <br>
<a href="profile/employees/1"> XML response POC</a>
<br>============================================================================================================= <br>


