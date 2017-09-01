package com.common.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.StudentInfo;
import com.model.TeacherInfo;


@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Resource
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	@Override
	public List<StudentInfo> loginStudent(String userId,String password) {
		String hql= "from StudentInfo s where s.stuId=? and s.stuPassword=?";
		@SuppressWarnings("unchecked")
		List<StudentInfo>stulist=(List<StudentInfo>) this.hibernateTemplate.find(hql, new String[]{userId,password});
		return stulist;
	}

	@Override
	public List<TeacherInfo> loginTeacher(String userId,String password) {
		String hql= "from TeacherInfo t where t.teaId=? and t.teaPassword=?";
		@SuppressWarnings("unchecked")
		List<TeacherInfo>tealist=(List<TeacherInfo>) this.hibernateTemplate.find(hql, new String[]{userId,password});
		return tealist;
	}




	

}
