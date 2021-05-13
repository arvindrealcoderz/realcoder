
function student(frm){
alert("student Login save");
	var email = $("#email").val();
	var mobile = $("#mobile").val();
	var aadhaar = $("#aadhaar").val();
	var password = $("#password").val();
	//form validation logic 
	var email_length=email.length;
	var mobile_length=mobile.length;
	var aadhaar_length=aadhaar.length;
	var password_length=password.length;
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
	
	if(flag){
		
		console.log(aadhaar);console.log(password);
		console.log(email);console.log(mobile);
	  $("#somebutton").click(function(){     
	     $.ajax({
	        url:'studentlogin',
	        data:{email : email , mobile : mobile , pass :password ,aadhaar_card:aadhaar },
	      //  data:{info:data},
	        type:'post',
	        //cache:false,
	        success:function(data){
	        alert(data);
	         console.log("============11111111111111================");
	         console.log('');
	         console.log(data);
	         
	          $('#somediv').html(data);  
	        },
	        error:function(){
	          alert('error');
	        }
	     });//ajax
		});//somebutton
	}//flag
	else{
		return ;
	}

}//save close
