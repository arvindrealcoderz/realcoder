package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import com.realcoderz.bo.ViewStudentDetailsBO;
import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dao.StudentRegisterDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.dto.ViewStudentDetailsDTO;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.FacultyService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.service.IFacultyService;
import com.realcoderz.service.IStudentService;
import com.realcoderz.service.StudentService;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;
import com.realcoderz.vo.UpdatePasswordVO;
import com.realcoderz.vo.ViewStudentDetailsVO;

public class StudentController {
	// create service class
	IStudentService service;
	String message = "";

	public String processRegister(RegisterVO vo) {

		// create RegisterDTO class object
		RegisterDTO dto = new RegisterDTO();
		// set value to dto object
		dto.setName(vo.getName());
		dto.setAddress(vo.getAddress());
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());
		dto.setLoginId(vo.getLoginId());
		service = new StudentService();
		// use service
		try {
			message = service.studentRegister(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	public String processLogin(LoginVO vo) {

		// create RegisterDTO class object
		LoginDTO dto = new LoginDTO();
		// set value to dto object

		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());

		service = new StudentService();
		// use service
		try {
			message = service.studentLogin(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	public String processUpdatePassword(UpdatePasswordVO vo) {

		// create RegisterDTO class object
		LoginUpdateDTO dto = new LoginUpdateDTO();
		// set value to dto object

		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());

		service = new StudentService();
		// use service
		try {
			message = service.studentPasswordUpdate(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}

	public List<ViewStudentDetailsVO> getStudentDetails(int loginId) throws Exception { // create
		List<ViewStudentDetailsVO> listvo = new ArrayList();

		// create ViewStudentDetailsDTO Object
		ViewStudentDetailsVO vo = null;

		service = new StudentService();

		List<ViewStudentDetailsDTO> listservice = service.viewStudentDetails(loginId);
		for (ViewStudentDetailsDTO list : listservice) {
			vo = new ViewStudentDetailsVO();
			vo.setId(list.getId());
			vo.setName(list.getName());
			vo.setAddhar_card(list.getAddhar_card());
			vo.setAddress(list.getAddress());
			vo.setEmail(list.getEmail());
			vo.setMobile(list.getMobile());
			vo.setPassword(list.getPassword());
			listvo.add(vo);
		} // for

		return listvo;
	}// getStudentDetails

	public int processLoginID(LoginVO vo) {

		// create service class
		IStudentService service;
		int message = 0;
		// create RegisterDTO class object
		LoginDTO dto = new LoginDTO();
		// set value to dto object

		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setPassword(vo.getPassword());

		service = new StudentService();
		// use service
		try {
			message = service.studentLoginID(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}
	public int processDeleteStudent(LoginVO vo) {
		//create service class 
		IStudentService service;
		int message=0;
		//create RegisterDTO class object
		LoginDTO dto=new LoginDTO();
		//set value to dto object
		
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setLoginId(vo.getLoginId());
		
		service=new StudentService();
		//use service
		try {
			message= service.facultyDelete(dto);
	//		System.out.println(message+"========message==============");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return message;
	}

	public String processUpdateProfile(LoginVO vo) {
		// create RegisterDTO class object
		LoginDTO dto = new LoginDTO();
		// set value to dto object
		dto.setAddhar_card(vo.getAddhar_card());
		dto.setEmail(vo.getEmail());
		dto.setMobile(vo.getMobile());
		dto.setLoginId(vo.getLoginId());
		service = new StudentService();
		// use service
		try {
			message = service.studentProfileUpdate(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
		
	}
	


}// class
