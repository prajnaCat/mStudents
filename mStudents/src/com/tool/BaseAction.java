package com.tool;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final Log logger = LogFactory.getLog(getClass());

	// 获取request
	private HttpServletRequest request ;
	// 获取response
	private HttpServletResponse response;

	// 得到request
	protected HttpServletRequest getRequest() {
		return request;
	}

	protected HttpServletResponse getResponse() {
		response.setContentType("text/html;charset=utf-8");
		return response;
	}
	
	
	
	protected void showJsonSuccess(String msg){
		showJson(true, msg);
	}

	
	protected void showJsonError(String msg){
		showJson(false, msg);
	}
	
	protected void showJson(boolean isSuccess,String msg){
		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("msg",msg);
		jsonObject.put("success",isSuccess);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			logger.error("转换报错:"+e);
		}
	}
	
	protected void showJsonStatus(String msg){
		showJson2("1", msg);
	}
	
	protected void showJson2(String isSuccess,String msg){
		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("response",msg);
		jsonObject.put("message","查询成功");
		jsonObject.put("status",isSuccess);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			logger.error("转换报错:"+e);
		}
	}
	
	protected void showBackJson(String status,String msg,String result){
		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("response",result);
		jsonObject.put("message",msg);

		jsonObject.put("status",status);
		response.setContentType("text/json;charset=utf-8");
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			logger.error("转换报错:"+e);
		}
	}
	// 获取session
	public HttpSession getSession() {
		HttpSession session = request.getSession();
		return session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request= request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * 字符转码
	 */
	public static String getUTFByIso(String value) {
		String result = "";
		try {
			if (!isEmpty(value)) {
				if (value.equals(new String(value.getBytes("ISO-8859-1"),"ISO-8859-1"))) {
					result = new String(value.getBytes("ISO-8859-1"),"UTF-8");
				} else {
					result = value; 
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean isEmpty(String value) {
		boolean flg = false;
		if (value==null || value.equals("") || value.equals("null")) {
			flg = true;
		}
		return flg;
	}
	
	/**
 	 * 生成时间戳主键
 	 * @return
 	 */
 	public static String getId(String value) {
//		long time = System.nanoTime() & 0x7fffffff;
 		long time = System.nanoTime();
		System.out.println(time);
		return value + time;
 	}


}
