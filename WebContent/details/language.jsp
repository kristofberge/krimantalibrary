<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.krimanta.library.dto.Language" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="language" class="com.krimanta.library.dto.Language" scope="request">
	<jsp:setProperty property="*" name="language" />
</jsp:useBean>

<h3>Language Details</h3>

Id: <jsp:getProperty property="langId" name="language"/> <br />
Name: <jsp:getProperty property="langName" name="language"/> <br />

<a href="/KrimantaLibrary">Home</a>

</body>
</html>