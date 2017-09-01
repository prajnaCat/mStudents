<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="com.model.TeacherInfo"%>
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
  TeacherInfo tea= (TeacherInfo)session.getAttribute("teacher");
 String teaid=tea.getTeaId();
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
                <p>圆饼图-展示教师个人担任课程的发布作业次数的占比情况</p>
                <p class="small">PIE CHART - SHOWS THE PROPORTION OF THE NUMBER OF TEACHERS AS THE COURSE OF THE RELEASE OF THE WORK</p>
            </div>
            <p class="nr">深蓝色：代表比重最大的课程。
次深蓝色：代表比重第二的课程，以此类推。
效果：教师可以通过查看此图，来了解所担任的所有课程，以及各对应每门课程的发布作业次数的占比情况。
</p>
        </div>
        
    </div>
    
	<!--------------------------------------分割线-------------------------------------->    
    <div class="h-line"></div>
    
    <div class="clearfix part">
        <div class="text fl">
            <div class="title">
            	<span class="fl">03</span>
                <p>柱状图-作业的提交累计情况</p>
                <p class="small">HISTOGRAM - JOB SUBMISSION CUMULATIVE</p>
            </div>
            <p class="nr">纵轴：作业简称。
横轴：提交人数。
预计效果：红色柱状代表未提交人数，深蓝色代表总人数，浅蓝色代表已提交人数。教师可以通过此每次作业的柱状大小来了解提交情况
。</p>
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
                <p>柱状图混搭圆饼图-动静结合展示每月每天教师验收作业次数分布</p>
                <p class="small">BAR CHART MASHUP PIE CHART - DYNAMIC AND COMBINED WITH THE NUMBER OF TEACHERS PER DAY TO SHOW THE NUMBER OF CHECKS AND VISITS</p>
            </div>
            <p class="nr">圆饼图：展示教师在每月份验收作业次数的占比情况。
            			 动态柱状图：用来展示每月份每天的教师作业验收次数分布。
            			 这种结合，能让我们清晰地了解每月每天的数据情况。在应对大型、密集数据时，能够轻松让数据可视化。</p>
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
var teaid="'"+<%=teaid%>+"'";  
//页面加载事件	
$(document).ready(function(){
	getFaBuDataViewByTeaid();

});
     
//散点图：老师发布作业时间分布图
function getFaBuDataViewByTeaid(){
  $.ajax({
            url:"${pageContext.request.contextPath}/student/dataViewAction_getFaBuDataViewByTeaid.action?teaId="+teaid,
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
			        text: '发布任务分布散点图',
			        link: 'https://github.com/pissang/echarts-next/graphs/punch-card'
			    },
			    legend: {
			        data: ['作业数量'],
			        left: 'right'
			    },
			    tooltip: {
			        position: 'top',
			        formatter: function (params) {
			            return '在' +days[params.value[1]]+' ： '+ hours[params.value[0]] + ' 点钟，发布 '+params.value[2] + ' 份作业';
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
			        name: '作业数量',
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

//圆饼图：根据教师ID查询次教师历史课程发布作业次数圆饼图

getCountFaBuDataByTeaid();
function getCountFaBuDataByTeaid(){
$.ajax({
          url:"${pageContext.request.contextPath}/student/dataViewAction_getCountFaBuDataByTeaid.action?teaId="+teaid,
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
	
	
countTaskDataByTeaid();
function countTaskDataByTeaid(){
$.ajax({
          url:"${pageContext.request.contextPath}/student/dataViewAction_countTaskDataByTeaid.action?teaId="+teaid,
          success: function (text) { 
          var data=text.data;	
			var myChart = echarts.init(document.getElementById('watch03'));	
			OPTION = {
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    legend: {
				        data:['已提交', '总数', '未提交']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            saveAsImage : {show: true}
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
				            type : 'value'
				        }
				    ],
				    yAxis : [
				        {
				            type : 'category',
				            axisTick : {show: false},
				            data : data[0]
				        }
				    ],
				    series : [
				        {
				            name:'总数',
				            type:'bar',
				            stack: '总量',
				            label: {
				                normal: {
				                    show: true
				                }
				            },
				            data:data[1]
				        },
				        {
				            name:'已提交',
				            type:'bar',
				            stack: '总量',
				            label: {
				                normal: {
				                    show: true,
				                    position: 'left'
				                }
				            },
				            data:data[2]
				        }
				    ]
				};
				var a = OPTION.series[0].data;
				var b = OPTION.series[1].data;
				var sum = [];
				for (var i=0; i<a.length; i++) {
				    sum[i] = a[i] + b[i]
				}

				OPTION.series.unshift({
				            name:'未提交',
				            type:'bar',
				            label: {
				                normal: {
				                    show: true,
				                    position: 'inside'
				                }
				            },
				            data: sum
				        });
				        
				myChart.setOption(OPTION); 
		          },
		          error: function (text) {
		           console.log("获取数据失败");
		          }
		      });  
		}

function dataFormatter(obj) {
    var pList = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31'];
    var temp;
    for (var month = 1; month <= 12; month++) {
        temp = obj[month.toString()];
        obj[month + 'sum'] = temp[0];
        for (var i = 1, len = temp.length; i < len; i++) {
            obj[month.toString()][i] = {
                name : pList[i],
                value : temp[i]
            }
        }
        obj[month.toString()].shift()
        
    }
    return obj;
}		
		
//教师评分作业时间分布
countPingfenTimeFenBuData();
 	function countPingfenTimeFenBuData(){
  		$.ajax({
            url:"${pageContext.request.contextPath}/student/dataViewAction_countPingfenTimeFenBuData.action?teaId="+teaid,
            success: function (text) { 
			var myChart = echarts.init(document.getElementById('watch04'));  
			console.log("data="+text);
			dataMap = {};
			dataMap.dataMonth = dataFormatter(text);
			option = {
			    baseOption: {
			        backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
			        offset: 0,
			        color: '#f7f8fa'
			    }, {
			        offset: 1,
			        color: '#cdd0d5'
			    }]),
			        timeline: {
			            // y: 0,
			            axisType: 'category',
			            // realtime: false,
			            // loop: false,
			            autoPlay: true,
			            // currentIndex: 2,
			            playInterval: 1500,
			            // controlStyle: {
			            //     position: 'left'
			            // },
			            data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
			            label: {
			                formatter : function(s) {
			                    return s + "月"
			                }
			            }
			        },
			        title: {
			            text: '验收作业时间分布'
			        },
			        tooltip: {},
			        
			        calculable : true,
			        grid: {
			            top: 80,
			            bottom: 100
			        },
			        xAxis: [
			            {
			                name : "天",
			                'type':'category',
			                'axisLabel':{'interval':0},
			                'data':['1', '\n2', '3', '\n4', '5', '\n6', '7', '\n8', '9', '\n10', '11', '\n12', '13', '\n14', '15', '\n16', '17', '\n18', '19', '\n20', '21', '\n22', '23', '\n24', '25', '\n26', '27', '\n28', '29', '\n30', '31'],
			                splitLine: {show: false}
			            }
			        ],
			        yAxis: [
			            {
			                type: 'value',
			                name: '次数',
			                // max: 53500
			                max : 80
			            }
			        ],
			        series: [
			            {name: 'days', type: 'bar'},
			            {
			                name: '每月验收次数占比',
			                type: 'pie',
			                color: ['#A5DEE4', '#81C7D4', '#24936E', '#5DAC81','#A8D8B9',"#F596AA","#E87A90","#F4A7B9","#DB8E71","#FB9966","#E9A368","#58B2DC"],
			                center: ['75%', '20%'],
			                radius: [20, '28%'],
			                roseType: 'area',
			                data:[{name: "1月",value : dataMap.dataMonth["1sum"]},
			                    {name: "2月",value : dataMap.dataMonth["2sum"]},
			                    {name: "3月",value : dataMap.dataMonth["3sum"]},
			                    {name: "4月",value : dataMap.dataMonth["4sum"]},
			                    {name: "5月",value : dataMap.dataMonth["5sum"]},
			                    {name: "6月",value : dataMap.dataMonth["6sum"]},
			                    {name: "7月",value : dataMap.dataMonth["7sum"]},
			                    {name: "8月",value : dataMap.dataMonth["8sum"]},
			                    {name: "9月",value : dataMap.dataMonth["9sum"]},
			                    {name: "10月",value : dataMap.dataMonth["10sum"]},
			                    {name: "11月",value : dataMap.dataMonth["11sum"]},
			                    {name: "12月",value : dataMap.dataMonth["12sum"]},
			                    ]
			            }
			            
			        ]
			    },
			    options: [
			        {
			
			
			            title: {subtext: '1月验收次数分布-2017'},
			            series: [
			                {data: dataMap.dataMonth['1'],itemStyle:{
			                    normal:{
			                        color: "#A5DEE4"
			                    }
			                },},
			                
			            ]
			        },
			        {
			            
			            title : {subtext: '2月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['2'],itemStyle:{
			                    normal:{
			                        color: "#81C7D4"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '3月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['3'],itemStyle:{
			                    normal:{
			                        color: "#24936E"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '4月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['4'],itemStyle:{
			                    normal:{
			                        color: "#5DAC81"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '5月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['5'],itemStyle:{
			                    normal:{
			                        color: "#A8D8B9"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '6月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['6'],itemStyle:{
			                    normal:{
			                        color: "#F596AA"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '7月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['7'],itemStyle:{
			                    normal:{
			                        color: "#E87A90"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '8月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['8'],itemStyle:{
			                    normal:{
			                        color: "#F4A7B9"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '9月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['9'],itemStyle:{
			                    normal:{
			                        color: "#DB8E71"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '10月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['10'],itemStyle:{
			                    normal:{
			                        color: "#FB9966"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '11月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['11'],itemStyle:{
			                    normal:{
			                        color: "#E9A368"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '12月验收次数分布-2017'},
			            series : [{data: dataMap.dataMonth['12'],itemStyle:{
			                    normal:{
			                        color: "#58B2DC"
			                    }
			                },},]
			        },
			        
			    ]
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
