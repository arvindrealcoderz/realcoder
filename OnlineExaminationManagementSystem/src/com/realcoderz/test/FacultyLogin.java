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
import com.nt.controller.FacultyController;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;

/**
 * Servlet implementation class AdminLogin
 */
//@WebServlet("/facultylogin")
public class FacultyLogin extends HttpServlet {
	public static final Logger logger = Logger.getLogger(FacultyLogin.class);
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		
		FacultyController controller;
		String message = "";
		//get printwrite object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// read form data (request param values)
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("pass");
		String aadhaar_card = req.getParameter("aadhaar_card");

		LoginVO vo = new LoginVO();
		
		vo.setAddhar_card(aadhaar_card);
		vo.setEmail(email);
		vo.setMobile(mobile);
		vo.setPassword(password);
		int loginid = 0;
		// use admin service
		controller = new FacultyController();
		try {
			message = controller.processLogin(vo);
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
			if(message.equalsIgnoreCase("Faculty login success")) {
				logger.info("faculty login success ");
				//res.sendRedirect("welcomeToFaculty.html");
				loginid = controller.processLoginID(vo);
				vo.setLoginId(loginid);
				ses.setAttribute("faculty_login",vo);
			}else
				logger.info("faculty login failure ");
		} catch (Exception e) {
			logger.info("faculty login failure due to exception rise ");
			e.printStackTrace();
		} // catch

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
