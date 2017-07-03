package com.song.dev.service;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.song.dev.model.UserInfo;

@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:config/*.xml"})
public class UserServiceTest extends TestCase{
    @Resource(name="userService")  
    private IUserService userService;  
  
    @Before  
    public void setUp() throws Exception{
    	
    }  
  
    @Test  
    public void test(){
        try{
        	UserInfo u = (UserInfo) userService.getUserById("101");
        	u.setId(null);
        	userService.createUser();
        	System.out.println("-----------------------------");
        	System.out.println(u.getUserName());
        }catch (Exception e){  
            fail("Test failed!");
        }  
    }  
  
    @Ignore  
    public void testOtherSpringObject(){
        fail("Not yet implemented");  
    }  
}  
