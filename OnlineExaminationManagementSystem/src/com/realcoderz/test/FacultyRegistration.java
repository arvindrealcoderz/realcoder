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
import com.nt.controller.FacultyController;
import com.nt.controller.StudentController;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.validation.Validation;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;

public class FacultyRegistration extends HttpServlet {
	public static final Logger logger = Logger.getLogger(FacultyRegistration.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		LoginVO loginvo=(LoginVO) ses.getAttribute("login");
		System.out.println("FacultyRegistration.doGet()");
		FacultyController controller;
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
		vo.setLoginId(loginvo.getLoginId());
		// use admin service
		controller = new FacultyController();
		try {
			message = controller.processRegister(vo); 
			//display message to control
			pw.println("<h1 style='color:red;text-align:center'><b>'" + message + "'</b></h1>");
			pw.println("<h1 style='color:green;text-align:center'>Hello "+name+ " welcome to faculty registration , you have successfully register </h1> ");
			pw.println("<body><div style='color:green;text-align:center'> <table border='1'  bgcolor='cyan' >");
			pw.println("<thead><tr>	<th>Faculty Name</th> <th>Faculty Address</th> <th>Faculty Mobile</th> <th>Faculty Email</th> <th>Faculty addhaar card no </th>	</tr> 	</thead>");
			pw.println("<tbody style='color:pink'><tr>	<td>"+ name +"</td><td>"+ addr + "</td><td>"+mobile + "</td><td>" + email + "</td><td>" + addhar_No + "</td>	</tr> 	</tbody>");
			pw.println("</table></div></body>");
			if(message.equalsIgnoreCase("Faculty Registration success")) {
				logger.info("Faculty Registration success ");
				
				pw.print("<h1 style='color:green;text-align:center'><a href='/OnlineExaminationManagementSystem/html/facultyProfileUpdate.html'>Profile Edit/Update </a> </h1>");
				pw.println("<h1 style='color:green;text-align:center'><a href='/OnlineExaminationManagementSystem/html/facultyLogin.html'>Faculty Login Creation</a> </h1>");
				pw.println("<h1 style='color:green;text-align:center'><a href='/OnlineExaminationManagementSystem/html/facultyPasswordUpdate.html'>Password change authority</a> </h1>");
			//	pw.println("<a href='welcomeToAdmin.html'>back </a>");	

				//pw.print("<h1><a href='/OnlineExaminationManagementSystem/html/adminRegistration.html'><img alt='click here to home' src='../images/homebtn.jpg' width='55px' height='55px'></a> </h1>");
			//	pw.println("<h1><a href='/OnlineExaminationManagementSystem/html/adminRegistration.html'><img alt='click here to home' src='../images/backButton.png' width='55px' height='55px'></a> </h1><br><br>");
				
				
			}else
				logger.info("Faculty Registration failure ");
			

		} catch (Exception e) {
			logger.error("Faculty Registration success ");
			
			e.printStackTrace();
		} // catch
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
