<%@page import="sk.garwan.todo.web.model.TodoForm"%>
<%@page import="java.util.Collection"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String path = request.getContextPath();

	String getProtocol = request.getScheme();
	String getDomain = request.getServerName();
	String getPort = Integer.toString(request.getServerPort());
	String getPath = getProtocol + "://" + getDomain + ":" + getPort + "/";
	String getURI = request.getRequestURI();
%>

<!--  
<body>-->

<h4>
	
	<core:out value="${version}" />
</h4>
