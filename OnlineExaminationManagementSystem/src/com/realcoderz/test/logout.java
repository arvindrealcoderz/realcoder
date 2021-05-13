package com.realcoderz.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

@WebServlet("/logout")
public class logout extends HttpServlet {
	public static final Logger logger = Logger.getLogger(logout.class);
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession ses=req.getSession();
		LoginVO loginvo=(LoginVO) ses.getAttribute("login");
		ses.invalidate();
		//System.out.println("============================");
		//System.out.println(loginvo.getLoginId());
		PrintWriter pw=res.getWriter();
		pw.println("<h1>Logout Successfully</h1>");
		logger.info("logut success ");
		res.sendRedirect("index.html");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
