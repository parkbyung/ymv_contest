<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<img src="${initParam.root }/img/location.jpg">
<div align="center" >
<!-- 1. 지도 노드 -->
<div id="daumRoughmapContainer1435713952816" class="root_daum_roughmap root_daum_roughmap_landing"></div>

<!--
	2. 설치 스크립트
	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
-->
<script charset="UTF-8" class="daum_roughmap_loader_script" src="http://dmaps.daum.net/map_js_init/roughmapLoader.js"></script>

<!-- 3. 실행 스크립트 -->
<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1435713952816",
		"key" : "4juy",
		"mapWidth" : "600",
		"mapHeight" : "300"
	}).render();
</script>
<br><br>
</div>
<div class="section" style="position: relative; left:130px;">
	<div class="container">
		<div class="row">
		<br>
			<img src="${initParam.root }/img/map.jpg">
		</div>
	</div>
</div>