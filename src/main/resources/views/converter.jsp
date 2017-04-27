<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="assets/js/jquery-2.0.3.min.js"/>"></script>
<script type="text/javascript">
	function req(){
		$.ajax({
			url: "convert",
			data: "110#zhangsan#111222",	// 注意这里的数据格式，必须与MyMessageConverter.readInternal中的格式相同
			type: "POST",
			contentType: "application/x-wisely",	// 媒体类型应与我们自定义的媒体类型一致
			success: function(data){
				$("#box").html(data);
			}
		});
	}
</script>
</head>
<body>
	<button onclick="req();">请求</button>
	<div id="box"></div>
</body>
</html>