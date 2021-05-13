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

import com.mysql.cj.Session;
import com.nt.controller.AdminController;
import com.realcoderz.exception.InvalidInput;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;

import oracle.net.aso.a;

//@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	//InvalidInput invalidInput=new InvalidInput("This is not valid input ");
	public static final Logger LOGGER = Logger.getLogger(AdminLogin.class); 
	String login=null;
	
	/*
	 * public AdminLogin() throws InvalidInput{ throw invalidInput; }
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("AdminLogin.doGet()");
		HttpSession ses=req.getSession();
		AdminController controller;
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

		//System.out.println("AdminLogin.doGet()");
		//System.out.println(email+" "+mobile+" "+aadhaar_card+" "+password);

		int loginid = 0;
		LoginVO vo = new LoginVO();

		vo.setAddhar_card(aadhaar_card);
		vo.setEmail(email);
		vo.setMobile(mobile);
		vo.setPassword(password);


		// use admin service
		controller = new AdminController();
		try {
			message = controller.processLogin(vo);
			pw.println( message );
			if(message.equalsIgnoreCase("Admin login success")) {
				LOGGER.info("Admin login success ");

				pw.println("<h1><a href='/OnlineExaminationManagementSystem/html/welcomeToAdmin.html'>click hear to go admin portel</a> </h1>");
				//res.sendRedirect("welcomeToAdmin.html");
				//pw.println("<h1><a href='/OnlineExaminationManagementSystem/html/facultyRegistration.html'>click hear to faculty registration </a> </h1><br><br>");
				//pw.println("<h1><a href='/OnlineExaminationManagementSystem/html/studentRegistration.html'>click hear to student registration </a> </h1>");
				///pw.println("<a href='/OnlineExaminationManagementSystem/html/passwordChange.html'>Password change authority</a> ");
				loginid = controller.processLoginID(vo);
				vo.setLoginId(loginid);
				ses.setAttribute("login",vo);
			//	AdminLogin login=new AdminLogin();
				//System.out.println();
			}else {
				ses.invalidate();
				pw.println( message );
				LOGGER.info("Admin login failue ");
			}

		} //catch (InvalidInput e) {
		//	LOGGER.error("input is wrong  "+invalidInput.getMessage());
		//	e.printStackTrace();
		//} // catch
		catch (Exception e) {
			LOGGER.error("admin login exception ");
			e.printStackTrace();
		} // catch

	}



	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//System.out.println("AdminLogin.doPost()");
		doGet(req, res);
	}

}
