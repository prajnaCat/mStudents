<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.model.StudentInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>

	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script src="<%=request.getContextPath()%>/js/boot.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/css/demo.css" type="text/css"/>
    <script src="<%=request.getContextPath()%>/js/echarts.js"></script>
     <script src="<%=request.getContextPath()%>/js/ajaxfileupload.js"type="text/javascript"></script>
    <%
     StudentInfo stu = (StudentInfo)session.getAttribute("student");
    String stuid=stu.getStuId();
    String classId=stu.getClassId();
     %>
   
</head>
  
  <body>
  <form  id="tijiao" name="tijiao">
<fieldset id="fd2"
				  style="width:60%; margin:30px 20% 20px 20%;padding:0px 3px 3px 3px;position: relative;">
				  <legend>作业信息</legend>
			<div class="fieldset-body">
				<table class="table_search" style="width:100%;margin:10px  40px ;">
					<tr>
							<table class="table_search" style="width:70%;margin-left: 130px;">
								<tr style="height:10px"></tr>
								<tr>
								<td align="right"style="width:30%;"><span style="color:red">*</span>专业选择：</td>
									<td style="width:80%;">
									
										 <input class="mini-combobox" id="zhuanyeId" name="zhuanyeId" 
										 textField="value" valueField="code"required="required"onvaluechanged="onZhuanyeIdChanged"
										  url="" /></td>
								</tr>
								<tr style="height:30px"></tr>
								<td align="right"style="width:30%;"><span style="color:red">*</span>课程选择：</td>
									<td style="width:80%;">
									
										 <input class="mini-combobox" id="courseId" name="courseId" 
										 textField="value" valueField="code"required="required"onvaluechanged="onCourseIdChanged"
										  url="" /></td>
								</tr>
								<tr style="height:30px"></tr>
								<tr>
								<td align="right"style="width:30%;"><span style="color:red">*</span>作业简称：</td>
									<td style="width:80%;">
										 <input class="mini-combobox" id="taskId" name="taskId"style="width:250px" 
										 textField="value" valueField="code"required="required" /></td>
								</tr>
								
								
							
								
								<tr style="height:30px"></tr>
								<tr>
									<td style="width:20%" align="right"><span style="color:red">*</span>作业文档备注：</td>
									<td style="width:30%"><input id="beizhu" name="beizhu"
																 class="mini-textarea" style="width:300px;height:50px" vtype="maxLength:500" required="required"/>
									</td>
									
								</tr>
								
								<tr style="height:30px"></tr>
								<tr>
									<td style="width:20%" align="right"><span style="color:red">*</span>作业提交文档：</td>
									<td style="width:80%" colspan=3>
										<input id="stuDocId"  class="mini-hidden" name="stuDocId" /> 
			     						<input id="fileToUpload1" type="file" size="35" style="width: 250px" name="fileToUpload1" required="required" class="file">
			        					&nbsp;
			        					<input type="button" name="bt1" value="上传" onclick="upload1();" />
			     						</td>
								</tr>
								
							
					<tr style="height:30px"></tr>
							
							</table>
					</tr>
					
				</table>
			</div>
		</fieldset>
	</form>
	<div align="center">
    <a class="mini-button" onclick="save()">提交</a>
    <a class="mini-button" iconCls="icon-cancel"onclick="resetForm()">重置</a>
	</div>
<script type="text/javascript">

mini.parse();
		var tijiao = new mini.Form("tijiao");
 		var zhuanye= mini.get("zhuanyeId");
 		var course=mini.get("courseId");
        var task = mini.get("taskId");
		
		window.onload=function(){
		
	     var url="${pageContext.request.contextPath}/teacher/teacherAction_queryZhuanyeByStuid.action?stuid="+<%=stuid %>;
	     zhuanye.setUrl(url);
		}
	
		
        function onZhuanyeIdChanged(e) {
            var zhuanyeId = zhuanye.getValue();

            course.setValue("");
            task.setValue("");
            var url = "${pageContext.request.contextPath}/teacher/teacherAction_queryCourseByzhuanyeId.action?zhuanyeId=" + zhuanyeId;
            course.setUrl(url);
            
        }
        
        function onCourseIdChanged(e) {
            var courseId = course.getValue();

            task.setValue("");
            var url = "${pageContext.request.contextPath}/teacher/teacherAction_queryTaskBycourseId.action?courseId=" + courseId;
            task.setUrl(url);
            
        }
//提交按钮
	function save(){
	var studoc=mini.get("stuDocId").getValue();
	var classId=""+<%=classId%>+"";
	if(studoc==null||studoc==""){
	mini.alert("文档不能为空");
	return;
	}
        tijiao.validate();
        if(!tijiao.isValid()) return;

        var obj = tijiao.getData();
        var s = mini.encode(obj);
        $.ajax({
            url:"${pageContext.request.contextPath}/student/studentAction_saveStuTiJiao.action?stuid="+<%=stuid %>+"&classId="+classId,
            data:{data:s},
            success: function (data) {
                if("00"==data[0]){
                     mini.alert("提交成功！");
                }else if("11"==data[0]){
                  	 mini.alert("修改成功！");
                }else if("22"==data[0]){
                 	 mini.alert("已评分不能修改！");
                }else{
                 mini.alert("提交失败！");
                }
            },
            error: function (text) {
                mini.alert("提交失败！");
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
			url : '${pageContext.request.contextPath}/upDownFileAction_studentUpload.action',
			secureuri : false,
			fileElementId : ['fileToUpload1'],
			data:{'name':filename},
			dataType : 'json',
			success : function(data) {
				var d =eval("("+data+")");
					 if("success"==d.status){
			              	mini.alert("上传成功");
			              	mini.get("stuDocId").setValue(d.studocid);
			         }else{
			         		mini.alert("上传失败");
			         }
			},
			error : function(text) {
					mini.alert("上传失败");
			}
		});
    }
   }


</script>
  </body>
</html>
