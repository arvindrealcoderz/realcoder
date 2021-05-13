package com.arvind.realcoderz;
import org.apache.log4j.Appender;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Tester {

	//create logger  class object
	private static Logger log=Logger.getLogger(Tester.class);
	public static void main(String[] args) {
		//print message
		log.info("From info");
		log.debug("from debug");
		log.fatal("from fatal");
		log.error("from error");
		log.warn("from warn");
		
		
		
		
	}
}
