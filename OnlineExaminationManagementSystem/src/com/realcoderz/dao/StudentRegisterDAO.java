package com.realcoderz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;
import com.realcoderz.bo.ViewStudentDetailsBO;

public class StudentRegisterDAO implements IStudentDAO {
	private static final String ADMIN_REGISTER_INSERT = "INSERT INTO ONLINE_STUDENT_REGISTRATION "
			+ "(STUDENT_ID,STUDENT_NAME,STUDENT_ADDRESS,STUDENT_MOBILE,STUDENT_AADHAAR_CARD,STUDENT_PASSWORD,STUDENT_EMAIL,ADMIN_ID) "
			+ "VALUES (STUDENT_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	private static final String STUDENT_LOGIN = "SELECT COUNT(*) FROM ONLINE_STUDENT_REGISTRATION WHERE STUDENT_MOBILE=? AND STUDENT_AADHAAR_CARD=? AND STUDENT_PASSWORD=? AND STUDENT_EMAIL=?";
	private static final String STUDENT_UPDATE_PASSWORD = "UPDATE ONLINE_STUDENT_REGISTRATION SET STUDENT_PASSWORD=? WHERE STUDENT_MOBILE=? AND "
			+ " STUDENT_AADHAAR_CARD=?  AND STUDENT_EMAIL=?";
	private static final String STUDENT_UPDATE_PROFILE = "UPDATE ONLINE_STUDENT_REGISTRATION SET STUDENT_MOBILE=? WHERE  "
			+ " STUDENT_AADHAAR_CARD=?  AND STUDENT_EMAIL=? and ADMIN_ID=?";
	
	private static final String VIEWSTUDENTDETAILS = "SELECT STUDENT_ID,STUDENT_NAME,STUDENT_ADDRESS,STUDENT_MOBILE,"
			+ " STUDENT_AADHAAR_CARD,STUDENT_PASSWORD,STUDENT_EMAIL FROM ONLINE_STUDENT_REGISTRATION where admin_id=?";
	private static final String STUDENT_LOGIN_ID = "SELECT  STUDENT_ID FROM ONLINE_STUDENT_REGISTRATION WHERE STUDENT_MOBILE=? AND "
			+ " STUDENT_AADHAAR_CARD=? AND STUDENT_PASSWORD=? AND STUDENT_EMAIL=? ";
	//private static final String Student_Delete="delete from ONLINE_STUDENT_REGISTRATION where STUDENT_MOBILE =? and STUDENT_AADHAAR_CARD=? and STUDENT_EMAIL=? and ADMIN_ID=?  ";
	
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
			
			// check conn is null or not
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(ADMIN_REGISTER_INSERT);
			// set ps to string query parameter
			if (ADMIN_REGISTER_INSERT != null) {
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
				pst = con.prepareStatement(STUDENT_LOGIN);
			// set ps to string query parameter
			if (STUDENT_LOGIN != null) {
				pst.setString(1, bo.getMobile());
				pst.setString(2, bo.getAddhar_card());
				pst.setString(3, bo.getPassword());
				pst.setString(4, bo.getEmail());
				rs = pst.executeQuery();
				if (rs.next()) {
					// System.out.println("AdminRegisterDAO.login(if)");
					count = rs.getInt(1);
					// System.out.println("AdminRegisterDAO.logindgdfgdfg()" + count);
				}

			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Login Failed</h1>");
		}

		return count;

	}

	@Override
	public int updatePassword(UpdatePasswordBO bo) throws Exception {
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
				pst = con.prepareStatement(STUDENT_UPDATE_PASSWORD);
			// set ps to string query parameter
			if (STUDENT_UPDATE_PASSWORD != null) {
				pst.setString(2, bo.getMobile());
				pst.setString(3, bo.getAddhar_card());
				pst.setString(1, bo.getPassword());
				pst.setString(4, bo.getEmail());
		//		System.out.println(bo.getAddhar_card() + "\n" + bo.getEmail() + "\n" + bo.getMobile() + "\n" + bo.getPassword());

				count = pst.executeUpdate();

			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Login Failed</h1>");
		}

		return count;
	}

	@Override
	public List<ViewStudentDetailsBO> viewStudentDetails(int loginId) throws Exception {
		List<ViewStudentDetailsBO> list = new ArrayList();

		// create connection object
		Connection con = null;
		// create preparestatemnt object
		PreparedStatement pst = null;
		int count = 0;
		ResultSet rs = null;
		// create viewStudentDetailsBO
		ViewStudentDetailsBO bo = null;
		try {
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
			// create prepare statement
			pst = con.prepareStatement(VIEWSTUDENTDETAILS);
			pst.setInt(1, loginId);
		//	System.out.println(VIEWSTUDENTDETAILS);
		//	System.out.println(loginId);
			if (pst != null)
				rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					bo = new ViewStudentDetailsBO();
					bo.setId(rs.getString("STUDENT_ID"));
					bo.setName(rs.getString("STUDENT_NAME"));
					bo.setAddress(rs.getString("STUDENT_ADDRESS"));
					bo.setMobile(rs.getString("STUDENT_MOBILE"));
					bo.setAddhar_card(rs.getString("STUDENT_AADHAAR_CARD"));
					bo.setPassword(rs.getString("STUDENT_PASSWORD"));
					bo.setEmail(rs.getString("STUDENT_EMAIL"));
					list.add(bo);
				}
			} // if rs

		} catch (Exception e) {
			new IllegalArgumentException("Student Details not found. ");
		}
		return list;

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
			
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(STUDENT_LOGIN_ID);
			
			// set ps to string query parameter
			if (STUDENT_LOGIN_ID != null) {
				pst.setString(1, bo.getMobile());
				pst.setString(2, bo.getAddhar_card());
				pst.setString(3, bo.getPassword());
				pst.setString(4, bo.getEmail());
			//	System.out.println(bo.getAddhar_card()+"\n"+bo.getEmail()+"\n"+bo.getMobile()+"\n"+bo.getPassword());
				
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
		Statement st=null;
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try {
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
			// check conn is null or not
			st=con.createStatement();

			String Student_Delete="delete from ONLINE_STUDENT_REGISTRATION "
					+ "where STUDENT_MOBILE ='"+bo.getMobile()+"' and STUDENT_AADHAAR_CARD='"+bo.getAddhar_card()+"' "
							+ "and STUDENT_EMAIL='"+bo.getEmail()+"' and ADMIN_ID="+bo.getLoginId()+"  ";
			System.out.println(Student_Delete);
			count =st.executeUpdate(Student_Delete);
			/*
			 * if (con != null) // create preparestatemnt pst =
			 * con.prepareStatement(Student_Delete); System.out.println(Student_Delete); //
			 * set ps to string query parameter if (Student_Delete != null) {
			 * System.out.println("==========="); pst.setString(1, bo.getMobile());
			 * pst.setString(2, bo.getAddhar_card()); pst.setInt(4, bo.getLoginId());
			 * pst.setString(3, bo.getEmail());
			 * System.out.println("================================st "); count =
			 * pst.executeUpdate();
			 * System.out.println("================================end "); } // if
			 */		} catch (Exception e) {
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
			// Load and register jdbc driver
			//for oracle
			con= Connection_Oracle.getConnection();
			//for mysql
			//con=Connection_Mysql.getConnection();
			
			// check conn is null or not
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(STUDENT_UPDATE_PROFILE);
			// set ps to string query parameter
			if (STUDENT_UPDATE_PROFILE != null) {
		//		System.out.println("STUDENT_UPDATE_PROFILE start");
				pst.setString(1, bo.getMobile());
				pst.setString(2, bo.getAddhar_card());
				pst.setInt(4, bo.getLoginId());
				pst.setString(3, bo.getEmail());
		//		System.out.println(STUDENT_UPDATE_PROFILE);
				//System.out.println("============================");
		//		System.out.println(bo.getAddhar_card());
		//		System.out.println(bo.getEmail());
		//		System.out.println(bo.getLoginId());
		//		System.out.println(bo.getMobile());
				//System.out.println("===========================");
		//		System.out.println("STUDENT_UPDATE_PROFILE end ");
				count = pst.executeUpdate();
			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Profile Update Failed</h1>");
		}

		return count;	}

	
	
	
}
