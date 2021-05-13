package com.realcoderz.dao;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;

public interface IFacultyDAO {

	public int insert(RegisterBO dto) throws Exception;

	public int login(LoginBO dto) throws Exception;	
	public int delete(LoginBO dto) throws Exception;	
	public int loginID(LoginBO bo) throws Exception ;public int updateProfile(LoginBO bo) throws Exception;

}
