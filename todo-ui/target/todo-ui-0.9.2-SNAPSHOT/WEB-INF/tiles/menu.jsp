<%@page import="org.springframework.web.util.WebUtils"%>
<%@page import="sk.garwan.todo.web.model.TodoForm"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%
	String getProtocol = request.getScheme();
	String getDomain = request.getServerName();
	String getPort = Integer.toString(request.getServerPort());

	String getPath = getProtocol + "://" + getDomain + ":" + getPort + "/";
%>

<div id="main-menu">
	<ul>	
	<c:set var="applicationName" value="ui-projects" scope="request" />
	
		<li><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></li>
	
	</ul>
</div>
