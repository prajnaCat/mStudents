package com.student.dao;

import java.util.Date;
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

import com.model.ClassInfo;
import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.Submit;
import com.model.Task;
import com.model.ZhuanyeInfo;
import com.tool.ToolUtil;


@Repository("dataViewDao")
public class DataViewDaoImpl implements DataViewDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Resource
	private SessionFactory sessionFactory;

	public   List findByPageBean( final int Size,
			 final String hql ) throws Exception {
			List list = null;
			try {
			list =  (List) this.hibernateTemplate.execute(
               new HibernateCallback() {
                       public Object doInHibernate(Session session)
                             throws HibernateException {
                       	Query query = session.createQuery(hql);
                            		  query.setFirstResult(0);
                                      query.setMaxResults(Size);
                                      return query.list();
                              }
               }); 
			} catch (Exception e) {
			throw e;
			}
			return list;
			}
	
	@Override
	public List<Task> getAllFaBuDataView() {
		String hql="from Task t ";
		List<Task> tlist=(List<Task>) this.hibernateTemplate.find(hql, null);
		return tlist;
	}

	@Override
	public List<Task> getTenthTask() throws Exception {
		String hql="from Task t order by t.fabuTime";
		List<Task> tlist=(List<Task>) this.findByPageBean(10, hql);
		return tlist;
	}

	@Override
	public ZhuanyeInfo getZhuanyeInfoById(String zhuanyeId) {
		ZhuanyeInfo zy=this.hibernateTemplate.get(ZhuanyeInfo.class, zhuanyeId);
		return zy;
	}

	@Override
	public List<Submit> querySubmitByTaskId(String taskId) {
		String hql="from Submit s where s.taskId=? and s.isvalue=?";
		List<Submit> sublist=(List<Submit>) this.hibernateTemplate.find(hql, new String[]{taskId,"1"});
		return sublist;
	}

	@Override
	public List<ClassInfo> queryClassInfoByZyid(String zhuanyeId) {
		String hql="from ClassInfo c where c.zhuanyeId=?";
		List<ClassInfo> clalist=(List<ClassInfo>) this.hibernateTemplate.find(hql, new String[]{zhuanyeId});
		return clalist;
	}

	@Override
	public List<ResultInfo> queryAllResultInfo() {
		String hql="from ResultInfo r where r.pfstatus=? ";
		List<ResultInfo> reslist=(List<ResultInfo>) this.hibernateTemplate.find(hql, new String[]{"22"});
		return reslist;
	}

	@Override
	public List<Submit> getAllSubmitInfo() {
		String hql="from Submit ";
		List<Submit> sublist=(List<Submit>) this.hibernateTemplate.find(hql);
		return sublist;
	}

	@Override
	public List<Submit> getSubmitByStuidAndCourseid(String stuid,
			String courseid) {
		String hql="from Submit s where s.stuId="+stuid+" and s.courseId="+courseid+"";
		List<Submit> sublist=(List<Submit>) this.hibernateTemplate.find(hql);
		return sublist;
	}

	@Override
	public List<Submit> getTiJiaoDataViewByStuid(String stuid) {
		String hql="from Submit s where s.stuId="+stuid+"";
		List<Submit> sublist=(List<Submit>) this.hibernateTemplate.find(hql);
		return sublist;
	}

	@Override
	public List<ResultInfo> queryResultInfoByStuid(String stuid) {
		String hql="from ResultInfo r where r.stuId="+stuid+"";
		List<ResultInfo> reslist=(List<ResultInfo>) this.hibernateTemplate.find(hql);
		return reslist;
	}

	@Override
	public List<ResultInfo> queryResultInfoByStuidAndPfstatus(String stuid) {
		String pfstatus="22";
		String hql="from ResultInfo r where r.stuId="+stuid+" and r.pfstatus="+pfstatus+"";
		List<ResultInfo> reslist=(List<ResultInfo>) this.hibernateTemplate.find(hql);
		return reslist;
	}

	@Override
	public List<Task> queryTaskByTeaid(String teaid) {
		String hql="from Task t where t.teaId="+teaid+"";
		List<Task> tasklist=(List<Task>) this.hibernateTemplate.find(hql);
		return tasklist;
	}

	@Override
	public List<Task> queryTaskByCourseid(String courseId) {
		String hql="from Task t where t.courseId="+courseId+"";
		List<Task> tasklist=(List<Task>) this.hibernateTemplate.find(hql);
		return tasklist;
	}

	@Override
	public CourseInfo queryCourseByid(String courseId) {
		CourseInfo cou=this.hibernateTemplate.get(CourseInfo.class, courseId);
		return cou;
	}
	
	@Override
	public List<Task> getTenthTaskByTeaid(String teaid) throws Exception {
		String hql="from Task t where t.teaId="+teaid+" order by t.fabuTime";
		List<Task> tlist=(List<Task>) this.findByPageBean(10, hql);
		return tlist;
	}

	@Override
	public List<Submit> getSubmitInfoByTaskid(String taskId) {
		String hql="from Submit s where s.taskId='"+taskId+"'";
		List<Submit> sublist=(List<Submit>) this.hibernateTemplate.find(hql);
		return sublist;
	}

	@Override
	public List<ResultInfo> queryResultInfoByTime(String stuid,String start, String last) {
		String hql="from ResultInfo r where r.stuId="+stuid+" and r.sctime>="+ToolUtil.toDate(start,"%Y-%m-%d %H:%i:%s")+" and r.sctime<="+ToolUtil.toDate(last,"%Y-%m-%d %H:%i:%s")+"";
		List<ResultInfo> reslist=(List<ResultInfo>) this.hibernateTemplate.find(hql);
		return reslist;
	}

}
