package com.realcoderz.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nt.controller.AdminController;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.validation.Validation;
import com.realcoderz.vo.RegisterVO;

public class AdminRegistration extends HttpServlet {
	public static final Logger logger = Logger.getLogger(AdminRegistration.class); 

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminController controller;
		String message = "";
		// set response content type
		res.setContentType("text/html");
		// get PrintWriter object
		
		PrintWriter pw = res.getWriter();
		// read form data (request param values)
		// : name , address : address ,email : email , mobile : mobile , pass :password ,conformpassword : conformpassword ,aadhaar_card:aadhaar
		
		String name = req.getParameter("name");
		String addr = req.getParameter("address");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String addhar_No = req.getParameter("aadhaar_card");
		String password = req.getParameter("pass");
		String psw_repeat = req.getParameter("conformpassword");
	//System.out.println("=========================================================");
	//	System.out.println(name + "" + mobile + "" + addhar_No);
	//	System.out.println("=========================================================");

		// create register vo object
		RegisterVO vo = new RegisterVO();
		vo.setName(name);
		vo.setAddress(addr);
		vo.setAddhar_card(addhar_No);
		vo.setEmail(email);
		vo.setMobile(mobile);
		vo.setPassword(password);

		// use admin service
		controller = new AdminController();
		try {
			message = controller.processRegister(vo);
			pw.println(message);
			
			if(message.equalsIgnoreCase("Registration success")) {
				logger.info("admin registration success");
				}else {
				logger.info("admin registration failure");
			}

		} catch (Exception e) {
			logger.error("admin regisration failure due to exception");
			e.printStackTrace();
		} // catch
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
