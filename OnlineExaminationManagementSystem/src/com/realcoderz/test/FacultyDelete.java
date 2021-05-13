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

@WebServlet("/html/facultyDelete")
public class FacultyDelete extends HttpServlet {
	public static final Logger logger = Logger.getLogger(FacultyDelete.class); 



	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


		//System.out.println("FacultyDelete.doGet()");
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
		controller = new FacultyController();
		try {

			loginid = controller.processDeleteFaculty(vo);
			message=loginid==0?"Deletion Failed ":"Faculty Delete Success";
			if(loginId!=0)
				logger.info("faculty are  deletion ");
			else
				logger.info("faculty are not deletion ");

			pw.println(message);
		} catch (Exception e) {
			logger.error("faculty are not deletion becouse exception is rise ");

			e.printStackTrace();
		} // catch

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
