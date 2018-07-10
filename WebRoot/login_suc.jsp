<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 <s:debug/><br>
 	<center>房屋出租系统首页<br><br><br>
 	<s:hidden username="pers.username" value="pers.username"/>
	<a href=rent_house_info.jsp>房屋出租</a>

	<a href=my_browse>浏览自己房屋出租信息</a>

	<a href=browse_all_house>浏览首页房屋信息</a>
	
	<a href=my_collect>查看我的收藏</a>
	<br>
	<a href=rent_needHouse_info.jsp>房屋求租</a>
	
	<a href=exit.jsp>退出</a>
	</center>
  </body>
</html>
