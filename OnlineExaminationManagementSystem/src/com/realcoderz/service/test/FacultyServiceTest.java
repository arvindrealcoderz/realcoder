package com.realcoderz.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.FacultyService;
import com.realcoderz.service.StudentService;
import com.realcoderz.validation.Validation;

public class FacultyServiceTest {
	private static  FacultyService service1;

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
		service1=new FacultyService();
		//studservice=new StudentService();
		name="raja ram";
		addhar_card="559457743723";
		email="arvindv7238@mail.com";
		address="Ayodhya ";
		mobile="7238959262";
		password="arvindv7238@gmai";

	}

	
	
	
	
	
	@Test
	public void facultyRegister() throws Exception {

		RegisterDTO dto =new RegisterDTO();
		dto.setAddhar_card(addhar_card);
		dto.setAddress(address);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setName(name);
		dto.setMobile(mobile);
		assertEquals("Faculty Registration Failure",service1.facultyRegister(dto));
		assertNotEquals("Faculty Registration success",service1.facultyRegister(dto));


	}


	@Test
	public void facultyLoginTest() throws Exception {
		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);

		assertEquals("Faculty login Failure",service1.facultyLogin(dto));
		assertNotEquals("Faculty login success",service1.
				facultyLogin(dto));

	}//Faculty login dto

	@Test
	public void facultyLoginIDTest() throws Exception {
		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertNotEquals("Admin login Failure",service1.facultyLoginID(dto));
		assertEquals(0,service1.facultyLoginID(dto));

	}//LoginIdTest


	@Test
	public void facultyDeleteTest() throws Exception {

		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setLoginId(1);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertEquals(0,service1.facultyDelete(dto));

	}//facultyLoginDeletion
	@Test
	public void studentProfileUpdate() throws Exception {

		LoginDTO dto=new LoginDTO();
		dto.setAddhar_card(addhar_card);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setMobile(mobile);
		assertEquals("Faculty Profile is not updated",service1.studentProfileUpdate(dto));
		assertNotEquals("Mobile number change successfully",service1.studentProfileUpdate(dto));


	}
}
