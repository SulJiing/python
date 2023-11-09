<%@page import="java.util.List"%>
<%@page import="kr.co.aiai.model.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
EMP_LIST_JSP<br>
<%=request.getAttribute("a")%>
<% String b = (String)request.getAttribute("a");%>
<br>
<%=b %><br>
${a}<br>
<%
	ArrayList<Emp> list = (ArrayList<Emp>)request.getAttribute("list");
	List<Emp> list2 = (List<Emp>)request.getAttribute("dao");
%>
<%=list.size() %>


<table border="1px">
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td>성별</td>
		<td>주소</td>
	</tr>
	<%for(int i=0; i<list2.size(); i++) {%>
	<% Emp vo = list2.get(i); %>
	<tr>
		<td><%=vo.getE_id() %></td>
		<td><%=vo.getE_name() %></td>
		<td><%=vo.getGen() %></td>
		<td><%=vo.getAddr() %></td>
	</tr>
	<%}%>
	
</table>
</body>
</html>