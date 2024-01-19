<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<table class="table table-bordered">
	<thead>
		<tr>
			<td>일련번호</td>
			<td>회원명</td>
			<td>이메일</td>
			<td>휴대폰</td>
			<td>주소1</td>
			<td>마일리지</td>
		</tr>
	</thead>
	<tbody>
<!-- 		screen size : 3, block size : 3 -->
	<c:choose>
		<c:when test="${not empty memberList }">
			<c:forEach items="${memberList }" var="member">
				<tr>
					<td>${member.rnum }</td>
					<td>${member.memName }</td>
					<td>${member.memMail }</td>
					<td>${member.memHp }</td>
					<td>${member.memAdd1 }</td>
					<td>${member.memMileage }</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6">조건에 맞는 회원 없음</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form:form id="submitForm" modelAttribute="paging" method="GET">
					<input type="text" name="page"/>
					<form:input path="simpleCondition.searchType"/>
					<form:input path="simpleCondition.searchWord"/>
				</form:form>
				<div data-pg-role="searchUI" data-pg-target="#submitForm"
					class="m-3 p-3 border border-primary row justify-content-center">
					<form:select path="paging.simpleCondition.searchType" class="form-select">
						<form:option value="" label="전체"/>
						<form:option value="name" label="이름"/>
						<form:option value="address" label="주소"/>
					</form:select>
					<div class="col-auto">
					<form:input type="text" path="paging.simpleCondition.searchWord"/>
					</div>
					<div class="col-auto">
					<button type="button" data-pg-role="searchBtn" class="btn btn-primary">>검색</button>
					</div>
				</div>
				${pagingHTML }
			</td>
		</tr>
	</tfoot>
</table>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>