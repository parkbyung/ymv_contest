<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <meta charset="UTF-8">
    <title>AdminLTE 2 | Flot Charts</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    
    
          
      <div class = "col-sm-6 col-sm-offset-3">
        <div class="box box-primary">
                <div class="box-header with-border">
                  <h1 class="box-title"><p  class = "text-center">봉사 분야별 선호도</p></h1>
                  <i class="fa fa-bar-chart-o"></i>
                </div>
                <div class="box-body">
                  <div id="bar-chart" style="height: 300px;"></div>
                </div><!-- /.box-body-->
              </div><!-- /.box -->
              </div>
    <!-- FLOT CHARTS -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.pie.min.js" type="text/javascript"></script>
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <script src="${initParam.root}chart/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
              
        <script type="text/javascript">
        
        
        $(function () {
           var arr=new Array();
           var arr2=new Array();

	       <c:forEach items="${requestScope.list }" var="test3">
		      	 arr=new Array();
		         arr.push("${test3.FIELD}");
		   		arr.push("${test3.COUNT}");
	  			arr2.push(arr);
			</c:forEach>

var bar_data = {
          data: arr2,
          color: "#3c8dbc"
        }; 
        $.plot("#bar-chart", [bar_data], {
          grid: {
            borderWidth: 1,
            borderColor: "#f3f3f3",
            tickColor: "#f3f3f3"
          },
          series: {
            bars: {
              show: true,
              barWidth: 0.5,
              align: "center"
            }
          },
          xaxis: {
            mode: "categories",
            tickLength: 0
          }
        });
        });

        </script>
