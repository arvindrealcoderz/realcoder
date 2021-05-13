package com.realcoderz.service;

import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.vo.RegisterVO;

public interface IFacultyService {
	public String facultyRegister(RegisterDTO dto) throws Exception;
	public String facultyLogin(LoginDTO dto) throws Exception;
	public int facultyLoginID(LoginDTO dto) throws Exception;
	public int facultyDelete(LoginDTO dto) throws Exception;
	public String studentProfileUpdate(LoginDTO dto) throws Exception;

}
