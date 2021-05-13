package com.realcoderz.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;
import com.realcoderz.dao.AdminRegisterDAO;
import com.realcoderz.dao.IAdminDAO;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.StudentService;
import com.realcoderz.validation.Validation;

public class AdminDAOTest {

	private static  IAdminDAO service;
	private int loginId;
	private static String name;
	private static String address;
	private static String email;
	private static String mobile;
	private static String addhar_card;
	private static String password;

	@BeforeAll
	public static void setUpOnce() {
		
		service=new AdminRegisterDAO();
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
		assertNotEquals(0,service.insert(bo));
		assertEquals(1,service.insert(bo));

	}
	@Test
	public void login() throws Exception {
		LoginBO bo=new LoginBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setLoginId(1);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertNotEquals(0,service.login(bo));
		assertEquals(1,service.login(bo));

	}
@Test
	public void loginID() throws Exception {
		LoginBO bo=new LoginBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setLoginId(1);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertNotEquals(0,service.loginID(bo));
		assertEquals(156,service.loginID(bo));
		
	}

@Test
	public void updatePassword() throws Exception {
		UpdatePasswordBO bo=new UpdatePasswordBO();
		bo.setAddhar_card(addhar_card);
		bo.setEmail(email);
		bo.setPassword(password);
		bo.setMobile(mobile);
		assertNotEquals(0,service.updatePassword(bo));
	//	assertEquals(163,service.updatePassword(bo));
	}

	
	
	
	
}
