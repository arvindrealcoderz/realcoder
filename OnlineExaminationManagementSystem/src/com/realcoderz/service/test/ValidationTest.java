package com.realcoderz.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.realcoderz.service.StudentService;
import com.realcoderz.validation.Validation;

public class ValidationTest {
	private static  Validation validation;
	@Test
	public void validateTest(){
		List<String> list = new ArrayList<String>();


		/*
		 * Assertions.assertThrows(IndexOutOfBoundsException.class,()->{
		 * validation.validate(list);}, "Array index out of bound exception "
		 * 
		 * );
		 */
		Assertions.assertThrows(NullPointerException.class,()->{
			validation.validate(list);},
				"Null pointer Exception "

				);

	}

}
