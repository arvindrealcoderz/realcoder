package com.nt.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AdminTest {

	//-------------create AdminController class objcet
		private static AdminController controller;
		@BeforeAll
		public static void setUpOnces() {
			//System.out.println("AdminControllerTest.setUpOnces()");
			controller=new AdminController();
		}
		
		@AfterAll
		public static void cleanOnces() {
			//System.out.println("AdminControllerTest.cleanOnces()");
			controller=null;
		}

}
