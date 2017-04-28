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
	function deferred(){
		$.ajax({
			url: "defer",
			type: "GET",
			success: function(data){
				$("#box").append(data);
				// console.log(data);
				// deferred();
			}
		});
	}
</script>
</head>
<body>
	<input type="button" onclick="deferred();" value="点击"/>
	<div id="box"></div>
</body>
</html>