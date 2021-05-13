package com.realcoderz.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import com.realcoderz.service.StudentService;
import com.realcoderz.validation.Validation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;
import com.realcoderz.bo.ViewStudentDetailsBO;
import com.realcoderz.dao.AdminRegisterDAO;
import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.dto.ViewStudentDetailsDTO;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.FacultyService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.vo.RegisterVO;
@DisplayName("Admin service test")
public class AdminServiceTest  {
	private static  AdminService service;
	//private static  FacultyService service1;
	private static  StudentService studservice;
	private static  Validation validation;

	private int loginId;
	private static String name;
	private static String address;
	private static String email;
	private static String mobile;
	private static String addhar_card;
	private static String password;

	@BeforeAll
	public static void setUpOnce() {
		System.out.println("aa.beforeAll()");
		service=new AdminService();
		//service1=new FacultyService();
		studservice=new StudentService();
		validation=new Validation();
		name="raja ram";
		addhar_card="559457743723";
		email="arvindv7238@mail.com";
		address="Ayodhya ";
		mobile="7238959262";
		password="arvindv7238@gmai";

	}

	@Test
	public void adminRegister() throws Exception {
		RegisterDTO dto =new RegisterDTO();
		dto.setAddhar_card(addhar_card);
		dto.setAddress(address);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setName(name);
		dto.setMobile(mobile);
		assertNotEquals("Registration Failure",service.adminRegister(dto));
		assertEquals("Registration success",service.adminRegister(dto));

	}	//adminRegister
	@Test
	public void adminRegister1() throws Exception {
		RegisterDTO dto =new RegisterDTO();
		dto.setAddhar_card(addhar_card);
		dto.setAddress(address);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setName(name);
		dto.setMobile(mobile);
		assertNotEquals("Registration Failure",service.adminRegister(dto));
		assertEquals("Registration success",service.adminRegister(dto));

	}	//adminRegister

	@Test
	public void adminLogin() throws Exception {
		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertNotEquals("Admin login Failure",service.adminLogin(dto));
		assertEquals("Admin login success",service.adminLogin(dto));

	}

	@Test
	public void adminUpdate() throws Exception {
		LoginUpdateDTO dto=new LoginUpdateDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertNotEquals("Password Not Change Successfully ",service.adminUpdate(dto));
		assertEquals("Password  updated Successfully",service.adminUpdate(dto));

	}
	@Test
	public void adminLoginID() throws Exception {
		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertNotEquals("Admin login Failure",service.adminLoginID(dto));
		assertEquals(156,service.adminLoginID(dto));

	}


}

