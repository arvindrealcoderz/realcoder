package com.realcoderz.dao;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;

public interface IAdminDAO {

	
	public int insert(RegisterBO bo) throws Exception;
	public int login(LoginBO bo) throws Exception;
	public int loginID(LoginBO bo) throws Exception;
	public int updatePassword(UpdatePasswordBO bo) throws Exception;
}
