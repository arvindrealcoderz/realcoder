package com.realcoderz.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;
import com.realcoderz.dao.IFacultyDAO;
import com.realcoderz.dao.IStudentDAO;

public class StudentRegisterDAOTest {


	private static  IStudentDAO dao;
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
		dao=new com.realcoderz.dao.StudentRegisterDAO();
		name="raja ram";
		addhar_card="559457743723";
		email="arvindv7238@mail.com";
		address="Ayodhya ";
		mobile="7238959262";
		password="arvindv7238@gmai";

	}
	@Test
	public void insert() throws Exception {
		RegisterBO bo=new RegisterBO();
		bo.setAddhar_card(addhar_card);
		bo.setAddress(address);
		bo.setEmail(email);
		bo.setLoginId(1);
		bo.setPassword(password);
		bo.setName(name);
		bo.setMobile(mobile);
		assertEquals(0,dao.insert(bo));
		assertNotEquals(1,dao.insert(bo));
	}
	@Test
	public void login() throws Exception {
		LoginBO bo=new LoginBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setLoginId(1);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertEquals(0,dao.login(bo));
		assertNotEquals(1,dao.login(bo));
	}
	@Test
	public void updatePassword() throws Exception {
		UpdatePasswordBO bo=new UpdatePasswordBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertEquals(0,dao.updatePassword(bo));
		assertNotEquals(163,dao.updatePassword(bo));
	}
		
	public void viewStudentDetails(int loginId) throws Exception {
		
		
	}
	@Test
	public void loginID() throws Exception {
		LoginBO bo=new LoginBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setLoginId(1);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertEquals(0,dao.loginID(bo));
		assertNotEquals(156,dao.loginID(bo));

		
	}
	@Test
	public void delete() throws Exception {
		LoginBO bo=new LoginBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setLoginId(1);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertEquals(0,dao.delete(bo));
		assertNotEquals(156,dao.delete(bo));

		
	}

	@Test
	public void updateProfile() throws Exception {
		LoginBO bo=new LoginBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertEquals(0,dao.updateProfile(bo));
		assertNotEquals(163,dao.updateProfile(bo));

	}




}
