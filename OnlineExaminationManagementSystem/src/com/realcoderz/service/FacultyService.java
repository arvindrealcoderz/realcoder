package com.realcoderz.service;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.dao.AdminRegisterDAO;
import com.realcoderz.dao.FacultyRegisterDAO;
import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dao.IFacultyDAO;
import com.realcoderz.dao.IStudentDAO;
import com.realcoderz.dao.StudentRegisterDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.vo.RegisterVO;

public class FacultyService implements IFacultyService {

	@Override
	public String facultyRegister(RegisterDTO dto) throws Exception {
		// create service class
		IFacultyDAO dao;
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
		bo.setLoginId(dto.getLoginId());
		// use dao
		dao = new FacultyRegisterDAO();
		try {
			if (dao != null) {
				count = dao.insert(bo);
				message = count == 0 ? "Faculty Registration Failure" : "Faculty Registration success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	@Override
	public String facultyLogin(LoginDTO dto) throws Exception {
	
		// create service class
		IFacultyDAO dao;
		int count = 0;
		String message = "";
		// create RegisterDTO class object
		LoginBO bo = new LoginBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());
		//System.out.println("login pass "+dto.getPassword());
		// use dao
		dao = new FacultyRegisterDAO();
		try {
			if (dao != null) {
				count = dao.login(bo);
				///System.out.println(count);
				message = count == 0 ? "Faculty login Failure" : "Faculty login success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}
	
	@Override
	public int facultyLoginID(LoginDTO dto) throws Exception {
	//	System.out.println("FacultyService.facultyLoginID()");
		// create service class
		IFacultyDAO dao;
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
		dao = new FacultyRegisterDAO();
		try {
			if (dao != null) {
				loginId = dao.loginID(bo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginId;
	}
	


	@Override
	public int facultyDelete(LoginDTO dto) throws Exception {
	//	System.out.println("FacultyService.facultyDelete()");
		// create service class
		IFacultyDAO dao;
		int loginId = 0;
		String message = "";
		// create RegisterDTO class object
		LoginBO bo = new LoginBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());
		bo.setLoginId(dto.getLoginId());
		// use dao
		dao = new FacultyRegisterDAO();
		try {
			if (dao != null) {
				loginId = dao.delete(bo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginId;
	}

	@Override
		public String studentProfileUpdate(LoginDTO dto) throws Exception {
			IFacultyDAO dao=null;
			// create RegisterDTO class object
			LoginBO bo = new LoginBO();
			// set value to dto object
			int count=0;
			String message="";
		
			bo.setAddhar_card(dto.getAddhar_card());
			bo.setEmail(dto.getEmail());
			bo.setMobile(dto.getMobile());
			bo.setLoginId(dto.getLoginId());
			// use dao
			dao = new FacultyRegisterDAO();
			try {
				if (dao != null) {
					count = dao.updateProfile(bo);
					message= count == 0 ? "Faculty Profile is not updated" : "Mobile number change successfully";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return message;
		
		}
}
	


	

