package com.realcoderz.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/html/reporturl")
public class ReportServlet extends HttpServlet {
	public static final Logger logger = Logger.getLogger(ReportServlet.class);
	
	private static final String  GET_ALL_EMPS_QUERY="SELECT EMPNO,ENAME,EPHOTO,ERESUME FROM FILE_UPLOAD";
	///@Resource(name="DsJndi")
	//private  DataSource ds;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//	System.out.println("ReportServlet.doGet()");
      String  param=null;
      Connection con=null;
      PreparedStatement ps=null;
      ResultSet rs=null;
      ServletOutputStream sos=null;
      File file=null;
      String filePath=null;
      String mimeType=null;
      InputStream is=null;
      //general settings
      sos=res.getOutputStream();
      res.setContentType("text/html");
      //read additional req param value
      param=req.getParameter("type");
      if(param.equalsIgnoreCase("report")) {
    	    try {
    	    	 
    	    	// Load and register jdbc driver
    	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
    	    	 // Established the connection
    	    	  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "Arvind");
    	    	    	    	//create PreparedStatment object
    	    	ps=con.prepareStatement(GET_ALL_EMPS_QUERY);
    	    	//execute query 
    	    	rs=ps.executeQuery();
    	    	//process the ResultSEt obj and display report as html table
    	    	sos.println("<h1 style='color:red;text-align:center'>Question paper Details </h1>");
    	    	sos.println("<table border='1' bgcolor='cyan' align='center'>");
    	    	sos.println("<tr><th>EMPNO</th><th>Branch Name </th> <th>Subject Name</th> <th>Question paper</th> </tr> ");
    	    	while(rs.next()) {
    	    		sos.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td>"
    	    		+ "<td>"+rs.getString(3)+"</td><td><a href='reporturl?type=download&path="+rs.getString(4)+"'>download</a></td>"
    	    				+ "</tr>");
    	    	}
    	    	sos.println("</table>");
    	    	logger.info("servlet report genertated successfully ");
    	       }//try
    	      catch(SQLException se) {
    	    	  se.printStackTrace();
    	    	  logger.error("servlet report is not generated due to data base exception rise ");
    	    	  sos.println("<h1> internal problem tdry again </h1>");
    	      }
    	    catch(Exception e) {
    	    	e.printStackTrace();
    	    	  logger.error("servlet report is not generated due to  exception rise ");
     	    	 
    	  	  sos.println("<h1> internal problem try again </h1>");
    	    }
    	    finally {
    	    	//close jdbc objs
    	    	try {
    	    		if(rs!=null)
    	    			rs.close();
    	    	}
    	    	catch(SQLException se) {
    	    		se.printStackTrace();
    	    		sos.println("<h1> internal problem try again </h1>");
    	    }
    	    	
    	    	try {
    	    		if(ps!=null)
    	    			ps.close();
    	    	}
    	    	catch(SQLException se) {
    	    		se.printStackTrace();
    	    		sos.println("<h1> internal problem try again </h1>");
    	    }
    	    	
    	    	try {
    	    		if(con!=null)
    	    			con.close();
    	    	}
    	    	catch(SQLException se) {
    	    		se.printStackTrace();
    	    		sos.println("<h1> internal problem try again </h1>");
    	    	}
    	    }//finally
      }//if
      else {   //downloading
    	  //get File location from hyperlink as addtional req param value\
    	  filePath=req.getParameter("path");
    	  //create java.io.File class object
    	  file=new File(filePath);
    	  //get the length of the file and make it response length
    	  res.setContentLengthLong(file.length());
    	  //get MIME of the file and make it as  response content type
    	  mimeType=getServletContext().getMimeType(filePath);
    	  res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
    	  //create InputSteam pointing to the file
    	  is=new FileInputStream(file);
    	  // set value to Content-Disposition response header
    	  res.addHeader("Content-Disposition","attachment;filename="+file.getName());
    	  // copy File content to response object
    	//  IOUtils.copy(is,sos);
    	  //close streams
    	  is.close();
    	  sos.close();
      }
		
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
