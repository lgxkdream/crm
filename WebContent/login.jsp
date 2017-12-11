<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="${contextPath}/static/assets/js/jquery-1.10.1.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$("#sub").click(function(){
  			$.ajax({
  				url : "${contextPath}/sys/sysUser/login",
  				type : "post",
  				data : $("#f").serialize(),
  				dataType : "json",
  				success : function(msg){
  					if(msg.msg == 1){
  						location = "${contextPath}/sys/sysUser/home";
  					}else{
  						$("#msg").html(msg.msg);
  					}
  				}
  			});
  		});
  	});
  </script>
  <body>
    	<form id="f" action="" method="post">
		用户名：<input name="name"><br /> 密码:<input name="password">
		<input type="button" id="sub" value=" 确认"/><br/>
		<span><font color="red" id="msg"></font></span>		
	</form>
  </body>
</html>
