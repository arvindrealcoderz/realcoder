package com.realcoderz.service;

import com.realcoderz.dto.LoginDTO;
import com.realcoderz.dto.LoginUpdateDTO;
import com.realcoderz.dto.RegisterDTO;
import com.realcoderz.vo.RegisterVO;

public interface IAdminService {
	public String adminRegister(RegisterDTO dto) throws Exception;
	public String adminLogin(LoginDTO dto) throws Exception;
	public int adminLoginID(LoginDTO dto) throws Exception;
	public String adminUpdate(LoginUpdateDTO dto) throws Exception;

}
