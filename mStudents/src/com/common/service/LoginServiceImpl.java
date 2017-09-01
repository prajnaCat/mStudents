package com.common.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.LoginDao;
import com.model.StudentInfo;
import com.model.TeacherInfo;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private  LoginDao loginDao;

	

	@Override
	public StudentInfo loginStudent( String userid, String password) {
		StudentInfo student=null;
			List<StudentInfo> stulist=loginDao.loginStudent(userid,password);
			if(stulist.size()==1){
				for(StudentInfo stu:stulist){
					student=stu;
				}
			}
			return student;
	}
	public TeacherInfo loginTeacher( String userid, String password) {
		TeacherInfo teacher=null;
		List<TeacherInfo> tealist=loginDao.loginTeacher(userid,password);
		if(tealist.size()==1){
			for(TeacherInfo tea:tealist){
				teacher=tea;
			}
		}
		return teacher;
}
    
    
}
