<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'homepage.jsp' starting page</title>
    
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
   		var v = '${user}';
   		var userJson = JSON.parse(v);
   		var menuList = userJson.childList;
   		var str = "";
   		for(var i = 0; i < menuList.length; i++){
   			var menu = menuList[i];
   			if(menu.TYPE == 1){
	   			str += '<span>' + menu.NAME + '</span><br/>';
   			}else{
	   			str += '<a href="${contextPath}' + menu.HTML + '">' + menu.NAME + '</a><br/>';
   			}
   			var childList = menu.childList;
   			if(childList != null && childList.length > 0){
   				for(var j = 0; j < childList.length; j++){
   					if(childList[j].TYPE == 1){
   			   			str += '&nbsp;&nbsp;&nbsp;&nbsp<span>' + childList[j].NAME + '</span><br/>';
   		   			}else{
		   				str += '&nbsp;&nbsp;&nbsp;&nbsp<a href="${contextPath}' + childList[j].HTML + '">' + childList[j].NAME + '</a><br/>';
   		   			}
   				}
   			}
   		}
   		$("#bd").html(str);
   	});
   </script>
  <body>
  	<div id="bd">
  	</div>
  </body>
</html>
