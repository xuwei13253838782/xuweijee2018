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

	<center>现有的全部地点信息</center>
	
	<table style="border: 1px solid green">
		<tr><td><td>qu_id<td><td>shi<td><td>qu<td><td>修改 
		<s:iterator value="pros" var="row"><tr>
						<td><td><s:property value="#row[0]" />
						<td><td><s:property value="#row[1]" />
						<td><td><s:property value="#row[2]" />
						<td><td><s:property value="#row[3]" />
		
			<s:url var="update_quUrl" action="admin_address_update_qu">
         	<s:param name="pro.qu_id" value="#row[0]"/>
         	</s:url>
         	<a href="${update_quUrl}">修改</a>
		</s:iterator>
			
	</table>

	<a href=admin_address_add_qu.jsp>增加区级信息</a>
	<a href=admin_address.jsp>地点管理首页</a>
	<a href=exit.jsp>退出</a>

</body>
</html>
