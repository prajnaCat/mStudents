package com.common.action;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.common.model.ResultDetailVo;
import com.common.model.SubmitDetailVo;
import com.common.service.CommonService;
import com.model.ResultInfo;
import com.tool.BaseAction;
import com.tool.Page;
import com.tool.ToolUtil;
import com.tool.VOUtils;
@Controller("commonAction")
public class CommonAction extends BaseAction {

	@Autowired
	private CommonService commonService;
	private JSONObject result ;
	

	public JSONObject getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	/**
	 * 老师验收作业时，根据作业ID和班级ID获取学生的作业提交详情。
	 * @throws Exception 
	 */
	public String querySubDetail(){
		JSONObject jsonObject = new JSONObject();
		String pStart = this.getRequest().getParameter("pageIndex");
		String pSize = this.getRequest().getParameter("pageSize");
		String taskId=this.getRequest().getParameter("taskId");
		String classId=this.getRequest().getParameter("classId");
		int pageIndex=Integer.parseInt(pStart);
		int pageSize=Integer.parseInt(pSize);
		Page page=new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		try{
			List<SubmitDetailVo> list=commonService.querySubDetail(taskId,classId, page);
			
			String json = VOUtils.getJsonDataFromCollection(list);
			System.out.println(json);
		
			jsonObject.put("data", json);
			jsonObject.put("total",list.size()+"");
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	/**
	 * 老师验收作业时，保存老师的评分
	 * @return
	 */
	public String saveSubmitScore(){
		JSONObject jsonObject = new JSONObject();
		String data=this.getRequest().getParameter("data");
		data=ToolUtil.getUTFByIso(data);
		try{
			List<SubmitDetailVo> svo=VOUtils.getBeanListFromJsonData(data,SubmitDetailVo.class );
			commonService.saveSubmitScore(svo);
			jsonObject.put("isok", "success");
		}catch(Exception e){
			jsonObject.put("isok", "failed");
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	/**
	 * 学生根据学生ID或者专业ID
	 * 获取具体消息的提交信息
	 * @return
	 */
	
	public String queryStudentSubDetail(){
		JSONObject jsonObject = new JSONObject();
		String pStart = this.getRequest().getParameter("pageIndex");
		String pSize = this.getRequest().getParameter("pageSize");
		String stuId=this.getRequest().getParameter("stuId");
		String courseId=this.getRequest().getParameter("courseId");
		int pageIndex=Integer.parseInt(pStart);
		int pageSize=Integer.parseInt(pSize);
		Page page=new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		try{
			List<SubmitDetailVo> list=commonService.querySubDetailByStuid(stuId, courseId, page);
			
			String json = VOUtils.getJsonDataFromCollection(list);
			System.out.println(json);
		
			jsonObject.put("data", json);
			jsonObject.put("total",list.size()+"");
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	/**
	 * 根据课程ID、专业ID、班级ID
	 * 获取某班级的所有学生的这门课程的详细信息。
	 * 平均分、最大值、最小值、方差。
	 * @return
	 */
	public String queryStudentResultDetail(){
		JSONObject jsonObject = new JSONObject();
		String pStart = this.getRequest().getParameter("pageIndex");
		String pSize = this.getRequest().getParameter("pageSize");
		
		String courseId=this.getRequest().getParameter("courseId");
		String zhuanyeId=this.getRequest().getParameter("zhuanyeId");
		String classId=this.getRequest().getParameter("classId");
		
		int pageIndex=Integer.parseInt(pStart);
		int pageSize=Integer.parseInt(pSize);
		Page page=new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		try{
			commonService.saveStudentResultDetail(courseId,zhuanyeId,classId,page);
			List<ResultDetailVo>list=commonService.queryResultBycouidAndclassid(courseId,classId,page);
			String json = VOUtils.getJsonDataFromCollection(list);
			System.out.println(json);
		
			jsonObject.put("data", json);
			jsonObject.put("total",list.size()+"");
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
	public String  savePingFen(){
		JSONObject jsonObject = new JSONObject();
		String data=this.getRequest().getParameter("data");
		data=ToolUtil.getUTFByIso(data);
		try{
			List<ResultInfo> res=VOUtils.getBeanListFromJsonData(data,ResultInfo.class );
			commonService.updatePingFen(res);
			jsonObject.put("isok", "success");
		}catch(Exception e){
			jsonObject.put("isok", "failed");
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
		
	}
	
	/**
	 * 学生查看自己的结课的课程成绩和详细数据
	 * 参数：学生ID
	 * 返回：此学生所有的结课详细数据
	 * @return
	 */
	
	public String stuDetailByStuId(){
		JSONObject jsonObject = new JSONObject();
		String pStart = this.getRequest().getParameter("pageIndex");
		String pSize = this.getRequest().getParameter("pageSize");
		
		String stuid=this.getRequest().getParameter("stuid");
		int pageIndex=Integer.parseInt(pStart);
		int pageSize=Integer.parseInt(pSize);
		Page page=new Page();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		try{
			List<ResultDetailVo>list=commonService.queryPageResultByStuId(stuid,page);
			String json = VOUtils.getJsonDataFromCollection(list);
			System.out.println(json);
			
			jsonObject.put("data", json);
			jsonObject.put("total",list.size()+"");
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonObject;
		return SUCCESS;
	}
	
}
