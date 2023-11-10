<%@page import="kr.co.aiai.model.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Emp vo =  (Emp)request.getAttribute("vo");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_mod_act(){
	document.frm.submit();
}

</script>
</head>
<body>
EMP_MOD
<form name="frm" action="emp_mod_act" method="post">
	<table border="1px">
		<tr>
			<td>사번</td>
			<td>
				<input type="text" name="e_id" value="<%=vo.getE_id() %>">
			</td> 
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="e_name" value="<%=vo.getE_name() %>">
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="text" name="gen" value="<%=vo.getGen() %>">
			</td>
				</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" name="addr" value="<%=vo.getAddr() %>">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="저장" onclick="fn_mod_act()"/>
			</td>
		</tr>
</form>
</body>
</html>