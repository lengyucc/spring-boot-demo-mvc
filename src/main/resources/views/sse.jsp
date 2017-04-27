<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sse demo</title>
<script type="text/javascript" src="<c:url value="assets/js/jquery-2.0.3.min.js"/>"></script>
<script type="text/javascript">
	if(!!window.EventSource){
		var source = new EventSource('push');
		s = '';
		source.addEventListener('message',function(e){
			console.log("接收到数据");
			s += e.data+'</br>';
			$("#box").html(s);
		});
		source.addEventListener('open',function(e){
			console.log("连接打开...");
		},false);
		source.addEventListener('error',function(e){
			if(e.readyState == EventSource.CLOSED){
				console.log("连接关闭");
			}else{
				console.log(JSON.stringify(e));
				//console.log(e.readyState);
			}
		},false);
	}else{
		console.log("你的浏览器不支持SSE");		
	}
</script>
</head>
<body>
	<div id="box"></div>
</body>
</html>