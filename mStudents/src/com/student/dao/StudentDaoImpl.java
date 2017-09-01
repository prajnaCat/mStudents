package com.student.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.CourseInfo;
import com.model.StudentInfo;
import com.model.Submit;
import com.model.Task;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void queryStuSubmit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStuSubmit(Submit sub) {
		this.hibernateTemplate.save(sub);
	}
	
	@Override
	public void updateStuSubmit(Submit sub) {
		this.hibernateTemplate.update(sub);
	}

	@Override
	public List<Task> queryTaskByTaskid(String taskId) {
		String hql="from Task t where t.taskId=? and t.isvalue=?";
		List<Task> talist=(List<Task>)this.hibernateTemplate.find(hql, new String[]{taskId,"1"});
		return talist;
	}

	@Override
	public List<CourseInfo> queryCourseId(String courseId) {
		String hql="from CourseInfo c where c.courseId=? and c.isvalue=?";
		List<CourseInfo> clist=(List<CourseInfo>)this.hibernateTemplate.find(hql, new String[]{courseId,"1"});
		return clist;
	}

	@Override
	public List<Submit> querySubmitBytaskidAndstuid(String taskid, String stuid) {
		String hql="from Submit s where s.taskId=? and s.stuId=? and  s.isvalue=?";
		List<Submit> slist=(List<Submit>)this.hibernateTemplate.find(hql, new String[]{taskid,stuid,"1"});
		return slist;
	}

}
