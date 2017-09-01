<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.model.TeacherInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Teacher</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script src="<%=request.getContextPath()%>/js/boot.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/css/demo.css" type="text/css"/>
    <script src="<%=request.getContextPath()%>/js/ajaxfileupload.js"type="text/javascript"></script>
    <%
     TeacherInfo tea= (TeacherInfo)session.getAttribute("teacher");
    String teaid=tea.getTeaId();
     %>
</head>
<body>
<form  id="taskInfo" name="taskInfo">
<fieldset id="fd2"
				  style="width:75%; margin:-5px 150px 0px 150px;padding:0px 3px 3px 3px;position: relative;">
				  <legend>作业信息</legend>
			<div class="fieldset-body">
				<table class="table_search" style="width:100%;">
					<tr>
							<table class="table_search" style="width:70%;margin-left: 130px;">
								<tr style="height:5px"></tr>
								<tr>
								<td align="right"style="width:30%;"><span style="color:red">*</span>课程选择：</td>
									<td style="width:100%;">
										 <input class="mini-combobox" id="courseId" name="courseId" style="width:50%;"
										 textField="value" valueField="code"required="required"
										  url="" /></td>
								</tr>
								<tr style="height:20px"></tr>
								<tr>
									<td style="width:30%" align="right"><span style="color:red">*</span>选择专业：</td>
									<td style="width:70%">
									 <input class="mini-combobox" id="zhuanyeId"  name="zhuanyeId" style="width:50%;"
										 textField="value" valueField="code"required="required"onvaluechanged="onZyChanged"
										  url="${pageContext.request.contextPath}/teacher/teacherAction_queryZhuanYe.action" /></td>
								</tr>
								<tr style="height:20px"></tr>
								<tr>
								<td align="right"style="width:30%;"><span style="color:red">*</span>作业简称：</td>
									<td style="width:70%;">
									<input class="mini-textbox" id="taskname"  name="taskname" style="width:50%;"
										required="required" />
									<input class="mini-textbox"type="hidden" id="tasknameid"  name="tasknameid" visible="false"
										   /></td>
								</tr>
								<tr style="height:20px"></tr>
								<tr>
									<td style="width:20%" align="right"><span style="color:red">*</span>发布时间：</td>
									<td style="width:30%">
									<input id="fabuTime" name="fabuTime"class="mini-datepicker" style="width:50%;"ondrawdate="dateLimit"nullValue="null"
        format="yyyy-MM-dd H:mm" timeFormat="H:mm" showTime="true" showOkButton="true" showClearButton="false"required="required" /></td>
								</tr>
								<tr style="height:20px"></tr>
								<tr>
									<td style="width:20%" align="right"><span style="color:red">*</span>截止时间：</td>
									<td style="width:30%"><input id="jiezhiTime" name="jiezhiTime"class="mini-datepicker" style="width:50%;" ondrawdate="dateLimit1"nullValue="null"
        format="yyyy-MM-dd H:mm" timeFormat="H:mm" showTime="true" showOkButton="true" showClearButton="false"required="required" /></td>
								</tr>
								
								<tr style="height:20px"></tr>
								<tr>
									<td style="width:20%" align="right"><span style="color:red">*</span>具体要求：</td>
									<td style="width:30%"><input id="yaoqiu" name="yaoqiu"style="width:50%;"
																 class="mini-textarea" style="width:300px;height:100px" vtype="maxLength:990" required="required" />
									</td>
									
								</tr>
								<tr style="height:20px"></tr>
								<tr>
									<td style="width:20%" align="right">作业参考文档：</td>
									<td style="width:80%" colspan=3>
										<input id="teadocid"  class="mini-hidden" name="teadocid" value=""/> 
			     						<input id="fileToUpload1" type="file" size="35" style="width: 250px" name="fileToUpload1"  class="file">
			        					&nbsp;
			        					<input type="button" name="bt1" value="上传" onclick="upload1();" />
			     						</td>
								</tr>
								<tr style="height:20px"></tr>
								<tr>
									<td style="width:20%" align="right">参考文档备注：</td>
									<td style="width:30%"><input id="beizhu" name="beizhu"
																 class="mini-textarea" style="width:300px;height:50px" vtype="maxLength:500" />
									</td>
									
								</tr>
								
								
								
							
					<tr style="height:20px"></tr>
							
							</table>
					</tr>
					
				</table>
			</div>
		</fieldset>
	</form>
	<div align="center"style="margin-top:5px">
    <a class="mini-button" onclick="save()">提交</a>
    <a class="mini-button" iconCls="icon-cancel"onclick="resetForm()">重置</a>
	</div>

</body>
<script type="text/javascript">
	mini.parse();
	var taskInfo = new mini.Form("taskInfo");
	var tea_id=<%=teaid%>;
	
	var courseid=mini.get("courseId");
	window.onload=function(){
	     var url="${pageContext.request.contextPath}/teacher/teacherAction_queryCourse.action?teaid="+tea_id;
	     courseid.setUrl(url);
		}
	
	 function onZyChanged(e) {
            var  courseid=mini.get("courseId").getValue();
			var zyid=mini.get("zhuanyeId").getValue();
			var taskname=mini.get("taskname");
			var tasknameid=mini.get("tasknameid");
            taskname.setValue("");
            if(courseid==null||courseid==""){
            return;
            }
            if(zyid==null||zyid==""){
            return;
            }
             $.ajax({
            url:"${pageContext.request.contextPath}/teacher/teacherAction_getTaskName.action?courseid="+courseid+"&zyid="+zyid,
            success: function (text) {
             taskname.setValue(text[0]);
              tasknameid.setValue(text[1]);
            },
            error: function (text) {
            
            }
        });
        }
	
	//提交按钮
	function save(){
        taskInfo.validate();
        if(!taskInfo.isValid()) return;

         mini.mask({
            el: document.body,
            cls: 'mini-mask-loading',
            html: 'loading...'
        }); 

        var obj = taskInfo.getData();
        obj.fabuTime= mini.formatDate(obj.fabuTime,'yyyy-MM-dd H:mm:ss');
        obj.jiezhiTime = mini.formatDate(obj.jiezhiTime,'yyyy-MM-dd H:mm:ss');
        var s = mini.encode(obj);
        $.ajax({
            url:"${pageContext.request.contextPath}/teacher/teacherAction_saveFaBuTask.action?teaid="+<%=teaid %>,
            data:{data:s},
            success: function (data) {
                if("success"==data[0]){
                    mini.alert("发布成功！");
                     mini.unmask(document.body);
                }else{
                    mini.alert(text.result);
                     mini.unmask(document.body);
                }
            },
            error: function (text) {
                mini.alert("发布失败！");
                 mini.unmask(document.body);
            }
        });
    }
	
	
	
	//附件上传
	 function upload1(){
	  var limitfilesize=1024*1024*2//2MB
    	if($("#fileToUpload1").val() == ""){
			mini.alert("请选择文件上传");
			return false;
		}else{
			//文件格式限制
			var fileName = $("#fileToUpload1").val();
			var extend = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length);
			
			var filename = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length);
			extend = extend.toLowerCase();
			//zip.rar.pdf.doc,docx.xls,xlsx
			if(extend != "zip" && extend != "rar" && extend != "pdf" && extend != "doc"&& extend != "docx"&& extend != "xls"&& extend != "xlsx") {
			   mini.alert("文件类型错误！");
			   return;
			}
		  var f = document.getElementById("fileToUpload1").files;   
	      var filesize = f[0].size; 
	      
	      if(filesize>limitfilesize) {
	        mini.alert("上传文件不能大于2MB!");
	        return false;
	      }
		
		$.ajaxFileUpload({
			url : '${pageContext.request.contextPath}/upDownFileAction_teaUpload.action',
			secureuri : false,
			fileElementId : ['fileToUpload1'],
			data:{'name':filename},
			dataType : 'json',
			success : function(data) {
			var d =eval("("+data+")");
			/* alert("=="+d); */
				 if("success"==d.status){
		              	mini.alert("上传成功");
		              	mini.get("teadocid").setValue(d.teadocid);
		              	mini.get("fileToUpload1").setValue(fileName);
		         }else{
		              mini.alert("上传出错");
		         }
			},
			error : function(data) {
				
			}
		});
    }
   }
   
   function dateLimit(e){
		var date = e.date;
		var d = new Date();
		 if (date.getTime() < d.getTime()-24*60*60*1000) {
        e.allowSelect = false;
    } 
	}
	function dateLimit1(e){
		var date = e.date;
		var d ;
		var vct_s_time = mini.get("fabuTime").getValue();
		 if (vct_s_time != null && vct_s_time != ""){
	        	d = new Date(mini.parseDate(vct_s_time).valueOf());
	        	if(date.getTime()<d){
	        		 e.allowSelect = false;}
	        } else {
	        	d = new Date();        	
	        }
	}
</script>
</html>
