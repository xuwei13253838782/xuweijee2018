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
	<br> 浏览自己房屋信息
	<br>
	<center>浏览自己房屋出租信息</center>
	<table style="border: 1px solid green">
		<tr>
			
			<td>发布人
			<td>类型
			<td>城市
			<td>区
			<td>室
			<td>厅
			<td>卫
			<td>房屋面积（㎡）
			<td>租金（元/月）
			<td>标题
			<td>入住时间
			<td>联系方式
			<td><td>功能操作
			<s:iterator value="hfs" var="row">
					<tr>
						
						<td><s:property value="#row[1]" />
						<td><s:property value="#row[2]" />
						<td><s:property value="#row[3]" />
						<td><s:property value="#row[4]" />
						<td><s:property value="#row[5]" />
						<td><s:property value="#row[6]" />
						<td><s:property value="#row[7]" />
						<td><s:property value="#row[8]" />
						<td><s:property value="#row[9]" />
						<td><s:property value="#row[10]" />
						<td><s:property value="#row[11]" />
						<td><s:property value="#row[12]" />
						<td><s:property value="#row[13]" />
						<td><s:property value="#row[14]" /> <s:url
								var="rentImageUrl" action="add_image">
								<s:param name="hf.id" value="#row[0]" />
							</s:url> <a href="${rentImageUrl}">添加图片</a> <s:url var="markUrl"
								action="mark_overdue">
								<s:param name="hf.id" value="#row[0]" />
							</s:url> <a href="${markUrl}"
							onClick="return readyDel(<s:property value='#row[0]'/>);">过期标志</a>
				</s:iterator>
	</table>
	<script>
      function readyDel(id){
        return confirm("是否真的标志出租序号为"+id+"已过期？");
      }
    </script>
	<a href=exit.jsp>退出</a>
</body>
</html>
