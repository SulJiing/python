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
function fn_mod(){
	location.href = "emp_mod?e_id=<%=vo.getE_id() %>";
}
function fn_del_act(){
	var flag = confirm("한번 지워진 데이터는 복구가 불가합니다. 그래도 지워시렵니까?");
	if(!flag){
		return;
	}
	document.frm.submit();
}

</script>
</head>
<body>
EMP_DETAIL
<form name="frm" action="emp_del_act" method="post">
<input type="hidden" name="e_id" value="<%=vo.getE_id() %>" >

</form>
<table border="1px">
	<tr>
		<td>사번</td>
		<td><%=vo.getE_id() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=vo.getE_name() %></td>
	</tr>
	<tr>
		<td>성별</td>
		<td><%=vo.getGen() %></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=vo.getAddr() %></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="수정" onclick="fn_mod()" />
			<input type="button" value="삭제" onclick="fn_del_act()" />
		</td>
	</tr>
</table>
</body>
</html>


