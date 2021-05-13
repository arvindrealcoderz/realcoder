package com.realcoderz.service;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;
import com.realcoderz.dao.AdminRegisterDAO;
import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.vo.RegisterVO;

public class AdminService implements IAdminService {

	@Override
	public String adminRegister(RegisterDTO dto) throws Exception {
		// create service class
		IAdminDAO dao;
		int count = 0;
		String message = "";
		// create RegisterDTO class object
		RegisterBO bo = new RegisterBO();
		// set value to dto object
		bo.setName(dto.getName());
		bo.setAddress(dto.getAddress());
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());

		// use dao
		dao = new AdminRegisterDAO();
		try {
			if (dao != null) {
				count = dao.insert(bo);
				message = count == 0 ? "Registration Failure" : "Registration success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}
	//Login 
	@Override
	public String adminLogin(LoginDTO dto) throws Exception {
	//	System.out.println("AdminService.adminLogin()");
		// create service class
		IAdminDAO dao;
		int count = 0;
		String message = "";
		// create RegisterDTO class object
		LoginBO bo = new LoginBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());
		// use dao
		dao = new AdminRegisterDAO();
		try {
			if (dao != null) {
				count = dao.login(bo);
				message = count == 0 ? "Admin login Failure" : "Admin login success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	@Override
	public String adminUpdate(LoginUpdateDTO dto) throws Exception {
		//System.out.println("AdminService.adminLogin()");
		// create service class
		IAdminDAO dao;
		int count = 0;
		String message = "";
		// create RegisterDTO class object
		UpdatePasswordBO bo = new UpdatePasswordBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());
		// use dao
		dao = new AdminRegisterDAO();
		try {
			if (dao != null) {
				count = dao.updatePassword(bo);
				message= count == 0 ? "Password Not Change Successfully " : "Password  updated Successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}
	@Override
	public int adminLoginID(LoginDTO dto) throws Exception {
	//	System.out.println("AdminService.adminLoginid()");
		// create service class
		IAdminDAO dao;
		int loginId = 0;
		String message = "";
		// create RegisterDTO class object
		LoginBO bo = new LoginBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());
		// use dao
		dao = new AdminRegisterDAO();
		try {
			if (dao != null) {
				loginId = dao.loginID(bo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginId;
	}


}
	
	