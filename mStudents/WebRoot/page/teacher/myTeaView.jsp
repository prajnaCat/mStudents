<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.model.TeacherInfo"%>
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
    TeacherInfo tea = (TeacherInfo)session.getAttribute("teacher");
    String teaid=tea.getTeaId();
     %>
   
</head>
  
  <body>
  <div id="myInfo" style="width:100%;height:120%;margin-top:-13px">

</div>
<script type="text/javascript">
<%--var teaid="'"+<%=teaid%>+"'";--%>
var myChart = echarts.init(document.getElementById('myInfo'));




myChart.setOption({
    tooltip: {
        formatter: '{b}'
    },
    series: [{
        data: [],
        type: 'map3d',
        mapType: 'world',
        hoverable: false,
        clickable: false,
        roam: {
            focus: 'China',
            autoRotate: true
        },
        baseLayer: {
            backgroundColor: '',
            backgroundImage: 'asset/earth.jpg',
            quality: 'high',
        },
        itemStyle: {
            normal: {
                label: {
                    show: true
                },
                borderWidth: 1,
                borderColor: 'yellow',
                areaStyle: {
                    color: 'rgba(0, 0, 0, 0)'
                }
            }
        },

        markPoint: {
            large: true,
            symbolSize: 20,
            effect: {
                show: true,
                shadowBlur: 0.4
            },
            data: [{
                geoCoord: [116.46, 39.92]
            }, {
                geoCoord: [113.51,23.22]
            }, {
                geoCoord: [-122.98,49.28]
            }, {
                geoCoord: [9.16,45.51]
            }]
        },
        markLine: {
            smooth: true,
            effect: {
                show: true
            },
            itemStyle: {
                borderWidth: 100,
                normal: {
                    borderWidth: 100,
                    width: 10,
                    color: 'red',
                    lineStyle: {
                        type: 'solid',
                        width: 100,
                        borderWidth: 100,
                        shadowBlur: 100
                    }
                }
            },
            data: [[
                {geoCoord: [116.46, 39.92]},
                {geoCoord: [113.51,23.22]}
            ],
                [
                    {geoCoord: [-122.98,49.28]},
                    {geoCoord: [9.16,45.51]}
                ]]
        },
    }]
});

myChart.setOption(option);
</script>
  </body>
</html>
