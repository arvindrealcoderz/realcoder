package com.realcoderz.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.nt.controller.AdminController;
import com.nt.controller.StudentController;
import com.realcoderz.vo.RegisterVO;
import com.realcoderz.vo.UpdatePasswordVO;

public class StudentUpdatePassword extends HttpServlet {
	private static final Logger log=Logger.getLogger(StudentUpdatePassword.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		StudentController controller;
		String message = "";
		//set response content type
		res.setContentType("text/html");
		// get PrintWriter object
		PrintWriter pw = res.getWriter();
		
		// read form data (request param values)
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String addhar_No = req.getParameter("aadhaar");
		String password = req.getParameter("password");

		//System.out.println(name + "" + mobile + "" + addhar_No);

		// create register vo object
		UpdatePasswordVO vo = new UpdatePasswordVO();
		vo.setAddhar_card(addhar_No);
		vo.setEmail(email);
		vo.setMobile(mobile);
		vo.setPassword(password);

		// use admin service
		controller = new StudentController();
		try {
			message = controller.processUpdatePassword(vo);
			if(message.equalsIgnoreCase("Password  Change Successfully")) 
				log.info("Password  updated Successfully");
			else
				log.info("Password not updated   Successfully");
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
			pw.println("<h1 style='color:green'>Hello User Your password is change</h1> ");
		} catch (Exception e) {
			log.error("Password not updated due to exception rise.");
			e.printStackTrace();
		} // catch

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
