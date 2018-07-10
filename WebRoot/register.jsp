<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

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

<body>
 <s:debug/>
	<s:form action="checkRegister" method="post" >
		<s:textfield name="pers.phone_number" label="手机号" requiredLabel="true"
			requiredPosition="left" />
		<s:textfield name="pers.username" label="用户名" requiredLabel="true"
			requiredPosition="left" />
		<s:password name="pers.pass" label="密码" requiredLabel="true" requiredPosition="left"  />
		<s:password name="repass" label="确认密码" requiredLabel="true" requiredPosition="left" />
		<s:submit />
	</s:form>
	
	<a href=exit.jsp>退出</a>
</body>
</html>

