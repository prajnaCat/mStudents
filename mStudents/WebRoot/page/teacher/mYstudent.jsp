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
				  style="width:90%; margin:-14px 0px 20px 0px;padding:0px 3px 3px 3px;position: relative;">
				  <legend>作业总评</legend>
	<div style="width:1000px;margin:10px 30px 0px 30px;">
	        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
	            <table style="width:100%;">
	              <tr>
	                    <td style="white-space:nowrap;">
	                        <input id="coursekey" class="mini-combobox" emptyText="请选择课程" style="width:200px;"onvaluechanged="onDeptChanged1"
	                         textField="value" valueField="code"required="required" url=""/>
	                          <input id="zhuanyekey" class="mini-combobox" emptyText="请选择专业" style="width:200px;"onvaluechanged="onDeptChanged2"
	                         textField="value" valueField="code"required="required" url=""/>
	                          <input id="classkey" class="mini-combobox" emptyText="请选择班级" style="width:150px;"
	                         textField="value" valueField="code" required="required" url=""/>      
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
        url="${pageContext.request.contextPath}/commonAction_queryStudentResultDetail.action" idField="id" 
        allowResize="true" pageSize="30" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true"
        
    >
        <div property="columns">
            <div type="indexcolumn"></div>
     	  <div name="resId"  field="resId" align="center"headerAlign="center" allowSort="true" width="0" ></div>
     	  <div name="courseId"  field="courseId" align="center"headerAlign="center" allowSort="true" width="0" ></div>
          <div name="stuId"  field="stuId" align="center"headerAlign="center" allowSort="true" width="7.4%" >学号
            </div>
          <div name="stuName"  field="stuName" align="center"headerAlign="center" allowSort="true" width="7.4%" >姓名
            </div>
            <div name="classId"  field="classId" align="center"headerAlign="center" allowSort="true" width="8.3%" >班级
            </div>
            <div name="coursename"  field="coursename" align="center"headerAlign="center" allowSort="true" width="10.1%" >课程
            </div>            
           	<div name="tasknum"  field="tasknum" align="center"headerAlign="center" allowSort="true" width="8%" >发布作业次数
            </div>
            <div name="jiaonum"  field="jiaonum" align="center"headerAlign="center" allowSort="true" width="8%" >实交作业次数
            </div>
            <div name="pingfnum"  field="pingfnum" align="center"headerAlign="center" allowSort="true" width="7.4%" >评分次数
            </div>
            <div name="maxscore"  field="maxscore" align="center"headerAlign="center" allowSort="true" width="5.5%" >最高分
            </div>   
            <div  name="minscore"  field="minscore" align="center"headerAlign="center" allowSort="true" width="5.5%" >最低分
            </div>   
            <div  name="pjscore"  field="pjscore" align="center"headerAlign="center" allowSort="true" width="5.5%" >平均分
            </div>
              <div  name="fangcha"  field="fangcha" align="center"headerAlign="center" allowSort="true" width="5.5%" >方差
            </div>
            <div name="action" width="11.1%" headerAlign="center" align="center" renderer="onActionRenderer">查看分数分布图
            </div> 
             <div  name="pfstatus"  field="pfstatus" align="center"headerAlign="center" allowSort="true" width="5.5%"renderer="onPfstatusRenderer" >评分状态
            </div>
             <div  name="resfen"  field="resfen" align="center"headerAlign="center" allowSort="true" width="7.4%" >评总分
             <input property="editor" class="mini-textbox" style="width:100%;" mixWidth="6%" />
            </div>                        
        </div>
    </div>
    </div>
				  
	</fieldset>
	<script type="text/javascript">
	
	mini.parse();
	var coursekey=mini.get("coursekey");
	var zhuanyekey=mini.get("zhuanyekey");
	var classkey=mini.get("classkey");
	var datagrid1 = mini.get("datagrid1");
	var isok=true;
	datagrid1.on("drawcell",function (e) {
		var grid = e.sender;
		var record = e.record;
         if(e.field=="jiaonum"&&(record.jiaonum!=record.tasknum)){
         e.cellStyle = "background:red";
        }
        if(e.field=="pingfnum"&&(record.jiaonum!=record.pingfnum)){
         e.cellStyle = "background:orange";
        }
        if(e.field=="pfstatus"&&(record.pfstatus!="22")){
         e.cellStyle = "background:#A4D3EE";
        }

    });
	
		window.onload=function(){
	     var url="${pageContext.request.contextPath}/teacher/teacherAction_queryCourseByTeaid.action?teaid="+<%=teaid %>;
	     coursekey.setUrl(url);
		}
	  	function onDeptChanged1(e) {
            var courseid = coursekey.getValue();
             zhuanyekey.setValue(""); 
             classkey.setValue("");
            var url = "${pageContext.request.contextPath}/teacher/teacherAction_queryZyByCourseidAndTeaid.action?courseid=" + courseid+"&teaid="+<%=teaid %>;
            zhuanyekey.setUrl(url);
            
        }
          function onDeptChanged2(e) {
            var zhuanyeid = zhuanyekey.getValue();
            classkey.setValue("");
            var url = "${pageContext.request.contextPath}/teacher/teacherAction_queryClassByZyid.action?zhuanyeid=" + zhuanyeid;
            classkey.setUrl(url);
            
        }
		
	 function search() {
            var courseId = coursekey.getValue();
            var zhuanyeId = zhuanyekey.getValue();
            var classId=classkey.getValue();
            if(courseId==null||courseId==""){
            mini.alert("请选择课程");
            return ;
            }
            if(zhuanyeId==null||zhuanyeId==""){
             mini.alert("请选择专业");
            return;
            }
             if(classId==null||classId==""){
             mini.alert("请选择班级");
            return;
            }
			datagrid1.load({courseId:courseId,zhuanyeId:zhuanyeId,classId:classId});
        }
        
        function save(){
         	var data = datagrid1.getChanges();
         	for(var i=0;i<data.length;i++){
	         	if(!(data[i].jiaonum==data[i].pingfnum)){
		         	mini.alert("作业未评论完！");
	         		return;
	         	}
         	}
            var json = mini.encode(data);
            
            $.ajax({
                url: "${pageContext.request.contextPath}/teacher/teacherAction_savePingFen.action",
                data: { data: json },
                type: "post",
                success: function (text) {
                	mini.alert("保存成功");
                },
                error: function () {
                	mini.alert("保存失败");
                }
            });
        }
        
	function onActionRenderer(e){
		var record = e.record;
		s = '<a id="fenview"class="mini-button" onclick="view()""> 查看 </a>';
		return s;
	}
	
	//查看分数分布图
	 function view() {
         	
            var row = datagrid1.getSelected();
            if (row.length < 1) {
				mini.alert("请先选择一条！");
				return;
			}
			if (row.length > 1) {
				mini.alert("只能选择一条！");
				return;
			}
            var stuid =row.stuId;
            var courseid=row.courseId;
                mini.open({
                    url: "${pageContext.request.contextPath}/page/viewData/scoreView.jsp",
                    title: "作业成绩分布", 
                    width: 700, height: 400,
                    onload: function () {
                        var iframe = this.getIFrameEl();
                        var data={courseid:courseid,stuid:stuid};
                        iframe.contentWindow.SetData(data);
                    },
                    ondestroy: function (action) {
                        datagrid1.reload();
                    }
                });
        }
     
	 var pfstatus= [{ id: "11", text: '未评分' }, { id: "22", text: '已评分'}];  
        function onPfstatusRenderer(e) {
            for (var i = 0, l = pfstatus.length; i < l; i++) {
                var g = pfstatus[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        
        

	
	</script>
  </body>
</html>
