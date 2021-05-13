package com.realcoderz.service;

import java.util.List;
import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.dto.ViewStudentDetailsDTO;

public interface IStudentService {
	public String studentRegister(RegisterDTO dto) throws Exception;
	public String studentLogin(LoginDTO dto) throws Exception;
	public String studentPasswordUpdate(LoginUpdateDTO dto) throws Exception;
	public String studentProfileUpdate(LoginDTO dto) throws Exception;
	public List<ViewStudentDetailsDTO> viewStudentDetails(int loginId) throws Exception;
	public int studentLoginID(LoginDTO dto) throws Exception;
	public int facultyDelete(LoginDTO dto) throws Exception;
	
	
	

}
