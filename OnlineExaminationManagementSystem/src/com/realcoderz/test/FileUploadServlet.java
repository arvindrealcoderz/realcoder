package com.realcoderz.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.realcoderz.vo.LoginVO;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;


@WebServlet("/html/uploadurl")
public class FileUploadServlet extends HttpServlet {
	public static final Logger logger = Logger.getLogger(FileUploadServlet.class);
	
	private  static final String  EMP_INSERT_QUERY="INSERT INTO FILE_UPLOAD  VALUES(ENO_SEQ.NEXTVAL,?,?,?,?)";
 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter  pw=null;
	  MultipartFormDataRequest nreq=null;
	  HttpSession ses=req.getSession();
	  LoginVO vo=(LoginVO) ses.getAttribute("login");
	
	  UploadBean uplBean=null;
	  Hashtable  map=null;
	  String bname=null;
	  String sname=null;
	  String paper=null;
	  
	  Connection con=null;
	  PreparedStatement ps=null;
	  ServletContext sc=null;
	  int count=0;
	  Enumeration< UploadFile> e=null;
	
		// get PrintWriter
	  pw=res.getWriter();
	  //set response content type
	  res.setContentType("text/html");
	  try {
	  // Create Special Request object
	  nreq=new MultipartFormDataRequest(req);
	  //read text based form data..
	  bname=nreq.getParameter("bname");
	  sname=nreq.getParameter("sname");
	  
	  //create FileUploading settings
	  uplBean=new UploadBean();
	  uplBean.setFolderstore("c:/store");
	  uplBean.setOverwrite(false);
	  //To keep  restrictions
	  uplBean.setFilesizelimit(1500*1024);
	  uplBean.setMaxfiles(20);
	  uplBean.setBlacklist("*.html");
	  //perform file uploading..
	  uplBean.store(nreq, "paper");
	  //get the name of the uploaded file..
	     map= nreq.getFiles();
	   paper=((UploadFile) map.get("paper")).getFileName();
	  //get ServletContext obj
	  sc=getServletContext();
	 
	// Load and register jdbc driver
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	 // Established the connection
	  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "Arvind");
		
	  //create PreparedStement ohject having query
	  ps=con.prepareStatement(EMP_INSERT_QUERY);
	  //set values to query param
	   ps.setString(1,bname);
	   ps.setString(2,sname);
	   ps.setInt(4,vo.getLoginId());
	   ps.setString(3,sc.getInitParameter("UPLOAD_LOC")+paper);
	   //execute the query
	  count=ps.executeUpdate();
	  //process the result.... and display the names of the upload files..
	  if(count==0) {
		  pw.println("<h1 style='color:red;text-align:center'>Problem in file uploading </h1>");
		  logger.info("Problem in file uploading");
			
	  }
	  else {
		  pw.println("<h1 style='color:red;text-align:center'>File uploading Successful </h1>");
		  logger.info("file uploading success ");
		 e=map.elements();
		 while(e.hasMoreElements()) {
			 UploadFile file=e.nextElement();
			 pw.println("<br>"+file.getFileName()+"---->"+file.getFileSize()+" --->"+file.getContentType());
		 }//while
	  }//else
	 }//try
	  catch(SQLException se) {
		  se.printStackTrace();
	  }
	  catch(Exception ex) {
		  logger.error("invalid size ,type , count");
		  pw.println("<h1 style='color:red;text-align:center'>invalid size ,type , count</h1>");
		  ex.printStackTrace();
	  }
	  finally {
		  //close jdbc objs
		  try {
			  if(ps!=null)
				  ps.close();
		  }
		  catch(SQLException se) {
			  se.printStackTrace();
		  }
		  
		  try {
			  if(con!=null)
				  con.close();
		  }
		  catch(SQLException se) {
			  se.printStackTrace();
		  }
		  
		  //home huperlink
		  pw.println("<br> <a href='uploadQuestionPaper.html'> home </a>");
		  
		  try {
			  if(pw!=null)
				  pw.close();
		  }
		  catch(Exception ex) {
			  ex.printStackTrace();
		  }
	  }
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
