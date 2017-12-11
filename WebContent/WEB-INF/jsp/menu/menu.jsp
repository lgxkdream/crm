<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'menu.jsp' starting page</title>
    
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
   		createRole();
   		
   		function createRole(){
   			var roleList = JSON.parse('${roleList}');
   			var str = "";
   			for(var i = 0; i < roleList.length; i++){
   				str += '<input class="roleBtn" type="button" roleId="' + roleList[i].ID + '" value="' + roleList[i].NAME + '"/>';
   			}
   			$("#btn").html(str);
   		}
   		
   		$(".roleBtn").click(function(){
   			$("#ROLE_ID").val($(this).attr("roleId"));
   			$.ajax({
   				url : "${contextPath}/sys/sysRoleMenu/getMenu",
   				type : "post",
   				dataType : "json",
   				data : {"role_id" : $(this).attr("roleId")},
   				success : function(msg){
		   			createMenuTree(msg);
   				}
   			});
   		});
   		
   		function createMenuTree(msg){
   			var v = '${menuList}';
   	   		var userJson = JSON.parse(v);
   	   		var menuList = userJson.childList;
   	   		var str = "";
   	   		for(var i = 0; i < menuList.length; i++){
   	   			var menu = menuList[i];
				var flag = false;
				for(var k = 0; k < msg.length; k++){
					if(menu.ID == msg[k].MENU_ID){
						flag = true;
						break;
					}
				}
   				if(flag){
		   			str += '<input type="checkbox" checked class="qx" menuValue="' + menu.ID + '"/><span>' + menu.NAME + '</span><br/>';
   				}else{
		   			str += '<input type="checkbox" class="qx" menuValue="' + menu.ID + '"/><span>' + menu.NAME + '</span><br/>';
   				}
   	   			var childList = menu.childList;
   	   			if(childList != null && childList.length > 0){
   	   				for(var j = 0; j < childList.length; j++){
	   	   				var flagJ = false;
	   					for(var k = 0; k < msg.length; k++){
	   						if(childList[j].ID == msg[k].MENU_ID){
	   							flagJ = true;
	   						}
	   					}
	   					if(flagJ){
	   			   			str += '&nbsp;&nbsp;&nbsp;&nbsp<input type="checkbox" checked class="qx" menuValue="' + childList[j].ID + '"/><span>' + childList[j].NAME + '</span><br/>';
	   	   				}else{
	   			   			str += '&nbsp;&nbsp;&nbsp;&nbsp<input type="checkbox" class="qx" menuValue="' + childList[j].ID + '"/><span>' + childList[j].NAME + '</span><br/>';
	   	   				}
   	   				}
   	   			}
   	   		}
   	   		$("#bd").html(str);
   		}
   		
   		$("#sub").click(function(){
   			var ids = "1,";
   			$("#bd").find("input").each(function(index, el){
   				if($(this).prop("checked")){
	   				ids += $(this).attr("menuValue") + ",";
   				}
   			});
   			$("#MENU_IDS").val(ids);
   			$.ajax({
   				url : "${contextPath }/sys/sysRoleMenu/updateMenu",
   				type : "post",
   				data : $("#f").serialize(),
   				success : function(msg){
   					history.go(0);
   				}
   			});
   		});
   		
   	});
   </script>
  <body>
  	<div id="btn">
  	</div>
  	<form action="" id="f">
	  	<input id="ROLE_ID" type="hidden" name="ROLE_ID"/>
	  	<input id="MENU_IDS" type="hidden" name="MENU_IDS"/>
	  	<div id="bd"></div>
	  	<input id="sub" type="button" value="ok"/>
  	</form>
  </body>
</html>
