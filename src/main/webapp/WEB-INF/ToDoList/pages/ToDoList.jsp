<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<sj:head/>
<sb:head/>
</head>
<body>
<h3>TO-DO List</h3>
<ol>
 <s:if test="!err.isEmpty()">
 	<s:property value="getErr()"/>
 </s:if>
 <s:iterator value="someItems" status="someItemsStatus">
 	<s:if test="#someItemsStatus.even == true">
 	 <li style="background: #CCCCCC"><s:property value="getText()"/></li>
 	</s:if>
 	<s:else>
 	<li><s:property value="getText()"/></li>
 	</s:else>
 </s:iterator>
 <s:form action="todoadd" theme="bootstrap">
 	<s:textfield label="New do:" name="newDo" tooltip="Enter new do name"/>
 	<s:submit title="add" name="submit"/>
 </s:form>
</ol>
</body>
</html>