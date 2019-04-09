$(document).ready(function () {

    var progressbar = $("#progressbar");
    var progressLabel = $(".progress-label" );

    progressbar.progressbar({
      value: false,
      change: function() {
        //console.log("jquery progressbar change function called." + progressbar.progressbar( "value" ) );

        progressLabel.text( progressbar.progressbar( "value" ) + "%" );
      },
      complete: function() {
        //console.log("jquery progressbar complete function called." + progressbar.progressbar( "value" ) );

        progressLabel.text( "Complete!" );
      }
    });

      function checkFileUploadProgress(){
           var actionUrl = "http://localhost:8080/SPRING_MVC_REPO_PROJECT/fileUploader/checkProgress";

           $.ajax({
                url : actionUrl ,
                method: "GET",
                datatype : "json", //The type of data that you're expecting back from the server
                cache : false, //If set to false, it will force requested pages not to be cached by the browser.
                success : function(response){
                    updateUploadProgressBar(response.progressPercentage)

                    if(response.progressPercentage < 100){
                        setTimeout(checkFileUploadProgress , 200);
                    }
                }
           });
     }

    $("#uploadSubmitButtonId").on("click", function(){
        setTimeout(checkFileUploadProgress , 500);
    });

    function updateUploadProgressBar(progressPercentage){
        console.log("Progress status: " + progressPercentage);
        $("#progressCheckId").text("Custom Progress bar: " + progressPercentage+" %");

        progressbar.progressbar( "value", progressPercentage);
    }

});