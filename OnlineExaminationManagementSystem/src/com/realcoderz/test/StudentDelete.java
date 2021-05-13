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

@WebServlet("/html/studentDelete")
public class StudentDelete extends HttpServlet {
	private static final Logger logger=Logger.getLogger(StudentDelete.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		StudentController controller;
		String message = "";
		//get printwrite object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// read form data (request param values)
		// read form data (request param values)
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String aadhaar_card = req.getParameter("aadhaar_card");
		LoginVO vo = new LoginVO();

		vo.setAddhar_card(aadhaar_card);
		vo.setEmail(email);
		vo.setMobile(mobile);
		LoginVO login=	(LoginVO) ses.getAttribute("login");
		int loginId=login.getLoginId();
		vo.setLoginId(Integer.valueOf(loginId));

		int loginid = 0;
		// use admin service
		controller = new StudentController();
		try {

			loginid = controller.processDeleteStudent(vo);
			message=loginid==0?"Deletion Failed ":"Student Delete Success";
			if(loginid!=0)
				logger.info("student recored are deleted successfully.");
			else
				logger.info("student recored are not deleted successfully.");
			pw.println("<h1>'"+message+"'</h1>");
		} catch (Exception e) {
			logger.error("student recored are deleted due to exception rise.");
			e.printStackTrace();
		} // catch
		//pw.println("<a href='/OnlineExaminationManagementSystem'><img alt='click here to home' src='../images/homebtn.jpg' width='55px' height='55px'> </a>");

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
