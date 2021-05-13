function validate(frm) {
	// empty the form validate error message
	document.getElementById("name").innerHTML = "";
	document.getElementById("addr").innerHTML = "";
	document.getElementById("email").innerHTML = "";
	document.getElementById("mobile").innerHTML = "";
	document.getElementById("aad").innerHTML = "";
	document.getElementById("pass").innerHTML = "";
	document.getElementById("re_pass").innerHTML = "";

	// read form data
	let flag = true;
	let name = frm.name.value;
	let addr = frm.addr.value;
	let email = frm.email.value;
	let mobile = frm.mobile.value;
	let aad = frm.aad.value;
	let pass = frm.pass.value;
	let re_pass = frm.re_pass.value;

	// client side validation
	if (name == "" || name == " ") {// required rule
		document.getElementById("name").innerHTML = '<i>Person name is required</i>';
		frm.name.focus();// text box focus
		flag = false;
	}// if
	else if (name.trim().length < 5) {// required rule
		document.getElementById("name").innerHTML = '<i>Person name must have min 5 chars </i>';
		frm.name.focus();
		flag = false;
	}// else if

	
	
	
	
	if (addr == "") {// required rule
		document.getElementById("addr").innerHTML = '<i>Person address is required</i>';
		frm.addr.focus();// text box focus
		flag = false;
	}// if
	else if (addr.length < 5) {// required rule
		document.getElementById("addr").innerHTML = '<i>Person address must have min 5 chars </i>';
		frm.addr.focus();
		
		flag = false;
	}// else if

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

	if (re_pass == "") {
		document.getElementById("re_pass").innerHTML = '<i>Person password is required  </i>';
		frm.re_pass.focus();
		flag = false;
	} else if (re_pass.trim().length < 10) {
		document.getElementById("re_pass").innerHTML = '<i>Person password must conatine al lest upper latter and with digit  </i>';
		frm.re_pass.focus();
		flag = false;

	}

	return flag;
}