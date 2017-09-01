package com.student.action;

import java.util.ArrayList;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.model.Submit;
import com.model.Task;
import com.student.service.StudentService;
import com.tool.BaseAction;
import com.tool.ToolUtil;
import com.tool.VOUtils;

@Controller("studentAction")
public class StudentAction extends BaseAction{

	@Autowired
	private StudentService studentService;
	
	private JSONArray result;
	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	} 
	/**
	 * 查询提交信息
	 * @return
	 */
	public String queryStuSubmit(){
		String stuid=this.getRequest().getParameter("stuid");
		JSONArray jsonArray;
		try{
			if(stuid!=null){
				
				ArrayList courselist= studentService.queryStuSubmit();
				jsonArray = JSONArray.fromObject(courselist);
				result=jsonArray;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			 return SUCCESS;
		
	}
	/**
	 * 保存学生的提交信息
	 * @return
	 */
	public String saveStuTiJiao(){
		
		JSONArray jsonArray=new JSONArray() ;
		try{
			String data=this.getRequest().getParameter("data");
			String stuid=this.getRequest().getParameter("stuid");
			String classid=this.getRequest().getParameter("classId");
			data=ToolUtil.getUTFByIso(data);
			Submit sub = (Submit)VOUtils.getBeanFromJsonData(data,Submit.class);
			sub.setStuId(stuid);
			sub.setClassId(classid);
			String status=studentService.saveStudentSubmit(sub);
			ArrayList result=new ArrayList();
			if("00".equals(status)){
				result.add(0,"00");//上传成功
			}else if("22".equals(status)){
				result.add(0, "22");//已评分不能修改
			}else if("11".equals(status)){
				result.add(0, "11");//修改成功
			}else{
				result.add(0, "fail");//失败
			}
			jsonArray = JSONArray.fromObject(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		result=jsonArray;
		return SUCCESS;
		
	}
}
