$(document).ready(function () {

	jQuery.validator.addMethod("lettersonly", function(value, element) {
     return this.optional(element) || /^[a-z\s]+$/i.test(value);
     });
	//---------------------email validation -----------------------------------
	var value = $("#password").val();
	
	$.validator.addMethod("checklower", function(value) {
	  return /[a-z]/.test(value);
	});
	$.validator.addMethod("checkupper", function(value) {
	  return /[A-Z]/.test(value);
	});
	$.validator.addMethod("checkdigit", function(value) {
	  return /[0-9]/.test(value);
	});
	$.validator.addMethod("pwcheck", function(value) {
	  return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) && /[a-z]/.test(value) && /\d/.test(value) && /[A-Z]/.test(value);
	});
	//---------------------email validation -----------------------------------
	
	$("form").validate({
	    rules: {
		    name: {
	            lettersonly: true
	
	        },
		    email: {
		        required: true,
		            email: true
		        },
		        password: {
		            required: true
		        },
			mobile:{
			    required:true,
			  	minlength:9,
			  	maxlength:10,
			  	number: true
			    },		
			aadhaar:{
			    required:true,
			  	minlength:12,
			  	maxlength:12,
			  	number: true
			    },
			password: {
		      minlength: 6,
		      maxlength: 30,
		      required: true,
		      //pwcheck: true,
		      checklower: true,
		      checkupper: true,
		      checkdigit: true
		    },
		    conformpassword: {
              required: true,
              minlength: 6,
		      maxlength: 30,
		      required: true,
		     
		      checklower: true,
		      checkupper: true,
		      checkdigit: true,
              equalTo: "#password"
        	},
	    },
	    messages: {
	    	name: {
            lettersonly: "please enter characters only",
        	},
		    password: {
		      pwcheck: "Password is not strong enough",
		      checklower: "Need atleast 1 lowercase alphabet",
		      checkupper: "Need atleast 1 uppercase alphabet",
		      checkdigit: "Need atleast 1 digit"
		    }
		    
		    
		    
	    },
	    
	    highlight: function(element) {
	        $(element).closest('.form-group').addClass('has-error');
	    },
	    unhighlight: function(element) {
	        $(element).closest('.form-group').removeClass('has-error');
	    }
	    
	}); //validate
 });//document