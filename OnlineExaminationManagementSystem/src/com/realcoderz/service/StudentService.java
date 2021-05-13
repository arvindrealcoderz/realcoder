package com.realcoderz.service;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;
import com.realcoderz.bo.ViewStudentDetailsBO;
import com.realcoderz.dao.AdminRegisterDAO;
import com.realcoderz.dao.FacultyRegisterDAO;
import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dao.IFacultyDAO;
import com.realcoderz.dao.IStudentDAO;
import com.realcoderz.dao.StudentRegisterDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.dto.ViewStudentDetailsDTO;
import com.realcoderz.vo.RegisterVO;

public class StudentService implements IStudentService {
	// create service class
	IStudentDAO dao;
	int count = 0;
	String message = "";
	
	@Override
	public String studentRegister(RegisterDTO dto) throws Exception {

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
		dao = new StudentRegisterDAO();
		try {
			if (dao != null) {
				count = dao.insert(bo);
				message = count == 0 ? "Student Registration Failure" : "Student Registration success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	@Override
	public String studentLogin(LoginDTO dto) throws Exception {

		// create RegisterDTO class object
		LoginBO bo = new LoginBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());
		// use dao
		dao = new StudentRegisterDAO();
		try {
			if (dao != null) {
				count = dao.login(bo);
				message = count == 0 ? "Student login Failure" : "Student login success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	@Override
	public String studentPasswordUpdate(LoginUpdateDTO dto) throws Exception {

		// create RegisterDTO class object
		UpdatePasswordBO bo = new UpdatePasswordBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setPassword(dto.getPassword());
		// use dao
		dao = new StudentRegisterDAO();
		try {
			if (dao != null) {
				count = dao.updatePassword(bo);
				message= count == 0 ? "Password Not Change Successfully " : "Password  Change Successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	
	}

	@Override
	public List<ViewStudentDetailsDTO> viewStudentDetails(int loginId) throws Exception {
		//create 
		List<ViewStudentDetailsDTO> listdto=new ArrayList();
		
		//create ViewStudentDetailsDTO Object 
		ViewStudentDetailsDTO dto=null;
		
		dao=new StudentRegisterDAO();
		
		List<ViewStudentDetailsBO> listdao=dao.viewStudentDetails(loginId);
		for (ViewStudentDetailsBO listbo : listdao) {
			dto=new ViewStudentDetailsDTO();
			dto.setId(listbo.getId());
			dto.setAddhar_card(listbo.getAddhar_card());
			dto.setAddress(listbo.getAddress());
			dto.setEmail(listbo.getEmail());
			dto.setPassword(listbo.getPassword());
			dto.setMobile(listbo.getMobile());
			dto.setName(listbo.getName());
			listdto.add(dto);
		}
		return listdto;
	}
	@Override
	public int studentLoginID(LoginDTO dto) throws Exception {
	//	System.out.println("AdminService.adminLoginid()");
		// create service class
		IStudentDAO dao;
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
		dao = new StudentRegisterDAO();
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
	//	System.out.println("StudentService.facultyDelete()");
		
			// create service class
			IStudentDAO dao;
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
			dao = new StudentRegisterDAO();
			try {
				if (dao != null) {
					loginId = dao.delete(bo);
					
		//			System.out.println("================="+loginId);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return loginId;
		}
		

	@Override
	public String studentProfileUpdate(LoginDTO dto) throws Exception {

		// create RegisterDTO class object
		LoginBO bo = new LoginBO();
		// set value to dto object
	
		bo.setAddhar_card(dto.getAddhar_card());
		bo.setEmail(dto.getEmail());
		bo.setMobile(dto.getMobile());
		bo.setLoginId(dto.getLoginId());
		// use dao
		dao = new StudentRegisterDAO();
		try {
			if (dao != null) {
				count = dao.updateProfile(bo);
				message= count == 0 ? "Mobile number not update successfully" : "Mobile number update successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	
	}

		

}
