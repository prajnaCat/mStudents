<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.model.TeacherInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teacher</title>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script src="<%=request.getContextPath()%>/js/boot.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/css/demo.css" type="text/css"/>
	<script src="<%=request.getContextPath()%>/js/echarts.js"></script>
	 <%
     TeacherInfo tea= (TeacherInfo)session.getAttribute("teacher");
    String teaid=tea.getTeaId();
     %>
</head>
  
  <body>
   <fieldset id="fd2"
				  style="width:90%; margin:-14px 0px 10px;padding:0px 3px 3px 3px;position: relative;">
				  <legend>验收作业</legend>
	<div style="width:1000px;margin:10px 30px 0px 30px;">
	        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
	            <table style="width:100%;">
	              <tr>
	                    <td style="white-space:nowrap;">
	                    <input id="coursekey" class="mini-combobox" emptyText="请选择课程" style="width:200px;"onvaluechanged="onDeptChanged00"
	                         textField="value" valueField="code"required="required" url=""/>
	                        <input id="taskkey" class="mini-combobox" emptyText="请选择作业名称" style="width:250px;"onvaluechanged="onDeptChanged"
	                         textField="value" valueField="code"required="required" url=""/>
	                          <input id="classkey" class="mini-combobox" emptyText="请选择班级" style="width:150px;" showNullItem="true"
	                         textField="value" valueField="code" url=""/>      
	                        <a class="mini-button" onclick="search()">查询</a>
	                    </td>
	                    
	                      <td style="white-space:nowrap;">
	                        <a class="mini-button" onclick="save()">保存</a>
	                    </td>
	                    
	                </tr>
	            </table>           
	        </div>
    </div>
    
 <div id="datagrid1" class="mini-datagrid" style="width:1000px;height:450px;margin:0px 30px 20px 30px;" 
        url="${pageContext.request.contextPath}/commonAction_querySubDetail.action" idField="id" 
        allowResize="true" pageSize="20" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true"
        
    >
        <div property="columns">
            <div type="indexcolumn"></div>
          <!--   <div type="checkcolumn"></div> -->
          <div name="subId"  field="subId" align="center"headerAlign="center" allowSort="true" width="0" >
            </div>
          <div name="stuId"  field="stuId" align="center"headerAlign="center" allowSort="true" width="7.4%" >学号
            </div>
          <div name="stuName"  field="stuName" align="center"headerAlign="center" allowSort="true" width="7.4%" >姓名
            </div>
            <div name="classId"  field="classId" align="center"headerAlign="center" allowSort="true" width="8.3%" >班级
            </div>
            <div name="taskname"  field="taskname" align="center"headerAlign="center" allowSort="true" width="11.1%" >作业简称
            </div>            
            <div name="titime" field="titime" width="11.1%" allowSort="true"align="center" headerAlign="center"dateFormat="yyyy-MM-dd HH:mm">提交日期
            </div>    
           <div name="jiezhiTime" field="jiezhiTime" width="11.1%" allowSort="true"align="center"headerAlign="center" dateFormat="yyyy-MM-dd HH:mm">截止日期
            </div> 
            <div  name="tjstatus"  field="tjstatus" align="center"headerAlign="center" 
            allowSort="true" width="6.4%" renderer="onGenderRenderer">作业状态
            </div>   
            <div  name="name"  field="name" align="center"headerAlign="center" allowSort="true" width="19.4%" >作业文档
             <input property="editor" class="mini-textbox" id="dname" style="width:100%;" minWidth="18.5%" /> 
            </div>
            <div name="docname" field="docname" width="0" headerAlign="center" align="center" ></div>
            <div name="action" width="7.4%" headerAlign="center" align="center" renderer="onActionRenderer">文档下载
            
            </div> 
             <div name="score"  field="score"align="center" headerAlign="center" allowSort="true" width="6.4%" >评分
                <input property="editor" class="mini-textbox" style="width:100%;" mixWidth="5%" />
            </div>                          
        </div>
    </div>
    </div>
				  
	</fieldset>
	<script type="text/javascript">
	
	mini.parse();
	var coursekey=mini.get("coursekey");
	var taskkey=mini.get("taskkey");
	var classkey=mini.get("classkey");
	var datagrid1 = mini.get("datagrid1");
	
	datagrid1.on("drawcell",function (e) {
		var grid = e.sender;
		var record = e.record;
        if(e.field== "score" ){
            e.cellStyle = "background:#bad4f3";
        }
        if(e.field=="titime"&&(record.tjtime>record.jiezhiTime)){
        	e.rowStyle = "background:orange";
        }
		 if(e.field=="tjstatus"&&(record.tjstatus!="22")){
         e.cellStyle = "background:#A4D3EE";
        }
    });
	
	
	window.onload=function(){
     var url="${pageContext.request.contextPath}/teacher/teacherAction_queryCourse.action?teaid="+<%=teaid %>;
     coursekey.setUrl(url);
	}
	
	  function onDeptChanged00(e) {
            var courseid = coursekey.getValue();
			
			taskkey.setValue("");
            classkey.setValue("");
            
            var url = "${pageContext.request.contextPath}/teacher/teacherAction_queryTaskBycourseId.action?courseId=" + courseid;
            taskkey.setUrl(url);
        }
	
	  function onDeptChanged(e) {
            var taskid = taskkey.getValue();
            classkey.setValue("");
            
            var url = "${pageContext.request.contextPath}/teacher/teacherAction_queryClassBytaskid.action?taskid=" + taskid;
            classkey.setUrl(url);
            
        }
        
        
        
		
	 function search() {
            var taskId = taskkey.getValue();
			var classId=classkey.getValue();
			if(taskId==""||taskId==null){
			mini.alert("请选择作业")
			return;
			}
			/*  grid.load({areaname: areaname}); */
			datagrid1.load({taskId:taskId,classId:classId});
        }
        
        function save(){
         	var data = datagrid1.getChanges();
         	console.log("123="+data);
            var json = mini.encode(data);
            
            mini.mask({
            el: document.body,
            cls: 'mini-mask-loading',
            html: 'loading...'
        	}); 
            $.ajax({
                url: "${pageContext.request.contextPath}/commonAction_saveSubmitScore.action",
                data: { data: json },
                type: "post",
                success: function (text) {
                if("success"==text.isok){
                	mini.alert("保存成功");
                	 mini.unmask(document.body);
                	 datagrid1.reload();
                	}else if("failed"==text.isok){
                	mini.alert("保存失败");
                	 mini.unmask(document.body);
                	}
                },
                error: function () {
                	mini.alert("保存失败");
                	 mini.unmask(document.body);
                }
            });
        
        
        }
        
	function onActionRenderer(e){
		var grid = e.sender;
		var record = e.record;
		var dname=record.name;
	   docname=record.docname;
		var url='${pageContext.request.contextPath}/upload/student/yongjiu/'+docname;
		var s="";
		if(dname!=null&&dname!=""){
		s = '<a id="filed" download='+dname+' href='+url+'> 下 载 </a>';
		}
		return s;
	}

	
	
	 var tjstatus= [{ id: "11", text: '未评分' }, { id: "22", text: '已评分'}];  
        function onGenderRenderer(e) {
            for (var i = 0, l = tjstatus.length; i < l; i++) {
                var g = tjstatus[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        
        

	
	</script>
  </body>
</html>
