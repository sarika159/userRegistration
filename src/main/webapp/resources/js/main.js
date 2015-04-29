$( document ).ready(function() {
	$("#loginButton").click(function(){
		$("#loginDiv").dialog({width:400});
	});
	    
	$("#submitButton").click(function(e){
		e.preventDefault();
		var userName = $("#userName").val();
	    if(userName == null || userName == ""){
	    	alert("Please enter a valid user name");
	    		return false;
	    }
	    $("#loginForm").submit();
	 })
});
