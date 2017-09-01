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
 <%
     StudentInfo stu= (StudentInfo)session.getAttribute("student");
    String stuid=stu.getStuId();
    String zhuanyeId=stu.getZhuanyeId();
     %>
</head>
  
 <body>
   <fieldset id="fd2"
				  style="width:90%; margin:20px 0px 20px 0px;padding:0px 3px 3px 3px;position: relative;">
				  <legend>作业总评</legend>
	
    
 <div id="datagrid1" class="mini-datagrid" style="width:1000px;height:400px;margin:20px 30px 20px 30px;" 
        url="${pageContext.request.contextPath}/commonAction_stuDetailByStuId.action" idField="id" 
        allowResize="true" pageSize="30" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true"
        
    >
        <div property="columns">
            <div type="indexcolumn"></div>
     	  <div name="resId"  field="resId" align="center"headerAlign="center" allowSort="true" width="0" ></div>
     	  <div name="courseId"  field="courseId" align="center"headerAlign="center" allowSort="true" width="0" ></div>
            <div name="coursename"  field="coursename" align="center"headerAlign="center" allowSort="true" width="110" >课程
            </div>            
           	<div name="tasknum"  field="tasknum" align="center"headerAlign="center" allowSort="true" width="80" >发布作业次数
            </div>
            <div name="jiaonum"  field="jiaonum" align="center"headerAlign="center" allowSort="true" width="80" >实交作业次数
            </div>
            <div name="pingfnum"  field="pingfnum" align="center"headerAlign="center" allowSort="true" width="80" >评分次数
            </div>
            <div name="maxscore"  field="maxscore" align="center"headerAlign="center" allowSort="true" width="60" >最高分
            </div>   
            <div  name="minscore"  field="minscore" align="center"headerAlign="center" allowSort="true" width="60" >最低分
            </div>   
            <div  name="pjscore"  field="pjscore" align="center"headerAlign="center" allowSort="true" width="60" >平均分
            </div>
              <div  name="fangcha"  field="fangcha" align="center"headerAlign="center" allowSort="true" width="60" >方差
            </div>
            <div name="action" width="120" headerAlign="center" align="center" renderer="onActionRenderer">查看分数分布图
            </div> 
             <div  name="pfstatus"  field="pfstatus" align="center"headerAlign="center" allowSort="true" width="5.5%"renderer="onPfstatusRenderer" >评分状态
            </div>
            <div  name="resfen"  field="resfen" align="center"headerAlign="center" allowSort="true" width="80" >最终成绩
             <input property="editor" class="mini-textbox" style="width:100%;" mixWidth="60" />
            </div>                        
        </div>
    </div>
    </div>
				  
	</fieldset>
	<script type="text/javascript">
	var stuid="'"+<%=stuid%>+"'";
	mini.parse();
	var grid=mini.get("datagrid1");
	grid.load({stuid:stuid});
	
	grid.on("drawcell",function (e) {
		var grid = e.sender;
		var record = e.record;
         if(e.field=="jiaonum"&&(record.jiaonum!=record.tasknum)){
         e.cellStyle = "background:red";
        }
        if(e.field=="pingfnum"&&(record.jiaonum!=record.pingfnum)){
         e.cellStyle = "background:orange";
        }
        if(e.field=="pfstatus"&&(record.pfstatus!="22")){
        e.cellStyle = "background:#D1D1D1";
        }

    });
	
	 var pfstatus= [{ id: "11", text: '未评分' }, { id: "22", text: '已评分'}];  
        function onPfstatusRenderer(e) {
            for (var i = 0, l = pfstatus.length; i < l; i++) {
                var g = pfstatus[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        
        
        
        function onActionRenderer(e){
		var record = e.record;
		s = '<a id="fenview"class="mini-button" onclick="view()"> 查看 </a>';
		return s;
	}
	
	//查看分数分布图
	 function view() {
         	
            var row = grid.getSelected();
            if (row.length < 1) {
				mini.alert("请先选择一条！");
				return;
			}
			if (row.length > 1) {
				mini.alert("只能选择一条！");
				return;
			}
            var courseid =row.courseId;
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
                        grid.reload();
                    }
                });
        }
	</script>
  </body>
</html>
