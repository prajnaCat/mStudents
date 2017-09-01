<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="images/title.ico" type="img/x-ico" />
<link rel="stylesheet" href="css/login.css" />
<title>mStudents登录</title>
</head>
<style>
/* @CHARSET "UTF-8"; */
html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,ruby,section,summary,time,mark,audio,video
{margin:0;padding:0;border:0;font-size:100%;font:inherit;vertical-align:baseline}
article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section
{display:block}body{line-height:1}
ol,ul{list-style:none}
blockquote,q{quotes:none}
blockquote:before,blockquote:after,q:before,q:after{content:'';content:none}
table{border-collapse:collapse;border-spacing:0}


</style>
<body>

<div class="signin-bg"></div>

<div class="signin-index">

	<div style="margin: 170px 0px 30px 50px;">
		<div style="width: 340px; float: left; display: inline-block;">
			<div style="margin-bottom:8px;"><a href=""><IMG style="width: 200px;" src="images/title.png" border="0"></a></div>
			<form  id="loginform" action="${pageContext.request.contextPath}/login_userLogin.action" method="post" >
				<input type="radio" name="role" value="student"/>学生
				<input type="radio" name="role" value="teacher"/>教师
			<!-- 	<input type="radio" name="act" value="admin"/>管理员  -->
				
				<div style="margin-top: 25px;"><input name="userid" class="signin-text" id="username" type="text" placeholder="学号/工号" value=""></div>
				<div style="margin-top: 20px;"><input name="password" class="signin-text" id="password" type="password" placeholder="密码" value=""></div>
				<div style="margin-top: 20px;">
					<input class="button default signin-btn" id="signin_btn"  type="submit" class="submit" value="立即登录"/>      <!-- <SPAN class="button default signin-btn" id="signin_btn" onClick="login()">立即登录</SPAN> -->	
				</div>
			</form>
		</div>
	</div>
	
</div>

</body>
</html>
