package com.realcoderz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;

public class AdminRegisterDAO implements IAdminDAO {

	private static final String ADMIN_REGISTER_INSERT = "insert into online_admin_registration "
			+ "(ADMIN_ID,admin_name,admin_address,admin_mobile,admin_aadhaar_card,admin_password,admin_email) "
			+ "values (ADMIN_ID_SEQ.nextval,?,?,?,?,?,?)";

	private static final String ADMIN_LOGIN = "select count(*) , admin_id from online_admin_registration where admin_mobile=? and "
			+ " admin_aadhaar_card=? and admin_password=? and admin_email=? group by admin_id";

	private static final String ADMIN_LOGIN_ID = "select  admin_id from online_admin_registration where admin_mobile=? and "
			+ " admin_aadhaar_card=? and admin_password=? and admin_email=? ";

	private static final String ADMIN_Update_Password = "update online_admin_registration set admin_password=? where admin_mobile=? and "
			+ " admin_aadhaar_card=?  and admin_email=?";

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
				;
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
			
			// check conn is null or not
			if (con != null)
				// create preparestatemnt
				pst = con.prepareStatement(ADMIN_LOGIN);
			
			// set ps to string query parameter
			if (ADMIN_LOGIN != null) {
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
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Login Failed</h1>");
		}

		return count;
	}

	@Override
	public int loginID(LoginBO bo) throws Exception {
	//
		
		System.out.println("AdminRegisterDAO.login()");
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
				pst = con.prepareStatement(ADMIN_LOGIN_ID);
			
			// set ps to string query parameter
			if (ADMIN_LOGIN_ID != null) {
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
	public int updatePassword(UpdatePasswordBO bo) throws Exception {
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
				pst = con.prepareStatement(ADMIN_Update_Password);
			// set ps to string query parameter
			if (ADMIN_Update_Password != null) {
				pst.setString(2, bo.getMobile());
				pst.setString(3, bo.getAddhar_card());
				pst.setString(1, bo.getPassword());
				pst.setString(4, bo.getEmail());
			//	System.out.println(bo.getAddhar_card()+"\n"+bo.getEmail()+"\n"+bo.getMobile()+"\n"+bo.getPassword());
				
				count = pst.executeUpdate();
				
			} // if
		} catch (Exception e) {
			e.printStackTrace();
			new IllegalArgumentException("<h1style='color:red;text-align:center'>Login Failed</h1>");
		}
		

		return count;
	}

	
}
