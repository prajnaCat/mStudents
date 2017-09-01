<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.model.StudentInfo"%>
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
     StudentInfo stu= (StudentInfo)session.getAttribute("student");
    String stuid=stu.getStuId();
    String zhuanyeId=stu.getZhuanyeId();
     %>
</head>
  
  <body>
   <fieldset id="fd2"
				  style="width:90%; margin:-14px 0px 30px;padding:0px 3px 3px 3px;position: relative;">
				  <legend>查看作业</legend>
	<div style="width:1000px;margin:20px 30px 0px 30px;">
	        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
	            <table style="width:100%;">
	              <tr>
	                    <td style="white-space:nowrap;">
	                       <input id="coursekey" class="mini-combobox" emptyText="请选择课程" style="width:150px;"
	                         textField="value" valueField="code"  showNullItem="true" url=""/>      
	                        <a class="mini-button" onclick="search()">查询</a>
	                    </td>
	                </tr>
	            </table>           
	        </div>
    </div>
    
 <div id="datagrid1" class="mini-datagrid" style="width:1000px;height:400px;margin:0px 30px 30px 30px;" 
        url="${pageContext.request.contextPath}/commonAction_queryStudentSubDetail.action" idField="id" 
        allowResize="true" pageSize="20" 
        allowCellEdit="true" allowCellSelect="true" multiSelect="true" 
        editNextOnEnterKey="true"  editNextRowCell="true"
    >
        <div property="columns">
            <div type="indexcolumn"></div>
          <!--   <div type="checkcolumn"></div> -->
          <div name="subId"  field="subId" align="center"headerAlign="center" allowSort="true" width="0" >
            </div>
              <div name="coursename"  field="coursename" align="center"headerAlign="center" allowSort="true" width="9.2%" >课程
            </div>
            <div name="taskname"  field="taskname" align="center"headerAlign="center" allowSort="true" width="12%" >作业简称
            </div>      
            <div  name="teaname"  field="teaname" align="center"headerAlign="center" allowSort="true" width="7.4%" >参考文档
            </div>
            <div name="teadocname" field="teadocname" width="0" headerAlign="center" align="center" ></div>
            <div name="action" width="8.4%" headerAlign="center" align="center" renderer="onActionRenderer00">参考文档下载
            </div>
            <!--  <div name="fbtime" field="fbtime" width="120" allowSort="true"align="center" headerAlign="center"dateFormat="yyyy-MM-dd ">发布日期
            </div>     -->   
            <div name="titime" field="titime" width="11.1%" allowSort="true"align="center" headerAlign="center"dateFormat="yyyy-MM-dd HH:mm">提交日期
            </div>    
           <div name="jiezhiTime" field="jiezhiTime" width="11.1%" allowSort="true"align="center"headerAlign="center" dateFormat="yyyy-MM-dd HH:mm">截止日期
            </div> 
            <div  name="tjstatus"  field="tjstatus" align="center"headerAlign="center" 
            allowSort="true" width="7.4%" renderer="onGenderRenderer">作业状态
            </div>   
            <div  name="name"  field="name" align="center"headerAlign="center" allowSort="true" width="18.5%" >作业文档
             <input property="editor" class="mini-textbox" id="dname" style="width:100%;" minWidth="16%" /> 
            </div>
            <div name="docname" field="docname" width="0" headerAlign="center" align="center" ></div>
            <div name="action" width="7.4%" headerAlign="center" align="center" renderer="onActionRenderer">文档下载
            
            </div> 
             <div name="score"  field="score"align="center" headerAlign="center" allowSort="true" width="6.4%" >评分
            </div>                          
        </div>
    </div>
    </div>
				  
	</fieldset>
	<script type="text/javascript">
	
	mini.parse();
	var coursekey=mini.get("coursekey");
	var stuId=""+<%=stuid %>+"";
	var datagrid1 = mini.get("datagrid1");
	
	datagrid1.on("drawcell",function (e) {
		var grid = e.sender;
		var record = e.record;
		if(e.field=="tjstatus"&&(record.tjstatus!="22")){
		e.cellStyle = "background:#D1D1D1";
		} 
        if(e.field=="titime"&&(record.titime>record.jiezhiTime)){
        	e.cellStyle = "background:#F0E68C";
        } 

    });
	

	 window.onload=function(){
     var url="${pageContext.request.contextPath}/teacher/teacherAction_queryCourseByStuid.action?stuid="+stuId;
     coursekey.setUrl(url);

	}
     
		search();
	 function search() {
            var courseId = coursekey.getValue();
			datagrid1.load({courseId:courseId,stuId:stuId});
        }
        
        function save(){
         	var data = datagrid1.getChanges();
         	console.log("123="+data);
            var json = mini.encode(data);
            
            datagrid1.loading("保存中，请稍后......");
            $.ajax({
                url: "${pageContext.request.contextPath}/commonAction_saveSubmitScore.action",
                data: { data: json },
                type: "post",
                success: function (text) {
                	mini.alert("保存成功");
                    datagrid1.reload();
                },
                error: function () {
                	mini.alert("保存失败");
                }
            });
        
        
        }
        
	function onActionRenderer(e){
		var grid = e.sender;
		var record = e.record;
		var dname=record.name;
	  var  docname=record.docname;
		var url='${pageContext.request.contextPath}/upload/student/yongjiu/'+docname;
		var s="";
		if(dname!=null&&dname!=""){
		s = '<a id="filed" download='+dname+' href='+url+'> 下 载 </a>';
		}
		return s;
	}

	
	function onActionRenderer00(e){
		var grid = e.sender;
		var record = e.record;
		var teaname=record.teaname;
	   var teadocname=record.teadocname;
		var url='${pageContext.request.contextPath}/upload/teacher/yongjiu/'+teadocname;
		var s="";
		if(teadocname!=null&&teadocname!=""){
		s = '<a id="filed" download='+teaname+' href='+url+'> 下 载 </a>';
		}
		return s;
	}

     
	 var tjstatus= [{ id: "00", text: '未提交' },{ id: "11", text: '未评分' }, { id: "22", text: '已评分'}];  
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
