package com.realcoderz.validation;

import java.util.ArrayList;
import java.util.List;

public class Validation {

	String name;
	String addr;
	String email;
	String mobile;
	String addhar_No;
	String password;
	String psw_repeat;
	
	public String validate(List<String> list){
		boolean flag=true;
		name=list.get(0);
		addhar_No=list.get(1);
		addr=list.get(2);
		email=list.get(3);
		mobile=list.get(4);
		password=list.get(5);
		psw_repeat=list.get(6);
		
		//execute server side validation logic only when client side validation not done
				//form validation logic
				List<String> errList=new ArrayList<String>();
				if(name==null || name.equals("") || name.length()==0)
					//errList.add("Person name is required");
					return "Person name is required";
				else if(name.length()<5)
					//errList.add("Person name must have minimum 5 character");
					return "Person name must have minimum 5 character";
				
				if(addr==null || addr.equals("") || addr.length()==0)
					//errList.add("Person address is required");
					return "Person address is required";
				else if(addr.length()<5)
					//errList.add("Person address must have minimum 5 character");
					return "Person address must have minimum 5 character";
				if(email==null || email.equals("") || email.length()==0)
					//errList.add("Person address is required");
					return "Person email is required";
				else if(email.length()<5)
					//errList.add("Person email must have minimum 5 character");
					return "Person email must have minimum 5 character";
				else if(email.contains("@"))
					//errList.add("Person email must have special @ character ");
					return "Person email must have special @ character";
				if(mobile==null || mobile.equals("") || mobile.length()==0)
					//errList.add("Person mobile number is required");
					return "Person mobile number is required";
				else if(mobile.length()<10)
					//errList.add("Person mobile must have 10 digit number ");
					return "Person mobile must have 10 digit number";
						
				if(addhar_No==null || addhar_No.equals("") || addhar_No.length()==0)
					//errList.add("Person aadhaar number is required");
					return "Person aadhaar number is required";
				else if(addhar_No.length()<12)
					//errList.add("Person mobile must have 12 digit number ");
					return "Person aadhaar number is required";	
				if(password==null || password.equals("") || password.length()==0)
					//errList.add("Person password number is required");
					return "Person aadhaar number is required";
				else if(password.length()<6)
					//errList.add("Person password must have 6 digit number ");
					return "Person aadhaar number is required";	
				if(psw_repeat==null || psw_repeat.equals("") || psw_repeat.length()==0)
					//errList.add("Person password number is required");
				return "Person password number is required";
				else if(psw_repeat.length()<6)
					//errList.add("Person password must have 6 digit number ");
					return "Person password must have 6 digit number";	
				if(psw_repeat==psw_repeat)
					//errList.add("Password must be same");
					return "Password must be same";
			//return errList;
				return "";
				
		
	}
}
