


function adminLoginsave(frm){
		$(document).ready(function() {
	alert("clcik save data ")
		var email = $("#email").val();
var mobile = $("#mobile").val();
var aadhaar = $("#aadhaar").val();
var password = $("#password").val();
//form validation logic 
var email_length=email.length;
var mobile_length=mobile.length;
var aadhaar_length=aadhaar.length;
var password_length=password.length;
	
	/*
	var flag=true;
	if (document.getElementById('Div1')) {
                if (document.getElementById('Div1').style.display == 'none') {
                    document.getElementById('Div1').style.display = 'block';
                    document.getElementById('Div2').style.display = 'none';
                }
                else {
                    document.getElementById('Div1').style.display = 'none';
                    document.getElementById('Div2').style.display = 'block';
                }
      }
	
	if(email_length<=0){
		alert("person email is required ");
		flag=false;
		return ;
	}//email
	if(mobile_length<=0){
		alert("person mobile is required ");
		flag=false;
		return ;
	}//email
	if(aadhaar_length<=0){
		alert("person aadhaar is required ");
		flag=false;
		return ;
	}//email
	if(password_length<=0){
		alert("person password is required ");
		flag=false;
		return ;
	}//email
	*/
	alert("click save data again ");
	function adminLoginsave(s){
	alert("111111111111111");
			$(document).on('#somebutton', 'click', function() {
				var email = $("#email").val();
	var mobile = $("#mobile").val();
	var aadhaar = $("#aadhaar").val();
	var password = $("#password").val();
	alert(mobile);
	//form validation logic 
	var email_length=email.length;
	var mobile_length=mobile.length;
	var aadhaar_length=aadhaar.length;
	var password_length=password.length;
				
				
	alert("click save data1111111111111111 again ");
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "adminlogin",
					data: JSON.stringify({email : email , mobile : mobile , pass :password ,aadhaar_card:aadhaar }),
					cache: false,
					success: function() {
						 $('#somediv').html("save data");
					},
					error: function() {
						$('#somediv').html("data save data");
					}
				});
			});
	
	
	
	
	}
	alert("click save data success");
		
		/*
			$.getJSON('http://localhost:8080/companyList', function(json) {
				var tr=[];
				for (var i = 0; i < json.length; i++) {
					tr.push('<tr>');
					tr.push('<td>' + json[i].id + '</td>');
					tr.push('<td>' + json[i].name + '</td>');
					tr.push('<td><button class=\'edit\'>Edit</button>&nbsp;&nbsp;<button class=\'delete\' id=' + json[i].id + '>Delete</button></td>');
					tr.push('</tr>');
				}
				$('table').append($(tr.join('')));
			});
			
			$(document).delegate('#addNew', 'click', function(event) {
				event.preventDefault();
				
				var name = $('#name').val();
				
				$.ajax({
					type: "POST",
					contentType: "application/json; charset=utf-8",
					url: "http://localhost:8080/company/save",
					data: JSON.stringify({'name': name}),
					cache: false,
					success: function(result) {
						$("#msg").html( "<span style='color: green'>Company added successfully</span>" );
						window.setTimeout(function(){location.reload()},1000)
					},
					error: function(err) {
						$("#msg").html( "<span style='color: red'>Name is required</span>" );
					}
				});
			});
			
			$(document).delegate('.delete', 'click', function() { 
				if (confirm('Do you really want to delete record?')) {
					var id = $(this).attr('id');
					var parent = $(this).parent().parent();
					$.ajax({
						type: "DELETE",
						url: "http://localhost:8080/company/delete/" + id,
						cache: false,
						success: function() {
							parent.fadeOut('slow', function() {
								$(this).remove();
							});
							location.reload(true)
						},
						error: function() {
							$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
								$(this).remove();
							});
						}
					});
				}
			});
			
			$(document).delegate('.edit', 'click', function() {
				var parent = $(this).parent().parent();
				
				var id = parent.children("td:nth-child(1)");
				var name = parent.children("td:nth-child(2)");
				var buttons = parent.children("td:nth-child(3)");
				
				name.html("<input type='text' id='txtName' value='" + name.html() + "'/>");
				buttons.html("<button id='save'>Save</button>&nbsp;&nbsp;<button class='delete' id='" + id.html() + "'>Delete</button>");
			});
*/			
		});
}