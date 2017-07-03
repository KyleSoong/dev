package com.song.dev;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
	final static Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	
	public static void main(String [] args) throws InterruptedException{
		for(int i = 10000; i>0; i++){
			logger.trace("现在的时间是{}",new Date().toString());
			logger.debug("现在的时间是{}",new Date().toString());
			logger.info("现在的时间是{}",new Date().toString());
			logger.warn("现在的时间是{}",new Date().toString());
			logger.error("现在的时间是{}",new Date().toString());
			//Thread.currentThread().sleep(1000);
		}
	}
}
