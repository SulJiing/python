<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="post" modelAttribute="buyer">
<table>
<tr><th>제조사코드</th><td><form:input type="text" path="buyerId"  cssClass="form-control"/><form:errors path="buyerId" element="span" cssClass="text-danger"/></td></tr>
<tr>
	<th>분류코드</th>
	<td>
		<form:select path="buyerLgu">
			<form:option value="" label="분류선택"/>
				<c:forEach items="${lprodList }" var="lprod">
				<form:option value="${lprod.lprodGu }" label="${lprod.lprodNm }" />
					<option value="${lprod.lprodGu }">${lprod.lprodNm }</option>
				</c:forEach>
		</form:select>
		<form:errors path="buyerLgu" element="span" cssClass="text-danger" />
		</td>
</tr>
<tr><th>제조사명</th><td><form:input type="text" path="buyerName"   cssClass="form-control"/><form:errors path="buyerName" element="span" cssClass="text-danger"/></td></tr>
<tr><th>은행</th><td><form:input type="text" path="buyerBank"   cssClass="form-control"/><form:errors path="buyerBank" element="span" cssClass="text-danger"/></td></tr>
<tr><th>계좌번호</th><td><form:input type="text" path="buyerBankno"   cssClass="form-control"/><form:errors path="buyerBankno" element="span" cssClass="text-danger"/></td></tr>
<tr><th>계좌주</th><td><form:input type="text" path="buyerBankname"   cssClass="form-control"/><form:errors path="buyerBankname" element="span" cssClass="text-danger"/></td></tr>
<tr><th>우편번호</th><td><form:input type="text" path="buyerZip"   cssClass="form-control"/><form:errors path="buyerZip" element="span" cssClass="text-danger"/></td></tr>
<tr><th>주소1</th><td><form:input type="text" path="buyerAdd1"   cssClass="form-control"/><form:errors path="buyerAdd1" element="span" cssClass="text-danger"/></td></tr>
<tr><th>주소2</th><td><form:input type="text" path="buyerAdd2"   cssClass="form-control"/><form:errors path="buyerAdd2" element="span" cssClass="text-danger"/></td></tr>
<tr><th>회사번호</th><td><form:input type="text" path="buyerComtel"   cssClass="form-control"/><form:errors path="buyerComtel" element="span" cssClass="text-danger"/></td></tr>
<tr><th>팩스</th><td><form:input type="text" path="buyerFax"   cssClass="form-control"/><form:errors path="buyerFax" element="span" cssClass="text-danger"/></td></tr>
<tr><th>메일</th><td><form:input type="text" path="buyerMail"   cssClass="form-control"/><form:errors path="buyerMail" element="span" cssClass="text-danger"/></td></tr>
<tr><th>??</th><td><form:input type="text" path="buyerCharger"   cssClass="form-control"/><form:errors path="buyerCharger" element="span" cssClass="text-danger"/></td></tr>
<tr><th>담당자</th><td><form:input type="text" path="buyerTelext"   cssClass="form-control"/><form:errors path="buyerTelext" element="span" cssClass="text-danger"/></td></tr>
		<tr>
			<td colspan="2">
				<button type="submit">전송</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form:form>
<script type="text/javascript">
   let $prodBuyer = $('select[name="buyerLgu"]').val("${buyer.buyerLgu}"); //name-prodBuyer 두개여서 select 붙여줌 //select하면서 값을 초기화하고 있음
</script>