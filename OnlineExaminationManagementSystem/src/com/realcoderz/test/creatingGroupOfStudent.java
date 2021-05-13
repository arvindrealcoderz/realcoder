package com.realcoderz.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.controller.AdminController;
import com.nt.controller.StudentController;
import com.realcoderz.service.AdminService;
import com.realcoderz.service.IAdminService;
import com.realcoderz.validation.Validation;
import com.realcoderz.vo.LoginVO;
import com.realcoderz.vo.RegisterVO;
import com.realcoderz.vo.ViewStudentDetailsVO;

@WebServlet("/groupOfStudent")
public class creatingGroupOfStudent extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//System.out.println("creatingGroupOfStudent.doGet()");
		HttpSession ses=req.getSession();
		LoginVO loginvo=(LoginVO) ses.getAttribute("faculty_login");
		int loginid=loginvo.getLoginId();
		//System.out.println("========================="+loginid);
		String check=req.getParameter("checkbox");
		
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
			
			//req.setAttribute("studentData", list);
			//RequestDispatcher  rd=req.getRequestDispatcher("viewStudentDetails.html");
			//rd.include(req,res);
			//res.sendRedirect("/OnlineExaminationManagementSystem/html/viewStudentDetails.html");
			if(list==null) {

				pw.println("<h1>No recored found.</h1>");
					
			}else {
			pw.println("<h1>Student Details are</h1>");
			pw.println("<table border='1'><thead><tr><th>Student Id </th><th>Student Name </th>"
					+ "<th>Student Address </th><th>Student Email </th><th>Student Aadhaar card number  </th>"
					+ "<th>Student mobile number  </th><th>assign question paper of the student  </th></tr></thread><tbody>");
			for (ViewStudentDetailsVO listvo : list) {
				pw.println("<tr><td>"+listvo.getId()+"</td>"+"<td>"+listvo.getName()+"</td>"
						+ " "+"<td>"+listvo.getAddress()+"</td>"+"<td>"+listvo.getEmail()+"</td>"+"<td>"
								+ ""+listvo.getAddhar_card()+"</td>"+"<td>"+listvo.getMobile()+"</td>"
										+ "<td> <input type='checkbox' class='btn btn-danger' ></td>");
			} // for
			pw.println("</tbody></table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
