package com.teacher.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.ClassInfo;
import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.StudentInfo;
import com.model.Task;
import com.model.ZhuanyeInfo;

@Repository("teacherDao")
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<CourseInfo> queryCourse(String teaid) {
		String hql= "from CourseInfo c where c.teaId=? and  c.isvalue=?" ;
	    List<CourseInfo>clist=(List<CourseInfo>)this.hibernateTemplate.find(hql, new String[]{teaid,"1"}); 
		return clist;
	}

	@Override
	public List<ZhuanyeInfo> queryZhuanYe() {
		String hql= "from ZhuanyeInfo zy where zy.isvalue=?" ;
	    List<ZhuanyeInfo>zylist=(List<ZhuanyeInfo>)this.hibernateTemplate.find(hql, new String[]{"1"}); 
		return zylist;
	}

	@Override
	public void saveFaBuTask(Task task) {
		this.hibernateTemplate.saveOrUpdate(task);
	}
	
	/**
	 * 根据学生的ID获取学生信息
	 */
	public List<StudentInfo> queryStudentBystuId(String stuid){
		String hql= "from StudentInfo stu where stu.isvalue=? and stu.stuId=?" ;
	    List<StudentInfo>stulist=(List<StudentInfo>)this.hibernateTemplate.find(hql, new String[]{"1",stuid}); 
		return stulist;
	}

	@Override
	public List<Task> queryTask() {
		    List<Task>tasklist=(List<Task>)this.hibernateTemplate.find("from Task");
			return tasklist;
		
	}

/**
 * 根据专业ID获取作业表信息
 */
	@Override
	public List<Task> queryTaskByZyid(String zyid) {
		String hql= "from Task tk where tk.isvalue=? and tk.zhuanyeId=?" ;
	    List<Task>tasklist=(List<Task>)this.hibernateTemplate.find(hql, new String[]{"1",zyid}); 
		return tasklist;
	}

	/**
	 * 根据课程ID获取作业信息
	 */

	@Override
	public List<Task> queryTaskById(String courseId) {
		String hql= "from Task tk where tk.isvalue=? and tk.courseId=?" ;
	    List<Task>tasklist=(List<Task>)this.hibernateTemplate.find(hql, new String[]{"1",courseId}); 
		return tasklist;
	}
	
	
	
/**
 * 根据课程ID获取课程表信息
 */
	@Override
	public List<CourseInfo> queryCourseBycourseid(String courseid) {
		String hql="from CourseInfo co where co.courseId=? and co.isvalue=?";
		List<CourseInfo> colist=(List<CourseInfo>) this.hibernateTemplate.find(hql,new String[]{courseid,"1"} );
		return colist;
	}

@Override
public List<ZhuanyeInfo> queryZhuanyeByStuid(String zyid) {
	String hql="from ZhuanyeInfo zy where zy.zhuanyeId=? and zy.isvalue=?";
	List<ZhuanyeInfo> zylist=(List<ZhuanyeInfo>) this.hibernateTemplate.find(hql,new String[]{zyid,"1"} );
	return zylist;
}

@Override
public List<Task> queryTaskByzhuanyeId(String zyid) {
	String hql="from Task ta where ta.zhuanyeId=? and ta.isvalue=?";
	List<Task> talist=(List<Task>) this.hibernateTemplate.find(hql,new String[]{zyid,"1"} );
	return talist;
}

@Override
public List<Task> queryTaskByTeaid(String teaid) {
	String hql="from Task ta where ta.teaId=? and ta.isvalue=?";
	List<Task> talist=(List<Task>) this.hibernateTemplate.find(hql,new String[]{teaid,"1"} );
	return talist;
}

@Override
public List<Task> queryZyidByTaskid(String taskid) {
	String hql="from Task ta where ta.taskId=? and ta.isvalue=?";
	List<Task> talist=(List<Task>) this.hibernateTemplate.find(hql,new String[]{taskid,"1"} );
	return talist;
}

@Override
public List<ClassInfo> queryClassByZyid(String zyid) {
	String hql="from ClassInfo cla where cla.zhuanyeId=? and cla.isvalue=?";
	List<ClassInfo> classlist=(List<ClassInfo>) this.hibernateTemplate.find(hql,new String[]{zyid,"1"} );
	return classlist;
}

@Override
public List<Task> queryCourseIdByTeaid(String teaid) {
	String hql="from Task t where t.teaId=? and t.isvalue=?";
	List<Task> tasklist=(List<Task>) this.hibernateTemplate.find(hql,new String[]{teaid,"1"} );
	return tasklist;
}

@Override
public List<Task> queryZyByCourseidAndTeaid(String courseid, String teaid) {
	String hql="from Task t where t.teaId=? and t.courseId=? and t.isvalue=?";
	List<Task> tasklist=(List<Task>) this.hibernateTemplate.find(hql,new String[]{teaid,courseid,"1"} );
	return tasklist;
}

@Override
public List<ZhuanyeInfo> queryZyByzyid(String zhuanyeId) {
	String hql="from ZhuanyeInfo zy where zy.zhuanyeId=? and zy.isvalue=?";
	List<ZhuanyeInfo> tasklist=(List<ZhuanyeInfo>) this.hibernateTemplate.find(hql,new String[]{zhuanyeId,"1"} );
	return tasklist;
}

@Override
public   List<ResultInfo> queryResultByResid(String resId) {
	String hql= "from ResultInfo r where r.resId=?  and  r.isvalue=?" ;
    List<ResultInfo>list=(List<ResultInfo>)this.hibernateTemplate.find(hql,new String[]{resId,"1"});
	return list;
}


/**
 * 保存Result实体类
 */
@Override
public void saveResult(ResultInfo resvo) {
	this.hibernateTemplate.saveOrUpdate(resvo);
}

@Override
public List<Task> queryTaskByCouidAndZyid(String courseid, String zyid) {
	String hql="from Task t where t.courseId=? and t.zhuanyeId=? and t.isvalue='1'  ";
	List<Task>list=(List<Task>)this.hibernateTemplate.find(hql,new String[]{courseid,zyid});
	return list;
}


}
