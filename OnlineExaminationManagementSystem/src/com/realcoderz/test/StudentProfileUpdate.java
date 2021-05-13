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
@WebServlet("/html/studentProfileUpdate")
public class StudentProfileUpdate extends HttpServlet {
	private static final Logger log=Logger.getLogger(StudentProfileUpdate.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		LoginVO loginvo=(LoginVO) ses.getAttribute("login");
		int loginId=loginvo.getLoginId();
		StudentController controller;
		String message = "";
		//set response content type
		res.setContentType("text/html");
		// get PrintWriter object
		PrintWriter pw = res.getWriter();
		// read form data (request param values)
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
		
		
		// use admin service
		controller = new StudentController();
		try {
			message = controller.processUpdateProfile(loginvo);
			if(message.equalsIgnoreCase("Mobile number update successfully"))
				log.info("student mobile number update successfully ");
			else
				log.info("student mobile number not update.  ");
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
		} catch (Exception e) {

			log.error("student mobile number not updated  successfully becouse exception is rise");
			e.printStackTrace();
		} // catch

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
