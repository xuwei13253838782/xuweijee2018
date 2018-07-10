<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	<s:debug />
	<br>
	<center>修改区级信息</center>
	现有的全部区级信息
	
	<s:form  action="update_qu" method="post">
   <s:hidden name="pro.qu_id"/>  
   <s:textfield name="pro.qu" label="区级"/>   
   <s:submit value="update"/>
   </s:form>

	<a href=admin_address_qu_list>区级信息管理首页</a>
	<a href=admin_address.jsp>地点管理首页</a>
	<a href=exit.jsp>退出</a>
</body>
</html>