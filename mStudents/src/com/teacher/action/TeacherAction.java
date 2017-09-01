package com.teacher.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.model.ResultInfo;
import com.model.Task;
import com.teacher.service.TeacherService;
import com.tool.BaseAction;
import com.tool.ToolUtil;
import com.tool.VOUtils;

@Controller("teacherAction")
public class TeacherAction extends BaseAction {

	@Autowired
	private TeacherService teacherService;
	
	private JSONArray result;
	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}
	/**
	 * 查询课程列表
	 * @return
	 */
	public String  queryCourse(){
		JSONArray jsonArray;
		String teaid=this.getRequest().getParameter("teaid");
		try{
			ArrayList courselist= teacherService.queryCourse(teaid);
			jsonArray = JSONArray.fromObject(courselist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	/**
	 * 学生提交任务时，根据学生ID获取学生的课程
	 * @return
	 */
	public String  queryCourseByStuid(){
		String stuid=this.getRequest().getParameter("stuid");
		JSONArray jsonArray;
		try{
			ArrayList courselist= teacherService.queryCourseByStuid(stuid);
			jsonArray = JSONArray.fromObject(courselist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	/**
	 * 根据学生ID获取学生的专业信息
	 */
	public String queryZhuanyeByStuid(){
		String stuid=this.getRequest().getParameter("stuid");
		JSONArray jsonArray;
		try{
			ArrayList courselist= teacherService.queryZhuanyeByStuid(stuid);
			jsonArray = JSONArray.fromObject(courselist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	/**
	 * 学生提交作业时，根据专业ID获取此学生有作业任务的所有的课程
	 * @return
	 */
	public String queryCourseByzhuanyeId(){
		String zyid=this.getRequest().getParameter("zhuanyeId");
		JSONArray jsonArray;
		try{
			ArrayList coulist= teacherService.queryCourseByzhuanyeId(zyid);
			jsonArray = JSONArray.fromObject(coulist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	/**
	 * 查询专业列表
	 * @return
	 */
	public String queryZhuanYe(){
		JSONArray jsonArray;
		try{
			ArrayList zhuanyelist= teacherService.queryZhuanYe();
			jsonArray = JSONArray.fromObject(zhuanyelist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	/**
	 * 根据课程ID获取作业信息
	 * @return
	 */
	public String queryTaskBycourseId(){
		String courseId=this.getRequest().getParameter("courseId");
		JSONArray jsonArray;
		try{
			ArrayList zhuanyelist= teacherService.queryTaskById(courseId);
			jsonArray = JSONArray.fromObject(zhuanyelist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
		
	}
	/**
	 * 保存老师发布的任务
	 * @return
	 */
	public String  saveFaBuTask(){
		JSONArray jsonArray=new JSONArray() ;
		try{
			String teaid=this.getRequest().getParameter("teaid");
			String data=this.getRequest().getParameter("data");
			data=ToolUtil.getUTFByIso(data);
			Task task = (Task)VOUtils.getBeanFromJsonData(data,
	                  new String[] {"fabuTime","jiezhiTime"},"yyyy-MM-dd HH:mm:ss",Task.class);
			task.setTeaId(teaid);
			teacherService.saveFaBuTask(task);
			ArrayList result=new ArrayList();
			result.add(0, "success");
			jsonArray = JSONArray.fromObject(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonArray;
		return SUCCESS;
	}
/**
 * 根据专业ID获取作业信息
 */
	public String queryTaskByzhuanyeId(){
		String zyid=this.getRequest().getParameter("zhuanyeId");
		JSONArray jsonArray;
		try{
			ArrayList tasklist= teacherService.queryTaskByzhuanyeId(zyid);
			jsonArray = JSONArray.fromObject(tasklist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	/**
	 * 根据老师ID获取老师的所有任务
	 * @return
	 */
	
	public String queryTaskByTeaid(){
		String teaid=this.getRequest().getParameter("teaid");
		JSONArray jsonArray;
		try{
			ArrayList tasklist= teacherService.queryTaskByTeaid(teaid);
			jsonArray = JSONArray.fromObject(tasklist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	/**
	 * 验收作业时，通过作业ID获取此作业专业所含的班级
	 * @return
	 */
	public String queryClassBytaskid(){
		String taskid=this.getRequest().getParameter("taskid");
		JSONArray jsonArray;
		try{
			ArrayList classlist= teacherService.queryClassBytaskid(taskid);
			jsonArray = JSONArray.fromObject(classlist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	/**
	 * 根据老师的ID查询老师发布作业中包含的课程
	 */
	
	public String queryCourseByTeaid(){
		String teaid=this.getRequest().getParameter("teaid");
		JSONArray jsonArray;
		try{
			ArrayList course= teacherService.queryCourseByTeaid(teaid);
			jsonArray = JSONArray.fromObject(course);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	/**
	 * 根据课程ID和老师ID查询此课程包含的专业
	 * @return
	 */
	public String queryZyByCourseidAndTeaid(){
		String courseid=this.getRequest().getParameter("courseid");
		String teaid=this.getRequest().getParameter("teaid");
		JSONArray jsonArray;
		try{
			ArrayList tasklist= teacherService.queryZyByCourseidAndTeaid(courseid,teaid);
			jsonArray = JSONArray.fromObject(tasklist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	
	/**
	 * 根据专业ID获取此专业包含的班级
	 * @return
	 */
	public String queryClassByZyid(){
		String zhuanyeId=this.getRequest().getParameter("zhuanyeid");
		JSONArray jsonArray;
		try{
			ArrayList tasklist= teacherService.queryClassByZyid(zhuanyeId);
			jsonArray = JSONArray.fromObject(tasklist);
			result=jsonArray;
		}catch(Exception e){
			e.printStackTrace();
		}
		 return SUCCESS;
	}
	/**
	 * 保存老师结课总评分
	 * @return
	 */
	public String  savePingFen(){
		JSONArray jsonArray=new JSONArray() ;
		String data=this.getRequest().getParameter("data");
		data=ToolUtil.getUTFByIso(data);
		try{
			List<ResultInfo> res=VOUtils.getBeanListFromJsonData(data,ResultInfo.class );
			teacherService.updatePingFen(res);
			ArrayList result=new ArrayList();
			result.add(0, "success");
			jsonArray = JSONArray.fromObject(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonArray;
		return SUCCESS;
		
	}
	
	public String getTaskName(){
		JSONArray jsonArray=new JSONArray() ;
		String courseid=this.getRequest().getParameter("courseid");
		String zyid=this.getRequest().getParameter("zyid");
		try{
			ArrayList result=teacherService.queryTaskByCouidAndZyid(courseid,zyid);
			jsonArray = JSONArray.fromObject(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonArray;
		return SUCCESS;
	}
	
}
