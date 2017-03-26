<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath}/css/style.less.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.15.custom.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.15.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/less-1.1.3.min.js"></script>

<title><tiles:insertAttribute name="title" ignore="true" />
</title>
</head>
<body>
	<div id="page">
		<div id="header">
			<div id="title">
				<h1><spring:message code="projects.title" /></h1>
			<h4><spring:message code="version"></spring:message>:<core:out value="0.0.6 (24.03.2017 15:59)" /></h4>
			</div>
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</body>
</html>
