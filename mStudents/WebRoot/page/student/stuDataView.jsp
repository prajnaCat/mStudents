<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="com.model.StudentInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<link rel="icon" href="../../images/title.ico" type="img/x-ico" />
<link href="../../css/main.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="../../js/jquery-2.2.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/boot.js" type="text/javascript">
	</script>
    <link href="<%=request.getContextPath()%>/css/demo.css" type="text/css"/>
	<script src="<%=request.getContextPath()%>/js/echarts.js"></script>
 <%
     StudentInfo stu = (StudentInfo)session.getAttribute("student");
    String stuid=stu.getStuId();
    String classId=stu.getClassId();
     %>
</head>

<body>
  
  <div class="index-bottom">
  
  	<div class="fg-line"><b></b><span>个人数据特色</span><b></b></div>
    
    <div class="clearfix part">
        <div class="text fl">
            <div class="title">
            	<span class="fl">01</span>
                <p>散点图~记录您作业发布时间点</p>
                <p class="small">SCATTER MAP ~ RECORD TEACHER HOMEWORK RELEASE TIME</p>
            </div>
            <p class="nr">纵轴：发布时间所在的星期。横轴：发布时间的24小时数。红色区域的大小代表着发布作业的次数的大小，红色区域越密集，相互重叠越多，代表着您发布的作业时间点集中在此区域.</p>
        </div>
        <div  id="watch01" class="pic fr"style="width: 700px;height:400px;	margin-right:10px; ">
        	
        </div>
    </div>
    
	<!--------------------------------------分割线-------------------------------------->    
    <div class="h-line"></div>
    
    <div class="clearfix part">
        
        <div  id="watch02" class="pic fl"style="width: 700px;height:400px;margin-left:20px; ">
        		<!-- 示例begin -->
			        	
        	<!-- 示例end -->
        </div>
        <div class="text fr">
            <div class="title">
            	<span class="fl">02</span>
                <p>圆饼图-展示学生个人所有课程的提交作业次数的占比情况</p>
                <p class="small">PIE CHART - SHOWING THE PROPORTION OF THE NUMBER OF HOMEWORK ASSIGNMENTS SUBMITTED BY ALL STUDENTS</p>
            </div>
            <p class="nr">深蓝色：代表比重最大的课程。
次深蓝色：代表比重第二的课程，以此类推。
效果：学生可以通过查看此图，来了解所学习的所有课程，以及各对应每门课程的发布作业次数的占比情况。
</p>
        </div>
        
    </div>
    
	<!--------------------------------------分割线-------------------------------------->    
    <div class="h-line"></div>
    
    <div class="clearfix part">
        <div class="text fl">
            <div class="title">
            	<span class="fl">03</span>
                <p>柱状图-学生个人所有课程的最终成绩</p>
                <p class="small">HISTOGRAM - FINAL RESULTS FOR ALL STUDENTS' COURSES</p>
            </div>
            <p class="nr">纵轴：分数。
横轴：课程名称。
预计效果：把学生所有的课程成绩都展现在此柱状图中，同时把所有成绩的平均线显示出来，可以让学生对自己的成绩水平有清晰的了解。
</p>
        </div>
        <div  id="watch03" class="pic fr"style="width: 700px;height:400px;	margin-right:10px; ">
        		<!-- 示例begin -->
			        	
        	<!-- 示例end -->
        </div>
    </div>
    
    	<!--------------------------------------分割线-------------------------------------->    
    <div class="h-line"></div>
	
    
    <div class="clearfix part">
        
        <div  id="watch04" class="pic fl"style="width: 700px;height:400px;margin-left:20px; ">
        		<!-- 示例begin -->
			        	
        	<!-- 示例end -->
        </div>
        <div class="text fr">
            <div class="title">
            	<span class="fl"></span>
                <p>柱状图-学生每门课程的最值、平均值以及最终成绩</p>
                <p class="small">HISTOGRAM - THE MAXIMUM VALUE, AVERAGE VALUE, AND FINAL GRADE FOR EACH COURSE</p>
            </div>
            <p class="nr">纵轴：分数。
横轴：课程名称。
效果：每门课程都会与四个对应的柱状，柱状分别代表最小值、平均值、成绩、最大值，学生可以根据此图来来预估课程的最终成绩是否和最值、平均值有隐藏的关联，而且能够对学生平时的课程作业的评分情况有整体的分布认识。
</p>
        </div>
    </div>
    
   
	<!--------------------------------------分割线-------------------------------------->    
    <div class=""style="height:30px"></div>
  </div>
  
<footer>
<div class="foot">
    <p class="font14"><a href=""></a>|<a href=""></a>|<a href=""></a>|<a href=""></a>|<a href=""></a>|<a href=""></a></p>
</div>
</footer>

<script  type="text/javascript">
var stuid="'"+<%=stuid%>+"'";
tiJiaoData();
function tiJiaoData(){
	  $.ajax({
	            url:"${pageContext.request.contextPath}/student/dataViewAction_getTiJiaoDataViewByStuid.action?stuId="+stuid,
	            success: function (text) {
	           	  var  data=text.data;
	             /*  console.log("data="+data); */
	              var myChart = echarts.init(document.getElementById('watch01'));
			 	  var hours = ['0','1', '2', '3', '4', '5', '6', '7',
			        '8', '9', '10','11','12','13', '14', '15', '16','17','18','19', '20', '21', '22','23'];
			      var days = ['周日','周一', '周二', '周三',
			        '周四', '周五', '周六'];
			
				data = data.map(function (item) {
				    return [item[1], item[0], item[2]];
				});
				
				option = {
				    title: {
				        text: '提交作业时间分布散点图',
				        link: 'https://github.com/pissang/echarts-next/graphs/punch-card'
				    },
				    legend: {
				        data: ['提交次数'],
				        left: 'right'
				    },
				    tooltip: {
				        position: 'top',
				        formatter: function (params) {
				            return '在' +days[params.value[1]]+' ： '+ hours[params.value[0]] + ' 点钟，提交 '+params.value[2] + ' 份作业';
				        }
				    },
				    grid: {
				        left: 2,
				        bottom: 10,
				        right: 10,
				        containLabel: true
				    },
				    xAxis: {
				        type: 'category',
				        data: hours,
				        boundaryGap: false,
				        splitLine: {
				            show: true,
				            lineStyle: {
				                color: '#999',
				                type: 'dashed'
				            }
				        },
				        axisLine: {
				            show: false
				        }
				    },
				    yAxis: {
				        type: 'category',
				        data: days,
				        axisLine: {
				            show: false
				        }
				    },
				    series: [{
				        name: '提交次数',
				        type: 'scatter',
				        symbolSize: function (val) {
				            return val[2] * 4.2;
				        },
				        data: data,
				        animationDelay: function (idx) {
				            return idx * 5;
				        }
				    }]
				};
		    	myChart.setOption(option);
		            },
		            error: function (text) {
		            fabudata=null;
		            }
		        });
	}
	
//柱状图：历史课程提交作业次数圆饼图

countSubmitData();
function countSubmitData(){
$.ajax({
          url:"${pageContext.request.contextPath}/student/dataViewAction_getCountSubmitData.action?stuId="+stuid,
          success: function (text) { 
          var data=text.data;
       	
         var myChart = echarts.init(document.getElementById('watch02'));
         option = {
      		    tooltip: {
      		        trigger: 'item',
      		        formatter: "{a} <br/>{b} : {c} ({d}%)"
      		    },
      		    series: [{
      		        name: '提交作业情况',
      		        type: 'pie',
      		        radius: '68%',
      		        center: ['50%', '60%'],
      		        clockwise: false,
      		        data:data,
      		        label: {
      		            normal: {
      		                textStyle: {
      		                    color: '#999',
      		                    fontSize: '14px',
      		                }
      		            }
      		        },
      		        labelLine: {
      		            normal: {
      		                show: false
      		            }
      		        },
      		        itemStyle: {
      		            normal: {
      		                borderWidth: 4,
      		                borderColor: '#ffffff',
      		            },
      		            emphasis: {
      		                borderWidth: 0,
      		                shadowBlur: 10,
      		                shadowOffsetX: 0,
      		                shadowColor: 'rgba(0, 0, 0, 0.5)'
      		            }
      		        }
      		    }],
      		    color: [
      		        '#00acee',
      		        '#52cdd5',
      		        '#79d9f1',
      		        '#a7e7ff',
      		        '#c8efff'
      		    ]
      		};
				myChart.setOption(option);
           },
	            error: function (text) {
	             console.log("获取数据失败");
	            }
	        });  
	}
	
countAllResultFeData();	
function countAllResultFeData(){
	  $.ajax({
		     url:"${pageContext.request.contextPath}/student/dataViewAction_getAllResultFeData.action?stuId="+stuid,
		     success: function (text) { 
		     var data=text.data;
			  var myChart =echarts.init(document.getElementById('watch03')); 
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
				};
		        myChart.setOption(option);
		   },
				            error: function (text) {
				            console.log("获取数据失败");
				            }
				        });  
			}
			
//学生提交作业时间分布
getStudentResultDetail();
	function getStudentResultDetail(){
		$.ajax({
          url:"${pageContext.request.contextPath}/student/dataViewAction_getStudentResultDetail.action?stuId="+stuid,
          success: function (text) { 
          var data=text.data;
          var course=data[0];
          var min=data[1];
          var max=data[2];
          var avg=data[3];
          var res=data[4];
          var kong=data[5];
			var myChart = echarts.init(document.getElementById('watch04'));  
			
			colors = ['#000000', '#58595B', '#808285', '#A7A9AC', '#D1D3D4'];
			top_space = 30;
			bar_category_gap = '28%';
			axis_line_color = 'rgb(135,135,135)';
			backgroundColor = 'rgb(255,255,255)';
			axisColor = '#000000';
			labelColor = '#333';
			legend_size = 10;
			dims =['最小值', '平均值', '最终成绩', '最大值'];
			option = {
			    grid: {
			        top: top_space,
			        //width: width,
			        // height: height
			        // left: '0',
			        // height:height,
			    },
			    legend: {
			        bottom: '10',
			        data:dims ,
			        icon: 'square',

			        itemWidth: legend_size,
			        itemHeight: legend_size,
			    },
			    backgroundColor: backgroundColor,
			    tooltip: {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'shadow'
			        }
			    },
			    xAxis: [{
			        type: 'category',
			        data: course,
			        axisLine: {
			            lineStyle: {
			                color: axisColor,
			                width: 4,
			            },
			        },
			        axisLabel: {
			            textStyle: {
			                color: labelColor,
			            }
			        },
			        axisTick:{
			            show: false
			        },
			        z: 10,
			    }],
			    yAxis: [{
			        nameLocation: 'middle',
			        nameGap: 35,
			        nameTextStyle: {
			            color: labelColor,
			        },
			        splitLine: {
			            show: false
			        },
			        axisLabel: {
			            formatter: '{value}分',
			            textStyle: {
			                color: labelColor,
			            }
			        },
			        axisLine: {
			            show: false,
			            lineStyle: {
			                color: axisColor,
			            },
			        },
			        axisTick:{
			            show: false
			        },
			        type: 'value',
			        name: '分数',
			    }, ],
			     "dataZoom": [
			        {
			            "show": true, 
			            "height": 20, 
			            "xAxisIndex": [
			                0
			            ], 
			            bottom:40,
			            "start": 0, 
			            "end": 80
			        }, 
			        {
			            "type": "inside", 
			            "show": true, 
			            "height": 20, 
			            "xAxisIndex": [
			                0
			            ], 
			            "start": 1, 
			            "end": 35
			        }
			    ], 
			    series: [{
			        name: dims[0],
			        type: 'bar',
			        barCategoryGap: bar_category_gap,
			        data: min,
			        itemStyle: {
			            normal: {
			                color: colors[0]
			            }
			        },
			    }, {
			        name: dims[1],
			        type: 'bar',
			        barCategoryGap: bar_category_gap,
			        data: avg,
			        itemStyle: {
			            normal: {
			                color: colors[1]
			            }
			        },
			    }, {
			        name: dims[2],
			        type: 'bar',
			        barCategoryGap: bar_category_gap,
			        data: res,
			        itemStyle: {
			            normal: {
			                color: colors[2]
			            }
			        },
			    }, {
			        name: dims[3],
			        type: 'bar',
			        barCategoryGap: bar_category_gap,
			        data: max,
			        itemStyle: {
			            normal: {
			                color: colors[3]
			            }
			        },
			    }]
			};

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
