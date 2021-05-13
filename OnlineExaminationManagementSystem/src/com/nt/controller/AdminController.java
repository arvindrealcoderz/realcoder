package com.nt.controller;

import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;
import com.realcoderz.vo.UpdatePasswordVO;

public class AdminController {

	public String processRegister(RegisterVO vo) {
		//create service class 
		IAdminService service;
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
		
		service=new AdminService();
		//use service
		try {
			message= service.adminRegister(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}
	
	
	public String processLogin(LoginVO vo) {
		//System.out.println("AdminController.processLogin()");
		//create service class 
		IAdminService service;
		String message="";
		//create RegisterDTO class object
		LoginDTO dto=new LoginDTO();
		//set value to dto object
		
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());
		
		service=new AdminService();
		//use service
		try {
			message= service.adminLogin(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}
	
	
	public int processLoginID(LoginVO vo) {
	//	System.out.println("AdminController.processLoginid ()");
		//create service class 
		IAdminService service;
		int message=0;
		//create RegisterDTO class object
		LoginDTO dto=new LoginDTO();
		//set value to dto object
		
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());
		
		service=new AdminService();
		//use service
		try {
			message= service.adminLoginID(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}
	
	public String processUpdate(UpdatePasswordVO vo) {

		//create service class 
		IAdminService service;
		String message="";
		//create RegisterDTO class object
		LoginUpdateDTO dto=new LoginUpdateDTO();
		//set value to dto object
		
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());
		
		service=new AdminService();
		//use service
		try {
			message= service.adminUpdate(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}
	

}
