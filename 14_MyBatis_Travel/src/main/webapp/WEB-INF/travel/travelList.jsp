<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    
web-inf\travel\travelList.jsp <br>

<script type="text/javascript">

function insert() {
	location.href="insert.tv";
}
function goUpdate(num) {
	location.href="update.tv?num=" + num;
}

</script>

<h2>여행 리스트 화면(${fn:length(travelLists) } / ${totalCount })</h2>

<form action="list.tv" method="get">
	<select name="whatColumn">
		<option value="">전체검색</option>
		<option value="area">지역</option>
		<option value="style">여행 타입</option>
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="8" align="right">
			<input type="button" value="내용추가" onClick="insert()">
		</td>
	</tr>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>나이</td>
			<td>지역</td>
			<td>여행타입</td>
			<td>금액</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
	<c:forEach var="tl" items="${travelLists }">	
		<tr>
			<td>${tl.num }</td>
			<td>${tl.name }</td>
			<td>${tl.age }</td>
			<td>${tl.area }</td>
			<td>${tl.style }</td>
			<td>${tl.price }</td>
			<td>
				<input type="button" value="수정" onClick="goUpdate(${tl.num})">
			</td>				
			<td><a href="delete.tv?num=${tl.num }">삭제</a></td>
		</tr>
	</c:forEach>	
</table>
<br><br>

${pageInfo.pagingHtml}