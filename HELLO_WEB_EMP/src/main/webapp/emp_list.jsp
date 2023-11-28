<%@page import="kr.co.aiai.model.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Emp> list = (ArrayList<Emp>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_add(){
	location.href = "emp_add"
}

</script>
</head>
<body>

EMP_LIST<br>
<table border="1px">
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td>성별</td>
		<td>주소</td>
	</tr>
<% for(int i=0;i<list.size();i++){ %>
	<%Emp vo = list.get(i); %>
	<tr>
		<td><a href="emp_detail?e_id=<%=vo.getE_id()%>"><%=vo.getE_id()%></a></td>
		<td><%=vo.getE_name()%></td>
		<td><%=vo.getGen()%></td>
		<td><%=vo.getAddr()%></td>
	</tr>
<%} %>
</table>
<input type="button" value="추가" onclick="fn_add()" >

</body>
</html>



