package com.common.action;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.common.service.LoginService;
import com.model.StudentInfo;
import com.model.TeacherInfo;
import com.tool.BaseAction;

@Controller("loginAction")
public class LoginAction extends BaseAction {
	@Autowired
    private  LoginService loginService ;
	
	private static final long serialVersionUID = 1L;
	

	public String userLogin(){
		String isok="failed";
		System.out.println("登录功能");
		try{
			String role=this.getRequest().getParameter("role");
			String userid=this.getRequest().getParameter("userid");
			String password=this.getRequest().getParameter("password");
			if("student".equals(role)){
				StudentInfo student=loginService.loginStudent(userid, password);
				if(student!=null){
					isok="success";
					HttpSession session = super.getSession();
					// 用户信息存入session
					session.setAttribute("student", student);
					session.setAttribute("role", "student");
					// 设置session超时时间（秒）
					session.setMaxInactiveInterval(1500);
				}
			}
			if("teacher".equals(role)){
				TeacherInfo teacher=loginService.loginTeacher(userid, password);
				if(teacher!=null){
					isok="success";
					HttpSession session = super.getSession();
					// 用户信息存入session
					session.setAttribute("teacher", teacher);
					session.setAttribute("role", "teacher");
					// 设置session超时时间（秒）
					session.setMaxInactiveInterval(1500);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return isok;
	}
	
}
