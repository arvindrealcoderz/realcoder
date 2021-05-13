package com.realcoderz.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nt.controller.AdminController;
import com.nt.controller.StudentController;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;

/**
 * Servlet implementation class AdminLogin
 */
//@WebServlet("/adminlogin")
public class StudentLogin extends HttpServlet {
	private static final Logger logger=Logger.getLogger(StudentLogin.class);
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses = req.getSession();
		StudentController controller;
		String message = "";
		// get printwrite object
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// read form data (request param values)
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("pass");
		String aadhaar_card = req.getParameter("aadhaar_card");

		int loginid = 0;
		LoginVO vo = new LoginVO();

		vo.setAddhar_card(aadhaar_card);
		vo.setEmail(email);
		vo.setMobile(mobile);
		vo.setPassword(password);

		// use admin service
		controller = new StudentController();
		try {
			message = controller.processLogin(vo);
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
			if (message.equalsIgnoreCase("Student login success")) {
				logger.info("student login success ");
				loginid = controller.processLoginID(vo);
				vo.setLoginId(loginid);
				ses.setAttribute("student_login", vo);
				LoginVO id = (LoginVO) ses.getAttribute("student_login");
				pw.println("<h1 style='color:blue;text-align:center'><a href='reporturl?type=report'>View Question paper</a></h1>");
			} else {
				logger.info("student login failure ");
				ses.invalidate();
				pw.println("<h1 style='color:red;text-align:center'><b>login fail</b></h1>");
			}
			pw.println("<h1><a href='/OnlineExaminationManagementSystem/html/studentLogin.html'>click hear to go back </a> </h1><br><br>");
			
		} catch (Exception e) {
			logger.error("student login failure due to exception rise ");
			e.printStackTrace();
		} // catch

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
