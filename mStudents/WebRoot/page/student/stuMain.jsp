<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.model.StudentInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>
<link rel="icon" href="../../images/title.ico" type="img/x-ico" />
<link href="../../css/teaMainStyle.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="../../js/jquery-1.7.min.js"></script>
<script src="<%=request.getContextPath()%>/js/echarts.js"></script>
 <%
     StudentInfo stu= (StudentInfo)session.getAttribute("student");
    String stuid=stu.getStuId();
    String name=stu.getStuName();
    String cla=stu.getClassId()+"班";
     %>
<style type="text/css">
.info{
width:200px;
height:60px;
float:right;
line-height: 28px;
margin-right: -200px;
}
.info p{
color:#201cd8;
font-family: "微软雅黑";
font-size: medium;
}

</style>


</head>

<body>

<header>
<div class="head">
	<div class="wrapper">
        <div class="logo"><img src="../../images/logo.jpg"></div>
        <div class="menu">
            <a href="javascript:void(0)" onclick="changPage(4)" id="menu4">个人首页</a>
            <span>|</span>
            <a  href="javascript:void(0)" onclick="changPage(1)" id="menu1">提交作业</a>
            <span>|</span>
            <a href="javascript:void(0)" onclick="changPage(3)" id="menu3">查看作业</a>
            <span>|</span>
            <a href="javascript:void(0)" onclick="changPage(2)" id="menu2">mEstudent</a>
            <span>|</span>
            
        </div>
        <div class="info">
        <p>| 学号：<%=stuid %> </p>
        <p>| <%=name %>同学 欢迎你</p>
        </div>
    </div>
</div>
</header>



 <div class="status" id="status">
  	<span class="on"></span>
    <span></span>
    <span></span>
  </div>
  
  
  <div class="index-bottom" style="height:617px;">
  <iframe id="iframes" src="myStuView.jsp" style="height:99% ;width:99%; " frameborder="no"></iframe>

  </div>
   <div class="index-bottom" style="height:8px;">
  </div>
<footer>
<div class="foot">
    <p class="font14"><a href=""></a>|<a href=""></a>|<a href=""></a>|<a href=""></a>|<a href=""></a>|<a href=""></a></p>
</div>
</footer>



</body>
<script type="text/javascript">
function  changPage(str){
	if(str=='1'){
		document.getElementById("iframes").src="tiJiaoTask.jsp";
	}else if(str=='2'){
		document.getElementById("iframes").src="mEstudent.jsp";
	}else if(str=='3'){
	document.getElementById("iframes").src="chaKanTask.jsp";
	}else if(str=='4'){
	document.getElementById("iframes").src="myStuView.jsp";
	}
}

</script>
</html>
