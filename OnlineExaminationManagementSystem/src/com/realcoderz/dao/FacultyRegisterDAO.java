package com.realcoderz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;

public class FacultyRegisterDAO implements IFacultyDAO {
	
	private static final String FACULTY_REGISTER_INSERT = "INSERT INTO ONLINE_FACULTY_REGISTRATION "
			+ "(FACULTY_ID,FACULTY_NAME,FACULTY_ADDRESS,FACULTY_MOBILE,FACULTY_AADHAAR,FACULTY_PASSWORD,FACULTY_EMAIL,ADMIN_ID) "
			+ "VALUES (FACULTY_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";

	private static final String FACULTY_Delete = "delete  from ONLINE_FACULTY_REGISTRATION "
			+ "where FACULTY_MOBILE=? and FACULTY_AADHAAR=?  and FACULTY_EMAIL=? and admin_id=?";

	private static final String FACULTY_LOGIN = "select count(*) from ONLINE_FACULTY_REGISTRATION where FACULTY_MOBILE=? and FACULTY_AADHAAR=? and FACULTY_PASSWORD=? and FACULTY_EMAIL=?";
	private static final String FACULTY_LOGIN_Id = "select FACULTY_ID from ONLINE_FACULTY_REGISTRATION where FACULTY_MOBILE=? and FACULTY_AADHAAR=? and FACULTY_PASSWORD=? and FACULTY_EMAIL=?";

	
	private static final String FACULTY_UPDATE_PROFILE = "UPDATE ONLINE_FACULTY_REGISTRATION SET FACULTY_MOBILE=? WHERE  "
			+ " FACULTY_AADHAAR=?  AND FACULTY_EMAIL=? and ADMIN_ID=?";
	
	
	@Override
	public int insert(RegisterBO bo) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
		if (con != null)
				//create preparestatemnt  
				pst = con.prepareStatement(FACULTY_REGISTER_INSERT);
			// set ps to string query parameter
			if (FACULTY_REGISTER_INSERT != null) {
				pst.setString(1, bo.getName());
				pst.setString(2, bo.getAddress());
				pst.setString(3, bo.getMobile());
				pst.setString(4, bo.getAddhar_card());
				pst.setString(5, bo.getPassword());
				// System.out.println(bo.getEmail());
				pst.setString(6, bo.getEmail());
				pst.setInt(7, bo.getLoginId());
				count = pst.executeUpdate();
			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Registration Failed</h1>");
		}

		return count;
	}


	@Override
	public int login(LoginBO bo) throws Exception {
	//	System.out.println("AdminRegisterDAO.login()");
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		ResultSet rs = null;
		try {
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(FACULTY_LOGIN);
			// set ps to string query parameter
			if (FACULTY_LOGIN != null) {
				pst.setString(1, bo.getMobile());
				pst.setString(2, bo.getAddhar_card());
				pst.setString(3, bo.getPassword());
				pst.setString(4, bo.getEmail());
				
	//			System.out.println(bo.getMobile()+"\t"+bo.getAddhar_card()+"\t"+bo.getEmail()+"\t"+bo.getPassword());
				rs = pst.executeQuery();
				if (rs.next()) {
					//System.out.println("AdminRegisterDAO.login(if)");
					count = rs.getInt(1);
					//System.out.println("AdminRegisterDAO.logindgdfgdfg()" + count);
				}

			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Login Failed</h1>");
		}

		return count;
	}
	@Override
	public int loginID(LoginBO bo) throws Exception {
	//	System.out.println("AdminRegisterDAO.login()");
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		ResultSet rs = null;
		try {
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
			// check conn is null or not
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(FACULTY_LOGIN_Id);
			
			// set ps to string query parameter
			if (FACULTY_LOGIN_Id != null) {
				pst.setString(1, bo.getMobile());
				pst.setString(2, bo.getAddhar_card());
				pst.setString(3, bo.getPassword());
				pst.setString(4, bo.getEmail());
		//		System.out.println(bo.getAddhar_card()+"\n"+bo.getEmail()+"\n"+bo.getMobile()+"\n"+bo.getPassword());
				
				rs = pst.executeQuery();
				if (rs.next()) {
					//System.out.println("AdminRegisterDAO.login(if)");
					count = rs.getInt(1);
					//System.out.println("AdminRegisterDAO.logindgdfgdfg()" + count);
				}
				

			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Login Id not match</h1>");
		}

		return count;
	}

	@Override
	public int delete(LoginBO bo) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
			// check conn is null or not
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(FACULTY_Delete);
	//		System.out.println(FACULTY_Delete);
			// set ps to string query parameter
			if (FACULTY_Delete != null) {
		//		System.out.println("===========");
				pst.setString(1, bo.getMobile());
				pst.setString(2, bo.getAddhar_card());
				pst.setInt(4, bo.getLoginId());
				pst.setString(3, bo.getEmail());
		//		System.out.println(bo.getAddhar_card()+"\t"+bo.getEmail()+"\t"+bo.getLoginId()+"\t"+bo.getMobile());
		//		System.out.println("================================st ");
				count = pst.executeUpdate();
		//		System.out.println("================================end ");
			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Login Id not match</h1>");
		}

		return count;
	}



	@Override
	public int updateProfile(LoginBO bo) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
			// check conn is null or not
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(FACULTY_UPDATE_PROFILE);
			// set ps to string query parameter
			if (FACULTY_UPDATE_PROFILE != null) {
				pst.setString(1, bo.getMobile());
				pst.setString(2, bo.getAddhar_card());
				pst.setInt(4, bo.getLoginId());
				pst.setString(3, bo.getEmail());
				//System.out.println(FACULTY_UPDATE_PROFILE);
				//System.out.println("============================");
				
				//  System.out.println(bo.getAddhar_card()); System.out.println(bo.getEmail());
				//  System.out.println(bo.getLoginId()); System.out.println(bo.getMobile());
				
				//System.out.println("===========================");
				count = pst.executeUpdate();
				//System.out.println(count);
			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Profile Update Failed</h1>");
		}

		return count;	}

	

}
