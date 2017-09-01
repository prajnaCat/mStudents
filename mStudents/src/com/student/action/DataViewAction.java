package com.student.action;

import java.util.ArrayList;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.student.service.DataViewService;
import com.tool.BaseAction;

@Controller("dataViewAction")
public class DataViewAction extends BaseAction {
	
	@Autowired
	private DataViewService dataViewService;
	
	private JSONObject result ;

	public JSONObject getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	/**
	 * 组装所有老师发布做业的时间分布图。
	 */
	public String getAllFaBuDataView(){
		JSONObject jsonObject=new JSONObject();
		try {
			int[][]  data =dataViewService.getAllFaBuDataView();
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	
	
	/**
	 * 获取前10个的作业提交情况：总人数 | 实际提交数量
	 * @return
	 */
	public String getAllCountTaskData(){
		JSONObject jsonObject=new JSONObject();
		try {
			ArrayList  data =dataViewService.getAllCountTaskData();
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 获取每个Result中的平均值、最值，最终结果
	 * @return
	 */
	public String getAllCountTjnumData(){
		JSONObject jsonObject=new JSONObject();
		try {
			ArrayList  data =dataViewService.getAllCountTjnumData();
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 获取每月总提交量，每天的提交量
	 */
	public  String getMonthnumAndDaynum(){
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,int[]> data=dataViewService.getMonthnumAndDaynum();
			for(int i=1;i<13;i++){
				jsonObject.put(i, data.get("'"+i+"'"));
			}
			System.out.println("data="+jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	/**
	 * 获取学生某课程的所有成绩
	 * @return
	 */
	public String getResultFenBu(){
		JSONObject jsonObject=new JSONObject();
		String stuid=this.getRequest().getParameter("stuid");
		String courseid=this.getRequest().getParameter("courseid");
		try {
			ArrayList data =dataViewService.getResultFenBu(stuid,courseid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 根据学生ID获取此学生所有的提交作业的时间分布
	 * @return
	 */
	public String getTiJiaoDataViewByStuid(){
		JSONObject jsonObject=new JSONObject();
		String stuid=this.getRequest().getParameter("stuId");
		try {
			int[][]  data =dataViewService.getTiJiaoDataViewByStuid(stuid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	/**
	 * 根据学生ID获取关于此学生的所有课程的提交作业次数
	 * @return
	 */
	public String getCountSubmitData(){
		JSONObject jsonObject=new JSONObject();
		String stuid=this.getRequest().getParameter("stuId");
		try {
		ArrayList  data =dataViewService.getCountSubmitData(stuid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	/**
	 * 根据学生ID，获取此学生的所有课程的最终成绩
	 * @return
	 */
	public String getAllResultFeData(){
		JSONObject jsonObject=new JSONObject();
		String stuid=this.getRequest().getParameter("stuId");
		try {
			ArrayList data =dataViewService.getAllResultFeData(stuid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	/**
	 * 根据学生ID获取学生的所有
	 * @return
	 */
	
	public String getStudentResultDetail(){
		JSONObject jsonObject=new JSONObject();
		String stuid=this.getRequest().getParameter("stuId");
		try {
			ArrayList data =dataViewService.getStudentResultDetail(stuid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	
	/**
	 * 组装所有老师发布做业的时间分布图。
	 */
	public String getFaBuDataViewByTeaid(){
		JSONObject jsonObject=new JSONObject();
		String teaid=this.getRequest().getParameter("teaId");
		try {
			int[][]  data =dataViewService.getFaBuDataViewByTeaid(teaid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 根据Teaid获取此老师的所有课程的发布次数。
	 */
	
    public String getCountFaBuDataByTeaid(){
    	JSONObject jsonObject=new JSONObject();
		String teaid=this.getRequest().getParameter("teaId");
		try {
		ArrayList  data =dataViewService.getCountFaBuDataByTeaid(teaid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
    }
    
    /**
	 * 根据老师ID获取此教师发布作业前10个的作业提交情况：总人数 | 实际提交数量
	 * @return
	 */
	public String countTaskDataByTeaid(){
		String teaid=this.getRequest().getParameter("teaId");
		JSONObject jsonObject=new JSONObject();
		try {
			ArrayList  data =dataViewService.countTaskDataByTeaid(teaid);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 根据教师ID获取教师每次作业的评分时间分布图
	 * @return
	 */
	public String countPingfenTimeFenBuData(){
		String teaid=this.getRequest().getParameter("teaId");
		JSONObject jsonObject=new JSONObject();
		try {
			Map<String,int[]> data=dataViewService.countPingfenTimeFenBuData(teaid);
			for(int i=1;i<13;i++){
				jsonObject.put(i, data.get("'"+i+"'"));
			}
			System.out.println("data="+jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 第一学年的学生的所有课程的最终成绩
	 * @return
	 */
	public String getFirstNianData(){
		String stuid=this.getRequest().getParameter("stuId");
		JSONObject jsonObject=new JSONObject();
		try {
			ArrayList  data =dataViewService.getFirstNianData(stuid,1);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 第二学年的学生的所有课程的最终成绩
	 * @return
	 */
	public String getSecondNianData(){
		String stuid=this.getRequest().getParameter("stuId");
		JSONObject jsonObject=new JSONObject();
		try {
			ArrayList  data =dataViewService.getFirstNianData(stuid,2);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 第三学年的学生的所有课程的最终成绩
	 * @return
	 */
	public String getThidNianData(){
		String stuid=this.getRequest().getParameter("stuId");
		JSONObject jsonObject=new JSONObject();
		try {
			ArrayList  data =dataViewService.getFirstNianData(stuid,3);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 第四学年的学生的所有课程的最终成绩
	 * @return
	 */
	public String getFourthNianData(){
		String stuid=this.getRequest().getParameter("stuId");
		JSONObject jsonObject=new JSONObject();
		try {
			ArrayList  data =dataViewService.getFirstNianData(stuid,4);
			jsonObject.put("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
}
