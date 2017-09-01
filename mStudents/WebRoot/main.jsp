<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<link rel="icon" href="images/title.ico" type="img/x-ico" />
<link href="css/main.css" type="text/css" rel="stylesheet" media="all" />
<!--[if ie]><link rel="stylesheet" type="text/css" href="images/index_ie.css" media="all" /><![endif]-->
<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
<script src="js/echarts.js"></script>
	<script src="<%=request.getContextPath()%>/js/boot.js" type="text/javascript">
	</script>
    <link href="<%=request.getContextPath()%>/css/demo.css" type="text/css"/>
	<script src="<%=request.getContextPath()%>/js/echarts.js"></script>
  <%
  String role="'"+session.getAttribute("role").toString()+"'";
     %>
</head>

<body>

<header>
<div class="head">
	<div class="wrapper">
        <div class="logo"><img src="images/logo.jpg"></div>
        <div id="daohangmenu" class="menu">
            
        </div>
    </div>
</div>
</header>


<!-- <div class="banner_area" id="banner_list">
  	
  </div> -->
 <div class="status" id="status">
  	<span class="on"></span>
    <span></span>
    <span></span>
  </div> 
  
  
  <div class="index-bottom">
  
  	<div class="fg-line"><b></b><span>mS数据特色</span><b></b></div>
    
    <div class="clearfix part">
        <div class="text fl">
            <div class="title">
            	<span class="fl">01</span>
                <p>散点图~记录老师作业发布时间点</p>
                <p class="small">SCATTER MAP ~ RECORD TEACHER HOMEWORK RELEASE TIME</p>
            </div>
            <p class="nr">纵轴：发布时间所在的星期数。
						     横轴：发布时间所在的24小时数。
						     效果：红色区域的大小代表着发布作业的次数的大小，红色区域越密集，相互重叠越多，代表着教师发布作业的时间点越集中在此区域。如果某一区域的红色圆圈重叠越多、分布越密集，那么在此区域坐标所代表的（周Y的X时）~（周Y的X时）时间段内，教师经常发布作业。
</p>
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
                <p>柱状图~学生作业提交累计</p>
                <p class="small">HISTOGRAM ~ CUMULATIVE WORK ON THE SITUATION</p>
            </div>
            <p class="nr">纵轴：所属于（最新发布作业的前十）作业的专业。
					                 横轴：人数。
效果：横坐标的原点线(x=0)为柱状图的分割轴，左右柱状使用不同的颜色，加以区分。(x=0)右边的柱状长度代表作业预计上交人数，也就是属于此专业的总人数，(x=0)左边的柱状长度代表着已提交作业的人数，用负数表示，未提交人数越多，左右柱状长度相差越多。通过此柱状图了解对应作业的提交情况，且能够起到显示作业之间提交情况的对比效果的作用。
</p>
        </div>
        
    </div>
    
	<!--------------------------------------分割线-------------------------------------->    
    <div class="h-line"></div>
    
    <div class="clearfix part">
        <div class="text fl">
            <div class="title">
            	<span class="fl">03</span>
                <p>折线图~历次作业评分最值、平均值走势</p>
                <p class="small">THE MOST VALUE AND THE AVERAGE VALUE OF THE PREVIOUS WORK</p>
            </div>
            <p class="nr">纵轴：分数(/分)。
  						 横轴：学生学号。
  						 效果：通过最大最小值的柱状堆砌和平均分、最终成绩的折线趋势，来显示最大最小之和和平均分是否对教师评定的最终成绩有关联，
  						 如果平均分折线和最终成绩折线大致上有相似的走势，那么平均分对最终成绩有一定的影响，如果最大最小值堆砌的高度是和最终成绩的高低有同上同下的关联，那么最大最小值对最终成绩的高低是有影响的。</p>
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
                <p>柱状图混搭圆饼图~每月每天学生提交作业次数分布</p>
                <p class="small">HISTOGRAM MIX ROUND PIE CHART</p>
            </div>
            <p class="nr">柱状图纵轴：次数(/次)。
柱状图横轴：时间所在日。
柱状图时间轴：月份。
圆饼图的不同颜色：月份。
效果：圆饼图使用不同的颜色来代表不同月份学生提交作业次数的大小对比情况。柱状图能够根据时间的月份来显示所在月份的每天的提交作业次数的累计。这种柱状图和圆饼图混搭的效果，能够通过圆饼图上对数据有整体的把控，再通过柱状图对数据有局部细微的认知。
</p>
        </div>
    </div>
    
        	<!--------------------------------------分割线-------------------------------------->    
    <div class="h-line"></div>
    
    
    <div class="clearfix part">
        <div class="text fl">
            <div class="title">
            	<span class="fl">05</span>
                <p>华北水利水电大学-院系专业关系图</p>
                <p class="small">UNIVERSITY OF NORTH CHINA WATER CONSERVANCY AND HYDROPOWER UNIVERSITY PROFESSIONAL RELATIONSHIP CHART</p>
            </div>
            <p class="nr">圆点大小：代表着不同的层级。
   相同层级的不同颜色：代表着相同层级的不同院系/专业。
	预计效果：
	层次分明地显示华北水利水电大学的院系关系，可移动过鼠标对圆圈的不同操作，可以显示华北水利水电大学下的院系，以及院系所含的专业。此图让复杂的院系关系变得层级分明。
</p>
        </div>
        <div  id="watch05" class="pic fr"style="width: 700px;height:400px;	margin-right:10px; ">
        		<!-- 示例begin -->
			        	
        	<!-- 示例end -->
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
	var role=<%=role %>;
	jiazai();
	function jiazai(){
		var str='';
			if(role!=null&&"student"==role){
			str+= ' <span>|</span>'+
			'<a href="page/student/stuMain.jsp"target="_blank" id="menu1">我是学生</a>'+
		           ' <span>|</span>'+
		           '<a href="page/student/stuDataView.jsp"target="_blank" id="menu4">个人数据总览</a>'+
		           ' <span>|</span>';
			}else if(role!=null&&"teacher"==role){
			str+= ' <span>|</span>'+
			'<a href="page/teacher/teaMain.jsp"target="_blank" id="menu2">我是老师</a>'+
		           ' <span>|</span>'+
		           '<a href="page/teacher/teaDataView.jsp"target="_blank" id="menu4">个人数据总览</a>'+
		           ' <span>|</span>';
			}else{
			alert("请登录");
			}
		document.getElementById('daohangmenu').innerHTML = str; 
	
	}
//页面加载事件	
$(document).ready(function(){
     fabuData();

})
     
//散点图：老师发布作业时间分布图
function fabuData(){
  $.ajax({
            url:"${pageContext.request.contextPath}/student/dataViewAction_getAllFaBuDataView.action",
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
//柱状图：作业提交数量累计图

countTaskData();
  function countTaskData(){
  $.ajax({
            url:"${pageContext.request.contextPath}/student/dataViewAction_getAllCountTaskData.action",
            success: function (text) { 
            var data=text.data;
         	var sum=data[1];
         	var tnum=data[2];
           var myChart = echarts.init(document.getElementById('watch02'));
            var xAxisData = data[0];
			var data01 = [];
			var data02 = [];
			for (var i = 9; i < 19; i++) {
			    data01.push(Math.round(Math.random() * 500) + 200);
			    data02.push(Math.round(Math.random() * 600) + 100);
			}
			option = {
			    title: { text: '提交作业累计柱状图', },
			    legend:{data:[,'已提交数量','总人数']},
			    xAxis:{
			        axisLabel:{show:true},
			        splitLine:{show:true},
			        axisLine:{show:true},
			        axisTick:{show:false},
			    },
			    yAxis:[{
			        data: xAxisData,
			        axisLabel:{inside:false,textStyle:{color:'#03a9f4'}},
			        axisLine:{show:true,lineStyle:{color:'rgba(96, 236, 236)',type:'dashed'}},
			        splitLine:{show:false},
			        axisTick:{show:false},
			    }],
			    series: [{
			        name:'总人数',
			        type:'bar',
			        stack: '总量',
			        barWidth: 10,
			        label: {normal:{show: true, position: 'right'}},
			        data:sum,
			        itemStyle: {
			            normal: {
			                color: new echarts.graphic.LinearGradient(0, 0, 1, 1, [{
			                        offset: 0,
			                        color: 'yellow'
			                    }, {
			                        offset: 0.4,
			                        color: 'green'
			                    }, {
			                        offset: 0.8,
			                       color: 'red'
			                    }, {
			                        offset: 1,
			                        color: 'blue'
			                }])
			            }
			        }
			    },{
			        name:'已提交数量',
			        type:'bar',
			        stack: '总量',
			        label: {normal:{show: true, position: 'left'}},
			        data:tnum,
			        itemStyle: {
			            normal: {
			                color: new echarts.graphic.LinearGradient(1, 0, 0, 0, [{
			                        offset: 0,
			                        color: 'transparent'
			                    }, {
			                        offset: 0.4,
			                        color: 'rgba(169, 110, 61, 0.3)'
			                    }, {
			                        offset: 0.8,
			                       color: 'rgba(169, 110, 61, 0.7)'
			                    }, {
			                        offset: 1,
			                        color: 'rgba(169, 110, 61, 1)'
			                }])
			          	  }
			      	  }
			  	  }]
				};
				myChart.setOption(option);
             },
	            error: function (text) {
	             console.log("获取数据失败");
	            }
	        });  
	}
	 countTjnumData();//获取学生结课成绩的最大值和最小值和最后结果
	 function countTjnumData(){
  		$.ajax({
            url:"${pageContext.request.contextPath}/student/dataViewAction_getAllCountTjnumData.action",
            success: function (text) { 
            var data=text.data;
            var stuId=data[0];
            var max=data[1];
            var min=data[2];
            var arg=data[3];
            var res=data[4];
			var myChart = echarts.init(document.getElementById('watch03'));     
			var dataBeast=max;
			var dataBeauty=min;
			var xAxisData=stuId;
			var dataTotal=function(){
			    var data=[];
			    for(var i=0;i<dataBeauty.length;i++){
			        data.push(dataBeauty[i]+dataBeast[i]);
			    }
			    
			    return data;
			}
			console.log(dataTotal());
			option = {
			    color:['#019aba','#7a201f','#11565d'],
			    backgroundColor:'#344b58',
			    title: {
			        text: '同学成绩最大最小值',
			        textStyle: {
			            color:'#fff',
			            fontSize:18,
			            fontWeight:'bold',
			            
			        },
			    },
			    legend:{
			        right:'20%',
			        textStyle: {
			            color: '#666',
			            fontSize: 12,
			        },
			        data:['最大值','最小值','平均分','成绩'],
			     
			    },
			    tooltip:{
			        show:true,
			        trigger: 'axis',
			        axisPointer: {
			            type:'shadow',
			            textStyle: {
			                color: '#fff',
			            }
			        },
			    },
			    toolbox:{
			        show:true,
			        feature: {
			            saveAsImage: {
			                show:true,
			            },
			            restore: {
			                show:true,
			            },
			            dataView: {
			                show:true,
			            },
			            dataZoom: {
			                show:true,
			            },
			            magicType: {
			                show:true,
			            },
			        },
			    },
			    grid:{
			        left:5,
			        right:20,
			        top:80,
			        bottom:50,
			        containLabel:true,
			    },
			    xAxis: {
			      show:true,
			      axisLabel:{
			         interval:0,
			         rotate:-20,
			         margin: 30,
			         textStyle:{
			              color:'#fff',
			              align: 'center'
			         },
			      },
			      axisTick:{
			          alignWithLabel:true,
			          lineStyle:{
			              color:'#ddd',
			          },
			      },
			      data:xAxisData,
			    },
			    yAxis: [
			        {
			            type:'value',
			            name:'( /分)',
			            nameTextStyle:{
			                color:'#ddd',
			            },
			            axisLabel:{
			             textStyle:{
			                  color:'#ddd',
			             },
			            },
			            axisTick:{
			              alignWithLabel:true,
			              lineStyle:{
			                  color:'#ddd',
			              },
			            },
			            splitLine:{
			                show:false,
			            },
			        },
			        {
			            type:'value',
			            name:'',
			            nameTextStyle:{
			                color:'#ddd',
			            },
			            axisLabel:{
			             textStyle:{
			                  color:'#ddd',
			             },
			            },
			            axisTick:{
			              alignWithLabel:true,
			              lineStyle:{
			                  color:'#ddd',
			              },
			            },
			            splitLine:{
			                show:false,
			            },
			        },
			    ],
			    dataZoom: [{
			        show: true,
			        height:20,
			        bottom:10,
			        start: 10,
			        end: 60,
			        handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
			        handleSize: '110%',
			        handleStyle:{color:"#d3dee5",},
			        textStyle:{color:"#fff"}, 
			            borderColor:"#90979c",
			        }, 
			        { type: "inside"}
			    ],
			    series: [
			        {
			            type: 'bar',
			            name:'最大值',
			            stack:'max+min',
			            data:dataBeast,
			            label: {
			                normal: {
			                    show:true,
			                    position: 'insideTop',
			                    offset:[0,20],
			                    textStyle:{
			                       color:'#fff',
			                    },
			                },
			                emphasis: {
			                     textStyle:{
			                       color:'#fff',
			                    }, 
			                },
			            },
			        },
			        {
			            type: 'bar',
			            name:'最小值',
			            stack:'max+min',
			            data:dataBeauty,
			            label: {
			                normal: {
			                    show:true,
			                    position: 'insideTop',
			                    offset:[0,20],
			                    textStyle:{
			                       color:'#fff',
			                    },
			                },
			                emphasis: {
			                   textStyle:{
			                       color:'#fff',
			                    }, 
			                },
			            },
			        },
					{
			            name: '成绩',
			            type: 'line',
			            stack: '总量',
			            symbolSize:10,
			            symbol:'circle',
			            "itemStyle": {
	               			 "normal": {
	                  		  "color": "rgba(252,230,48,1)",
	                  		  "barBorderRadius": 0,
	                  		  "label": {
	                        	"show": true,
	                      	  formatter: function(p) {
	                            return p.value > 0 ? (p.value) : '';
	                      	  }
                   		 	}
                		}
            		},
			            data:res,
			        },
			        {
			            name: '平均分',
			            type: 'line',
			            stack: '总量',
			            symbolSize:10,
			            symbol:'circle',
			            "itemStyle": {
	               			 "normal": {
	                  		  "color": "green",
	                  		  "barBorderRadius": 0,
	                  		  "label": {
	                        	"show": true,
	                      	  formatter: function(p) {
	                            return p.value > 0 ? (p.value) : '';
	                      	  }
                   		 	}
                		}
            		},
			            data:arg,
			        },
			        /* {
			            type: 'line',
			            name:'max+min',
			            yAxisIndex:1,
			            stack:'max+min',
			            data:dataTotal(),
			            label: {
			                normal: {
			                    show:true,
			                    position: 'insideTop',
			                    offset: [0,-30],
			                     textStyle:{
			                       color:'#fff',
			                    }, 
			                },
			                emphasis: {
			                    textStyle:{
			                       color:'#fff',
			                    },  
			                },
			            },
			            symbolSize:8,
			            itemStyle: {
			                    normal: {
			                        barBorderRadius: 0,
			                        label: {
			                            show:false,
			                            position: "top",
			                            formatter: function(p) {
			                                return p.value > 0 ? (p.value) : '';
			                            }
			                        }
			                    }
			                },
			            lineStyle: {
			                    normal: {
			                    color: '#01B3D7',
			                    width: 1,
			                
			                    },
			                },
			        }, */
			    ]
			};     
			myChart.setOption(option);
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
//学生提交作业时间分布
countSumMonthAndDayData();
 	function countSumMonthAndDayData(){
  		$.ajax({
            url:"${pageContext.request.contextPath}/student/dataViewAction_getMonthnumAndDaynum.action",
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
			            text: '提交作业时间分布'
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
			                name: '每月提交次数占比',
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
			
			
			            title: {subtext: '1月提交次数分布-2017'},
			            series: [
			                {data: dataMap.dataMonth['1'],itemStyle:{
			                    normal:{
			                        color: "#A5DEE4"
			                    }
			                },},
			                
			            ]
			        },
			        {
			            
			            title : {subtext: '2月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['2'],itemStyle:{
			                    normal:{
			                        color: "#81C7D4"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '3月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['3'],itemStyle:{
			                    normal:{
			                        color: "#24936E"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '4月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['4'],itemStyle:{
			                    normal:{
			                        color: "#5DAC81"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '5月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['5'],itemStyle:{
			                    normal:{
			                        color: "#A8D8B9"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '6月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['6'],itemStyle:{
			                    normal:{
			                        color: "#F596AA"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '7月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['7'],itemStyle:{
			                    normal:{
			                        color: "#E87A90"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '8月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['8'],itemStyle:{
			                    normal:{
			                        color: "#F4A7B9"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '9月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['9'],itemStyle:{
			                    normal:{
			                        color: "#DB8E71"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '10月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['10'],itemStyle:{
			                    normal:{
			                        color: "#FB9966"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '11月提交次数分布-2017'},
			            series : [{data: dataMap.dataMonth['11'],itemStyle:{
			                    normal:{
			                        color: "#E9A368"
			                    }
			                },},]
			        },
			        {
			            title : {subtext: '12月提交次数分布-2017'},
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
	
	//学校的学院专业关系图
	guanXiTuData()
			function guanXiTuData(){
			var myChart = echarts.init(document.getElementById('watch05')); 
option = {
    backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
        offset: 0,
        color: '#f7f8fa'
    }, {
        offset: 1,
        color: '#cdd0d5'
    }]),
    title: {
        text: "华北水利水电大学数据分析",
        subtext: "各学院专业关系",
        top: "top",
        left: "center"
    },
    tooltip: {},
    legend: [{
        formatter: function(name) {
            return echarts.format.truncateText(name, 40, '14px Microsoft Yahei', '…');
        },
        tooltip: {
            show: true
        },
        selectedMode: 'false',
        bottom: 20,
        data: ['数学与统计学院', '电力学院', '水利学院', '机械学院', '土木与交通学院', '资源与环境学院', '环境与市政工程学院', '信息工程学院', '管理与经济学院', '外国语学院', '建筑学院', '法学与公共管理学院', '国际教育学院', '软件学院', '艺术与设计学院']
    }],
    toolbox: {
        show: true,
        feature: {
            dataView: {
                show: true,
                readOnly: true
            },
            restore: {
                show: true
            },
            saveAsImage: {
                show: true
            }
        }
    },
    animationDuration: 3000,
    animationEasingUpdate: 'quinticInOut',
    series: [{
        name: '华北水利水电大学',
        type: 'graph',
        layout: 'force',

        force: {
            repulsion: 50
        },
        data: [{
            "name": "华北水利水电大学",
            // "x": 0,
            // y: 0,
            "symbolSize": 20,
            "draggable": "true",
            "value": 15

        }, {
            "name": "电力学院",
            "value": 7,
            "symbolSize": 21,
            "category": "电力学院",
            "draggable": "true"
        }, {
            "name": "能源与动力工程(水动)",
            "symbolSize": 3,
            "category": "电力学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "能源与动力工程(热动)",
            "symbolSize": 3,
            "category": "电力学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "电气工程及其自动化",
            "symbolSize": 3,
            "category": "电力学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "自动化",
            "symbolSize": 3,
            "category": "电力学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "电子科学与技术",
            "symbolSize": 3,
            "category": "电力学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "核工程与核技术",
            "symbolSize": 3,
            "category": "电力学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "轨道交通信号与控制",
            "symbolSize": 3,
            "category": "电力学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "水利学院",
            "value": 7,
            "symbolSize": 21,
            "category": "水利学院",
            "draggable": "true"
        }, {
            "name": "有水利水电工程",
            "symbolSize": 3,
            "category": "水利学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "农业水利工程",
            "symbolSize": 3,
            "category": "水利学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "水文与水资源工程",
            "symbolSize": 3,
            "category": "水利学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "港口航道与海岸工程",
            "symbolSize": 3,
            "category": "水利学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "工程管理",
            "symbolSize": 3,
            "category": "水利学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "工程造价",
            "symbolSize": 3,
            "category": "水利学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "水务工程",
            "symbolSize": 3,
            "category": "水利学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "机械学院",
            "value": 4,
            "symbolSize": 12,
            "category": "机械学院",
            "draggable": "true"
        }, {
            "name": "机械设计制造及其自动化",
            "symbolSize": 3,
            "category": "机械学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "材料成型及控制工程",
            "symbolSize": 3,
            "category": "机械学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "交通运输",
            "symbolSize": 3,
            "category": "机械学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "测控技术与仪器",
            "symbolSize": 3,
            "category": "机械学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "土木与交通学院",
            "value": 6,
            "symbolSize": 18,
            "category": "土木与交通学院",
            "draggable": "true"
        }, {
            "name": "土木工程",
            "symbolSize": 3,
            "category": "土木与交通学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "交通工程",
            "symbolSize": 3,
            "category": "土木与交通学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "工程力学",
            "symbolSize": 3,
            "category": "土木与交通学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "无机非金属材料工程",
            "symbolSize": 3,
            "category": "土木与交通学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "资源循环科学与工程",
            "symbolSize": 3,
            "category": "土木与交通学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "建筑环境与能源应用工程",
            "symbolSize": 3,
            "category": "土木与交通学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "道路桥梁与渡河工程",
            "symbolSize": 3,
            "category": "土木与交通学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "资源与环境学院",
            "value": 6,
            "symbolSize": 18,
            "category": "资源与环境学院",
            "draggable": "true"
        }, {
            "name": "地质工程",
            "symbolSize": 3,
            "category": "资源与环境学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "土木工程(岩土及地下建筑方向)",
            "symbolSize": 3,
            "category": "资源与环境学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "资源环境与城乡规划管理",
            "symbolSize": 3,
            "category": "资源与环境学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "地理信息系统",
            "symbolSize": 3,
            "category": "资源与环境学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "测绘工程",
            "symbolSize": 3,
            "category": "资源与环境学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "水土保持与荒漠化防治",
            "symbolSize": 3,
            "category": "资源与环境学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "环境与市政工程学院",
            "value": 5,
            "symbolSize": 15,
            "category": "环境与市政工程学院",
            "draggable": "true"
        }, {
            "name": "给排水科学与工程",
            "symbolSize": 3,
            "category": "环境与市政工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "建筑环境与能源应用",
            "symbolSize": 3,
            "category": "环境与市政工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "环境工程",
            "symbolSize": 3,
            "category": "环境与市政工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "消防工程",
            "symbolSize": 3,
            "category": "环境与市政工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "应用化学",
            "symbolSize": 3,
            "category": "环境与市政工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "信息工程学院",
            "value": 5,
            "symbolSize": 15,
            "category": "信息工程学院",
            "draggable": "true"
        }, {
            "name": "电子信息工程",
            "symbolSize": 3,
            "category": "信息工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "通信工程",
            "symbolSize": 3,
            "category": "信息工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "电子信息科学与技术",
            "symbolSize": 3,
            "category": "信息工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "网络工程",
            "symbolSize": 3,
            "category": "信息工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "土木工程(结构分析)",
            "symbolSize": 3,
            "category": "信息工程学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "管理与经济学院",
            "value": 5,
            "symbolSize": 15,
            "category": "管理与经济学院",
            "draggable": "true"
        }, {
            "name": "会计学",
            "symbolSize": 3,
            "category": "管理与经济学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "市场营销",
            "symbolSize": 3,
            "category": "管理与经济学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "物流与工业工程",
            "symbolSize": 3,
            "category": "管理与经济学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "信息管理",
            "symbolSize": 3,
            "category": "管理与经济学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "经济贸易",
            "symbolSize": 3,
            "category": "管理与经济学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "外国语学院",
            "value": 3,
            "symbolSize": 9,
            "category": "外国语学院",
            "draggable": "true"
        }, {
            "name": "英语",
            "symbolSize": 3,
            "category": "外国语学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "汉语国际教育",
            "symbolSize": 3,
            "category": "外国语学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "俄语",
            "symbolSize": 3,
            "category": "外国语学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "数学与统计学院",
            "value": 5,
            "symbolSize": 15,
            "category": "数学与统计学院",
            "draggable": "true"
        }, {
            "name": "数学与应用数学",
            "symbolSize": 3,
            "category": "数学与统计学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "信息与计算科学",
            "symbolSize": 3,
            "category": "数学与统计学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "统计学",
            "symbolSize": 3,
            "category": "数学与统计学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "应用统计学",
            "symbolSize": 3,
            "category": "数学与统计学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "金融数学",
            "symbolSize": 3,
            "category": "数学与统计学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "建筑学院",
            "value": 3,
            "symbolSize": 9,
            "category": "建筑学院",
            "draggable": "true"
        }, {
            "name": "建筑学专业",
            "symbolSize": 3,
            "category": "建筑学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "城乡规划专业",
            "symbolSize": 3,
            "category": "建筑学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "风景园林专业",
            "symbolSize": 3,
            "category": "建筑学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "法学与公共管理学院",
            "value": 3,
            "symbolSize": 9,
            "category": "法学与公共管理学院",
            "draggable": "true"
        }, {
            "name": "法学",
            "symbolSize": 3,
            "category": "法学与公共管理学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "行政管理",
            "symbolSize": 3,
            "category": "法学与公共管理学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "劳动与社会保障",
            "symbolSize": 3,
            "category": "法学与公共管理学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "国际教育学院",
            "value": 8,
            "symbolSize": 24,
            "category": "国际教育学院",
            "draggable": "true"
        }, {
            "name": "英语专业",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "英语(商务方向)",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "英语(科技英语方向)",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "俄语专业",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "汉语国际教育专业",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "汉语国际教育(东亚地区)",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "英语(工程英语)",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "地质工程(灾害管理)",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "机械设计制造及自动化",
            "symbolSize": 3,
            "category": "国际教育学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "软件学院",
            "value": 3,
            "symbolSize": 9,
            "category": "软件学院",
            "draggable": "true"
        }, {
            "name": "软件工程",
            "symbolSize": 3,
            "category": "软件学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "软件工程(娱乐软件设计方向)",
            "symbolSize": 3,
            "category": "软件学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "软件工程(软件测试方向)",
            "symbolSize": 3,
            "category": "软件学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "艺术与设计学院",
            "value": 3,
            "symbolSize": 9,
            "category": "艺术与设计学院",
            "draggable": "true"
        }, {
            "name": "环境设计",
            "symbolSize": 3,
            "category": "艺术与设计学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "视觉传达设计",
            "symbolSize": 3,
            "category": "艺术与设计学院",
            "draggable": "true",
            "value": 1
        }, {
            "name": "公共艺术设计",
            "symbolSize": 3,
            "category": "艺术与设计学院",
            "draggable": "true",
            "value": 1
        }],
        links: [{
                "source": "华北水利水电大学",
                "target": "电力学院"
            }, {
                "source": "电力学院",
                "target": "能源与动力工程(水动)"
            }, {
                "source": "电力学院",
                "target": "能源与动力工程(热动)"
            }, {
                "source": "电力学院",
                "target": "电气工程及其自动化"
            }, {
                "source": "电力学院",
                "target": "自动化"
            }, {
                "source": "电力学院",
                "target": "电子科学与技术"
            }, {
                "source": "电力学院",
                "target": "核工程与核技术"
            }, {
                "source": "电力学院",
                "target": "轨道交通信号与控制"
            }, {
                "source": "华北水利水电大学",
                "target": "水利学院"
            }, {
                "source": "水利学院",
                "target": "有水利水电工程"
            }, {
                "source": "水利学院",
                "target": "农业水利工程"
            }, {
                "source": "水利学院",
                "target": "水文与水资源工程"
            }, {
                "source": "水利学院",
                "target": "港口航道与海岸工程"
            }, {
                "source": "水利学院",
                "target": "工程管理"
            }, {
                "source": "水利学院",
                "target": "工程造价"
            }, {
                "source": "水利学院",
                "target": "水务工程"
            }, {
                "source": "华北水利水电大学",
                "target": "机械学院"
            }, {
                "source": "机械学院",
                "target": "机械设计制造及其自动化"
            }, {
                "source": "机械学院",
                "target": "材料成型及控制工程"
            }, {
                "source": "机械学院",
                "target": "交通运输"
            }, {
                "source": "机械学院",
                "target": "测控技术与仪器"
            }, {
                "source": "华北水利水电大学",
                "target": "土木与交通学院"
            }, {
                "source": "土木与交通学院",
                "target": "土木工程"
            }, {
                "source": "土木与交通学院",
                "target": "交通工程"
            }, {
                "source": "土木与交通学院",
                "target": "工程力学"
            }, {
                "source": "土木与交通学院",
                "target": "无机非金属材料工程"
            }, {
                "source": "土木与交通学院",
                "target": "资源循环科学与工程"
            }, {
                "source": "土木与交通学院",
                "target": "建筑环境与能源应用工程"
            }, {
                "source": "土木与交通学院",
                "target": "道路桥梁与渡河工程"
            }, {
                "source": "华北水利水电大学",
                "target": "资源与环境学院"
            }, {
                "source": "资源与环境学院",
                "target": "地质工程"
            }, {
                "source": "资源与环境学院",
                "target": "土木工程(岩土及地下建筑方向)"
            }, {
                "source": "资源与环境学院",
                "target": "资源环境与城乡规划管理"
            }, {
                "source": "资源与环境学院",
                "target": "地理信息系统"
            }, {
                "source": "资源与环境学院",
                "target": "测绘工程"
            }, {
                "source": "资源与环境学院",
                "target": "水土保持与荒漠化防治"
            }, {
                "source": "华北水利水电大学",
                "target": "环境与市政工程学院"
            }, {
                "source": "环境与市政工程学院",
                "target": "给排水科学与工程"
            }, {
                "source": "环境与市政工程学院",
                "target": "建筑环境与能源应用"
            }, {
                "source": "环境与市政工程学院",
                "target": "环境工程"
            }, {
                "source": "环境与市政工程学院",
                "target": "消防工程"
            }, {
                "source": "环境与市政工程学院",
                "target": "应用化学"
            }, {
                "source": "华北水利水电大学",
                "target": "信息工程学院"
            }, {
                "source": "信息工程学院",
                "target": "电子信息工程"
            }, {
                "source": "信息工程学院",
                "target": "通信工程"
            }, {
                "source": "信息工程学院",
                "target": "电子信息科学与技术"
            }, {
                "source": "信息工程学院",
                "target": "网络工程"
            }, {
                "source": "信息工程学院",
                "target": "土木工程(结构分析)"
            },

            {
                "source": "华北水利水电大学",
                "target": "管理与经济学院"
            }, {
                "source": "管理与经济学院",
                "target": "经济贸易"
            }, {
                "source": "管理与经济学院",
                "target": "会计学"
            }, {
                "source": "管理与经济学院",
                "target": "市场营销"
            }, {
                "source": "管理与经济学院",
                "target": "物流与工业工程"
            }, {
                "source": "管理与经济学院",
                "target": "信息管理"
            }, {
                "source": "华北水利水电大学",
                "target": "外国语学院"
            }, {
                "source": "外国语学院",
                "target": "英语"
            }, {
                "source": "外国语学院",
                "target": "汉语国际教育"
            }, {
                "source": "外国语学院",
                "target": "俄语"
            }, {
                "source": "华北水利水电大学",
                "target": "数学与统计学院"
            }, {
                "source": "数学与统计学院",
                "target": "数学与应用数学"
            }, {
                "source": "数学与统计学院",
                "target": "信息与计算科学"
            }, {
                "source": "数学与统计学院",
                "target": "统计学"
            }, {
                "source": "数学与统计学院",
                "target": "应用统计学"
            }, {
                "source": "数学与统计学院",
                "target": "金融数学"
            }, {
                "source": "华北水利水电大学",
                "target": "建筑学院"
            }, {
                "source": "建筑学院",
                "target": "建筑学专业"
            }, {
                "source": "建筑学院",
                "target": "城乡规划专业"
            }, {
                "source": "建筑学院",
                "target": "风景园林专业"
            }, {
                "source": "华北水利水电大学",
                "target": "法学与公共管理学院"
            }, {
                "source": "法学与公共管理学院",
                "target": "法学"
            }, {
                "source": "法学与公共管理学院",
                "target": "行政管理"
            }, {
                "source": "法学与公共管理学院",
                "target": "劳动与社会保障"
            }, {
                "source": "华北水利水电大学",
                "target": "国际教育学院"
            }, {
                "source": "国际教育学院",
                "target": "英语专业"
            }, {
                "source": "国际教育学院",
                "target": "英语(商务方向)"
            }, {
                "source": "国际教育学院",
                "target": "英语(科技英语方向)"
            }, {
                "source": "国际教育学院",
                "target": "俄语专业"
            }, {
                "source": "国际教育学院",
                "target": "汉语国际教育专业"
            }, {
                "source": "国际教育学院",
                "target": "汉语国际教育(东亚地区)"
            }, {
                "source": "国际教育学院",
                "target": "英语(工程英语)"
            }, {
                "source": "国际教育学院",
                "target": "地质工程(灾害管理)"
            }, {
                "source": "国际教育学院",
                "target": "机械设计制造及自动化"
            }, {
                "source": "华北水利水电大学",
                "target": "软件学院"
            }, {
                "source": "软件学院",
                "target": "软件工程"
            }, {
                "source": "软件学院",
                "target": "软件工程(娱乐软件设计方向)"
            }, {
                "source": "软件学院",
                "target": "软件工程(软件测试方向)"
            }, {
                "source": "华北水利水电大学",
                "target": "艺术与设计学院"
            }, {
                "source": "艺术与设计学院",
                "target": "环境设计"
            }, {
                "source": "艺术与设计学院",
                "target": "视觉传达设计"
            }, {
                "source": "艺术与设计学院",
                "target": "公共艺术设计"
            }
        ],
        categories: [{
            'name': '数学与统计学院'
        }, {
            'name': '电力学院'
        }, {
            'name': '水利学院'
        }, {
            'name': '机械学院'
        }, {
            'name': '土木与交通学院'
        }, {
            'name': '资源与环境学院'
        }, {
            'name': '环境与市政工程学院'
        }, {
            'name': '信息工程学院'
        }, {
            'name': '管理与经济学院'
        }, {
            'name': '外国语学院'
        }, {
            'name': '建筑学院'
        }, {
            'name': '法学与公共管理学院'
        }, {
            'name': '国际教育学院'
        }, {
            'name': '软件学院'
        }, {
            'name': '艺术与设计学院'
        }],
        focusNodeAdjacency: true,
        roam: true,
        label: {
            normal: {

                show: true,
                position: 'top',

            }
        },
        lineStyle: {
            normal: {
                color: 'source',
                curveness: 0,
                type: "solid"
            }
        }
    }]
};
			  		myChart.setOption(option);
	 }	
</script>
</body>
</html>
