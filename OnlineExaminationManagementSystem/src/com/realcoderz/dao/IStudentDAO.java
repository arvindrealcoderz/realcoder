package com.realcoderz.dao;

import java.util.List;

import com.realcoderz.bo.LoginBO;
import com.realcoderz.bo.RegisterBO;
import com.realcoderz.bo.UpdatePasswordBO;
import com.realcoderz.bo.ViewStudentDetailsBO;

public interface IStudentDAO {

	public int insert(RegisterBO dto) throws Exception;
	public int login(LoginBO dto) throws Exception;
	public int updatePassword(UpdatePasswordBO bo) throws Exception;
	public int updateProfile(LoginBO bo) throws Exception;
	public List<ViewStudentDetailsBO> viewStudentDetails(int loginId) throws Exception;
	public int loginID(LoginBO bo) throws Exception;
	public int delete(LoginBO bo) throws Exception;
	
}
