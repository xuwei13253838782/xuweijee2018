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
	<center>首页房屋信息</center>
	<table style="border: 1px solid green">
		<tr><td>发布人<td>类型
			<td>城市<td>区<td>室<td>厅
			<td>卫<td>房屋面积（㎡）<td>租金（元/月）
			<td>标题<td>入住时间<td>联系方式
			<td>功能操作
		<s:iterator value="hfs" var="hf"><tr>
						
						<td><s:property value="#hf.username" />
						<td><s:property value="#hf.house_various" />
						<td><s:property value="#hf.house_address_shi" />
						<td><s:property value="#hf.house_address_qu" />
						<td><s:property value="#hf.house_shi" />
						<td><s:property value="#hf.house_ting" />
						<td><s:property value="#hf.house_wei" />
						<td><s:property value="#hf.house_area" />
						<td><s:property value="#hf.house_cost" />
						<td><s:property value="#hf.house_title" />
						<td><s:property value="#hf.ruzhu_time" />
						<td><s:property value="#hf.contact" />
						<td><s:property value="#row[13]" />
						
			<s:url var="look_imageUrl" action="image_info">
    		<s:param name="hf.id" value="#row[0]"/>
  			</s:url>	
  			<a href="${look_imageUrl}">查看图片</a>
  						
			<s:url var="collectUrl" action="collect_info">
         	<s:param name="hf.id" value="#row[0]"/>
         	<s:param name="hf.username" value="#row[1]"/>
         	<s:param name="hf.house_various" value="#row[2]"/>
         	<s:param name="hf.house_address_shi" value="#row[3]"/>
         	<s:param name="hf.house_address_qu" value="#row[4]"/>
         	<s:param name="hf.house_shi" value="#row[5]"/>
         	<s:param name="hf.house_ting" value="#row[6]"/>
         	<s:param name="hf.house_wei" value="#row[7]"/>
         	<s:param name="hf.house_area" value="#row[8]"/>
         	<s:param name="hf.house_cost" value="#row[9]"/>
         	<s:param name="hf.house_title" value="#row[10]"/>
         	<s:param name="hf.ruzhu_time" value="#row[11]"/>
         	<s:param name="hf.contact" value="#row[12]"/>
         	</s:url>
         	<a href="${collectUrl}" onClick="return readycollect(<s:property value='#row[0]'/>);">收藏</a>   	
    		
    </s:iterator>
    </table>
        
 	<script>
      function readycollect(id){
		
        return confirm("是否收藏出租序号为"+ id+"的出租信息？");
        
      }
    </script>
		<s:url var="url_pre" value="browse_all_house.action">
         <s:param name="pageNow" value="pageNow-1"></s:param>
     </s:url>
     <s:url var="url_next" value="browse_all_house.action">
         <s:param name="pageNow" value="pageNow+1"></s:param>
     </s:url>  
     <s:a href="%{url_pre}">上一页</s:a>
     
     <s:iterator value="hfs" status="status">
        <s:url var="url" value="browse_all_house.action">
            <s:param name="pageNow" value="pageNow"/>
        </s:url>
     </s:iterator>
     <s:a href="%{url_next}">下一页</s:a>  	

	<br><a href = login_suc.jsp>房屋出租系统首页</a>
	<a href=exit.jsp>退出</a>
  </body>
</html>










