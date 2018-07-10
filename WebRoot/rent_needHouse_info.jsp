<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>

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
	<center>房屋求租信息发布</center>
	<br>
	<br>
	<s:form action="up_rent_needHouse_info" method="post">

		<s:label value="求租地段"></s:label>

		<s:textfield name="hf.house_address_shi" label="城市" requiredLabel="true"
			requiredPosition="left" />
		<s:textfield name="hf.house_address_qu" label="小区" requiredLabel="true"
			requiredPosition="left" />
			
		<s:radio list="#{'1':'租整套','0':'租单间'}" name="hf.house_various"
			label="求租类型" requiredLabel="true" requiredPosition="left" value="1" />

		<s:select name="hf.house_shi" list="{'一室','两室','三室','四室'}" headerKey="-1"
			headerValue="--请选择室--" emptyOption="false" multiple="false"
			label="房屋类型" requiredLabel="true" requiredPosition="left" />
		<s:select name="hf.house_ting" list="{'零厅','一厅','两厅','三厅','四厅'}"
			headerKey="-1" headerValue="--请选择厅--" emptyOption="false"
			multiple="false" />
		<s:select name="hf.house_wei" list="{'零卫','一卫','两卫','三卫','四卫'}"
			headerKey="-1" headerValue="--请选择卫--" emptyOption="false"
			multiple="false" />
		<s:textfield name="hf.house_area" label="房屋面积（㎡）" requiredLabel="true"
			requiredPosition="left" />
		<s:textfield name="hf.house_cost" label="租金（元/月）"
			requiredLabel="true" requiredPosition="left" />
		<s:label value="详细信息"></s:label>
		<s:textfield name="hf.house_title" label="标题"
			requiredLabel="true" requiredPosition="left" />
			<s:textfield name="hf.ruzhu_time" label="入住时间（格式年-月-日）" requiredLabel="true"
			requiredPosition="left" />
			<s:textfield name="hf.contact" label="联系方式（手机号）" requiredLabel="true"
			requiredPosition="left" />
		<s:submit />

	</s:form>
	<a href = login_suc.jsp>房屋出租系统首页</a>
	<a href=exit.jsp>退出</a>
</body>
</html>
