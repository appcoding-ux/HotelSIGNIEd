<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/QnA.css">
<link rel="stylesheet" href="css/QnAlist.css" />
<script src="https://kit.fontawesome.com/f21f7d3508.js" crossorigin="anonymous"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
<link rel="stylesheet"
	href="hotel-datepicker-main/dist/css/hotel-datepicker.css">
<script src="hotel-datepicker-main/dist/fecha.js"></script>
<script src="hotel-datepicker-main/fecha-4.2.1/dist/fecha.min.js"></script>
<script src="hotel-datepicker-main/dist/js/hotel-datepicker.js"></script>
<script src="js/search.js"></script>
<script src="js/slide.js"></script>
<script src="js/QnAview.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="QnAlistWrap">
		<h2>Q&A</h2>
		
		<div class="writeBtn">
			<a href="HotelServlet?command=QnAwrite">글쓰기</a>
		</div>

		<div class="QnAlistTable">
			<table>
				<colgroup>
					<col width="80">
					<col width="30">
					<col width="60">
					<col width="*">
					<col width="110">
					<col width="110">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">NO.</th>
						<th scope="col">&nbsp;</th>
						<th scope="col">CATEGORY</th>
						<th scope="col">TITLE</th>
						<th scope="col">EMAIL</th>
						<th scope="col">DATE</th>
					</tr>
				</thead>
				
				
				
				<c:forEach var="QnAlist" items="${QnAList}">
					<c:set var="email" value="${QnAlist.email}" />
    				<c:set var="hiddenEmail" value="${fn:substring(email, 0, 2)}****${fn:substring(email, fn:length(email) - 2, fn:length(email))}" />
					<tr>
						<td>${QnAlist.qnaNum}</td>
						<td><i class="fa-solid fa-lock"></i></td>
						<td>${QnAlist.qnaCategory}</td>
						<td><a href="" onclick="open_win('HotelServlet?command=QnA_check&num=${QnAlist.qnaNum}', 'view')">${QnAlist.qnaTitle}</a></td>
						<td>${hiddenEmail}</td>
						<td>
							<fmt:parseDate value="${QnAlist.qnaRegidate}" var="date" pattern="yyyy-MM-dd"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="writeBtn">
			<a href="HotelServlet?command=QnAwrite">글쓰기</a>
		</div>
	</div>
</body>
</html>