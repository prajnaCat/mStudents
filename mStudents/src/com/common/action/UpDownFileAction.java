package com.common.action;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.common.service.UpDownFileService;
import com.model.StuDocInfo;
import com.model.TeaDocInfo;
import com.tool.BaseAction;
import com.tool.FileUploadUtil;

@Controller("upDownFileAction")
public class UpDownFileAction extends BaseAction{
	@Autowired
    private  UpDownFileService upDownFileService ;
	
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
/**
 * 保存老师的上传作业参考文档
 */
	public String teaUpload(){
		JSONObject jsonObject = new JSONObject();
		try{
			String name =this.getRequest().getParameter("name");
			TeaDocInfo teadoc=new TeaDocInfo();
			teadoc.setName(name);
			upDownFileService.saveTeaFile(teadoc);
			FileUploadUtil f=new FileUploadUtil();
			String docname = f.teaupload(getRequest(), getResponse(),teadoc.getTeadocid());
			teadoc.setDocname(docname);
			upDownFileService.saveTeaFile(teadoc);
			 jsonObject.put("teadocid", teadoc.getTeadocid());
			 jsonObject.put("status", "success");
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.put("status", "failed");
		}
		 result=jsonObject.toString();
		return SUCCESS;
	}
	
	
	
	public String studentUpload(){
		JSONObject jsonObject = new JSONObject();
		try{
			String name =this.getRequest().getParameter("name");
			StuDocInfo studoc=new StuDocInfo();
			studoc.setName(name);
			upDownFileService.saveStuFile(studoc);
			FileUploadUtil f=new FileUploadUtil();
			String docname = f.stuupload(getRequest(), getResponse(),studoc.getStudocid());
			studoc.setDocname(docname);
			upDownFileService.saveStuFile(studoc);
			 jsonObject.put("studocid", studoc.getStudocid());
			 jsonObject.put("status", "success");
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.put("status", "failed");
		}
		 result=jsonObject.toString();
		return SUCCESS;
	}
}
