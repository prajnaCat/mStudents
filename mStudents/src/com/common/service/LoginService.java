package com.common.service;

import com.model.StudentInfo;
import com.model.TeacherInfo;


public interface LoginService {
	
	/**
	 * 登录验证
	 * @param password 
	 * @param userid 
	 * @param role 
	 */
public StudentInfo  loginStudent( String userid, String password);
public TeacherInfo  loginTeacher( String userid, String password);
}
