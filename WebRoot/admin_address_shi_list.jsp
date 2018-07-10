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

	<center>市级信息管理首页</center>
	现有的全部市级信息
	<table style="border: 1px solid green"><tr><td>shi_id<td>shi<td>修改
				<s:iterator value="pros" var="row">
					<tr>
						<td><s:property value="#row[0]" />
						<td><s:property value="#row[1]" />
						<td><s:property value="#row[2]" />
				
				<s:url var="update_shiUrl" action="admin_address_update_shi">
      			   <s:param name="pro.shi_id" value="#row[0]"/>
     			</s:url>
				<a href="${update_shiUrl}">修改</a>
				
				</s:iterator>	
	</table>



	<br>
	<a href=admin_address_add_shi.jsp>市级信息增加</a>
	<a href=admin_address_qu_list>区级信息管理</a>
	<a href=admin_address.jsp>地点管理首页</a>
	<a href=exit.jsp>退出</a>

</body>
</html>
