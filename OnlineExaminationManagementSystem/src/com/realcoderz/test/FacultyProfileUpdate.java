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
import com.nt.controller.StudentController;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;
import com.realcoderz.vo.UpdatePasswordVO;
@WebServlet("/html/facultyProfileUpdate")
public class FacultyProfileUpdate extends HttpServlet {
	public static final Logger logger = Logger.getLogger(FacultyProfileUpdate.class);
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		LoginVO loginvo=(LoginVO) ses.getAttribute("login");
		int loginId=loginvo.getLoginId();
		FacultyController controller;
		String message = "";
		//set response content type
		res.setContentType("text/html");
		// get PrintWriter object
		PrintWriter pw = res.getWriter();
		// read form data (request param values)
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("pass");
		String aadhaar_card = req.getParameter("aadhaar_card");

		// create register vo object
		
		loginvo.setAddhar_card(aadhaar_card);
		loginvo.setLoginId(loginId);
		loginvo.setEmail(email);
		loginvo.setMobile(mobile);
		
		System.out.println(aadhaar_card);
		// use admin service
		controller = new FacultyController();
		try {
			message = controller.processUpdateProfile(loginvo);
			if(message.equalsIgnoreCase("Mobile number change successfully")) {
				logger.info("faculty mobile no has been updated successfully");
			}else
				logger.info("faculty mobile no has been not updated successfully");
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
		} catch (Exception e) {
			logger.error("faculty mobile no has been updated successfully becouse due to exception rise ");
			e.printStackTrace();
		} // catch

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
