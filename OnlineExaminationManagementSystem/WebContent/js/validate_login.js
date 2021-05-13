function validate(frm) {
	// empty the form validate error message
	document.getElementById("email").innerHTML = "";
	document.getElementById("mobile").innerHTML = "";
	document.getElementById("aad").innerHTML = "";
	document.getElementById("pass").innerHTML = "";
	
	
	
	
	
	
	
	// read form data
	let flag = true;
	let email = frm.email.value;
	let mobile = frm.mobile.value;
	let aad = frm.aad.value;
	let pass = frm.pass.value;


 alert("submit button callled");



$("#form").on('submit',(function(e){
        e.preventDefault();
       
        $.ajax({
            url: "adminlogin",
            type: "POST",
            data:  new FormData(this),
            contentType: false,
            cache: false,
            processData:false,
            success: function(data){
                alert(data);
            },
            error: function(){
                alert("error");
            }           
        })
    }));
		
		
	if (email == "" || email == " ") {// required rule
		document.getElementById("email").innerHTML = '<i>Person email is required</i>';
		frm.addr.focus();// text box focus
		flag = false;
	}// if
	else if (email.trim().length < 5) {// required rule
		document.getElementById("email").innerHTML = '<i>Person email must have special charcter with dot </i>';
		frm.email.focus();
		flag = false;
	}// else if

	if (mobile == "") {
		document.getElementById("mobile").innerHTML = '<i>Person mobile is required  </i>';
		frm.mobile.focus();
		flag = false;
	} else if (mobile.trim().length < 10) {
		document.getElementById("mobile").innerHTML = '<i>Person mobile is number must be 10 digit numeric </i>';
		frm.mobile.focus();
		flag = false;
	} else if (mobile.trim().length > 11) {
		document.getElementById("mobile").innerHTML = '<i>Person mobile is number must be exject 10 digit numeric </i>';
		frm.mobile.focus();
		flag = false;
	}

	if (aad == "") {
		document.getElementById("aad").innerHTML = '<i>Person aadhaar is required  </i>';
		frm.aad.focus();
		flag = false;
	} else if (aad.trim().length < 10) {
		document.getElementById("aad").innerHTML = '<i>Person aadhaar card number must be 12 digit </i>';
		frm.aad.focus();
		flag = false;

	}

	if (pass == "") {
		document.getElementById("pass").innerHTML = '<i>Person password is required  </i>';
		frm.pass.focus();
		flag = false;
	} else if (aad.trim().length < 10) {
		document.getElementById("pass").innerHTML = '<i>Person password must conatine al lest upper latter and with digit  </i>';
		frm.pass.focus();
		flag = false;

	}
	return flag;
}