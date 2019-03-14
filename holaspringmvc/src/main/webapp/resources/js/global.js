$(document).ready(function(){

	$("#idLogout").click(function(e){
		e.preventDefault();
		$("#logout-form").submit();
	});
});