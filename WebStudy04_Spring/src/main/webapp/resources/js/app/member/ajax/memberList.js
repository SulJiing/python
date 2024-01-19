$(submitForm).on("submit", function(event){
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize(); // ajax에서만 사용할 수 있음
	let $listBody = $(listBody);
	let $pagingArea = $(pagingArea);
	$.ajax({
		url:url
		, method:method
		, data : data
		, dataType : "json"
		, success:function(jsonObj){
			$listBody.empty();
			$pagingArea.empty();
			
			let dataList = jsonObj.memberList;
			let pagingHTML = jsonObj.pagingHTML;
			
			let trTags = null;
			
			if(dataList.length > 0){
				$.each(dataList, function(index, member){
					trTags += `
						<tr>
							<td>${member.rnum }</td>
							<td>${member.memName }</td>
							<td>${member.memMail }</td>
							<td>${member.memHp }</td>
							<td>${member.memAdd1 }</td>
							<td>${member.memMileage }</td>
						</tr>
					`;
				});
			}else{
				trTags = `
					<tr>
						<td colspan="6">조건에 맞는 회원이 없음.</td>
					</tr>
				`;
			}
			
			$listBody.append(trTags);
			$pagingArea.append(pagingHTML);
			
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{ // fetch의 finally와 같음
		form.page.value="";
	});
	return false;
}).submit(); // 페이지 로딩 후 초기값
//미완성된 코드(페이지 선택 못함)
/*fetch로
$(submitForm).on("submit",(event)=>{
   event.preventDefault();
   
   let form = event.target;
   let url = form.action;
   let method = form.method;
   
   let formData = new FormData(form);
   let queryString = new URLSearchParams(formData);
   
   //fetch로 post요청을 보낼떄 json으로 보내야할떄
   // 폼 데이터를 JSON으로 변환
   //   let formData = new FormData(form);
   //   let jsonObject = {};
   //   formData.forEach((value, key) => {
   //     jsonObject[key] = value;
   //   });
   //   
   //   // JSON 데이터를 문자열로 직렬화
   //   let jsonData = JSON.stringify(jsonObject);
   
   fetch(`${url}?${queryString}`,{
      method : method,
      headers : {
         "Accept" : "application/json"
      }
   }).then(resp=>{
      if(resp.ok){
         return resp.json();
      }else{
         throw new Error(`상태코드 ${resp.status} 수신`, {cause : resp});
      }
   }).then(jsonObj=>{
      
      $(pagingArea).html(jsonObj.pagingHTML);
      
      let memList = jsonObj.memberList;
      console.log(memList);
      let tag = "";
      for(let mem of memList){
         tag += `
            <tr>
               <td>${mem.rnum }</td>
               <td>${mem.memName }</td>
               <td>${mem.memMail }</td>
               <td>${mem.memHp }</td>
               <td>${mem.memAdd1 }</td>
               <td>${mem.memMileage }</td>
            </tr>
         `;
      }
      document.querySelector('tbody').innerHTML = tag;
      $(pagingArea).html(jsonObj.pagingHTML);

   }).catch(err=>{
      console.error(err,err.cause);
   }).finally(()=>{
      form.page.value="";
   });
   
   return false;
}).submit();
*/