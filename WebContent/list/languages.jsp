<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.krimanta.library.dto.Language"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.krimanta.library.meta.DataType" %>
<%@ page import="com.krimanta.library.dto.Language" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Languages list</title>
</head>
<body>
<a href="addlanguage.jsp">Add language</a><br />

<table border="1">
<tr>
<td><b>Id</b></td>
<td><b>Language</b></td>
<td></td>
</tr>


<%
	ResultSet languages = (ResultSet)request.getAttribute(DataType.LANGUAGES.getTableName());
	languages.last();
	Language array[] = new Language[languages.getRow()];
	languages.beforeFirst();
	
	
	int i=0;
while(languages.next()){
	array[i] = new Language(languages.getString("lang_id"), languages.getString("lang_name"));
	i++;
}

languages.close();

for(Language l : array){
%>

<tr>
<td><%=l.getLangId()%></td>
<td><%=l.getLangName()%></td>
<td>
<form action="DeleteServlet" method="post">
<input type="hidden" name="toDelete" value="<%=l.getLangId() %>" />
<input type="submit" value="Delete"/>
</form>
</td>
</tr>

<%} %>

</table>
</body>
</html>