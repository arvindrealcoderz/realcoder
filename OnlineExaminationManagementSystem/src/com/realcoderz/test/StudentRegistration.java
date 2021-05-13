package com.realcoderz.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.nt.controller.AdminController;
import com.nt.controller.StudentController;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.validation.Validation;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;

public class StudentRegistration extends HttpServlet {
	private static final Logger log=Logger.getLogger(StudentRegistration.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession ses=req.getSession();
		LoginVO loginvo=(LoginVO) ses.getAttribute("login");
		
		StudentController controller;
		String message = "";
		// set response content type
		res.setContentType("text/html");
		// get PrintWriter object
		PrintWriter pw = res.getWriter();
		// read form data (request param values)
		String name = req.getParameter("name");
		String addr = req.getParameter("address");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String addhar_No = req.getParameter("aadhaar_card");
		String password = req.getParameter("pass");
		String psw_repeat = req.getParameter("conformpassword");
		
		//System.out.println(name + "" + mobile + "" + addhar_No);

		// create register vo object
		RegisterVO vo = new RegisterVO();
		vo.setName(name);
		vo.setAddress(addr);
		vo.setAddhar_card(addhar_No);
		vo.setEmail(email);
		vo.setMobile(mobile);
		vo.setPassword(password);
		//System.out.println(loginvo.getLoginId()+"log in id "+loginvo.getEmail());
		vo.setLoginId(loginvo.getLoginId());
		// use admin service
		controller = new StudentController();
		try {
			message = controller.processRegister(vo);
			
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
			pw.println("<h1 style='color:green;text-align:center'>Hello "+name+ " welcome to student registration , you have successfully register </h1> ");
			pw.println("<body><div style='color:green;text-align:center'> <table border='1'  bgcolor='cyan' >");
			pw.println("<body><table border='1'  bgcolor='blue'>");
			pw.println(
					"<thead style='color:white'><tr><th>Admin Name</th> <th>Admin Address</th> <th>Admin Mobile</th> <th>Admin Email</th> <th>Admin addhaar card no </th>	</tr> 	</thead>");
			pw.println("<tbody style='color:white'><tr>	<td>"+ name +"</td><td>"+ addr + "</td><td>"+mobile + "</td><td>" + email + "</td><td>" + addhar_No + "</td>	</tr> 	</tbody>");
			pw.println("</table></body>");
			if(message.equalsIgnoreCase("Student Registration success")) {
				log.info("student registration success ");
			//	pw.println("<h1><a href='/OnlineExaminationManagementSystem/html/studentProfileUpdate.html'>Profile Edit/Update </a> </h1><br><br>");
				pw.println("<h1 style='color:green;text-align:center'><a href='/OnlineExaminationManagementSystem/html/studentLogin.html'>Student Login Creation</a> </h1>");
				pw.println("<h1 style='color:green;text-align:center'><a href='/OnlineExaminationManagementSystem/html/StudentpasswordChange.html'>Password change authority</a> </h1>");
				
			}
			else {
				log.info("student registration failure  ");
			}
		} catch (Exception e) {
			log.error("student registration failure failue due to exception rise. ");
			e.printStackTrace();
		} // catch
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
