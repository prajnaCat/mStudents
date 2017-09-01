package com.teacher.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ClassInfo;
import com.model.CourseInfo;
import com.model.ResultInfo;
import com.model.StudentInfo;
import com.model.Task;
import com.model.ZhuanyeInfo;
import com.teacher.dao.TeacherDao;
import com.tool.StringUtils;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public ArrayList queryCourse(String teaid) {
		List <CourseInfo> coulist=teacherDao.queryCourse(teaid);
		ArrayList resultlist = new ArrayList();
		if (coulist.size() > 0) {
			for (int i = 0; i < coulist.size(); i++) {
				resultlist.add(i, "{code:'" + coulist.get(i).getCourseId() + "',value:'" + coulist.get(i).getName() + "'}");
			}
		}
		return resultlist;
	}
	
	public ArrayList queryZhuanYe() {
		List <ZhuanyeInfo> zylist=teacherDao.queryZhuanYe();
		ArrayList resultlist = new ArrayList();
		if (zylist.size() > 0) {
			for (int i = 0; i < zylist.size(); i++) {
				resultlist.add(i, "{code:'" + zylist.get(i).getZhuanyeId() + "',value:'" + zylist.get(i).getZhuanyeName() + "'}");
			}
		}
		return resultlist;
	}

	@Override
	public void saveFaBuTask(Task task) {
		String taskid = StringUtils.getId("t");
		task.setTaskId(taskid);	
		task.setIsvalue("1");
		teacherDao.saveFaBuTask(task);
	}
	/**
	 * 根据课程ID获取作业表信息
	 */
	@Override
	public ArrayList queryTaskById(String courseId) {
		List <Task> tasklist=teacherDao.queryTaskById(courseId);
		ArrayList resultlist = new ArrayList();
		if (tasklist.size() > 0) {
			for (int i = 0; i < tasklist.size(); i++) {
				resultlist.add(i, "{code:'" + tasklist.get(i).getTaskId() + "',value:'" + tasklist.get(i).getTaskname() + "'}");
			}
		}
		return resultlist;
	}

	/**
	 * 学生提交任务时，根据学生ID获取学生的课程
	 * @return
	 */
	@Override
	public ArrayList queryCourseByStuid(String stuid) {
		List<StudentInfo> stulist=teacherDao.queryStudentBystuId(stuid);
		
		String zyid=new String();
		for(StudentInfo stu:stulist){
			zyid=stu.getZhuanyeId();
		}
		List <Task> tasklist=teacherDao.queryTaskByZyid(zyid);
		for  ( int  i  =   0 ; i  <  tasklist.size()  -   1 ; i ++ )   { 
		    for  ( int  j  =  tasklist.size()  -   1 ; j  >  i; j -- )   { 
				if(tasklist.get(i).getCourseId().equals(tasklist.get(j).getCourseId())){
					tasklist.remove(j);
				}
			}
		}
		ArrayList resultlist = new ArrayList();
		if (tasklist.size() > 0) {
			for (int i = 0; i < tasklist.size(); i++) {
				List<CourseInfo> coulist=teacherDao.queryCourseBycourseid(tasklist.get(i).getCourseId());
				for(CourseInfo cou:coulist){
					resultlist.add(i, "{code:'" +cou.getCourseId() + "',value:'" +cou.getName()+ "'}");
				}
				
			}
		}
		
		return resultlist;
	}

	@Override
	public ArrayList queryZhuanyeByStuid(String stuid) {
List<StudentInfo> stulist=teacherDao.queryStudentBystuId(stuid);
		
		String zyid=new String();
		for(StudentInfo stu:stulist){
			zyid=stu.getZhuanyeId();
		}
		List<ZhuanyeInfo> zylist=teacherDao.queryZhuanyeByStuid(zyid);
		ArrayList resultlist = new ArrayList();
		for (int i = 0; i < zylist.size(); i++) {
					resultlist.add(i, "{code:'" + zylist.get(i).getZhuanyeId()+ "',value:'" +zylist.get(i).getZhuanyeName()+ "'}");
		}
		return resultlist;
	}

	@Override
	public ArrayList queryTaskByzhuanyeId(String zyid) {
		List <Task> tasklist=teacherDao.queryTaskByzhuanyeId(zyid);
		ArrayList resultlist = new ArrayList();
		if (tasklist.size() > 0) {
			for (int i = 0; i < tasklist.size(); i++) {
				resultlist.add(i, "{code:'" + tasklist.get(i).getTaskId() + "',value:'" + tasklist.get(i).getTaskname() + "'}");
			}
		}
		return resultlist;
	}

	@Override
	public ArrayList queryTaskByTeaid(String teaid) {
		List <Task> tasklist=teacherDao.queryTaskByTeaid(teaid);
		ArrayList resultlist = new ArrayList();
		if (tasklist.size() > 0) {
			for (int i = 0; i < tasklist.size(); i++) {
				resultlist.add(i, "{code:'" + tasklist.get(i).getTaskId() + "',value:'" + tasklist.get(i).getTaskname() + "'}");
			}
		}
		return resultlist;
	}

	@Override
	public ArrayList queryClassBytaskid(String taskid) {
		List <Task> tasklist=teacherDao.queryZyidByTaskid(taskid);
		String zyid="";
		for(Task ta:tasklist){
			zyid=ta.getZhuanyeId();
		}
		List <ClassInfo> classlist=teacherDao.queryClassByZyid(zyid);
		ArrayList resultlist = new ArrayList();
		if (classlist.size() > 0) {
			for (int i = 0; i < classlist.size(); i++) {
				resultlist.add(i, "{code:'" + classlist.get(i).getClassId()+ "',value:'" + classlist.get(i).getClassId()+"班" + "'}");
			}
		}
		return resultlist;
	}

	@Override
	public ArrayList queryCourseByTeaid(String teaid) {
		List<Task> tasklist=teacherDao.queryCourseIdByTeaid(teaid);
		for  ( int  i  =   0 ; i  <  tasklist.size()  -   1 ; i ++ )   { 
		    for  ( int  j  =  tasklist.size()  -   1 ; j  >  i; j -- )   { 
				if(tasklist.get(i).getCourseId().equals(tasklist.get(j).getCourseId())){
					tasklist.remove(j);
				}
			}
		}
		ArrayList resultlist = new ArrayList();
		if (tasklist.size() > 0) {
			for (int i = 0; i < tasklist.size(); i++) {
				List<CourseInfo> coulist=teacherDao.queryCourseBycourseid(tasklist.get(i).getCourseId());
				for(CourseInfo cou:coulist){
					resultlist.add(i, "{code:'" +cou.getCourseId() + "',value:'" +cou.getName()+ "'}");
				}
			}
		}
		return resultlist;
	}

	@Override
	public ArrayList queryZyByCourseidAndTeaid(String courseid, String teaid) {
		List<Task> tasklist=teacherDao.queryZyByCourseidAndTeaid(courseid,teaid);
		for  ( int  i  =   0 ; i  <  tasklist.size()  -   1 ; i ++ )   { 
		    for  ( int  j  =  tasklist.size()  -   1 ; j  >  i; j -- )   { 
				if(tasklist.get(i).getZhuanyeId().equals(tasklist.get(j).getZhuanyeId())){
					tasklist.remove(j);
				}
			}
		}
		ArrayList resultlist = new ArrayList();
		for(Task t:tasklist){
			List<ZhuanyeInfo>zylist=teacherDao.queryZyByzyid(t.getZhuanyeId());
			
			if (zylist.size() > 0) {
				for (int i = 0; i < zylist.size(); i++) {
					resultlist.add(i, "{code:'" + zylist.get(i).getZhuanyeId()+ "',value:'" + zylist.get(i).getZhuanyeName() + "'}");
				}
			}
		
		}
		return resultlist;
	}

	@Override
	public ArrayList queryClassByZyid(String zhuanyeId) {
		List<ClassInfo>classlist=teacherDao.queryClassByZyid(zhuanyeId);
		ArrayList resultlist = new ArrayList();
		if (classlist.size() > 0) {
			for (int i = 0; i < classlist.size(); i++) {
				resultlist.add(i, "{code:'" + classlist.get(i).getClassId()+ "',value:'" + classlist.get(i).getClassId()+"班" + "'}");
			}
		}
		return resultlist;
	}

	/**
	 * 保存老师的总分评分，生成时间，状态改为："22"
	 * @throws ParseException 
	 */
		@Override
		public void updatePingFen(List<ResultInfo> reslist) throws ParseException  {
					Date d=new Date();
					SimpleDateFormat ff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dd=ff.format(d);
					Date ddd=ff.parse(dd);
					for(ResultInfo res:reslist){
						List<ResultInfo> list=teacherDao.queryResultByResid(res.getResId());
						for(ResultInfo rf:list){
							rf.setResfen((Double)res.getResfen());
							rf.setSctime(ddd);//提交时间
							rf.setPfstatus("22");//改为"提交"
							
							rf.setFangcha((Double)res.getFangcha());
							rf.setMaxscore((Double)res.getMaxscore());
							rf.setBzcha((Double)res.getBzcha());
							rf.setMinscore((Double)res.getMinscore());
							rf.setPjscore((Double)res.getPjscore());
							teacherDao.saveResult(rf);
						}
					}
		}

	@Override
	public ArrayList queryTaskByCouidAndZyid(String courseid, String zyid) {
		ArrayList result=new ArrayList();
		String taskname="";
		String tasknameid="";
		String coursename="";
		String zhuanyename="";
	
		List<CourseInfo> cou=teacherDao.queryCourseBycourseid(courseid);
		for(CourseInfo c:cou){
			coursename=c.getName();
		}
		List<ZhuanyeInfo> zylist=teacherDao.queryZyByzyid(zyid);
		for(ZhuanyeInfo zy:zylist){
			zhuanyename=zy.getZhuanyeName();
		}
		List<Task> tlist=teacherDao.queryTaskByCouidAndZyid(courseid,zyid);
		taskname=coursename+"_"+zhuanyename+"_作业 "+(tlist.size()+1);
		tasknameid="作业 "+(tlist.size()+1)+"";
		result.add(0, taskname);
		result.add(1, tasknameid);
		return result;
	}

	@Override
	public ArrayList queryCourseByzhuanyeId(String zyid) {
		List <Task> tasklist=teacherDao.queryTaskByZyid(zyid);
		for  ( int  i  =   0 ; i  <  tasklist.size()  -   1 ; i ++ )   { 
		    for  ( int  j  =  tasklist.size()  -   1 ; j  >  i; j -- )   { 
				if(tasklist.get(i).getCourseId().equals(tasklist.get(j).getCourseId())){
					tasklist.remove(j);
				}
			}
		}
		ArrayList resultlist = new ArrayList();
		if (tasklist.size() > 0) {
			for (int i = 0; i < tasklist.size(); i++) {
				List<CourseInfo> coulist=teacherDao.queryCourseBycourseid(tasklist.get(i).getCourseId());
				for(CourseInfo cou:coulist){
					resultlist.add(i, "{code:'" +cou.getCourseId() + "',value:'" +cou.getName()+ "'}");
				}
				
			}
		}
		
		return resultlist;
	}

	
}
