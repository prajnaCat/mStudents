package com.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.dao.LoginDaoImpl;
import com.common.service.LoginService;
import com.common.service.LoginServiceImpl;

public class TestSpring {
	
	ApplicationContext ac;

	@Before
	public void init(){
		this.ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
	}
	
	@Test
	public void test1(){
		
		/*LoginDaoImpl dao = ac.getBean("loginDao",LoginDaoImpl.class);
		System.out.println(dao);*/
		LoginServiceImpl s = ac.getBean("loginService",LoginServiceImpl.class);
		System.out.println(s);
	}
}
