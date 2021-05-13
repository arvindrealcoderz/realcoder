package com.realcoderz.service.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Run Junit 5 tests in Junit 4")
@SelectPackages("com.realcoderz.service.test")
@IncludePackages
	({
		"com.realcoderz.service.test.AdminServiceTest" ,
		"com.realcoderz.service.test.FacultyServiceTest",
		"com.realcoderz.service.test.ValidationTest" ,
		"com.realcoderz.service.test.StudentServiceTest",
		"com.realcoderz.service.test.AdminDAOTest",
		"com.realcoderz.service.test.FacultyDaoTest",
		"com.realcoderz.service.test.StudentRegisterDAOTest"
	})
public class IncludePackages_TestSuite_Test {
	
	
	
}