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
import com.realcoderz.vo.ViewStudentDetailsVO;

public class ViewStudentDetails extends HttpServlet {
	private static final Logger logger=Logger.getLogger(ViewStudentDetails.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		LoginVO loginvo=(LoginVO) ses.getAttribute("login");
		int loginid=loginvo.getLoginId();
		StudentController controller;
		List<ViewStudentDetailsVO> list = null;
		// set response content type
		res.setContentType("text/html");
		// get PrintWriter object
		PrintWriter pw = res.getWriter();
		// create register vo object
		ViewStudentDetailsVO vo = new ViewStudentDetailsVO();
		// use admin service
		controller = new StudentController();
		try {
			list = controller.getStudentDetails(loginid);
			pw.println("<h1>Student Details are</h1>");
			if(list.isEmpty())
				logger.info("no student recored found.");
			else
				logger.info(" student recored found");
			pw.println("<table border='1'><thead><tr><th>Student Id </th><th>Student Name </th><th>Student Address </th><th>Student Email </th><th>Student Aadhaar card number  </th><th>Student mobile number  </th></tr></thread><tbody>");
			for (ViewStudentDetailsVO listvo : list) {
				pw.println("<tr><td>"+listvo.getId()+"</td>"+"<td>"+listvo.getName()+"</td>"+"<td>"+listvo.getAddress()+"</td>"+"<td>"+listvo.getEmail()+"</td>"+"<td>"+listvo.getAddhar_card()+"</td>"+"<td>"+listvo.getMobile()+"</td>");
			} // for
			pw.println("</tbody></table>");
			pw.println("<h1><a href='/OnlineExaminationManagementSystem/html/welcomeToAdmin.html'>click hear to go back </a> </h1><br><br>");
			
		} catch (Exception e) {
			logger.error("no student recored found.due to exception rise.");
		
			e.printStackTrace();
		} // catch
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
