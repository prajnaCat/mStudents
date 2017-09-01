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
     StudentInfo stu = (StudentInfo)session.getAttribute("student");
    String stuid=stu.getStuId();
    String classId=stu.getClassId();
     %>
   
</head>
  
  <body>
  <div style="width:100%;height:120%;margin-top:-13px">
  <div style="width:100%;height:50%;">
		<div id="firstView"
			  style="width:50%;height:260px;float:left;">
			  	
		</div>
		<div id="secondView"
			  style="width:50%;height:260px;float:right">
			  	
		</div>
</div>

<div style="width:100%;height:50%">
		<div id="thidView"
			  style="width:50%;height:260px;float:left">
			  	
		</div>
		<div id="fourthView"
			  style="width:50%;height:260px;float:right">
			  	
		</div>
</div>
</div>
<script type="text/javascript">
var stuid="'"+<%=stuid%>+"'";


firstView()
function firstView(){
		  $.ajax({
            url:"${pageContext.request.contextPath}/student/dataViewAction_getFirstNianData.action?stuId="+stuid,
            success: function (text) {
            	var data=text.data;
            	var myChart = echarts.init(document.getElementById('firstView'));
            	option = {
            		    title: {
            		    },
            		    tooltip: {},
            		    legend: {
            		        data: ['第一学年']
            		    },
            		    radar: {
            		        // shape: 'circle',
            		        indicator: data[0]
            		    },
            		    series: [{
            		        name: '',
            		        type: 'radar',
            		        // areaStyle: {normal: {}},
            		        data :data[1]
            		    }]
            		};
            	myChart.setOption(option);
	            },
	            error: function (text) {
	            fabudata=null;
	            }
	        });
		}
SecondView();
function SecondView(){
	  $.ajax({
      url:"${pageContext.request.contextPath}/student/dataViewAction_getSecondNianData.action?stuId="+stuid,
      success: function (text) {
      	var data=text.data;
      	var secondViewChart = echarts.init(document.getElementById('secondView'));
      	option = {
      		    title: {
      		    },
      		    tooltip: {},
      		    legend: {
      		        data: [ '第二学年']
      		    },
      		    radar: {
      		        // shape: 'circle',
      		        indicator:data[0]
      		    },
      		    series: [{
      		        name: '预算 vs 开销（Budget vs spending）',
      		        type: 'radar',
      		        // areaStyle: {normal: {}},
      		        data : data[1]
      		    }]
      		};
      	secondViewChart.setOption(option);
		
          },
          error: function (text) {
          fabudata=null;
          }
      });
	}
ThidView();
function ThidView(){
	  $.ajax({
    url:"${pageContext.request.contextPath}/student/dataViewAction_getThidNianData.action?stuId="+stuid,
    success: function (text) {
    	var data=text.data;
    	var thidViewChart = echarts.init(document.getElementById('thidView'));
    	option = {
    		    title: {
    		    },
    		    tooltip: {},
    		    legend: {
    		        data: [ '第三学年']
    		    },
    		    radar: {
    		        // shape: 'circle',
    		        indicator:data[0]
    		    },
    		    series: [{
    		        name: '预算 vs 开销（Budget vs spending）',
    		        type: 'radar',
    		        // areaStyle: {normal: {}},
    		        data :data[1]
    		    }]
    		};
    	thidViewChart.setOption(option);
        },
        error: function (text) {
        fabudata=null;
        }
    });
	}


FourthView();
function FourthView(){
	  $.ajax({
    url:"${pageContext.request.contextPath}/student/dataViewAction_getFourthNianData.action?stuId="+stuid,
    success: function (text) {
    	var data=text.data;
    	var fourthViewChart = echarts.init(document.getElementById('fourthView'));
    	option = {
    		    title: {
    		    },
    		    tooltip: {},
    		    legend: {
    		        data: ['第四学年']
    		    },
    		    radar: {
    		        // shape: 'circle',
    		        indicator:data[0]
    		    },
    		    series: [{
    		        name: '预算 vs 开销（Budget vs spending）',
    		        type: 'radar',
    		        // areaStyle: {normal: {}},
    		        data : data[1]
    		    }]
    		};
    	fourthViewChart.setOption(option);
        },
        error: function (text) {
        fabudata=null;
        }
    });
	}
	


</script>
  </body>
</html>
