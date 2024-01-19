<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form method="post" modelAttribute="prod" enctype="multipart/form-data">
	<table class="table table-bordered">
		<tr>
			<th>상품명</th>
			<td>
				<form:input path="prodName" class="form-control" />
				<form:errors path="prodName" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>분류코드</th>
			<td>
			<form:select path="prodLgu">
				<form:option value="" label="분류선택" />
				<c:forEach items="${lprodList }" var="lprod">
					<form:option value="${lprod.lprodGu }" label="${lprod.lprodNm }" />
<%-- 					<option value="${lprod.lprodGu }">${lprod.lprodNm }</option> --%>
				</c:forEach>
			</form:select>
			<form:errors path="prodLgu" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>제조사코드</th>
			<td>
				<form:select path="prodBuyer">
					<form:option value="" label="제조사선택"></form:option>
					<c:forEach items="${buyerList }" var="buyer">
						<form:option value="${buyer.buyerId }" cssClass="${buyer.buyerLgu }" label="${buyer.buyerName }"></form:option>
					</c:forEach>
				</form:select>
				<form:errors path="prodBuyer" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>구매가</th>
			<td>
				<form:input path="prodCost" class="form-control" />
				<form:errors path="prodCost" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>판매가</th>
			<td><form:input path="prodPrice" class="form-control" />
			<form:errors path="prodPrice" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>세일가</th>
			<td><form:input path="prodSale" class="form-control" />
				<form:errors path="prodSale" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>요약정보</th>
			<td><form:input path="prodOutline" class="form-control" />
				<form:errors path="prodOutline" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>상세정보</th>
			<td><form:input path="prodDetail" class="form-control" />
				<form:errors path="prodDetail" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><form:input type="file" path="prodImage" class="form-control" />
				<form:errors path="prodImage" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>총재고</th>
			<td><form:input path="prodTotalstock" class="form-control" />
				<form:errors path="prodTotalstock" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td><form:input path="prodProperstock" class="form-control" />
				<form:errors path="prodProperstock" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>크기</th>
			<td><form:input path="prodSize" class="form-control" />
				<form:errors path="prodSize" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>색상</th>
			<td><form:input path="prodColor" class="form-control" />
				<form:errors path="prodColor" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td><form:input path="prodDelivery" class="form-control" />
				<form:errors path="prodDelivery" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>단위</th>
			<td><form:input path="prodUnit" class="form-control" />
				<form:errors path="prodUnit" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>입고량</th>
			<td><form:input path="prodQtyin" class="form-control" />
				<form:errors path="prodQtyin" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>출고량</th>
			<td><form:input path="prodQtysale" class="form-control" />
				<form:errors path="prodQtysale" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><form:input path="prodMileage" class="form-control" />
				<form:errors path="prodMileage" element="span" cssClass="text-danger"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">전송</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form:form>
<script type="text/javascript">
   let $prodBuyer = $('select[name="prodBuyer"]').val("${prod.prodBuyer}"); //name-prodBuyer 두개여서 select 붙여줌 //select하면서 값을 초기화하고 있음
   $('select[name="prodLgu"]').on("change",(event)=>{ 
      let $prodLgu = $(event.target); 
      let selectedLgu = $prodLgu.val(); //let selectedLgu = event.target.value; //val(), value 하면 선택되어있는 옵션의 값이 나옴.
      $prodBuyer.find("option:gt(0)").each((idx, op)=>{ //:gt 보다 큰 //여러개의 option을 하나하나 처리
         let $op = $(op);
         let showFlag = (selectedLgu && $op.hasClass(selectedLgu)) || (!selectedLgu);
         // 없을떄      :  없으니까 false   뒤에는 계산 안하고                  없으니까 true
         // 있을떄      :  있으니까 true  (분류코드)를 클래스로 가지고 있으면 true  있으니까 false
         //                           (분류코드)를 클래스로 가지고 있지 않으면 false 
         $op.toggle(showFlag);
         //flase면 hidden
      });
   }).trigger("change"); //이벤트가 끝난 후에 초기값을 정해줌 // 트리거 : 이벤트 발생시키겠다.
</script>