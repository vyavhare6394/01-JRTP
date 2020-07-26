

$(document).ready(function(event) {
	$("#countryId").change(function() {
		
		$("#stateId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#stateId");
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");
		
		var countryId = $("#countryId").val();
		$.ajax({
			type : "GET",
			url : "getStates?cid=" + countryId,
			success : function(res) {
				$.each(res, function(stateId, stateName) {
					$('<option>').val(stateId).text(stateName).appendTo("#stateId");
				});
			}
		});
	});

	$("#stateId").change(function() {
		
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");
		
		var stateId = $("#stateId").val();
		$.ajax({
			type : "GET",
			url : "getCities?sid=" + stateId,
			success : function(data) {
				$.each(data, function(cityId, cityName) {
					$('<option>').val(cityId).text(cityName).appendTo("#cityId");
				});
			}
		});
	});

});


$("#login_btn").click(function(){
    var userName=$('#username').val();
    var passWord=$('#pass').val();

   if($.trim(userName)==""){
      $('.errorLogin').fadeIn(100);
      return false;
    }

 });


	 














