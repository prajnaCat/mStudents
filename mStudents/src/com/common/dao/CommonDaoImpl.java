package com.common.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.StuDocInfo;
import com.model.StudentInfo;
import com.model.Submit;
import com.model.Task;
import com.model.TeaDocInfo;
import com.tool.Page;


@Repository("commonDao")
public class CommonDaoImpl implements CommonDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public   List findByPageBean( final int pageIndex,  final int pageSize,
			 final String hql ) throws Exception {
			List list = null;
			try {
			list =  (List) this.hibernateTemplate.execute(
                new HibernateCallback() {
                        public Object doInHibernate(Session session)
                              throws HibernateException {
                        	Query query = session.createQuery(hql);
                             		  query.setFirstResult((pageIndex-1)*pageSize);
                                       query.setMaxResults(pageSize);
                                       return query.list();
                               }
                }); 
			} catch (Exception e) {
			throw e;
			}
			return list;
			}

	@Override
	public List<Submit> querySubDetailThress(String taskId,
			String classId, Page page) throws Exception {
		String hql="";
		if(classId!=null&&classId.length()>0){
			 hql= "from Submit sb where sb.taskId='"+taskId+"' and sb.classId='"+classId+"' and sb.isvalue=1" ;
		}else{
			 hql= "from Submit sb where sb.taskId='"+taskId+"' and sb.isvalue=1" ;
		}
	    List<Submit>sblist=(List<Submit>)this.findByPageBean(page.getPageIndex(), page.getPageSize(), hql);
		return sblist;
	}

	@Override
	public StudentInfo queryStudentBystuid(String stuid) {
		StudentInfo  stu=this.hibernateTemplate.get(StudentInfo.class, stuid);
		return stu;
	}
	@Override
	public Task queryTaskBytaskid(String taskid) {
		Task t=this.hibernateTemplate.get(Task.class, taskid);
		return t;
	}

	@Override
	public StuDocInfo queryStuDocBydocid(String stuDocId) {
		StuDocInfo sd=this.hibernateTemplate.get(StuDocInfo.class, stuDocId);
		return sd;
	}

	@Override
	public List<Submit> querySubmitBysubid(String subId) {
		String hql="from Submit s where s.submitId=? and s.isvalue=?";
		List<Submit> sublist=(List<Submit>)this.hibernateTemplate.find(hql, new String[]{subId,"1"});
		return sublist;
	}

	@Override
	public void saveSubmit(Submit ss) {
		this.hibernateTemplate.saveOrUpdate(ss);
	}

	@Override
	public List<Submit> querySubDetailByStuIdAndTaskid(String stuId,
			String taskId) throws Exception {
		String hql= "from Submit sb where sb.stuId=? and sb.taskId=? and sb.isvalue=1" ;
	    List<Submit>sblist=(List<Submit>)this.hibernateTemplate.find(hql, new String[]{stuId,taskId});
		return sblist;
	}

	@Override
	public List<Submit> querySubDetailByStuId(String stuId, Page page) throws Exception {
		String hql= "from Submit sb where sb.stuId='"+stuId+"'  and sb.isvalue=1" ;
	    List<Submit>sblist=(List<Submit>)this.findByPageBean(page.getPageIndex(), page.getPageSize(), hql);
		return sblist;
	}

	/**
	 * 根据课程ID、专业ID
	 * 获取task的相关信息
	 */
	@Override
	public List<Task> queryTaskByCouidAndZyid(String courseId, String zhuanyeId) {
		String hql= "from Task t where t.courseId=? and t.zhuanyeId=? and  t.isvalue=?" ;
	    List<Task>tasklist=(List<Task>)this.hibernateTemplate.find(hql, new String[]{courseId,zhuanyeId,"1"});
		return tasklist;
	}
	
	/**
	 * 根据班级ID
	 * 获取学生信息
	 * @throws Exception 
	 */
	@Override
	public List<StudentInfo> queryStudentsByclassid(String classId,Page page) throws Exception {
		String hql= "from StudentInfo s where s.classId=? and  s.isvalue=1" ;
	    List<StudentInfo>stulist=(List<StudentInfo>)this.hibernateTemplate.find(hql,new String[]{classId});
		return stulist;
	}

	/**
	 * 根据学生ID、课程ID
	 * 分页查询相关信息
	 * @throws Exception 
	 */
	@Override
	public List<Submit> querySubmitByStuidAndCouid(String stuId, String courseId) {
		String hql= "from Submit sb where sb.stuId=? and sb.courseId=? and sb.isvalue=?" ;
	    List<Submit>sblist=(List<Submit>)this.hibernateTemplate.find(hql,new String[]{stuId,courseId,"1"});
		return sblist;
	}

	@Override
	public List<Submit> querySubmitByStuidAndCouidAndTistatus(String stuId,String courseId) {
		String hql= "from Submit sb where sb.stuId=? and sb.courseId=? and sb.tjstatus=? and  sb.isvalue=?" ;
	    List<Submit>sblist=(List<Submit>)this.hibernateTemplate.find(hql,new String[]{stuId,courseId,"22","1"});
		return sblist;
	}

	/**
	 * 保存Result实体类
	 */
	@Override
	public void saveResult(ResultInfo resvo) {
		this.hibernateTemplate.saveOrUpdate(resvo);
	}
	
	@Override
	public List<ResultInfo> queryResultBycouidAndclassid(String courseId,
			String classId, Page page) throws Exception {
		String hql="from ResultInfo r where r.courseId="+courseId+" and r.classId="+classId+" and isvalue='1' ";
		List<ResultInfo>list=(List<ResultInfo>)this.findByPageBean(page.getPageIndex(), page.getPageSize(), hql);
		return list;
	}

	@Override
	public   List<ResultInfo> queryResultByResid(String resId) {
		String hql= "from ResultInfo r where r.resId=?  and  r.isvalue=?" ;
	    List<ResultInfo>list=(List<ResultInfo>)this.hibernateTemplate.find(hql,new String[]{resId,"1"});
		return list;
	}

	@Override
	public void updateResInfo(ResultInfo res) {
		this.hibernateTemplate.delete(res);
		this.hibernateTemplate.save(res);
		
	}

	@Override
	public TeaDocInfo queryTeaDocById(String teadocid) {
		TeaDocInfo  td=this.hibernateTemplate.get(TeaDocInfo.class, teadocid);
		return td;
	}

	@Override
	public List<Task> queryTaskBycourseid(String courseId, String zyid,
			Page page) throws Exception {
		String hql="";
		if(courseId!=null&&courseId.length()>0){
			 hql="from Task t where  t.courseId='"+courseId+"' and t.zhuanyeId='"+zyid+"' and t.isvalue= '1' ";
		}else{
			hql="from Task t  where t.zhuanyeId='"+zyid+"'and t.isvalue= '1'";
		}
	    List<Task>list=(List<Task>)this.findByPageBean(page.getPageIndex(), page.getPageSize(), hql);
		return list;
	}

	@Override
	public CourseInfo queryCourseInfoBycoid(String courseId) {
		CourseInfo cf=this.hibernateTemplate.get(CourseInfo.class, courseId);
		return cf;
	}

	@Override
	public List<ResultInfo> queryPageResultByStuId(String stuid, Page page) throws Exception {
		String hql="from ResultInfo rf where rf.stuId="+stuid+" and isvalue='1' ";
		List<ResultInfo> reslist=this.findByPageBean(page.getPageIndex(),page.getPageSize(), hql);
		return reslist;
	}

	@Override
	public List<ResultInfo> queryResultByStuidAndCourseid(String stuId,
			String courseId) {
		String hql="from ResultInfo rs where rs.stuId=? and rs.courseId=? and rs.isvalue=?";
		List<ResultInfo> reslist=(List<ResultInfo>) this.hibernateTemplate.find(hql, new String[]{stuId,courseId,"1"});
		return reslist;
	}
	
	
}
