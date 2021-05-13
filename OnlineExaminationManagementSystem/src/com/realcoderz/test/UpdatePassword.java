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
import com.realcoderz.vo.RegisterVO;
import com.realcoderz.vo.UpdatePasswordVO;


public class UpdatePassword extends HttpServlet {
	private static final Logger logger=Logger.getLogger(UpdatePassword.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminController controller;
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
		controller = new AdminController();
		try {
			message = controller.processUpdate(vo);
			if(message.equalsIgnoreCase("Password  updated Successfully"))
				logger.info("Password  updated Successfully");
			else
				logger.info("Password  not updated.");
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
			pw.println("<h1 style='color:green'>Hello User Your password is change</h1> ");
		} catch (Exception e) {
			logger.error("Password not updated due to exception rise.");
			e.printStackTrace();
		} // catch

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
