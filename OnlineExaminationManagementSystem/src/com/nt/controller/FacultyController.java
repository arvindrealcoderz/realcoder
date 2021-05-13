package com.nt.controller;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dao.StudentRegisterDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.FacultyService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.service.IFacultyService;
import com.realcoderz.service.StudentService;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;

public class FacultyController {

	public String processRegister(RegisterVO vo) {
		//create service class 
		IFacultyService service;
		String message="";
		//create RegisterDTO class object
		RegisterDTO dto=new RegisterDTO();
		//set value to dto object
		dto.setName(vo.getName());
		dto.setAddress(vo.getAddress());
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());
		dto.setLoginId(vo.getLoginId());
		service= new FacultyService();
		//use service
		try {
			message= service.facultyRegister(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}

	public String processLogin(LoginVO vo) {

	//	System.out.println("AdminController.processLogin()");
		//create service class 
		IFacultyService service;
		String message="";
		//create RegisterDTO class object
		LoginDTO dto=new LoginDTO();
		//set value to dto object
		
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());
		
		service=new FacultyService();
		//use service
		try {
			message= service.facultyLogin(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	
	}
	public int processLoginID(LoginVO vo) {
	//	System.out.println("AdminController.processLoginid ()");
		//create service class 
		IFacultyService service;
		int message=0;
		//create RegisterDTO class object
		LoginDTO dto=new LoginDTO();
		//set value to dto object
		
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());
		
		service=new FacultyService();
		//use service
		try {
			message= service.facultyLoginID(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}
	

	public int processDeleteFaculty(LoginVO vo) {
	//	System.out.println("AdminController.processDeleteFaculty ()");
		//create service class 
		IFacultyService service;
		int message=0;
		//create RegisterDTO class object
		LoginDTO dto=new LoginDTO();
		//set value to dto object
		
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setLoginId(vo.getLoginId());
		
		service=new FacultyService();
		//use service
		try {
			message= service.facultyDelete(dto);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}

	
	public String processUpdateProfile(LoginVO vo) {
		IFacultyService service;
		String message="";
		// create RegisterDTO class object
		LoginDTO dto = new LoginDTO();
		// set value to dto object
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setLoginId(vo.getLoginId());
		service = new FacultyService();
		// use service
		try {
			message = service.studentProfileUpdate(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
		
	}

		
	

}
