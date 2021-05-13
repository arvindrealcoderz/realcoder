package com.realcoderz.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.FacultyService;
import com.realcoderz.service.StudentService;
import com.realcoderz.validation.Validation;

public class StudentServiceTest {
	private static  StudentService studservice;
	
	private int loginId;
	private static String name;
	private static String address;
	private static String email;
	private static String mobile;
	private static String addhar_card;
	private static String password;

	@BeforeAll
	public static void setUpOnce() {
		System.out.println("FacultyServiceTest.setUpOnce()");
		studservice=new StudentService();
		name="raja ram";
		addhar_card="559457743723";
		email="arvindv7238@mail.com";
		address="Ayodhya ";
		mobile="7238959262";
		password="arvindv7238@gmai";

	}

	
	
	


	@Test
	public void studentRegister() throws Exception{
		RegisterDTO dto =new RegisterDTO();
		dto.setAddhar_card(addhar_card);
		dto.setAddress(address);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setName(name);
		dto.setMobile(mobile);
		//		assertNotEquals("Student Registration Failure",studservice.studentRegister(dto));
		assertNotEquals("Student Registration success",studservice.studentRegister(dto));

	}
	@Test
	public void studentLogin() throws Exception{
		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);

		assertNotEquals("Student login success",studservice.studentLogin(dto));
		assertNotEquals("FStudent login Failure",studservice.studentLogin(dto));
	}
	@Test
	public void studentPasswordUpdate() throws Exception{
		LoginUpdateDTO dto=new LoginUpdateDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setMobile(mobile);
		//	assertEquals("Password Not Change Successfully",studservice.studentPasswordUpdate(dto));
		assertNotEquals("Password  Change Successfully",studservice.studentPasswordUpdate(dto));

	}

	@Test
	public void viewStudentDetails() throws Exception{
		;
		studservice.viewStudentDetails(0);
		//assertNotEquals(List<ViewStudentDetailsBO>,studservice.viewStudentDetails(0));
		//assertEquals("Password  Change Successfully",studservice.viewStudentDetails(1));

	}
	@Test
	public void studentLoginID() throws Exception{
		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertNotEquals(1,studservice.studentLoginID(dto));
		assertEquals(0,studservice.studentLoginID(dto));


	}
	@Test
	public void facultyDelete() throws Exception{ 
		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertEquals(0,studservice.facultyDelete(dto));
		//assertEquals(1,studservice.facultyDelete(dto));

	}
	@Test
	public void studentProfileUpdateTest() throws Exception {

		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertNotEquals("Mobile number update successfully",studservice.studentProfileUpdate(dto));
		assertEquals("Mobile number not update successfully",studservice.studentProfileUpdate(dto));

	}

	


}
