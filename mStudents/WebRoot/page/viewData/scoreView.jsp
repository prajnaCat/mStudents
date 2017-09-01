<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%--   <%@page import="com.model.StudentInfo"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script src="<%=request.getContextPath()%>/js/boot.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/css/demo.css" type="text/css"/>
<script src="<%=request.getContextPath()%>/js/echarts.js"></script>
</head>
  
 <body>
 	<div id="fenshu"style="height:350px;width:600px">  
 
	<script type="text/javascript">
	mini.parse();
	var stuid;
	var courseid;
	function SetData(data) {
		//跨页面传递的数据对象，克隆后才可以安全使用
		data = mini.clone(data);
		courseid=data.courseid+"";
		stuid=data.stuid;

     $.ajax({
     url:"${pageContext.request.contextPath}/student/dataViewAction_getResultFenBu.action?stuid="+stuid+"&courseid="+courseid+"",
     success: function (text) { 
     var data=text.data;
	  var myChart =echarts.init(document.getElementById('fenshu')); 
	  option = {
    color: ['#3398DB'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data :data[0],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            // type : 'category',
            // data : ['10','20','30','40'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    series : [
        {
            name:'成绩',
            type:'bar',
            barWidth: '40%',
            data:data[1],
            markLine: {  
                            data: [  
                                {type: 'average', name: '平均值'}  
                            ]  
                        }  
        },
        
    ],
    label: {
            normal: {
                show: true,
                position: 'top',
                formatter: '{c}'
            }
        },
    itemStyle: {
                normal: {
                 
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: 'rgba(17, 168,171, 1)'
                    }, {
                        offset: 1,
                        color: 'rgba(17, 168,171, 0.1)'
                    }]),
                    shadowColor: 'rgba(0, 0, 0, 0.1)',
                    shadowBlur: 10
                }
            }
		}
        myChart.setOption(option);
   },
		            error: function (text) {
		            console.log("获取数据失败");
		            }
		        });  
	}
	
	
	
	</script>
  </body>
</html>
