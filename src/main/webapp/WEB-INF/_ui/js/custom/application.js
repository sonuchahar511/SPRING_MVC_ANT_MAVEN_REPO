$(document).ready(function () {
	console.log("Welcome to js file");

	$("#updateProfileFormSubmitButtonId").on("click", function(event) {
		event.preventDefault();
		
		//Method1: Fetch form element data by id individually.
		var accountFormJson = {
			"firstName" : $("#firstNameId").val(),
			"lastName" : $("#lastNameId").val(),
			"email" : $("#emailId").val()
		};
		
		/*$.ajax({
			url : "profile/updateProfile" , 
			method: "POST",
			contentType:'application/json', //When sending data to the server, use this content type.
			data: JSON.stringify(accountFormJson), // Convert Json Object to Json string
			datatype : "json", //The type of data that you're expecting back from the serverx
			cache : false, //If set to false, it will force requested pages not to be cached by the browser.
			success : function(response){
				alert("success: " + response);
				
				console.log(response);
				
				//TODO: Update UI based on response operation
				//true: update UI (show success banner/css) or change view(redirect one page to another page by java script) from browser side
				//false: update UI(error css) and show error message
			},
			error : function(thrownError, xhr){
				alert("error: " + thrownError + xhr);
			}
		});*/
		
		console.log("Before: " + accountFormJson); // JSON Object
		console.log("After: " + JSON.stringify(accountFormJson) ); //JSON String
		
		//Method2: Fetch form all element data by form object.
		var formJson = convertFormToJson( $("#updateProfileForm") );
		console.log(formJson);
		console.log("Form Data: " + JSON.stringify(formJson));
		
		var formActionUrl = $("#updateProfileForm").attr('action');
		var formMethodType = $("#updateProfileForm").attr('method');
		
		console.log("FormActionUrl: " + formActionUrl);
		console.log("Form Method: " + formMethodType);
		
		$.ajax({
			url : formActionUrl , 
			method: formMethodType,
			contentType:'application/json', //When sending data to the server, use this content type.
			data: JSON.stringify(formJson),
		
			datatype : "json", //The type of data that you're expecting back from the server
			cache : false, //If set to false, it will force requested pages not to be cached by the browser.
			success : function(response){
				//alert("success: " + response);
				
				console.log(response);
				
				//TODO: Update UI based on response operation
				//true: update UI (show success banner/css) or change view(redirect one page to another page by java script) from browser side
				//false: update UI(error css) and show error message
			},
			error : function(thrownError, xhr){
				alert("error: " + thrownError + xhr);
			}
		});
		
	});
	
	$("#updateProfileXmlFormSubmitButtonXmlId").on("click", function(event) {
		event.preventDefault();
		
		var profileForm = $("#updateProfileXmlForm");
		
		var formActionUrl = profileForm.attr('action');
		var formMethodType = profileForm.attr('method');
		var formJson = convertFormToJson( profileForm );
		
		console.log("Form Method: " + formMethodType);
		console.log("FormActionUrl: " + formActionUrl);
		console.log(formJson);
		
		$.ajax({
			url : formActionUrl , 
			method: formMethodType,
			contentType:'application/json',
			data: JSON.stringify(formJson),
			datatype : "xml",
			cache : false,
			success : function(response){
				var xmlResponseText = new XMLSerializer().serializeToString(response);
				
				console.log("XML Response: "  + xmlResponseText);
				
			},
			error : function(thrownError, xhr){
				alert("error: " + thrownError + xhr);
			}
		});
	}) ;	

	function convertFormToJson(form){
		var array = $(form).serializeArray();
		
		console.log("Original Form Elements: " + array);
		
		var jsonData = {};
		
		$.each(array , function () {
			jsonData[this.name] = this.value || '';
		} );
		
		console.log("Created Form JSON data: "+ jsonData);
		
		return jsonData;
	}
});